package com.msk.ds.logic;

import com.msk.common.consts.StockConst;
import com.msk.common.logic.CommonLogic;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.BaseParam;
import com.msk.core.bean.PageResult;
import com.msk.core.consts.NumberConst;
import com.msk.core.entity.SlPdArtno;
import com.msk.core.exception.BusinessException;
import com.msk.core.file.WmsFtpUtils;
import com.msk.core.file.xml.XmlWrite;
import com.msk.core.utils.DateTimeUtil;
import com.msk.core.utils.StringUtil;
import com.msk.core.web.consts.BusinessConst;
import com.msk.ds.bean.*;
import com.msk.pd.bean.ProductBean;
import com.msk.so.bean.StockParam;
import com.msk.so.logic.OrderLogic;
import com.msk.so.logic.StockLogic;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * yang_yang
 */
@Service
public class SC182102Logic extends BaseLogic {

    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(SC183102Logic.class);

    @Autowired
    private DistSuppChainLogic distSuppChainLogic;

    @Autowired
    private CommonLogic commonLogic;

    @Autowired
    private StockLogic stockLogic;

    @Autowired
    private SC18210201Logic sc18210201Logic;

    @Autowired
    private OrderLogic orderLogic;


    /**
     * SQL Map 中SQL ID定义
     *
     * @author pxg
     */
    private interface SqlId {
        String SQL_ID_FIND_DELIVERYNUMS = "getDeliveryNum";

        String FIND_PRODUCT_LIST = "findProductList";

        String FIND_PRODUCT_SUM_LIST = "findProductSumList";

        String FIND_DETAIL_LIST = "findDetailList";

        String MODIFY_ACTUAL = "modifyActual";

        String SAVE_STOCK_DETAIL = "saveStockDetail";

        String SAVE_ACTUAL_STOCK = "saveActualStock";

        String EDIT_RECEIVE_NUM = "editReceiveNum";

        /** 应上海需求 #1791添加页面合计 modify by renyi on 2016/8/10 start */
        String SQL_ID_GET_CURRENT_INFO = "getCurrentInfo";
        /** 应上海需求 #1791添加页面合计 modify by renyi on 2016/8/10 end */

    }

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    /**
     * 检索发货入库通知明细List
     * @param sc181102Param 入力条件
     * @param isEdit True：编辑  False：新增
     * @return 入库明细
     */
    public PageResult<SC182102Param> findPageList(SC181102Param sc181102Param,boolean isEdit){
        PageResult<SC182102Param> pageResultList=new PageResult<SC182102Param>();

        //添加从实际表取值，修改从明细表取值
        String sql = SqlId.FIND_PRODUCT_SUM_LIST;
        if(isEdit){
            sql = SqlId.FIND_DETAIL_LIST;
        }

        List<SC182102Param> productList = findList(sql, sc181102Param);

        setProductInfo(productList);

        pageResultList.setData(productList);

        return pageResultList;
    }

