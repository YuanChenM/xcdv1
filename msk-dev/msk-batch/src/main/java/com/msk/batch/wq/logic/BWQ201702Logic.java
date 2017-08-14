package com.msk.batch.wq.logic;

import com.msk.batch.wq.bean.*;
import com.msk.batch.wq.util.WqHttpClient;
import com.msk.common.logic.CommonLogic;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.utils.DateTimeUtil;
import com.msk.core.utils.StringUtil;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Created by pxg on 2017/1/9 0009.
 */
@Service
public class BWQ201702Logic extends BaseLogic{
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(BWQ201702Logic.class);
    //插入数据成功统计
    private Integer insertSuccessCount=0;
    //更新成功数据统计
    private Integer updateSuccessCount=0;
    //插入数据失败统计
    private Integer insertErrorCount=0;
    //更新数据失败统计
    private Integer updateErrorCount=0;
    /**
     * SQL Map 中SQL ID定义
     * @author pxg
     */
    public interface SqlId{

        /**保存365数据到OMS员工表**/
        static final String SAVE_EMPLOYEE="saveEmployee";
        /**清空OMS员工表**/
        static final String REMOVE_EMPLOYEE="removeEmployee";
        /**查询买手信息**/
        static final String QUERY_SL_BS_ACCOUNT="querySlBsAccount";
        /**根据买手账号，在OMS员工表中查询数据**/
        static final String QUERY_BY_ACCOUNT_ID="queryByAccountId";
        /**查询买手类型**/
        static final String QUERY_SL_BS_TYPE="querySlBsType";
        /**查询买手和管家重复**/
        static final String QUERY_SL_BS_HOUSE="querySlBsHouse";
        /**查询固定参数**/
        static final String QUERY_CONSTANT="queryConstant";
        /**查询员工号码是否存在**/
        static final String QUERY_EMPLOYEE_PHOTO="queryEmployeePhoto";
        /**判断已停用的员工**/
        static final String QUERY_EMPLOYEE_STOP="queryEmployeeStop";
        /**判断删除的员工**/
        static final String QUERY_EMPLOYEE_DELETE="queryEmployeeDelete";
    }
    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }
    /**
     * 查询员工所有信息
     * @param url 请求路径
     * @param msgId msgid
     * @return 结果集
     */
    public String queryEmployee(String url,String msgId){
        //创建请求参数
        BWQ201702Param bwq201702Param=new BWQ201702Param();
        //调用共通post请求，得到结果集
        WqResponse<BWQ201702Result> wqResponse=WqHttpClient.httpPost(url,bwq201702Param,msgId,BWQ201702Result.class);
        if(null!=wqResponse){
            if(wqResponse.getReturnCode().equals("0")){
                //获取data结果集
                List<BWQ201702Result> list= wqResponse.getData();
                //先清空表数据
                super.remove(SqlId.REMOVE_EMPLOYEE,new BaseParam());
                logger.info(DateTimeUtil.formatDate("yyyy-MM-dd HH:mm:ss",new Date())+"：员工数据清空成功");
                //给主键ID赋值,插入数据
                setEmployee(list);
                //获取OMS数据
                List<SlBsAccountParam> slBsAccountList=super.findList(SqlId.QUERY_SL_BS_ACCOUNT, new BaseParam());
                if(CollectionUtils.isNotEmpty(slBsAccountList)){
                    for(SlBsAccountParam slBsAccountParam:slBsAccountList){
                        //查询买手和管家是否重复
                        BaseParam paramByHouse=new BaseParam();
                        paramByHouse.setFilter("empName",slBsAccountParam.getEmpName());
                        int countData=super.getCount(SqlId.QUERY_SL_BS_HOUSE,paramByHouse);
                        if(countData<=0){
                            //获取买手账号
                            BaseParam param=new BaseParam();
                            param.setFilter("empName", slBsAccountParam.getEmpName());
                            //根据OMS员工账号去365外勤查询，如果有的话更新，不存在则插入
                            BWQ201702Result resultCount=super.findOne(SqlId.QUERY_BY_ACCOUNT_ID, param);
                            //存在，调用更新接口，更新信息
                            if(null!=resultCount){
                                //slBsAccountParam.setEmpId(slBsAccountParam.getEmpCode());
                                slBsAccountParam.setId(resultCount.getId());
                                String updateUrl="employee/v2/modifyEmployee";
                                BWQ20170202Result bwq20170202ResultTwo=querySetting("买手岗位","EmpJob");
                                if(null!=bwq20170202ResultTwo){
                                    slBsAccountParam.setEmpJob(bwq20170202ResultTwo.getConstantValue());
                                }
                                //赋值额外字段
                                setExts(slBsAccountParam);
                                slBsAccountParam.setEmpMobile(null);
                                slBsAccountParam.setEmpCode(null);
                                WqResponse<?> wqResponseData= WqHttpClient.httpPost(updateUrl, slBsAccountParam, msgId,null);
                                if(null!=wqResponseData){
                                    if(wqResponseData.getReturnCode().equals("0")){
                                        logger.info(slBsAccountParam.getEmpName()+"：更新外勤365员工成功");
                                        updateSuccessCount++;
                                    }else{
                                        logger.error(slBsAccountParam.getEmpName()+"：更新外勤365员工失败");
                                        updateErrorCount++;
                                    }
                                }
                            }else{
                                slBsAccountParam.setEmpId(slBsAccountParam.getEmpCode());
                                BWQ20170202Result bwq20170202Result=querySetting("买手默认部门","EmpOrgIDDefault");
                                if(null!=bwq20170202Result){
                                    slBsAccountParam.setEmpOrgId(bwq20170202Result.getConstantValue());
                                }
                                BWQ20170202Result bwq20170202ResultTwo=querySetting("买手岗位","EmpJob");
                                if(null!=bwq20170202ResultTwo){
                                    slBsAccountParam.setEmpJob(bwq20170202ResultTwo.getConstantValue());
                                }
                                BWQ20170202Result bwq20170202ResultThree=querySetting("买手","EmpIsOrgLeader");
                                if(null!=bwq20170202ResultThree){
                                    slBsAccountParam.setEmpIsOrgLearder(bwq20170202ResultThree.getConstantValue());
                                }
                                //赋值额外字段
                                setExts(slBsAccountParam);
                                slBsAccountParam.setEmpImsiBinding("0");
                                slBsAccountParam.setEmpStatus("1");
                                //如果员工有删除，可以添加
                                BaseParam paramDelete=new BaseParam();
                                paramDelete.setFilter("empName",slBsAccountParam.getEmpName()+"(删除)");
                                int countDelete=super.getCount(SqlId.QUERY_EMPLOYEE_DELETE,paramDelete);
                                BaseParam paramPhoto=new BaseParam();
                                paramPhoto.setFilter("empMobile",slBsAccountParam.getEmpMobile());
                                paramPhoto.setFilter("empName",slBsAccountParam.getEmpName()+"(停用)");
                                //如果员工已停用，不添加
                                int countStop=super.getCount(SqlId.QUERY_EMPLOYEE_STOP,paramPhoto);
                                if(countStop>0 & countDelete==0){
                                    continue;
                                }
                                //查看手机号码，是否已存在
                                int countPhoto=super.getCount(SqlId.QUERY_EMPLOYEE_PHOTO,paramPhoto);
                                if(countPhoto>0){
                                    slBsAccountParam.setEmpMobile(null);
                                }
                                //不存在，调用365外勤接口插入员工信息
                                String saveUrl="employee/v2/addEmployee";
                                WqResponse<?> wqResponseData= WqHttpClient.httpPost(saveUrl, slBsAccountParam, msgId,null);
                                if(null!=wqResponseData){
                                    if(wqResponseData.getReturnCode().equals("0")){
                                        logger.info(slBsAccountParam.getEmpName()+"：添加外勤365员工成功");
                                        insertSuccessCount++;
                                    }else{
                                        logger.error(slBsAccountParam.getEmpName()+"：添加外勤365员工失败");
                                        insertErrorCount++;
                                    }
                                }
                            }
                        }else{
                            logger.info("买手名称为："+slBsAccountParam.getEmpName()+",与冻品管家重复!");
                            continue;
                        }
                    }
                }
                logger.info("添加成功："+insertSuccessCount);
                logger.error("添加失败：" + insertErrorCount);
                logger.info("更新成功："+updateSuccessCount);
                logger.error("更新失败：" + updateErrorCount);
            }else{
                logger.error("接口异常：" + wqResponse.getReturnMsg());
            }
        }
        return null;
    }

    /**
     * 共通方法，查询固定数据
     * @param constantName
     * @param constantType
     * @return BWQ20170202Result
     */

    public BWQ20170202Result querySetting(String constantName,String constantType){
        BaseParam paramConThree=new BaseParam();
        paramConThree.setFilter("constantName",constantName);
        paramConThree.setFilter("constantType",constantType);
        BWQ20170202Result bwq20170202ResultThree=super.findOne(SqlId.QUERY_CONSTANT, paramConThree);
        return bwq20170202ResultThree;
    }

    /**
     * 设置主键id
     * @param list
     * @return
     */
    public void setEmployee(List<BWQ201702Result> list){
        if(CollectionUtils.isNotEmpty(list)){
            List listTwo=new ArrayList();
            for(int i=0;i<list.size();i++){
                BWQ201702Result bwq201702Result=list.get(i);
                int id=i;
                bwq201702Result.setTblId(id++);
                //过滤已删除数据
                if(bwq201702Result.getEmpStatus().equals("1") || bwq201702Result.getEmpStatus().equals("2") || bwq201702Result.getEmpStatus().equals("0")){
                    listTwo.add(bwq201702Result);
                }
            }
            BaseParam baseParam=new BaseParam();
            baseParam.getFilterMap().put("list",listTwo);
            //执行插入操作，并得到结果
            int count=super.save(SqlId.SAVE_EMPLOYEE,baseParam);
            if(count > 0) {
                logger.info("员工信息插入成功");
            }else{
                logger.error("员工信息插入失败");
            }
        }
    }

    /**
     * 赋值额外字段
     */
    public void setExts(SlBsAccountParam slBsAccountParam){
        List listExt=new ArrayList();
        BWQ20170201Result bwq20170201Result=new BWQ20170201Result();
        bwq20170201Result.setExtKey("物流区编码");
        bwq20170201Result.setExtValue(slBsAccountParam.getLgcsAreaName());

        BWQ20170201Result bwq20170201ResultTwo=new BWQ20170201Result();
        bwq20170201ResultTwo.setExtKey("省编码");
        bwq20170201ResultTwo.setExtValue(slBsAccountParam.getProvinceName());

        BWQ20170201Result bwq20170201ResultThree=new BWQ20170201Result();
        bwq20170201ResultThree.setExtKey("地区编码");
        bwq20170201ResultThree.setExtValue(slBsAccountParam.getCityName());

        BWQ20170201Result bwq20170201ResultFore=new BWQ20170201Result();
        bwq20170201ResultFore.setExtKey("区编码");
        bwq20170201ResultFore.setExtValue(slBsAccountParam.getDistrictName());

        BWQ20170201Result bwq20170201ResultFive=new BWQ20170201Result();
        bwq20170201ResultFive.setExtKey("注册来源");
        bwq20170201ResultFive.setExtValue(slBsAccountParam.getFromFlg());

        BWQ20170201Result bwq20170201Resultsix=new BWQ20170201Result();
        bwq20170201Resultsix.setExtKey("传真号");
        bwq20170201Resultsix.setExtValue(slBsAccountParam.getMemo5());
        /*BaseParam baseParamTwo=new BaseParam();
        baseParamTwo.setFilter("byType",slBsAccountParam.getMemo6());
        baseParamTwo.setFilter("account",slBsAccountParam.getEmpCode());
        SlBsAccountParam slBsAccountParam1=super.findOne(SqlId.QUERY_SL_BS_TYPE,baseParamTwo);*/
       // if(null!=slBsAccountParam1){
            //bwq20170201ResultSeven.setExtValue(slBsAccountParam1.getMemo6());
            BWQ20170201Result bwq20170201ResultSeven=new BWQ20170201Result();
            bwq20170201ResultSeven.setExtKey("买手类型");
            if(StringUtil.isNullOrEmpty(slBsAccountParam.getMemo8())){
                bwq20170201ResultSeven.setExtValue(null);
             }
            else if(slBsAccountParam.getMemo8().equals("01") || slBsAccountParam.getMemo8().equals("02")){
                bwq20170201ResultSeven.setExtValue("分销买手");
            }else if(slBsAccountParam.getMemo8().equals("21")){
                bwq20170201ResultSeven.setExtValue("区域配送站买手");
            }else{
                bwq20170201ResultSeven.setExtValue("其他买手");
            }
            listExt.add(bwq20170201ResultSeven);
        // }
        listExt.add(bwq20170201Result);
        listExt.add(bwq20170201ResultTwo);
        listExt.add(bwq20170201ResultThree);
        listExt.add(bwq20170201ResultFore);
        listExt.add(bwq20170201ResultFive);
        listExt.add(bwq20170201Resultsix);
        slBsAccountParam.setExts(listExt);
    }
}
