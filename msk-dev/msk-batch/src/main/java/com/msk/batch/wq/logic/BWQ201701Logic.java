package com.msk.batch.wq.logic;

import com.msk.batch.wq.bean.*;
import com.msk.batch.wq.entity.SlHouseAccount;
import com.msk.batch.wq.util.WqHttpClient;
import com.msk.common.logic.CommonLogic;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by air on 2017/1/9.
 */
@Service
public class BWQ201701Logic extends BaseLogic{

    private static Logger logger = LoggerFactory.getLogger(BWQ201701Logic.class);

    public interface SqlId {
        static final String SQLID_INSERT_OMSDATA = "insertCmCustomer";
        static final String SQLID_SELECT_BUYERSINOMS = "selectBuyserInOMS";
        static final String SQLID_DELETE_ALLWQCUSTOMER = "deleteAllWqCustomer";
        static final String SQLID_SELECT_ISHIMINTHETABLE = "selectHimInTheTable";
        static final String QUERY_BU_STATUS = "queryBuStatus";
        static final String QUERY_BU_HOUSE = "queryByHouse";
    }

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }
    @Autowired
    CommonLogic commonLogic;

    public void deleteAllWqCustomer(BaseParam param){
        super.remove(SqlId.SQLID_DELETE_ALLWQCUSTOMER,param);
    }

    public void insertCmCustomer(List<BWQ201701Bean3> bwq201701BeanList){
        //给主键ID赋值
        List listTwo=new ArrayList();
        if(CollectionUtils.isNotEmpty(bwq201701BeanList)){
            for(int i=0;i<bwq201701BeanList.size();i++){
                BWQ201701Bean3 bwq201701Bean3=bwq201701BeanList.get(i);
                int id=i;
                bwq201701Bean3.setTbl_id(id++);
                listTwo.add(bwq201701Bean3);
            }
            //如果数据大于两千，分批插入
            List<BWQ201701Bean3> bwq201701Bean3List=null;
            if(listTwo.size()>1000){
                for(int i=0;i<=listTwo.size()/1000;i++){
                    bwq201701Bean3List=new ArrayList<>();
                    //判断是最后一次循环并且余数大于0
                    if(i==listTwo.size()/1000 & listTwo.size()%1000>0){
                        //取余数插入
                        bwq201701Bean3List=listTwo.subList(i*1000,i*1000+listTwo.size()%1000);
                    }else{
                        //取整数插入
                        bwq201701Bean3List=listTwo.subList(i*1000,i*1000+1000);
                    }
                    BaseParam baseParam=new BaseParam();
                    //执行插入操作，并得到结果
                    baseParam.getFilterMap().put("listData",bwq201701Bean3List);
                    int count=super.save(SqlId.SQLID_INSERT_OMSDATA, baseParam);
                    if(count>0){
                        logger.info("插入外勤客户表第："+i+"批分批成功");
                    }else{
                        logger.error("插入外勤客户表第："+i+"批分批失败");
                    }
                }
            }else{
                BaseParam baseParam=new BaseParam();
                //执行插入操作，并得到结果
                baseParam.getFilterMap().put("listData",listTwo);
                int count=super.save(SqlId.SQLID_INSERT_OMSDATA, baseParam);
                if(count>0){
                    logger.info("插入外勤客户表成功");
                }else{
                    logger.error("插入外勤客户表失败");
                }
            }
        }
    }


    //查询所有OMS买家表的买家名称
    public List<BWQ201701Bean2> selectBuyerInfo(BaseParam param){
        List<BWQ201701Bean2> bwq201701Beans = super.findList(SqlId.SQLID_SELECT_BUYERSINOMS,param);
        return bwq201701Beans;
    }

    public BWQ201701Bean isHimInTheTable(BWQ201701Bean2 testOne){
        BaseParam param = new BaseParam();
        param.setFilter("buyerName",testOne.getBuyerName());
        BWQ201701Bean bean = super.findOne(SqlId.SQLID_SELECT_ISHIMINTHETABLE, param);
        return bean;
    }

    //将status状态，转换为状态名称
    public String byStatusToName(String status){
        BaseParam param = new BaseParam();
        param.setFilter("marketingsStatus",status);
        BWQ201701Bean2 bean = super.findOne(SqlId.QUERY_BU_STATUS, param);
        if(null!=bean){
            return bean.getMarketingsStatus();
        }
        return null;
    }

    //查找买家的管家
    public String queryByHouse(String buyerId){
        BaseParam param = new BaseParam();
        param.setFilter("buyerId",buyerId);
        SlHouseAccount bean = super.findOne(SqlId.QUERY_BU_HOUSE, param);
        if(null!=bean){
            return bean.getHouseShowName();
        }
        return null;
    }

    /**
     * 查询接口数据
     * @param url 路径
     * @param key
     * @param msgId
     * @return 返回查询结果
     */
    public WqResponse<BWQ201701Bean3> queryWqResponseData(String url,BWQ201701Param key,String msgId){
        WqResponse<BWQ201701Bean3> rs = WqHttpClient.httpPost(url, key, msgId, BWQ201701Bean3.class);
        return rs;
    }

    /**
     * 赋值额外字段
     */
    public void setExts(BWQ201701Bean3 key2,BWQ201701Bean2 testOne){
        BWQ20170101Result bwq20170101Result=new BWQ20170101Result();
        bwq20170101Result.setExtKey("买家网站");
        bwq20170101Result.setExtValue(testOne.getBuyerWebsite());
        BWQ20170101Result bwq20170101ResultOne=new BWQ20170101Result();
        bwq20170101ResultOne.setExtKey("城市地区编码");
        bwq20170101ResultOne.setExtValue(testOne.getCityName());
        BWQ20170101Result bwq20170101ResultTwo=new BWQ20170101Result();
        bwq20170101ResultTwo.setExtKey("区县编码");
        bwq20170101ResultTwo.setExtValue(testOne.getDistrictName());
        BWQ20170101Result bwq20170101ResultThree=new BWQ20170101Result();
        bwq20170101ResultThree.setExtKey("买家微信公众号");
        bwq20170101ResultThree.setExtValue(testOne.getBuyerWechat());
        BWQ20170101Result bwq20170101ResultForm=new BWQ20170101Result();
        bwq20170101ResultForm.setExtKey("店铺面积");
        bwq20170101ResultForm.setExtValue(testOne.getStoreArea());
        BWQ20170101Result bwq20170101ResultNight=new BWQ20170101Result();
        bwq20170101ResultNight.setExtKey("店铺名称");
        bwq20170101ResultNight.setExtValue(testOne.getStoreNo());
        BWQ20170101Result bwq20170101ResultFive=new BWQ20170101Result();
        bwq20170101ResultFive.setExtKey("员工人数");
        bwq20170101ResultFive.setExtValue(testOne.getEmployeesNum());
        BWQ20170101Result bwq20170101ResultSex=new BWQ20170101Result();
        bwq20170101ResultSex.setExtKey("习惯支付方式");
        bwq20170101ResultSex.setExtValue(testOne.getPaymentType());
        BWQ20170101Result bwq20170101ResultServen=new BWQ20170101Result();
        bwq20170101ResultServen.setExtKey("上线状态");
        bwq20170101ResultServen.setExtValue(byStatusToName(testOne.getMarketingsStatus()));
        List<BWQ20170101Result> listAddData=new ArrayList();
        listAddData.add(bwq20170101Result);
        listAddData.add(bwq20170101ResultOne);
        listAddData.add(bwq20170101ResultTwo);
        listAddData.add(bwq20170101ResultThree);
        listAddData.add(bwq20170101ResultForm);
        listAddData.add(bwq20170101ResultNight);
        listAddData.add(bwq20170101ResultFive);
        listAddData.add(bwq20170101ResultSex);
        listAddData.add(bwq20170101ResultServen);
        key2.setExts(listAddData);
    }
}
