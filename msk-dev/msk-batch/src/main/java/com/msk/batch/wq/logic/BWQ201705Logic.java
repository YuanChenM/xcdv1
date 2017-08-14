package com.msk.batch.wq.logic;

import com.msk.batch.wq.bean.*;
import com.msk.batch.wq.entity.WqOrder;
import com.msk.batch.wq.util.WqConfigInfo;
import com.msk.batch.wq.util.WqHttpClient;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.consts.NumberConst;
import com.msk.core.utils.DateTimeUtil;
import com.msk.core.utils.StringUtil;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * Created by pxg on 2017/1/9 0009.
 */
@Service
public class BWQ201705Logic extends BaseLogic{
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(BWQ201705Logic.class);
    //插入数据成功统计
    private Integer insertSuccessCount=0;
    //更新成功数据统计
    private Integer updateSuccessCount=0;
    //插入数据失败统计
    private Integer insertErrorCount=0;
    //更新数据失败统计
    private Integer updateErrorCount=0;
    //插入数据成功统计子表
    private Integer insertSuccessCountChild=0;
    //更新成功数据统计子表
    private Integer updateSuccessCountChild=0;
    //插入数据失败统计子表
    private Integer insertErrorCountChild=0;
    //更新数据失败统计子表
    private Integer updateErrorCountChild=0;
    //插入数据成功统计365
    private Integer insertSuccessCount365=0;
    //更新成功数据统计365
    private Integer updateSuccessCount365=0;
    //插入数据失败统计365
    private Integer insertErrorCount365=0;
    //更新数据失败统计365
    private Integer updateErrorCount365=0;
    /**
     * SQL Map 中SQL ID定义
     * @author pxg
     */
    public interface SqlId{