    /**
     * 发货
     * @param sc182101Bean
     * @return
     */
    @Transactional
    public int saveStock(SC182101Bean sc182101Bean){
        Date currentDate = DateTimeUtil.getCustomerDate();

        long deliveryStockId = this.commonLogic.maxId("DS_DELIVERY_STOCK", "DELIVERY_STOCK_ID");
        sc182101Bean.setDeliveryStockId(deliveryStockId);
        //发货后状态为"待收货"
        sc182101Bean.setDeliveryStockStatus(BusinessConst.DeliveryStockStatus.NoDelivery);
        sc182101Bean.setDelFlg(String.valueOf(NumberConst.IntDef.INT_ZERO));
        sc182101Bean.setCrtTime(currentDate);
        sc182101Bean.setCrtId(sc182101Bean.getCrtId());
        sc182101Bean.setUpdTime(currentDate);
        sc182101Bean.setUpdId(sc182101Bean.getCrtId());

        //通知单主表
        this.save(sc182101Bean);

        //查询条件
        SC181102Param sc181102Param = new SC181102Param();

        sc181102Param.setDistMonth(sc182101Bean.getDistMonth());
        sc181102Param.setAreaCode(sc182101Bean.getLgcsCode());
        sc181102Param.setSupplierCode(sc182101Bean.getSuppCode());
        sc181102Param.setHalfCode(sc182101Bean.getHalfCode());

        //实际发货箱数
        String[] actualNums = sc182101Bean.getActualNums();

        //明细表
        List<SC182102Param> productSumList = this.findList(SqlId.FIND_PRODUCT_SUM_LIST, sc181102Param);

        setProductInfo(productSumList);

        List<SC182102Bean> detailList = new ArrayList<SC182102Bean>();
        for(int i = 0;i < productSumList.size();i++){

            if(Integer.valueOf(actualNums[i]) != 0){
                SC182102Param sc182102Param = productSumList.get(i);

                SC182102Bean sc182102Bean = new SC182102Bean();

                sc182102Bean.setDeliveryStockId(deliveryStockId);
                sc182102Bean.setPdCode(sc182102Param.getProductCode());
                sc182102Bean.setNormsCode(sc182102Param.getPackageCode());
                sc182102Bean.setApplyDeliveryNum(BigDecimal.ZERO);
                sc182102Bean.setConfirmDeliveryNum(BigDecimal.ZERO);
                sc182102Bean.setPlanDeliveryNum(sc182102Param.getSendNum());
                sc182102Bean.setActualDeliveryNum(new BigDecimal(actualNums[i]));
                sc182102Bean.setDelFlg(String.valueOf(NumberConst.IntDef.INT_ZERO));
                sc182102Bean.setCrtId(sc182101Bean.getCrtId());
                sc182102Bean.setCrtTime(currentDate);
                sc182102Bean.setUpdId(sc182101Bean.getCrtId());
                sc182102Bean.setUpdTime(currentDate);

                detailList.add(sc182102Bean);
                //明细表插入
                this.save(SqlId.SAVE_STOCK_DETAIL,sc182102Bean);
            }

        }
        //分配库存（从2库移到3库）
        allocateActualStockNums(sc181102Param, sc182101Bean);

        //create Xml
        createXml(sc182101Bean, detailList);

        return NumberConst.IntDef.INT_ONE;
    }

