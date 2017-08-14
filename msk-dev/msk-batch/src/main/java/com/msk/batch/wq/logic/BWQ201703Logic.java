package com.msk.batch.wq.logic;

import com.msk.batch.wq.bean.*;
import com.msk.batch.wq.entity.SlHouseAccount;
import com.msk.batch.wq.entity.WqEmployee;
import com.msk.batch.wq.util.WqHttpClient;
import com.msk.common.logic.CommonLogic;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.utils.DateTimeUtil;
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
public class BWQ201703Logic extends BaseLogic{
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(BWQ201703Logic.class);
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
        /**查询管家信息**/
        static final String QUERY_SL_HOUSE_ACCOUNT="querySlHouseAccount";
        /**根据买手账号，在OMS员工表中查询数据**/
        static final String QUERY_HOUSE_ACCOUNT_ID="queryHouseAccountId";
        /**查询管家的买手**/
        static final String QUERY_HOUSE_BY_ID="queryHouseById";
        /**查询买手类型**/
        static final String QUERY_SL_BS_TYPE="querySlBsType";
        /**查询物流区**/
        static final String QUERY_LGCSAREA_NAME="queryLgcsAreaName";
        /**查询省**/
        static final String QUERY_PROVINCENAME="queryProvinceName";
        /**查询市区**/
        static final String QUERY_CITY_NAME="queryCityName";
        /**查询地区**/
        static final String QUERY_DISTRICT_NAME="queryDistrictName";
        /**查询外勤手机号码**/
        static final String QUERY_HOUSE_TEL="queryHouseTel";
        /**查询管家表手机号码**/
        static final String QUERY_HOUSE_TEL_NO="queryHouseTelNo";
        /**查询管家和买手是否一样**/
        static final String QUERY_HOUSE_SLBS="queryHouseSlBs";
        /**判断已停用的员工**/
        static final String QUERY_EMPLOYEE_STOP_TWO="queryEmployeeStopTwo";
        /**查询管家类型**/
        static final String QUERY_HOSUE_TYPE="queryHouseType";
        /**判断删除的员工**/
        static final String QUERY_EMPLOYEE_DELETE="queryEmployeeDelete";
    }
    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }
    @Autowired
    private BWQ201702Logic bwq201702Logic;
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
        List<BWQ201702Result> list=null;
        if(null!=wqResponse){
            if(wqResponse.getReturnCode().equals("0")){
                //获取data结果集
                list= wqResponse.getData();
                //清空数据，并且执行插入操作
                utilInsertRemove(list);
                //获取OMS数据
                List<BWQ201703Result> slHouseAccountList=super.findList(SqlId.QUERY_SL_HOUSE_ACCOUNT, new BaseParam());
                if(CollectionUtils.isNotEmpty(slHouseAccountList)){
                    for(BWQ201703Result slHouseAccountParam:slHouseAccountList){
                        //获取管家账号
                        String HouseCode=slHouseAccountParam.getHouseCode();
                        BaseParam param=new BaseParam();
                        param.setFilter("houseCode", HouseCode);
                        WqEmployee wqEmployee=super.findOne(SqlId.QUERY_HOUSE_BY_ID, param);
                        //根据OMS员工名称去365外勤查询，如果有的话更新，不存在则插入
                        param.setFilter("empName",slHouseAccountParam.getEmpName());
                        BWQ201702Result resultCount=super.findOne(SqlId.QUERY_HOUSE_ACCOUNT_ID, param);
                        //存在，调用更新接口，更新信息
                        if(null!=resultCount){
                            List listData=new ArrayList();
                            //slHouseAccountParam.setEmpId(slHouseAccountParam.getEmpCode());
                            slHouseAccountParam.setId(resultCount.getId());
                            String updateUrl="employee/v2/modifyEmployee";
                            BaseParam baseParamTwo=new BaseParam();
                            //查询上级
                            if(null!=wqEmployee){
                                baseParamTwo.setFilter("empName",resultCount.getEmpName());
                                //根据emp去查询员工表，是否存在
                                WqEmployee wqEmployeeTwo=super.findOne(SqlId.QUERY_HOUSE_SLBS, baseParamTwo);
                                if(null!=wqEmployeeTwo){
                                    //如果存在，判断name是否是同一个人，如果是不更新上级，如果不是更新上级
                                    if(!wqEmployeeTwo.getEmpName().equals(wqEmployee.getEmpName())){
                                        slHouseAccountParam.setEmpParentId(wqEmployee.getEmpId());
                                    }
                                }
                            }
                            setExts(slHouseAccountParam);
                            slHouseAccountParam.setEmpMobile(null);
                            slHouseAccountParam.setEmpCode(null);
                            BWQ20170202Result bwq20170202ResultTwo=bwq201702Logic.querySetting("冻品管家", "EmpJob");
                            if(null!=bwq20170202ResultTwo){
                                slHouseAccountParam.setEmpJob(bwq20170202ResultTwo.getConstantValue());
                            }
                            WqResponse<?> wqResponseData= WqHttpClient.httpPost(updateUrl, slHouseAccountParam, msgId,null);
                            if(null!=wqResponseData){
                                if(wqResponseData.getReturnCode().equals("0")){
                                    logger.info(slHouseAccountParam.getEmpName()+"：更新外勤365员工成功");
                                    updateSuccessCount++;
                                }else{
                                    logger.error(slHouseAccountParam.getEmpName()+"：更新外勤365员工失败");
                                    updateErrorCount++;
                                }
                            }
                        }else{
                            slHouseAccountParam.setEmpId(slHouseAccountParam.getEmpCode());
                            setExts(slHouseAccountParam);
                            //查询上级
                            if(null!=wqEmployee){
                                slHouseAccountParam.setEmpParentId(wqEmployee.getEmpId());
                            }
                            BWQ20170202Result bwq20170202Result=bwq201702Logic.querySetting("冻品管家默认部门", "EmpOrgIDDefault");
                            if(null!=bwq20170202Result){
                                slHouseAccountParam.setEmpOrgId(bwq20170202Result.getConstantValue());
                            }
                            BWQ20170202Result bwq20170202ResultTwo=bwq201702Logic.querySetting("冻品管家", "EmpJob");
                            if(null!=bwq20170202ResultTwo){
                                slHouseAccountParam.setEmpJob(bwq20170202ResultTwo.getConstantValue());
                            }
                            BWQ20170202Result bwq20170202ResultThree=bwq201702Logic.querySetting("冻品管家", "EmpIsOrgLeader");
                            if(null!=bwq20170202ResultThree){
                                slHouseAccountParam.setEmpIsOrgLearder(bwq20170202ResultThree.getConstantValue());
                            }
                            slHouseAccountParam.setEmpImsiBinding("1");
                            slHouseAccountParam.setEmpStatus("1");

                            //如果员工有删除，可以添加
                            BaseParam paramDelete=new BaseParam();
                            paramDelete.setFilter("empName",slHouseAccountParam.getEmpName()+"(删除)");
                            int countDelete=super.getCount(SqlId.QUERY_EMPLOYEE_DELETE,paramDelete);
                            //如果员工已停用，不添加
                            BaseParam paramPhoto=new BaseParam();
                            paramPhoto.setFilter("empName",slHouseAccountParam.getEmpName()+"(停用)");
                            int countStop=super.getCount(SqlId.QUERY_EMPLOYEE_STOP_TWO,paramPhoto);
                            if(countStop>0 & countDelete==0){
                                continue;
                            }
                            BaseParam paramHouseTel=new BaseParam();
                            paramHouseTel.setFilter("empMobile",slHouseAccountParam.getEmpMobile());
                            //查询外勤员工表，手机号是否存在
                            int countHouseTel=super.getCount(SqlId.QUERY_HOUSE_TEL,paramHouseTel);
                            if(countHouseTel>0){
                                slHouseAccountParam.setEmpMobile(null);
                            }
                            //查询管家表，是否有重复号码，有不传手机号码
                            int houseTelNo=super.getCount(SqlId.QUERY_HOUSE_TEL_NO,paramHouseTel);
                            if(houseTelNo>1){
                                slHouseAccountParam.setEmpMobile(null);
                            }
                            //不存在，调用365外勤接口插入员工信息
                            String saveUrl="employee/v2/addEmployee";
                            WqResponse<?> wqResponseData= WqHttpClient.httpPost(saveUrl, slHouseAccountParam, msgId,null);
                            if(null!=wqResponseData){
                                if(wqResponseData.getReturnCode().equals("0")){
                                    logger.info(slHouseAccountParam.getEmpName()+"：添加外勤365员工成功");
                                    insertSuccessCount++;
                                }else{
                                    logger.error(slHouseAccountParam.getEmpName()+"：添加外勤365员工失败");
                                    insertErrorCount++;
                                }
                            }
                        }
                    }
                }
                logger.info("添加成功："+insertSuccessCount);
                logger.error("添加失败：" + insertErrorCount);
                logger.info("更新成功："+updateSuccessCount);
                logger.error("更新失败："+updateErrorCount);
                utilInsertRemove(list);
            }else{
                logger.error("接口异常：" + wqResponse.getReturnMsg());
            }
        }
        return null;
    }

    /**
     * 共通方法
     * @param list
     */
    public void utilInsertRemove(List<BWQ201702Result> list){
        //先清空表数据
        super.remove(SqlId.REMOVE_EMPLOYEE, new BaseParam());
        logger.info(DateTimeUtil.formatDate("yyyy-MM-dd HH:mm:ss",new Date())+"：员工数据清空成功");
        if(CollectionUtils.isNotEmpty(list)){
            //给主键ID赋值
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
     * 扩展字段赋值
     * @param slHouseAccountParam
     */
    public void setExts(BWQ201703Result slHouseAccountParam){
        List listData=new ArrayList();
        BaseParam baseParamTwo=new BaseParam();
        baseParamTwo.setFilter("houseCode",slHouseAccountParam.getHouseCode());
        BWQ201703Result bwq201703ResultNight=super.findOne(SqlId.QUERY_HOSUE_TYPE,baseParamTwo);
        if(null!=bwq201703ResultNight){
            baseParamTwo.setFilter("byType",bwq201703ResultNight.getHouseType());
        }
        baseParamTwo.setFilter("account",slHouseAccountParam.getEmpCode());
        SlHouseAccount slHouseAccount=super.findOne(SqlId.QUERY_SL_BS_TYPE,baseParamTwo);
        if(null!=slHouseAccount){
            BWQ20170201Result bwq20170201Result=new BWQ20170201Result();
            bwq20170201Result.setExtKey("管家分类");
            bwq20170201Result.setExtValue(slHouseAccount.getHouseCategory());
            listData.add(bwq20170201Result);
        }
        BaseParam paramOne=new BaseParam();
        paramOne.setFilter("vlgcsAreaCode",slHouseAccountParam.getVlgcsAreaCode());
        BWQ201703Result bwq201703Result= super.findOne(SqlId.QUERY_LGCSAREA_NAME,paramOne);
        String vlgcsAreaId="";
        if(null!=bwq201703Result){
            BWQ20170201Result bwq20170201ResultSex=new BWQ20170201Result();
            bwq20170201ResultSex.setExtKey("物流区编码");
            bwq20170201ResultSex.setExtValue(bwq201703Result.getVdistrictName());
            vlgcsAreaId=bwq201703Result.getVlgcsAreaId();
            listData.add(bwq20170201ResultSex);
        }
        BaseParam paramTwo=new BaseParam();
        paramTwo.setFilter("vprovinceCode",slHouseAccountParam.getVprovinceCode());
        BWQ201703Result bwq201703ResultTwo= super.findOne(SqlId.QUERY_PROVINCENAME,paramTwo);
        if(null!=bwq201703ResultTwo){
            BWQ20170201Result bwq20170201ResultTwo=new BWQ20170201Result();
            bwq20170201ResultTwo.setExtKey("省编码");
            bwq20170201ResultTwo.setExtValue(bwq201703ResultTwo.getVprovinceName());
            listData.add(bwq20170201ResultTwo);
            BaseParam paramThree=new BaseParam();
            paramThree.setFilter("vcityCode",slHouseAccountParam.getVcityCode());
            paramThree.setFilter("vprovinceId",vlgcsAreaId);
            if(null!=bwq201703Result){
                paramThree.setFilter("vlgcsAreaId",bwq201703Result.getVlgcsAreaId());
            }
            BWQ201703Result bwq201703ResultThree= super.findOne(SqlId.QUERY_CITY_NAME,paramThree);
            if(null!=bwq201703ResultThree){
                BWQ20170201Result bwq20170201ResultThree=new BWQ20170201Result();
                bwq20170201ResultThree.setExtKey("地区编码");
                bwq20170201ResultThree.setExtValue(bwq201703ResultThree.getVcityName());
                listData.add(bwq20170201ResultThree);
                BaseParam paramForm=new BaseParam();
                paramForm.setFilter("vdistrictCode",slHouseAccountParam.getVdistrictCode());
                paramForm.setFilter("vcityId",bwq201703ResultThree.getVcityId());
                BWQ201703Result bwq201703ResultForm= super.findOne(SqlId.QUERY_DISTRICT_NAME,paramForm);
                if(null!=bwq201703ResultForm){
                    BWQ20170201Result bwq20170201ResultFour=new BWQ20170201Result();
                    bwq20170201ResultFour.setExtKey("区编码");
                    bwq20170201ResultFour.setExtValue(bwq201703ResultForm.getVdistrictName());
                    listData.add(bwq20170201ResultFour);
                }
            }
        }
        BWQ20170201Result bwq20170201ResultFive=new BWQ20170201Result();
        bwq20170201ResultFive.setExtKey("传真号");
        bwq20170201ResultFive.setExtValue(slHouseAccountParam.getFax());
        listData.add(bwq20170201ResultFive);
        slHouseAccountParam.setExts(listData);
    }
}