        /**保存365全部数据到OMS订单表中**/
        static final String SAVE_WQ_ORDER="saveWqOrder";
        /**保存365单一数据到OMS订单表中**/
        static final String SAVE_WQ_ORDER_ONE="saveWqOrderOne";
        /**保存365数据到OMS订单产品表中**/
        static final String SAVE_WQ_ORDER_PRODUCT="saveWqOrderProDuct";
        /**查询订单已有的数据最大ID值**/
        static final String QUERY_NAX_WQ_ORDER_ID="queryMaxWqOrderId";
        /**查询订单产品已有的数据最大ID值**/
        static final String QUERY_NAX_WQ_ORDER_PRODUCT_ID="queryMaxWqOrderProDuctId";
        /**获取oms订单数据和订单产品数据**/
        static final String QUERY_ORDER_AND_PRODUCT="queryOrderAndProduct";
        /**查询全部orderCode**/
        static final String QUERY_ORDER_CODE="queryOrderCode";
        /**查询wqOrder是否存在记录**/
        static final String QUERY_WQ_ORDER_CODE="queryWqOrderCode";
        /**查询外勤365返回数据是否存在于wqOrder**/
        static final String QUERY_WQ_ORDER="queryWqOrder";
        /**更新wqOrder**/
        static final String UPDATE_WQ_ORDER_ONE="updateWqOrderOne";
        /**更新订单产品数据**/
        static final String UPDATE_WQ_ORDER_PRODUCT="updateWqOrderProDuct";
        /**根据订单id和产品编码查询产品子表id**/
        static final String QUERY_WQ_ORDER_PRODUCT_ID="queryWqOrderProductId";
        /**根据买家id查询365买家id**/
        static final String QUERY_WQ_CUSTOMER_ID="queryWqCustomerId";
        /**查询时间段**/
        static final String QUERY_COMMTIME_ID="queryCommTimeId";
        /**根据slcode取值slName**/
        static final String QUERY_SHOWNAMEBY_SLCODE="queryShowNameBySlCode";
    }
    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }
    private static WqConfigInfo config;
    @Autowired
    public void setConfigInfo(final WqConfigInfo config) {
        BWQ201705Logic.config = config;
    }
    /** 注入BWQ201701Logic */
    @Autowired
    private BWQ201701Logic bwq201701Logic;
    /**
     * 业务处理
     * @param url 请求路径
     * @param msgId msgid
     * @return 结果集
     */
    public void queryUserDefined(String url,String msgId){
        //查询临时表数据
        int orderCount=ifWqOrderIsNull();
        String flg=null;
        //判断临时表数据是否为空
        if(orderCount>0){
            //外勤查询接口拆分，传入参数flg为1
            flg="1";
            List<BWQ201705Result> bwq201705ResultSplit=resultList(url,msgId,flg);
            //判断接口返回值是否为空
            if(CollectionUtils.isNotEmpty(bwq201705ResultSplit)){
                for(BWQ201705Result bwq201705Result:bwq201705ResultSplit){
                    //获取订单编码去查询数据是否存在
                    String orderCode=bwq201705Result.getPt().getSlfdf1701180002();
                    BaseParam baseParam=new BaseParam();
                    baseParam.setFilter("orderCode",orderCode);
                    //执行查询
                    int returnWqOrderCount=super.getCount(SqlId.QUERY_WQ_ORDER,baseParam);
                    //记录存在
                    if(returnWqOrderCount>0){
                        //执行更新接口操作
                        updateWqOrder(bwq201705Result);
                    }else{
                        //执行新增接口操作
                        saveWqOrder(bwq201705Result);
                    }
                }
            }
        }else{
            //不拆分全部查询，传入参数0
            flg="0";
            List<BWQ201705Result> bwq201705ResultList=resultList(url,msgId,flg);
            if(CollectionUtils.isNotEmpty(bwq201705ResultList)){
                //执行全部新增接口操作
                saveWqOrders(bwq201705ResultList);
            }
        }
        //查询临时表数据
        int orderCount2=ifWqOrderIsNull();
        //判断数据是否存在
        BaseParam param=new BaseParam();
        if(orderCount2>0){
            //获取全部的订单编码，查询封装
            List<WqOrder> wqOrderList=null;
            //判断365外勤数据集是否有值，有值的话，只新增3天的订单，没有值的话新增全部数据
            param.setFilter("flg","1");
            wqOrderList= super.findList(SqlId.QUERY_ORDER_CODE, param);
            //如果拆分后的数据不为空
            if(CollectionUtils.isNotEmpty(wqOrderList)){
                for(WqOrder wqOrder:wqOrderList){
                    //获取订单编码
                    String orderCode=wqOrder.getOrderCode();
                    param.setFilter("orderCode",orderCode);
                    //查询本地数据临时表是否存在
                    int returnWqOrderCount=super.getCount(SqlId.QUERY_WQ_ORDER,param);
                    if(returnWqOrderCount>0){
                        //执行更新操作
                        updateWqOrderAndProduct(param,msgId);
                    }else{
                        //执行新增操作
                        saveWqOrderAndProduct(param,msgId);
                    }
                }
            }
        }else{
            //调用添加365接口方法
            saveWqOrderAndProduct(new BaseParam(),msgId);
        }
        logger.info("本地添加成功："+insertSuccessCount);
        logger.error("本地添加失败：" + insertErrorCount);
        logger.info("本地更新成功："+updateSuccessCount);
        logger.error("本地更新失败："+updateErrorCount);
        logger.info("本地产品添加成功："+insertSuccessCountChild);
        logger.error("本地产品添加失败：" + insertErrorCountChild);
        logger.info("本地产品更新成功："+updateSuccessCountChild);
        logger.error("本地产品更新失败："+updateErrorCountChild);
        logger.info("365添加成功："+insertSuccessCount365);
        logger.error("365添加失败：" + insertErrorCount365);
        logger.info("365更新成功："+updateSuccessCount365);
        logger.error("365更新失败："+updateErrorCount365);
    }

    /**
     * 查询外勤365接口
     * @return
     */
    public List<BWQ201705Result> resultList(String url,String msgId,String flg){
        //创建请求参数,并且赋值
        BWQ201705Param bwq201705Param=new BWQ201705Param();
        bwq201705Param.setForm_id(config.getFormid());
        bwq201705Param.setRows("1000");
        //365外勤查询标示，为1表示要进行拆分查询
        if(flg.equals("1")){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar c = Calendar.getInstance();
            String endTime=sdf.format(c.getTime());
            c.add(Calendar.DATE, - 2);
            String startTime = sdf.format(c.getTime());
            //赋值拆分查询条件
            bwq201705Param.setDate_start(startTime);
            bwq201705Param.setDate_end(endTime);
        }
        //将每次分页取到的数据，放到一个集合里面。以便操作
        List<BWQ201705Result> datas=new ArrayList();
        WqResponse<BWQ201705Result> wqResponse=null;
        int countNumber=0;
        do {
            countNumber++;
            //如果countNumber大于等于2，表示第二次取值
            if(countNumber>=2){
                bwq201705Param.setPage(String.valueOf(countNumber));
                //调用共通post请求，得到结果集
                wqResponse= WqHttpClient.httpPost(url, bwq201705Param, msgId, BWQ201705Result.class);
            }else{
                bwq201705Param.setPage("1");
                //调用共通post请求，得到结果集
                wqResponse=WqHttpClient.httpPost(url,bwq201705Param,msgId,BWQ201705Result.class);
            }
            //将每次得到的值，合并到datas集合中
            datas.addAll(wqResponse.getData());
            //如果取到的结果集不等于空，并且集合大小大于等于1000，表示还有下一页。继续取值
        }while(null!=wqResponse & null!=wqResponse.getData() & wqResponse.getData().size()>=1000);
        return datas;
    }

    /**
     * @param list 通过接口取到的结果集
     * 保存365所有订单信息
     */
    @Transactional
    public void saveWqOrders(List<BWQ201705Result> list){
        logger.info("执行订单全部插入...");
        //查询订单已有的数据最大ID值
        int countWqOrder=super.getCount(SqlId.QUERY_NAX_WQ_ORDER_ID,new BaseParam());
        for(int i=0;i<list.size();i++){
            BWQ201705Result bwq201705Result=list.get(i);
            //如果取到的值小于等于0，表示没有数据，从1开始赋值，如果有值，直接往上加
            //判断赋值情况
            if(i>0){
                if(countWqOrder<=0){
                    int count=i;
                    bwq201705Result.getPt().setTblId(Long.valueOf(++count));
                }else{
                    bwq201705Result.getPt().setTblId(Long.valueOf(++countWqOrder));
                }
            }else{
                //如果取到的值小于等于0，表示没有数据，从1开始赋值，如果有值，直接往上加
                if(countWqOrder<=0){
                    bwq201705Result.getPt().setTblId(Long.valueOf(NumberConst.IntDef.INT_ONE));
                }else{
                    bwq201705Result.getPt().setTblId(Long.valueOf(++countWqOrder));
                }
            }
        }
        //如果数据大于两千，分批插入
        List<BWQ201705Result> bwq201705ResultList=null;
        if(list.size()>1000){
            for(int i=0;i<=list.size()/1000;i++){
                bwq201705ResultList=new ArrayList<>();
                //判断是最后一次循环并且余数大于0
                if(i==list.size()/1000 & list.size()%1000>0){
                    //取余数插入
                    bwq201705ResultList=list.subList(i*1000,i*1000+list.size()%1000);
                }else{
                    //取整数插入
                    bwq201705ResultList=list.subList(i*1000,i*1000+1000);
                }
                BaseParam saveParam=new BaseParam();
                saveParam.getFilterMap().put("listPt",bwq201705ResultList);
                int returnCount=super.save(SqlId.SAVE_WQ_ORDER,saveParam);
                if(returnCount>0) {
                    logger.info("365订单数据分批第："+i+"批插入本地成功!");
                    insertSuccessCount++;
                } else {
                    logger.error("365订单数据分批第："+i+"批插入本地失败!");
                    insertErrorCount++;
                }
            }
        }else{
            BaseParam saveParam=new BaseParam();
            saveParam.getFilterMap().put("listPt",list);
            int returnCount=super.save(SqlId.SAVE_WQ_ORDER,saveParam);
            if(returnCount>0){
                logger.info("365订单数据插入本地成功!");
                insertSuccessCount++;
            }else {
                logger.error("365订单数据插入本地失败!");
                insertErrorCount++;
            }
        }
        //产品信息插入
            for(int j=0;j<list.size();j++){
                BWQ201705Result bwq201705ResultProduct=list.get(j);
                for(int z=0;z<bwq201705ResultProduct.getSts().size();z++){
                    BWQ2017050202Bean bwq2017050202Bean=bwq201705ResultProduct.getSts().get(z);
                    //开始执行订单产品信息插入, 查询订单产品已有的数据最大ID值
                    int countWqOrderProduct=super.getCount(SqlId.QUERY_NAX_WQ_ORDER_PRODUCT_ID,new BaseParam());
                    //取到订单产品结果集
                    List<BWQ201705020201Bean> bwq201705020201BeanList=bwq2017050202Bean.getRows();
                    for(int k=0;k<bwq201705020201BeanList.size();k++){
                        //获取其中一个产品
                        BWQ201705020201Bean bwq201705020201Bean=bwq201705020201BeanList.get(k);
                        //判断赋值情况
                        if(k>0){
                            if(countWqOrderProduct<=0){
                                int count=k;
                                bwq201705020201Bean.setTblId(Long.valueOf(++count));
                            }else{
                                bwq201705020201Bean.setTblId(Long.valueOf(++countWqOrderProduct));
                            }
                        }else{
                            //如果取到的值小于等于0，表示没有数据，从1开始赋值，如果有值，直接往上加
                            if(countWqOrderProduct<=0){
                                bwq201705020201Bean.setTblId(Long.valueOf(NumberConst.IntDef.INT_ONE));
                            }else{
                                bwq201705020201Bean.setTblId(Long.valueOf(++countWqOrderProduct));
                            }
                        }
                    }
                    //如果数据大于两千，分批插入
                   /* List<BWQ201705020201Bean> bwq201705020201BeanLists=null;
                    if(bwq201705020201BeanList.size()>1000){
                        for(int i=0;i<bwq201705020201BeanList.size()/1000;i++){
                            BaseParam saveWqOrderProductParam=new BaseParam();
                            bwq201705020201BeanLists=new ArrayList<>();
                            int number=i;
                            //判断是最后一次循环并且余数大于0
                            if(i==bwq201705020201BeanList.size()/1000 & bwq201705020201BeanList.size()%1000>0){
                                bwq201705020201BeanLists=bwq201705020201BeanList.subList(i*1000,i*1000+bwq201705020201BeanList.size()%1000);
                            }else{
                                bwq201705020201BeanLists=bwq201705020201BeanList.subList(i*1000,i*1000+1000);
                            }
                            saveWqOrderProductParam.setFilter("orderId",bwq201705ResultProduct.getPt().getSourceCode());
                            saveWqOrderProductParam.setFilter("wqId",bwq201705ResultProduct.getPt().getId());
                            saveWqOrderProductParam.getFilterMap().put("listSts",bwq201705020201BeanLists);
                            int returnWOrderPdCount=super.save(SqlId.SAVE_WQ_ORDER_PRODUCT,saveWqOrderProductParam);
                            if(returnWOrderPdCount>0) {
                                logger.info(bwq201705ResultProduct.getPt().getSlfdf1701180002()+":365订单产品数据批量第："+i+"批插入本地成功!");
                                insertSuccessCountChild++;
                            }else{
                                logger.error(bwq201705ResultProduct.getPt().getSlfdf1701180002()+":365订单产品数据批量第："+i+"批插入本地失败!");
                                insertErrorCountChild++;
                            }
                        }
                    }else{*/
                        BaseParam saveWqOrderProductParam=new BaseParam();
                        saveWqOrderProductParam.setFilter("orderId",bwq201705ResultProduct.getPt().getSourceCode());
                        saveWqOrderProductParam.setFilter("wqId",bwq201705ResultProduct.getPt().getId());
                        saveWqOrderProductParam.getFilterMap().put("listSts",bwq201705020201BeanList);
                        int returnWOrderPdCount=super.save(SqlId.SAVE_WQ_ORDER_PRODUCT,saveWqOrderProductParam);
                        if(returnWOrderPdCount>0) {
                            logger.info(bwq201705ResultProduct.getPt().getSlfdf1701180002()+":365订单产品数据插入本地成功!");
                            insertSuccessCountChild++;
                        }else{
                            logger.error(bwq201705ResultProduct.getPt().getSlfdf1701180002() + ":365订单产品数据插入本地失败!");
                            insertErrorCountChild++;
                        }
                    /*}*/
                }
            }
    }

    /**
     * @param bwq201705Result 单一对象数据
     * 保存365单一订单信息
     */
    @Transactional
    public void saveWqOrder(BWQ201705Result bwq201705Result){
        logger.info("执行订单单一插入...");
        //查询订单已有的数据最大ID值
        int countWqOrder=super.getCount(SqlId.QUERY_NAX_WQ_ORDER_ID,new BaseParam());
        if(countWqOrder<=0){
            bwq201705Result.getPt().setTblId(Long.valueOf(NumberConst.IntDef.INT_ONE));
        }else{
            bwq201705Result.getPt().setTblId(Long.valueOf(++countWqOrder));
        }
        BaseParam saveParam=new BaseParam();
        saveParam.getFilterMap().put("bwq201705Result",bwq201705Result);
        int returnCount=super.save(SqlId.SAVE_WQ_ORDER_ONE,saveParam);
        if(returnCount>0){
            logger.info("365订单数据插入本地成功!");
            insertSuccessCount++;
            //判断产品是不是空
            if(CollectionUtils.isNotEmpty(bwq201705Result.getSts())){
                for(int k=0;k<bwq201705Result.getSts().size();k++){
                    BWQ2017050202Bean bwq2017050202Bean=bwq201705Result.getSts().get(k);
                    //开始执行订单产品信息插入, 查询订单产品已有的数据最大ID值
                    int countWqOrderProduct=super.getCount(SqlId.QUERY_NAX_WQ_ORDER_PRODUCT_ID,new BaseParam());
                    //取到订单产品结果集
                    if(CollectionUtils.isNotEmpty(bwq2017050202Bean.getRows())){
                        for(int y=0;y<bwq2017050202Bean.getRows().size();y++){
                            BWQ201705020201Bean bwq201705020201Bean=bwq2017050202Bean.getRows().get(y);
                            //判断赋值情况
                            if(y>0){
                                if(countWqOrderProduct<=0){
                                    int count=k;
                                    bwq201705020201Bean.setTblId(Long.valueOf(++count));
                                }else{
                                    bwq201705020201Bean.setTblId(Long.valueOf(++countWqOrderProduct));
                                }
                            }else{
                                //如果取到的值小于等于0，表示没有数据，从1开始赋值，如果有值，直接往上加
                                if(countWqOrderProduct<=0){
                                    bwq201705020201Bean.setTblId(Long.valueOf(NumberConst.IntDef.INT_ONE));
                                }else{
                                    bwq201705020201Bean.setTblId(Long.valueOf(++countWqOrderProduct));
                                }
                            }
                        }
                    }
                    BaseParam saveWqOrderProductParam=new BaseParam();
                    saveWqOrderProductParam.setFilter("wqId",bwq201705Result.getPt().getId());
                    saveWqOrderProductParam.setFilter("orderId",bwq201705Result.getPt().getSourceCode());
                    saveWqOrderProductParam.getFilterMap().put("listSts",bwq2017050202Bean.getRows());
                    int returnWOrderPdCount=super.save(SqlId.SAVE_WQ_ORDER_PRODUCT,saveWqOrderProductParam);
                    if(returnWOrderPdCount>0) {
                        logger.info(bwq201705Result.getPt().getSlfdf1701180002()+":365订单产品数据插入本地成功!");
                        insertSuccessCountChild++;
                    }else{
                        logger.error(bwq201705Result.getPt().getSlfdf1701180002()+":365订单产品数据插入本地失败!");
                        insertErrorCountChild++;
                    }
                }
            }
        } else {
            logger.error("365订单数据插入本地失败!");
            insertErrorCount++;
        }
    }

    /**
     * @param bwq201705Result 单一对象数据
     * 更新365单一订单信息
     */
    @Transactional
    public void updateWqOrder(BWQ201705Result bwq201705Result){
        logger.info("执行订单单一更新...");
        BaseParam saveParam=new BaseParam();
        saveParam.getFilterMap().put("bwq201705Result",bwq201705Result);
        int returnCount=super.modify(SqlId.UPDATE_WQ_ORDER_ONE, saveParam);
        if(returnCount>0){
            logger.info(bwq201705Result.getPt().getSlfdf1701180002()+":365订单数据更新本地成功!");
            updateSuccessCount++;
            //判断产品是不是空
            if(CollectionUtils.isNotEmpty(bwq201705Result.getSts())) {
                for (int k = 0; k < bwq201705Result.getSts().size(); k++) {
                    BWQ2017050202Bean bwq2017050202Bean = bwq201705Result.getSts().get(k);
                    BaseParam saveWqOrderProductParam = new BaseParam();
                    if(CollectionUtils.isNotEmpty(bwq2017050202Bean.getRows())){
                        for(int j=0;j<bwq2017050202Bean.getRows().size();j++){
                            BWQ201705020201Bean bwq201705020201Bean=bwq2017050202Bean.getRows().get(j);
                            saveWqOrderProductParam.setFilter("orderId", bwq201705Result.getPt().getSourceCode());
                            saveWqOrderProductParam.getFilterMap().put("bwq201705020201Bean",bwq201705020201Bean);
                            int returnWOrderPdCount = super.modify(SqlId.UPDATE_WQ_ORDER_PRODUCT, saveWqOrderProductParam);
                            if (returnWOrderPdCount > 0) {
                                logger.info(bwq201705020201Bean.getSlfdf1701180026()+":365订单产品数据更新本地成功!");
                                updateSuccessCountChild++;
                            } else {
                                logger.error(bwq201705020201Bean.getSlfdf1701180026()+":365订单产品数据更新本地失败!");
                                updateErrorCountChild++;
                            }
                        }
                    }
                }
            }
        } else {
            logger.error(bwq201705Result.getPt().getSlfdf1701180002()+":365订单数据更新本地失败!");
            updateErrorCount++;
        }
    }

    /**
     * @param param param
     * 365外勤更新接口调用
     */
    public void updateWqOrderAndProduct(BaseParam param,String msgId){
        param.setFilter("flg","1");
        List<BWQ20170503Bean> bwq20170503BeanList= super.findList(SqlId.QUERY_ORDER_AND_PRODUCT, param);
        //判断集合是否为空，不是空，取值赋值给参数
        if(CollectionUtils.isNotEmpty(bwq20170503BeanList)) {
            //声明rows参数集合
            List<BWQ201705020201Bean> bwq201705020201BeanList=new ArrayList<>();
            List<BWQ20170502Bean> bwq20170502BeanList = new ArrayList<>();
            //创建输入参数data对象
            BWQ20170502Bean bwq20170502Bean = new BWQ20170502Bean();
            //创建输入参数sts对象
            BWQ2017050202Bean bwq2017050202Bean = new BWQ2017050202Bean();
            List<BWQ2017050202Bean> bwq2017050202BeanList=new ArrayList<>();
            for (int i=0;i<bwq20170503BeanList.size();i++){
                BWQ20170503Bean bwq20170503Bean=bwq20170503BeanList.get(i);
                String orderTime=bwq20170503Bean.getSlfdf1701180004();
                //时间转换
                SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                try {
                    Date date=simpleDateFormat.parse(orderTime);
                    bwq20170503Bean.setSlfdf1701180004(simpleDateFormat.format(date));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                //订单状态是5的时候，取值name
                /*if(!StringUtil.isNullOrEmpty(bwq20170503Bean.getOrderType()) & bwq20170503Bean.getOrderType().equals("5")){
                    BaseParam baseParam=new BaseParam();
                    baseParam.setFilter("slCode",bwq20170503Bean.getSlfdf1701180007());
                    BWQ2017050201Bean bwq2017050201Bean=super.findOne(SqlId.QUERY_SHOWNAMEBY_SLCODE,baseParam);
                    if(null!=bwq2017050201Bean){
                        bwq20170503Bean.setSlfdf1701180008(bwq2017050201Bean.getSellerName());
                    }else{
                        logger.error(bwq20170503Bean.getSlfdf1701180002() + "：查询卖家名称不存在");
                    }
                }*/
                //遍历Rows集合，赋值id
                for(int j=0;j<bwq20170503Bean.getRows().size();j++){
                    BWQ201705020201Bean bwq201705020201Bean=bwq20170503Bean.getRows().get(j);
                    BaseParam baseParam=new BaseParam();
                    baseParam.setFilter("orderId", bwq20170503Bean.getSourceCode());
                    if(StringUtil.isNullOrEmpty(bwq201705020201Bean.getSlfdf1701180025())){
                        baseParam.setFilter("pdCode",bwq201705020201Bean.getSlfdf1701180029());
                    }else{
                        baseParam.setFilter("pdCode",bwq201705020201Bean.getSlfdf1701180025());
                    }
                    BWQ201705020201Bean bwq201705020201BeanSql=super.findOne(SqlId.QUERY_WQ_ORDER_PRODUCT_ID,baseParam);
                    if(null!=bwq201705020201BeanSql){
                        bwq201705020201Bean.setId(bwq201705020201BeanSql.getId());
                    }
                }
                bwq20170503Bean.setCreatorId(config.getCreatorid());
                bwq20170502Bean.setPt(bwq20170503Bean);
                bwq201705020201BeanList.addAll(bwq20170503Bean.getRows());
                bwq2017050202Bean.setRows(bwq20170503Bean.getRows());
                bwq2017050202Bean.setId(config.getWpid());
                //不更新产品
                bwq2017050202BeanList.add(bwq2017050202Bean);
                //bwq20170502Bean.setSts(bwq2017050202BeanList);
            }
            //创建config对象参数
            BWQ20170501Bean bwq20170501Bean = new BWQ20170501Bean();
            bwq20170501Bean.setFormId(config.getFormid());
            bwq20170502BeanList.add(bwq20170502Bean);
            //创建输入参数对象,(其他部分参数，等365确定再赋值测试)
            BWQ201705Bean bwq201705Bean = new BWQ201705Bean();
            bwq201705Bean.setConfig(bwq20170501Bean);
            bwq201705Bean.setData(bwq20170502Bean);
            String saveUrl = "userDefined/v1/modifyUserDefined";
            WqResponse<BWQ201705020102Bean> wqResponseData = WqHttpClient.httpPost(saveUrl, bwq201705Bean, msgId,BWQ201705020102Bean.class);
            if (null != wqResponseData) {
                if (wqResponseData.getReturnCode().equals("0")) {
                    logger.info(bwq201705Bean.getData().getPt().getSlfdf1701180002() + "：更新外勤365订单成功");
                    updateSuccessCount365++;
                } else {
                    logger.error(bwq201705Bean.getData().getPt().getSlfdf1701180002() + "：更新外勤365订单失败");
                    updateErrorCount365++;
                }
            }
        }
    }

    /**
     * 外勤365接口新增调用
     * @param param 是否查询全部，如果不是传入orderCode，查询唯一结果集
     * @param msgId msgId
     */
    public void saveWqOrderAndProduct(BaseParam param,String msgId){
        param.setFilter("flg","1");
        List<BWQ20170503Bean> bwq20170503BeanList= super.findList(SqlId.QUERY_ORDER_AND_PRODUCT, param);
        //判断集合是否为空，不是空，取值赋值给参数
        if(CollectionUtils.isNotEmpty(bwq20170503BeanList)) {
            for (int i=0;i<bwq20170503BeanList.size();i++){
                //声明rows参数集合
                List<BWQ20170502Bean> bwq20170502BeanList = new ArrayList<>();
                List<BWQ2017050202Bean> bwq2017050202BeanList=new ArrayList<>();
                //创建输入参数data对象
                BWQ20170502Bean bwq20170502Bean = new BWQ20170502Bean();
                //创建输入参数sts对象
                BWQ2017050202Bean bwq2017050202Bean = new BWQ2017050202Bean();
                //创建config对象参数
                BWQ20170501Bean bwq20170501Bean = new BWQ20170501Bean();
                //创建输入参数对象,(其他部分参数，等365确定再赋值测试)
                BWQ201705Bean bwq201705Bean = new BWQ201705Bean();
                BWQ20170503Bean bwq20170503Bean=bwq20170503BeanList.get(i);
                String orderTime=bwq20170503Bean.getSlfdf1701180004();
                //时间转换
                SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                try {
                    Date date=simpleDateFormat.parse(orderTime);
                    bwq20170503Bean.setSlfdf1701180004(simpleDateFormat.format(date));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                bwq20170503Bean.setCreatorId(config.getCreatorid());

                //子订单如果存在，根据子订单编码查询子订单产品，将产品信息加入主订单产品中
                if(CollectionUtils.isNotEmpty(bwq20170503Bean.getRows())){
                    for(int z=0;z<bwq20170503Bean.getRows().size();z++){
                        BWQ201705020201Bean bwq201705020201Bean=bwq20170503Bean.getRows().get(z);
                        if(!StringUtil.isNullOrEmpty(bwq201705020201Bean.getChildOrderCode())){
                            BaseParam baseParam=new BaseParam();
                            baseParam.setFilter("orderCode",bwq201705020201Bean.getChildOrderCode());
                            List<BWQ20170503Bean> bwq20170503Beans=super.findList(SqlId.QUERY_ORDER_AND_PRODUCT,baseParam);
                            List<BWQ201705020201Bean> bwq201705020201BeanList=new ArrayList<>();
                            if(CollectionUtils.isNotEmpty(bwq20170503Beans)){
                                for(int a=0;a<bwq20170503Beans.size();a++){
                                    BWQ20170503Bean bwq20170503BeansOne=bwq20170503Beans.get(a);
                                    bwq201705020201BeanList=bwq20170503BeansOne.getRows();
                                    bwq20170503Bean.getRows().addAll(bwq201705020201BeanList);
                                }
                            }
                        }
                    }
                }
                //去掉产品重复
                if(CollectionUtils.isNotEmpty(bwq20170503Bean.getRows())) {
                    for (int j = 0; j < bwq20170503Bean.getRows().size() - 1; j++) {
                        for(int s=bwq20170503Bean.getRows().size()-1;s>j;s--){
                            String valueOne="";
                            String valueTwo="";
                            String valueThree="";
                            String valueForm="";
                            if(!StringUtil.isNullOrEmpty(bwq20170503Bean.getRows().get(j).getSlfdf1701180025())){
                                valueOne=bwq20170503Bean.getRows().get(j).getSlfdf1701180025();
                            }
                            if(!StringUtil.isNullOrEmpty(bwq20170503Bean.getRows().get(s).getSlfdf1701180025())){
                                valueTwo=bwq20170503Bean.getRows().get(s).getSlfdf1701180025();
                            }
                            if(!StringUtil.isNullOrEmpty(bwq20170503Bean.getRows().get(j).getSlfdf1701180029())){
                                valueThree=bwq20170503Bean.getRows().get(j).getSlfdf1701180029();
                            }
                            if(!StringUtil.isNullOrEmpty(bwq20170503Bean.getRows().get(s).getSlfdf1701180029())){
                                valueForm=bwq20170503Bean.getRows().get(s).getSlfdf1701180029();
                            }
                            /*
                            if(!StringUtil.isNullOrEmpty(valueTwo) & valueTwo.equals(valueOne)){
                                bwq20170503Bean.getRows().remove(s);
                            }
                            else if(StringUtil.isNullOrEmpty(valueThree) & valueTwo.equals(valueThree)){
                                bwq20170503Bean.getRows().remove(s);
                            }
                            else if(StringUtil.isNullOrEmpty(valueForm) & valueForm.equals(valueThree)){
                                bwq20170503Bean.getRows().remove(s);
                            }
                            else if(StringUtil.isNullOrEmpty(valueOne) & valueForm.equals(valueOne)){
                                bwq20170503Bean.getRows().remove(s);
                            }*/
                            //上面的判断方法无法对应有些场合，换成下面的方法
                            if(!StringUtil.isNullOrEmpty(valueOne))
                            {
                                if(!StringUtil.isNullOrEmpty(valueTwo))
                                {
                                    if(valueTwo.equals(valueOne))
                                    {
                                        bwq20170503Bean.getRows().remove(s);
                                    }
                                }
                                else if(!StringUtil.isNullOrEmpty(valueForm))
                                {
                                    if(valueForm.equals(valueOne))
                                    {
                                        bwq20170503Bean.getRows().remove(s);
                                    }
                                }
                            }
                            else if(!StringUtil.isNullOrEmpty(valueThree))
                            {
                                if(!StringUtil.isNullOrEmpty(valueTwo))
                                {
                                    if(valueTwo.equals(valueThree))
                                    {
                                        bwq20170503Bean.getRows().remove(s);
                                    }
                                }
                                else if(!StringUtil.isNullOrEmpty(valueForm))
                                {
                                    if (valueForm.equals(valueThree))
                                    {
                                        bwq20170503Bean.getRows().remove(s);
                                    }
                                }
                            }
                            //以下2个判断，应该和上面的判断效果重复，今后如果有过滤不掉的case以后添加一下判断做反向过滤
                            /*
                            else if(!StringUtil.isNullOrEmpty(valueTwo))
                            {
                                if(!StringUtil.isNullOrEmpty(valueOne))
                                {
                                    if(valueTwo.equals(valueOne))
                                    {
                                        bwq20170503Bean.getRows().remove(s);
                                    }

                                }
                                else if(!StringUtil.isNullOrEmpty(valueThree))
                                {
                                    if(valueTwo.equals(valueThree))
                                    {
                                        bwq20170503Bean.getRows().remove(s);
                                    }

                                }
                            }
                            else if(!StringUtil.isNullOrEmpty(valueForm))
                            {
                                if(!StringUtil.isNullOrEmpty(valueOne))
                                {
                                    if(valueForm.equals(valueOne))
                                    {
                                        bwq20170503Bean.getRows().remove(s);
                                    }
                                }
                                else if(!StringUtil.isNullOrEmpty(valueThree))
                                {
                                    if (valueForm.equals(valueThree))
                                    {
                                        bwq20170503Bean.getRows().remove(s);
                                    }
                                }
                            }
                            */
                        }
                    }
                }
                //如何产品1不存在，赋值产品2
               // List<BWQ201705020201Bean>  bwq201705020201BeanList=new ArrayList<>();
                if(CollectionUtils.isNotEmpty(bwq20170503Bean.getRows())){
                    //bwq201705020201BeanList.addAll(bwq20170503Bean.getRows());
                    for(int j=0;j<bwq20170503Bean.getRows().size();j++){
                        BWQ201705020201Bean bwq201705020201Bean=bwq20170503Bean.getRows().get(j);
                        //主产品不为空
                        if(null!=bwq201705020201Bean & StringUtil.isNullOrEmpty(bwq201705020201Bean.getSlfdf1701180025())){
                           /* if(!StringUtil.isNullOrEmpty(bwq201705020201Bean.getChildOrderCode())){
                                //bwq201705020201BeanList.remove(j);
                                continue;
                            }*/
                            bwq201705020201Bean.setSlfdf1701180025(bwq201705020201Bean.getSlfdf1701180029());
                            bwq201705020201Bean.setSlfdf1701180026(bwq201705020201Bean.getSlfdf1701180030());
                            bwq201705020201Bean.setSlfdf1701180027(bwq201705020201Bean.getSlfdf1701180031());
                            bwq201705020201Bean.setSlfdf1701180028(bwq201705020201Bean.getSlfdf1701180032());
                        }
                    }
                }
                bwq2017050202Bean.setRows(bwq20170503Bean.getRows());
                //删除Rows对象，不传
                bwq20170503Bean.setRows(null);
                String time=bwq20170503Bean.getSlfdf1701180022();
                StringBuffer returnTime=new StringBuffer();
                if(!StringUtil.isNullOrEmpty(time)){
                    String[] arrayTime=time.split(",");
                    if(null!=arrayTime){
                        for(int z=0;z<arrayTime.length;z++){
                            String getTime=arrayTime[z];
                            BaseParam paramTime=new BaseParam();
                            paramTime.setFilter("time",getTime);
                            BWQ2017050201Bean bwq2017050201Bean=super.findOne(SqlId.QUERY_COMMTIME_ID,paramTime);
                            //时间转换
                            if(null!=bwq2017050201Bean){
                                if(z==arrayTime.length-1){
                                    returnTime.append(bwq2017050201Bean.getSlfdf1701180022());
                                }else{
                                    returnTime.append(bwq2017050201Bean.getSlfdf1701180022()+",");
                                }
                            }
                        }
                    }
                }
                bwq20170503Bean.setSlfdf1701180022(returnTime.toString());
                //订单状态是5的时候，取值name
                if(!StringUtil.isNullOrEmpty(bwq20170503Bean.getOrderType()) & bwq20170503Bean.getOrderType().equals("5")){
                    BaseParam baseParam=new BaseParam();
                    baseParam.setFilter("slCode",bwq20170503Bean.getSlfdf1701180007());
                    BWQ2017050201Bean bwq2017050201Bean=super.findOne(SqlId.QUERY_SHOWNAMEBY_SLCODE,baseParam);
                    if(null!=bwq2017050201Bean){
                        bwq20170503Bean.setSlfdf1701180008(bwq2017050201Bean.getSellerName());
                    }else{
                        logger.error(bwq201705Bean.getData().getPt().getSlfdf1701180002() + "：查询卖家名称不存在");
                    }
                }
                bwq20170502Bean.setPt(bwq20170503Bean);
                bwq2017050202Bean.setId(config.getWpid());
                bwq2017050202BeanList.add(bwq2017050202Bean);
                bwq20170502Bean.setSts(bwq2017050202BeanList);
                bwq20170501Bean.setFormId(config.getFormid());
                bwq20170502BeanList.add(bwq20170502Bean);
                bwq201705Bean.setConfig(bwq20170501Bean);
                bwq201705Bean.setData(bwq20170502Bean);
                String saveUrl = "userDefined/v1/addUserDefined";
                WqResponse<BWQ201705020102Bean> wqResponseData = WqHttpClient.httpPost(saveUrl, bwq201705Bean, msgId, BWQ201705020102Bean.class);
                if (null != wqResponseData) {
                    if (wqResponseData.getReturnCode().equals("0")) {
                        logger.info(bwq201705Bean.getData().getPt().getSlfdf1701180002() + "：添加外勤365订单成功");
                        insertSuccessCount365++;
                    } else {
                        if(!StringUtil.isNullOrEmpty(bwq201705Bean.getData().getPt().getSlfdf1701180006Name())){
                            //新增失败，重新赋值新增
                            BaseParam baseParamId=new BaseParam();
                            //如何buyersId为空，使用365id赋值
                            baseParamId.setFilter("cmName",bwq201705Bean.getData().getPt().getSlfdf1701180006Name());
                            BWQ201701Bean bwq201701Bean=super.findOne(SqlId.QUERY_WQ_CUSTOMER_ID,baseParamId);
                            if(null!=bwq201701Bean){
                                bwq201705Bean.getData().getPt().setSlfdf1701180006(bwq201701Bean.getId());
                                WqResponse<BWQ201705020102Bean> wqResponse = WqHttpClient.httpPost(saveUrl, bwq201705Bean, msgId, BWQ201705020102Bean.class);
                                if(null != wqResponse & wqResponse.getReturnCode().equals("0") ){
                                    logger.info(bwq201705Bean.getData().getPt().getSlfdf1701180002() + "：添加外勤365订单成功");
                                    insertSuccessCount365++;
                                }else{
                                    logger.error(bwq201705Bean.getData().getPt().getSlfdf1701180002() + "：添加外勤365订单失败");
                                    insertErrorCount365++;
                                }
                            }
                        }else{
                            logger.error(bwq201705Bean.getData().getPt().getSlfdf1701180002() + "：添加外勤365，订单买家名称为空，跳过");
                        }
                    }
                }
            }
        }
    }

    /**
     * 判断临时表，是否为空
     * @return 结果
     */
    public int ifWqOrderIsNull(){
        int count=super.getCount(SqlId.QUERY_WQ_ORDER_CODE,new BaseParam());
        return count;
    }

    /**
     * 查询外勤客户表数据，拉取最新
     */
    public void queryWqCustomer(){
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
        if(null!=rs & rs.getReturnCode().equals("0")) {
            //每次批处理先删除wq_customer表数据
            bwq201701Logic.deleteAllWqCustomer(new BaseParam());
            if (CollectionUtils.isNotEmpty(datas)) {
                //执行插入操作，插入到外勤客户表
                bwq201701Logic.insertCmCustomer(datas);
            }
        }
    }

    public static void main(String[] a){
        System.out.print(6300/1000);
    }
}