    /**
     * 生成美迪福接口 XML文件
     * @param bean
     * @param detailList
     */
    private void createXml(SC182101Bean bean, List<SC182102Bean> detailList) {
        Date currentDate = DateTimeUtil.getCustomerDate();
//        String fileName = "SC182102Template.ftl";
//        XmlWrite<SC182102XmlParam> xml = new XmlWrite<SC182102XmlParam>("/template", fileName );
        SC182102XmlParam param = new SC182102XmlParam();
        param.setReceipt(StringUtil.toSafeString(bean.getDeliveryStockId()));
        /**卖家编码*/
        //param.setConsignee(bean.getSuppCode());
        /**销售区域*/
        //param.setArea(bean.getLgcsCode());
        /**供应商名字*/
        //param.setCompanyName(bean.getSuppName());
        /**备注信息*/
        param.setNotes(StringUtil.toSafeString(bean.getDeliveryMemo()));
        /**计划发货时间*/
        param.setScheduledDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(currentDate));
        /**计划到货时间*/
        param.setStartReceiptDate(StringUtil.toSafeString(bean.getDeliveryStockTimeReq()));
        List<SC182102XmlDetailParam> xmlDetailList =  new ArrayList<SC182102XmlDetailParam>();
        param.setDetailList(xmlDetailList);
        Integer index = NumberConst.IntDef.INT_ONE;
        for(SC182102Bean detail : detailList) {
            SC182102XmlDetailParam xmlDetail = new SC182102XmlDetailParam();
            /**入库单行号*/
            xmlDetail.setReceiptLine(index.toString());
            /** #1919 入库明细ID modify by likai on 2016/8/15 start */
//            xmlDetail.setReceiptLine(StringUtil.toSafeString(detail.getDeliveryStockId()));
            /** #1919 入库明细ID modify by likai on 2016/8/15 end */
            /**卖家编码*/
            xmlDetail.setCompany(StringUtil.toSafeString(bean.getSuppCode()));
            /**销售区域*/
            xmlDetail.setArea(StringUtil.toSafeString(bean.getLgcsCode()));
            /**供应商*/
            xmlDetail.setCompanyName(StringUtil.toSafeString(bean.getSuppName()));

            //根据供应商编码，产品编码，平台编码获取货号
            SlPdArtno slPdArtno = orderLogic.getSlPdArtNo(bean.getSuppCode(),detail.getPdCode(),String.valueOf(NumberConst.IntDef.INT_ONE));
            //xmlDetail.setSku(detail.getPdCode());
            //sku=sl_code_dis+货号
            if(slPdArtno != null && !StringUtil.isNullOrEmpty(slPdArtno.getSlCodeDis()) && !StringUtil.isNullOrEmpty(slPdArtno.getSlPdArtno())){
                /**商品货号*/
                xmlDetail.setSku(slPdArtno.getSlCodeDis() + slPdArtno.getSlPdArtno());
            }else {
                xmlDetail.setSku("");
            }

            //根据产品Code获取产品信息
            ProductBean product = this.sc18210201Logic.getProductInfo(detail.getPdCode());
            if (product == null) {
                logger.info("产品编号:" + detail.getPdCode() + "没有相关产品");
                throw new BusinessException("产品编号:" + detail.getPdCode() + "没有相关产品");
            }

            //商品名称
            StringBuffer productName = new StringBuffer();
            if(!StringUtil.isNullOrEmpty(product.getPdClasses().getClassesName())){
                productName.append(product.getPdClasses().getClassesName());
            }
            if(!StringUtil.isNullOrEmpty(product.getPdMachining().getMachiningName())){
                productName.append("-").append(product.getPdMachining().getMachiningName());
            }
            if(!StringUtil.isNullOrEmpty(product.getPdBreed().getBreedName())){
                productName.append("-").append(product.getPdBreed().getBreedName());
            }
            if(!StringUtil.isNullOrEmpty(product.getPdFeature().getFeatureName())){
                productName.append("-").append(product.getPdFeature().getFeatureName());
            }
            if(!StringUtil.isNullOrEmpty(product.getPdWeight().getWeightName())){
                productName.append("-").append(product.getPdWeight().getWeightName());
            }
            if(!StringUtil.isNullOrEmpty(product.getPdGrade().getGradeName())){
                productName.append("-").append(product.getPdGrade().getGradeName());
            }
            xmlDetail.setSkuDesc(String.valueOf(productName));
            if(product.getPdClasses() != null){
                /**产品一级分类*/
                xmlDetail.setSkuGroup(StringUtil.toSafeString(product.getPdClasses().getClassesCode()));
                xmlDetail.setGroupName(StringUtil.toSafeString(product.getPdClasses().getClassesName()));
            }else {
                xmlDetail.setSkuGroup("");
                xmlDetail.setGroupName("");
            }
            if(product.getPdFeature() != null){
                /**计量单位*/
                xmlDetail.setUom("CASE");
            }else {
                xmlDetail.setUom("");
            }
            /**包装规格*/
            if(product.getPdNormsStd() != null){
                /**毛重量*/
                xmlDetail.setGrossWeight(StringUtil.toSafeString(product.getPdNormsStd().getGrossweightOut()));
                /**净重量*/
                xmlDetail.setNetWeight(StringUtil.toSafeString(product.getPdNormsStd().getNetweightOut()));
                /**长度*/
                xmlDetail.setLength(StringUtil.toSafeString(product.getPdNormsStd().getNormsLength()));
                /**宽度*/
                xmlDetail.setWidth(StringUtil.toSafeString(product.getPdNormsStd().getNormsWidth()));
                /**高度*/
                xmlDetail.setHeight(StringUtil.toSafeString(product.getPdNormsStd().getNormsHeight()));
                /**体积*/
                xmlDetail.setVolume(StringUtil.toSafeString(product.getPdNormsStd().getNormsVolume()));
            }else {
                xmlDetail.setGrossWeight("");
                /**净重量*/
                xmlDetail.setNetWeight("");
                /**长度*/
                xmlDetail.setLength("");
                /**宽度*/
                xmlDetail.setWidth("");
                /**高度*/
                xmlDetail.setHeight("");
                /**体积*/
                xmlDetail.setVolume("");
            }
            /**实际发货数量*/
            xmlDetail.setQtyExpected(StringUtil.toSafeString(detail.getActualDeliveryNum()));
            /**计划发货数量*/
            xmlDetail.setQtyOriginal(StringUtil.toSafeString(detail.getPlanDeliveryNum()));
            /**
             * 设置默认值
             */
            xmlDetail.setConsignee("0000000");
            xmlDetail.setName("神农客");
            xmlDetail.setCompanytype("SUPPLY");
            xmlDetail.setInventorystatus("AVAILABLE");
            /** #1919  add by likai on 2016/8/15 start */
            //原产地+动检证
            xmlDetail.setCoo("");
            /** #1919  add by likai on 2016/8/15 end */
            index++;
            xmlDetailList.add(xmlDetail);
        }
        //输出名
        String outputName = "SC182102" + DateTimeUtil.formatDate(DateTimeUtil.FORMAT_YYMMDD_HHMMSS, currentDate) + ".xml";

