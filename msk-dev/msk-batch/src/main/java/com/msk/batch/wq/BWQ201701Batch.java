package com.msk.batch.wq;


import com.msk.batch.base.BaseBatch;
import com.msk.batch.wq.bean.*;
import com.msk.batch.wq.logic.BWQ201701Logic;
import com.msk.batch.wq.util.Md5;
import com.msk.batch.wq.util.WqHttpClient;
import com.msk.core.bean.BaseParam;
import com.msk.core.consts.NumberConst;
import com.msk.core.utils.DateTimeUtil;
import com.msk.core.utils.StringUtil;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by air on 2017/1/9.
 */
@Component("BWQ201701")
public class BWQ201701Batch extends BaseBatch{

    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(BWQ201701Logic.class);
    //插入数据成功统计
    private Integer insertSuccessCount=0;
    //更新成功数据统计
    private Integer updateSuccessCount=0;
    //插入数据失败统计
    private Integer insertErrorCount=0;
    //更新数据失败统计
    private Integer updateErrorCount=0;

    /** 注入BWQ201701Logic */
    @Autowired
    private BWQ201701Logic bwq201701Logic;

    /**
     * 创建Param
     *
     * @param args String[]
     * @return BWQ201701Param
     */
    @Override
    public BaseParam createParam(String[] args) {
        logger.debug("BWQ201701Batch创建param");

        BWQ201701Param param = new BWQ201701Param();

        Date currentDate = DateTimeUtil.getCustomerDate();
        param.setCurrentDate(currentDate);
        return param;
    }

    /**
     * 业务处理
     *
     * @param param param
     */
    @Override
    public void doOperate(BaseParam param) {
        logger.debug("BWQ201701Batch的doOperate");
        //从365外勤接口那边查出客户信息保存在OMS的wq_customer表里
        String url = "customer/v1/queryCustomer";
        String msgId = "BWQ201701";
        BWQ201701Param key=new BWQ201701Param();
        WqResponse<BWQ201701Bean3> rs=null;
        //将每次分页取到的数据，放到一个集合里面。以便操作
        List<BWQ201701Bean3> datas=new ArrayList();
        int countNumber=0;
        do {
            countNumber++;
            if(countNumber>=2){
                key.setPageNumber(countNumber);
                rs=bwq201701Logic.queryWqResponseData(url,key,msgId);
            }else{
                key.setPageNumber(NumberConst.IntDef.INT_ONE);
                rs = bwq201701Logic.queryWqResponseData(url,key,msgId);
            }
            datas.addAll(rs.getData());
            //如果取到的结果集不等于空，并且集合大小大于等于1000，表示还有下一页。继续取值
        }while(null!=rs & null!=rs.getData() & rs.getData().size()>=1000);
        if(null!=rs & rs.getReturnCode().equals("0")){
            //每次批处理先删除wq_customer表数据
            bwq201701Logic.deleteAllWqCustomer(param);
            if(CollectionUtils.isNotEmpty(datas)){
                //执行插入操作，插入到外勤客户表
                bwq201701Logic.insertCmCustomer(datas);
            }
            List<BWQ201701Bean2> allBuyers=new ArrayList<>();
            //从OMS买家表里找出所有买家，挨个去刚才的wq_customer表里进行循环查询，如果有相同的就更新365外勤接口，没有就插入
            //1.先找出所有买家信息
            if(null!=datas & datas.size()>0){
                param.setFilter("flg","1");
                allBuyers=bwq201701Logic.selectBuyerInfo(param);
            }else{
                allBuyers=bwq201701Logic.selectBuyerInfo(param);
            }

            if(null!=allBuyers & allBuyers.size()>0){
                for (int i=0;i<allBuyers.size();i++){
                    BWQ201701Bean2 testOne = allBuyers.get(i);
                    // if(i>allBuyers.size()-50){
                    //3.拿这个去wq_customer表里查，看存在与否
                    BWQ201701Bean yesOrno = bwq201701Logic.isHimInTheTable(testOne);
                    String url2 =null;
                    String msgId2 ="BWQ201701";
                    BWQ201701Bean3 key2 = new BWQ201701Bean3();
                    //如果不存在，执行新增操作
                    if(null==yesOrno){
                        key2.setCm_id(testOne.getBuyerId());
                        key2.setCm_code(testOne.getBuyerCode());
                        key2.setCm_tel(testOne.getTelNo());
                        key2.setCm_name(testOne.getBuyerName());
                        key2.setCm_type(testOne.getSuperiorName());
                        key2.setCm_type_code(testOne.getSuperiorType());
                        key2.setCm_district(testOne.getLgcsAreaName());
                        key2.setCm_mss_province(testOne.getProvinceName());
                        key2.setCm_mss_city(testOne.getCityName());
                        key2.setCm_mss_area(testOne.getDistrictName());
                        key2.setCm_addr(testOne.getBuyerAddr());
                        key2.setCm_manager(bwq201701Logic.queryByHouse(testOne.getBuyerId()));
                        bwq201701Logic.setExts(key2,testOne);
                        //插入365接口`
                        url2 = "customer/v1/addCustomer";
                        WqResponse<BWQ201701Bean3> rss =WqHttpClient.httpPost(url2, key2, msgId2,BWQ201701Bean3.class);
                        if(null!=rss){
                            if(rss.getReturnCode().equals("0")){
                                logger.info(key2.getCm_name()+"：新增外勤365客户成功！");
                                insertSuccessCount++;
                            }else{
                                logger.error(key2.getCm_name()+"：新增外勤365客户失败！");
                                insertErrorCount++;
                            }
                        }
                    }else {
                        //本地id不存在，跳出进入下一次循环
                        if(StringUtil.isNullOrEmpty(yesOrno.getCmId())){
                            //暂未开放
                            //key2.setId(yesOrno.getId());
                            continue;
                        }else{
                            key2.setCm_id(yesOrno.getCmId());
                        }
                        key2.setCm_code(testOne.getBuyerCode());
                        key2.setCm_name(testOne.getBuyerName());
                        key2.setCm_tel(testOne.getTelNo());
                        key2.setCm_manager(bwq201701Logic.queryByHouse(testOne.getBuyerId()));
                        key2.setCm_district(testOne.getLgcsAreaName());
                        key2.setCm_mss_province(testOne.getProvinceName());
                        key2.setCm_mss_city(testOne.getCityName());
                        key2.setCm_mss_area(testOne.getDistrictName());
                        key2.setCm_addr(testOne.getBuyerAddr());
                        key2.setCm_type(testOne.getSuperiorName());
                        key2.setCm_type_code(testOne.getSuperiorType());
                        bwq201701Logic.setExts(key2,testOne);
                        url2 = "customer/v1/modifyCustomer";
                        WqResponse<BWQ201701Bean3> rsss =WqHttpClient.httpPost(url2, key2, msgId2,BWQ201701Bean3.class);
                        if(null!=rsss){
                            if(rsss.getReturnCode().equals("0")){
                                logger.info(key2.getCm_name()+"：更新外勤365客户信息成功！");
                                updateSuccessCount++;
                            }else{
                                logger.error(key2.getCm_name()+"：更新外勤365客户信息失败！");
                                updateErrorCount++;
                            }
                        }
                    }
                }
            }
            logger.info("添加成功："+insertSuccessCount);
            logger.error("添加失败：" + insertErrorCount);
            logger.info("更新成功："+updateSuccessCount);
            logger.error("更新失败：" + updateErrorCount);
        }else{
            logger.error("接口异常：" + rs.getReturnMsg());
        }
    }
}