        // Modify for bug#1410 at 2016/07/22 by li_kai1 Start.

        List<SC182102XmlParam> xmlData = new ArrayList<SC182102XmlParam>();
        xmlData.add(param);
        List182102Template listTestTemplate = new List182102Template();
        listTestTemplate.setData(xmlData);

        XmlWrite<SC182102XmlParam> xmlWrite = new XmlWrite<>(listTestTemplate);
        InputStream inputStream =  xmlWrite.createListTemplateXml(List182102Template.class);

//        String uploadFile = xml.createXml(param, outputName);
        //上传文件或目录到FTP
        boolean result = WmsFtpUtils.uploadXml("/",outputName,inputStream);
        if (logger.isDebugEnabled()) {
            if (result) {
                logger.debug(outputName + "文件上传成功");
            } else {
                logger.debug(outputName + "文件上传失败");
                throw new BusinessException("文件上传失败");
            }
        }
        // Modify for bug#1410 at 2016/07/22 by li_kai1 end.

    }

    /**
     * 分配库存（从2库移到3库）
     * @param sc181102Param
     * @param sc182101Bean
     */
    private void allocateActualStockNums(SC181102Param sc181102Param, SC182101Bean sc182101Bean) {
        Date currentDate = DateTimeUtil.getCustomerDate();

        //产品编码(2:待运库产品)
        sc181102Param.getFilterMap().put("pdStockType", String.valueOf(NumberConst.IntDef.INT_TWO));
        //实际表
        List<SC182102Param> productList = this.findList(SqlId.FIND_PRODUCT_LIST, sc181102Param);

        setProductInfo(productList);

        String[] actualNums = sc182101Bean.getActualNums();
        String[] productCodes = sc182101Bean.getProductCodes();

        //分配
        for(int i = 0;i<actualNums.length;i++){
            int actualNum = Integer.valueOf(actualNums[i]);

            if(actualNum != 0) {
                String productCode = productCodes[i];
                double actualWeight = 1;

                for(int j = 0;j < productList.size();j++){
                    if(actualWeight == 0){
                        break;
                    }

                    SC182102Param sc182102Param = productList.get(j);
                    if(sc182102Param != null) {
                        if (sc182102Param.getProductCode().equals(productCode)) {
                            //变化值
                            double newActualNum = 0;
                            if(actualWeight == 1){
                                actualWeight = sc182102Param.getNetWeight().multiply(new BigDecimal(actualNum)).doubleValue();
                            }
                            if (sc182102Param.getSendNum().doubleValue() <= actualWeight) {
                                actualWeight -= sc182102Param.getSendNum().doubleValue();
                                newActualNum = -sc182102Param.getSendNum().doubleValue();
                            } else {
                                newActualNum = -actualWeight;
                                actualWeight = 0;
                            }

                            //修改实际表中库存类型为2的数据到3类型的实际数量
                            //2:待运库产品
                            BaseParam baseParam = new BaseParam();
                            baseParam.getFilterMap().put("distMonth", sc182101Bean.getDistMonth());
                            baseParam.getFilterMap().put("areaCode", sc182101Bean.getLgcsCode());
                            baseParam.getFilterMap().put("supplierCode", sc182101Bean.getSuppCode());
                            baseParam.getFilterMap().put("halfCode", sc182101Bean.getHalfCode());
                            baseParam.getFilterMap().put("pdCode", sc182102Param.getProductCode());
                            baseParam.getFilterMap().put("inputDate", sc182102Param.getInputDate());
                            baseParam.setUpdId(sc182101Bean.getCrtId());
                            baseParam.setUpdTime(currentDate);
                            baseParam.getFilterMap().put("newActualNum", newActualNum);
                            baseParam.getFilterMap().put("pdStockType", NumberConst.IntDef.INT_TWO);
                            super.modify(SqlId.MODIFY_ACTUAL, baseParam);

                            //3:在途产品(插入)
                            baseParam.getFilterMap().put("newActualNum", -newActualNum);
                            baseParam.getFilterMap().put("pdStockType", NumberConst.IntDef.INT_THREE);
                            int updateNums = super.modify(SqlId.MODIFY_ACTUAL, baseParam);
                            if(updateNums <= 0){
                                long virtualStockActualId = this.commonLogic.maxId("DS_PD_VIRTUAL_STOCK_ACTUAL","VIRTUAL_STOCK_ACTUAL_ID");
                                baseParam.getFilterMap().put("virtualStockActualId", String.valueOf(virtualStockActualId));
                                baseParam.getFilterMap().put("pdStockTypeFm", NumberConst.IntDef.INT_TWO);
                                baseParam.getFilterMap().put("pdStockTypeTo", NumberConst.IntDef.INT_THREE);
                                baseParam.setCrtId(sc182101Bean.getCrtId());
                                baseParam.setCrtTime(currentDate);
                                save(SqlId.SAVE_ACTUAL_STOCK, baseParam);
                            }
                        }
                    }
                }
            }

        }
    }

    /**
     *  修改实际数量
     * @param
     * @return 结果
     */
    @Transactional
    public int modifyStock(SC182101Bean sc182101Bean){
        Date currentDate = DateTimeUtil.getCustomerDate();

        //查询条件
        SC181102Param sc181102Param = new SC181102Param();

        sc181102Param.setDistMonth(sc182101Bean.getDistMonth());
        sc181102Param.setAreaCode(sc182101Bean.getLgcsCode());
        sc181102Param.setSupplierCode(sc182101Bean.getSuppCode());
        sc181102Param.setHalfCode(sc182101Bean.getHalfCode());

        sc181102Param.getFilterMap().put("pdStockType", String.valueOf(NumberConst.IntDef.INT_THREE));
        sc181102Param.getFilterMap().put("deliveryStockId", sc182101Bean.getDeliveryStockId());

        //实际表
        List<SC182102Param> productList = this.findList(SqlId.FIND_PRODUCT_LIST, sc181102Param);
        setProductInfo(productList);
        //细节表
        List<SC182102Param> detailtList = this.findList(SqlId.FIND_DETAIL_LIST, sc181102Param);
        setProductInfo(detailtList);

        Integer[] receiveActualNums = sc182101Bean.getReceiveActualNums();
        //收货判断条件
        boolean flagLivery = true;

        for(int i = 0;i<detailtList.size();i++){

            SC182102Param detailInfo =  detailtList.get(i);
            //实际发货数量
            int actualNum = detailInfo.getSendActualNum().intValue();
            //实际收货箱数
            int receiveActualTail = receiveActualNums[i];

            if(actualNum != receiveActualTail){
                flagLivery = false;
            }
            double actualWeight = 1;

            for(int j = 0;j < productList.size();j++){

                SC182102Param sc182102Param = productList.get(j);
                if(sc182102Param != null) {

                    if (sc182102Param.getProductCode().equals(detailInfo.getProductCode())) {

                        //变化值
                        double newActualNum = 0;
                        if(actualWeight == 1){
                            actualWeight = sc182102Param.getNetWeight().multiply(new BigDecimal(receiveActualTail)).doubleValue();
                        }
                        if (sc182102Param.getSendNum().doubleValue() <= actualWeight) {
                            actualWeight -= sc182102Param.getSendNum().doubleValue();
                            newActualNum = -sc182102Param.getSendNum().doubleValue();
                        } else {
                            newActualNum = -actualWeight;
                            actualWeight = 0;
                        }

                        //修改实际表中库存类型为3的数据到4类型的实际数量
                        //3
                        BaseParam baseParam = new BaseParam();
                        baseParam.getFilterMap().put("newActualNum", newActualNum);
                        baseParam.getFilterMap().put("distMonth", sc182101Bean.getDistMonth());
                        baseParam.getFilterMap().put("areaCode", sc182101Bean.getLgcsCode());
                        baseParam.getFilterMap().put("supplierCode", sc182101Bean.getSuppCode());
                        baseParam.getFilterMap().put("pdStockType", NumberConst.IntDef.INT_THREE);
                        baseParam.getFilterMap().put("halfCode", sc182101Bean.getHalfCode());
                        baseParam.getFilterMap().put("pdCode", sc182102Param.getProductCode());
                        baseParam.getFilterMap().put("inputDate", sc182102Param.getInputDate());

                        super.modify(SqlId.MODIFY_ACTUAL, baseParam);

                        //4
                        baseParam.getFilterMap().put("newActualNum", -newActualNum);
                        baseParam.getFilterMap().put("pdStockType", NumberConst.IntDef.INT_FOUR);

                        int updateNums = super.modify(SqlId.MODIFY_ACTUAL, baseParam);
                        if(updateNums <= 0){
                            long virtualStockActualId = this.commonLogic.maxId("DS_PD_VIRTUAL_STOCK_ACTUAL","VIRTUAL_STOCK_ACTUAL_ID");
                            baseParam.getFilterMap().put("virtualStockActualId",String.valueOf(virtualStockActualId));
                            baseParam.getFilterMap().put("pdStockTypeFm", NumberConst.IntDef.INT_THREE);
                            baseParam.getFilterMap().put("pdStockTypeTo", NumberConst.IntDef.INT_FOUR);
                            baseParam.setCrtId(sc182101Bean.getCrtId());
                            baseParam.setCrtTime(currentDate);
                            save(SqlId.SAVE_ACTUAL_STOCK, baseParam);
                        }
                    }
                }

            }

            BaseParam baseParam = new BaseParam();
            baseParam.getFilterMap().put("deliveryStockId", sc182101Bean.getDeliveryStockId());
            baseParam.getFilterMap().put("pdCode", detailInfo.getProductCode());
            baseParam.getFilterMap().put("normsCode", detailInfo.getPackageCode());
            baseParam.getFilterMap().put("actualDeliveryNum", detailInfo.getSendActualNum().intValue());
            baseParam.getFilterMap().put("actualReceiveNum", receiveActualTail);
            baseParam.getFilterMap().put("memo", sc182101Bean.getStockMemo());
            baseParam.setCrtId(sc182101Bean.getCrtId());
            baseParam.setCrtTime(currentDate);
            baseParam.setUpdId(sc182101Bean.getCrtId());
            baseParam.setUpdTime(currentDate);
            super.modify(SqlId.EDIT_RECEIVE_NUM, baseParam);
        }

        //修改销售库存
        List<StockParam> stockParamList = new ArrayList<StockParam>();
        for(SC182102Param detail : detailtList){
            StockParam param = new StockParam();
            param.setLgcsCode(sc182101Bean.getLgcsCode());
            param.setWarehouseCode("01");
            param.setWarehouseName("神龙客仓库");
            //TODO
            param.setSupplyPlatform(NumberConst.IntDef.INT_ONE);
            param.setSlCode(StockConst.SL_Name.SL_CODE);
            param.setSlName(StockConst.SL_Name.SL_NAME);
            param.setStockType(StockConst.StockType.NORMAL_STOCK);
            param.setSupplierCode(sc182101Bean.getSuppCode());
            param.setPdCode(detail.getProductCode());
            param.setStockNum(detail.getSendActualNum());
            param.setFlowId(String.valueOf(sc182101Bean.getDeliveryStockId()));

            stockParamList.add(param);
        }

        stockLogic.saveStockOfSupplierList(stockParamList);

        //修改该通知单的状态
        SC182101Bean bean = super.findOne(sc181102Param);
        bean.setDeliveryStockStatus(BusinessConst.DeliveryStockStatus.Delivery);
        //已收货
        if (flagLivery == true) {
            bean.setDeliveryStockStatus(BusinessConst.DeliveryStockStatus.Delivery);
            /** #1664 添加实际到货时间 modify by likai on 2016/8/8 start */
            bean.setDeliveryReceiveStockTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(currentDate));
            /** #16634 添加实际到货时间 modify by likai on 2016/8/8 end */
        } else {
            //部分收货
            bean.setDeliveryStockStatus(BusinessConst.DeliveryStockStatus.PartialDelivery);
            /** #1664 添加实际到货时间 modify by likai on 2016/8/8 start */
            bean.setDeliveryReceiveStockTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(currentDate));
            /** #1664 添加实际到货时间 modify by likai on 2016/8/8 end */
        }
        bean.setStockMemo(sc182101Bean.getStockMemo());
        bean.setUpdId(sc182101Bean.getCrtId());
        bean.setUpdTime(currentDate);
        super.modify(bean);

        return NumberConst.IntDef.INT_ONE;

    }

    /**
     * 获取分销月度
     * @return DistSuppChain
     */
    public DistSuppChain getDistMonth(){
        /**传入对象的参数保留至传出对象*/
        DistSuppChain distSuppChain = new DistSuppChain();
        /*期*/
        List<DistSuppChain> distMonthList = distSuppChainLogic.findDistMonth();

        distSuppChain.setDistMonthList(distMonthList);

        return distSuppChain;
    }

    /**
     * 获取半旬信息
     * @param sc181102Param 传入参数
     * @return
     */
    public DistSuppChain getHalfName(SC181102Param sc181102Param){
        DistSuppChain distSuppChain = new DistSuppChain();
        if(!StringUtil.isNullOrEmpty(sc181102Param.getDistMonth())){
            //获取地区
            List<DistSuppChain> areaInfoList = distSuppChainLogic.findLogisticsAreaList(sc181102Param.getDistMonth());
            //获取供应商
            BaseParam param = new BaseParam();
            param.setFilter("distMonth",sc181102Param.getDistMonth());
            param.setFilter("logisAreaCode",sc181102Param.getAreaCode());
            param.setFilter("userType",sc181102Param.getUserType());
            param.setFilter("loginId",sc181102Param.getCrtId()); // 登录用户编号
            List<DistSuppChain> suppInfoList = distSuppChainLogic.findSuppInfoList(param);
            distSuppChain.setProductName(sc181102Param.getProductName());
            distSuppChain.setAreaCode(sc181102Param.getAreaCode());
            distSuppChain.setSupplierCode(sc181102Param.getSupplierCode());
            distSuppChain.setSupplierInfoList(suppInfoList);
            distSuppChain.setAreaInfoList(areaInfoList);
            distSuppChain.setDistMonth(sc181102Param.getDistMonth());
        }else{
            //初期化时获取当前分销月份和地区
            String now = DateTimeUtil.formatDate(DateTimeUtil.FORMAT_YYYYMMDD, DateTimeUtil.getCustomerDate());
            String currentDistMonth = distSuppChainLogic.getNowHalfDate(now);
            distSuppChain.setDistMonth(currentDistMonth);
            //获取当前月对应的地区
            List<DistSuppChain> areaInfoList = distSuppChainLogic.findLogisticsAreaList(currentDistMonth);
            if(areaInfoList == null || areaInfoList.size() == 0) {
                throw new BusinessException(currentDistMonth + "月度没有可发货的产品");
            }
            //获取当前月对应的地区对应的供应商
            //获取供应商
            BaseParam param = new BaseParam();
            param.setFilter("distMonth",currentDistMonth);
            param.setFilter("logisAreaCode",sc181102Param.getAreaCode());
            param.setFilter("userType",sc181102Param.getUserType());
            param.setFilter("loginId",sc181102Param.getCrtId()); // 登录用户编号
            List<DistSuppChain> suppInfoList = distSuppChainLogic.findSuppInfoList(param);
            distSuppChain.setAreaInfoList(areaInfoList);
            distSuppChain.setSupplierInfoList(suppInfoList);
            if (CollectionUtils.isNotEmpty(suppInfoList)) {

                distSuppChain.setSupplierCode(suppInfoList.get(0).getSupplierCode());
                sc181102Param.setSupplierCode(suppInfoList.get(0).getSupplierCode());
            }
            distSuppChain.setAreaCode(areaInfoList.get(0).getAreaCode());

            sc181102Param.setDistMonth(currentDistMonth);
            sc181102Param.setAreaCode(areaInfoList.get(0).getAreaCode());
        }
        /*表头日期数据和当前日期所在的半旬*/
        int year = Integer.parseInt(sc181102Param.getDistMonth().substring(NumberConst.IntDef.INT_ZERO,NumberConst.IntDef.INT_FOUR));
        int month = Integer.parseInt(sc181102Param.getDistMonth().substring(NumberConst.IntDef.INT_FOUR,NumberConst.IntDef.INT_SIX));
        String dataSelect = getCurrentDateStr(month,year);
        String dataSelectBefore = "";
        if(month == NumberConst.IntDef.INT_ONE){
            dataSelectBefore = getCurrentDateStr(NumberConst.IntDef.INT_TWELVE,year - NumberConst.IntDef.INT_ONE);
        }else{
            dataSelectBefore = getCurrentDateStr(month - NumberConst.IntDef.INT_ONE,year);
        }
        distSuppChain.setDataSelect(dataSelect);
        distSuppChain.setDataSelectBefore(dataSelectBefore);
        //当前半旬Code
        distSuppChain.setCurrentHalfCode(distSuppChainLogic.getNowHalfCode(sc181102Param.getDistMonth()));
        /*半旬名称List*/
        distSuppChain.setHalfNameList(distSuppChainLogic.getHalfNameList(sc181102Param.getDistMonth(),NumberConst.IntDef.INT_ZERO));

        return distSuppChain;
    }

    /**
     * 获得XX年XX月字符串
     * @param month 月
     * @param year 年
     * @return string
     */
    public String getCurrentDateStr(int month,int year){
        String dataStr = null;
        if(month < NumberConst.IntDef.INT_TEN){
            dataStr = year + "年0" + month + "月";
        }else {
            dataStr = year + "年" + month + "月";
        }
        return dataStr;
    }

    /**
     * 取得发货次数
     * @return 发货次数
     */
    public  Long getDeliveryNums(BaseParam bean){
        Long deliveryNums = 0l;
        SC182101Bean res = super.findOne(SqlId.SQL_ID_FIND_DELIVERYNUMS, bean);
        if(res != null && res.getDeliveryNums() != null){
            deliveryNums = res.getDeliveryNums() + 1;
        }
        return deliveryNums == 0l ? 1l : deliveryNums;
    }

    /**
     * 获取产品相关信息
     * @param list 数据列表
     */
    private void setProductInfo(List<SC182102Param> list){
        for(SC182102Param sc182102Param : list){
            //根据产品Code获取产品信息
            ProductBean product = this.sc18210201Logic.getProductInfo(sc182102Param.getProductCode());
            if (product == null) {
                logger.info("产品编号:" + sc182102Param.getProductCode() + "没有相关产品");
                throw new BusinessException("产品编号:" + sc182102Param.getProductCode() + "没有相关产品");
            }

            if(product.getPdClasses() != null){
                sc182102Param.setProductName(product.getPdClasses().getClassesName());
            }
            if(product.getPdBreed() != null){
                sc182102Param.setProductTypeName(product.getPdBreed().getBreedName());
            }
            if(product.getPdFeature() != null){
                sc182102Param.setProductFeature(product.getPdFeature().getFeatureName());
            }
            if(product.getPdGrade() != null){
                sc182102Param.setProductLevel(product.getPdGrade().getGradeName());
            }
        }
    }

    /** 应上海需求 #1791添加页面合计 modify by renyi on 2016/8/10 start */
    @Transactional(readOnly = true)
    public SC182102Param getCurrentInfo(SC181102Param sc181102Param) {
        return super.findOne(SqlId.SQL_ID_GET_CURRENT_INFO,sc181102Param);
    }
    /** 应上海需求 #1791添加页面合计 modify by renyi on 2016/8/10 end */

}
