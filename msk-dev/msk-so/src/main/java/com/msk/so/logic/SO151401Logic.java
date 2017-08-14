package com.msk.so.logic;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.*;

import com.msk.common.consts.OrderConst;
import com.msk.common.consts.StatusConst;
import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.BaseParam;
import com.msk.core.consts.NumberConst;
import com.msk.core.utils.DecimalUtil;
import com.msk.core.utils.StringUtil;
import com.msk.core.web.consts.BusinessConst;
import com.msk.core.web.consts.CodeMasterConst;
import com.msk.so.bean.order.OrderAndDetail;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.PageResult;
import com.msk.core.utils.DateTimeUtil;
import com.msk.so.bean.SO151401Bean;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

/**
 * @author rwf
 *         订单列表service
 */
@Service
public class SO151401Logic extends BaseLogic {

    /**
     * logger
     *
     * @author rwf
     */


    /**
     * 初始化单元格的 数据    标题  以及对应的数据
     */
    private static Map<String, String> cellMap = new LinkedHashMap<>();

    static {
        cellMap.put("orderID", "订单ID");
        cellMap.put("shipId", "发货单ID");
        cellMap.put("orderCode", "订单编码");
        cellMap.put("orderType", "订单类型");
        cellMap.put("orderDate", "订单创建日期");
        cellMap.put("orderTime", "订单创建时间");
        cellMap.put("orderStatus", "订单状态");
        cellMap.put("buyersCode", "买家编码");
        cellMap.put("buyersName", "买家名称");
        cellMap.put("buyersTypeName", "买家类型");
        cellMap.put("markt", "市场");
        cellMap.put("receiverAddr", "收货地址");
        cellMap.put("receiverTel", "电话");
        cellMap.put("frozenGoodsHousekeep", "冻品管家");
        cellMap.put("orderAmount", "订单总金额");
        cellMap.put("orderDetailId", "订单明细ID");
        cellMap.put("classCode", "产品类型");
        cellMap.put("className", "产品类型名称");
        cellMap.put("breedCode", "产品品种");
        cellMap.put("breedName", "产品品种名称");
        cellMap.put("featureCode", "特征编码");
        cellMap.put("featrueName", "特征名称");
        cellMap.put("normsName", "产品包装名称");
        cellMap.put("pdCode", "产品编码");
        cellMap.put("pdName", "产品名称");
        cellMap.put("pdGradeName", "产品等级名称");
        cellMap.put("price", "产品单价");
        cellMap.put("orderQty", "订单数量");
        cellMap.put("orderDetailAmount", "订单明细金额");
        cellMap.put("supplierName", "供应商名称");
        cellMap.put("suppQty", "供货数量");
        cellMap.put("sendQty", "发货数量");
        cellMap.put("receiveQty", "收货数量");
        cellMap.put("cancelQty", "取消数量");
        cellMap.put("rejectionQty", "退货数量");
        cellMap.put("returnQty", "拒收数量");
        cellMap.put("sendTime", "发货时间");
        cellMap.put("RecevicedTime", "收货时间");
        // <!--zhang_qiang  end:2017-2-17 start-->
        cellMap.put("salesParty", "销售人");
        // <!--zhang_qiang  end:2017-2-17 end-->
        cellMap.put("orderSource", "订单来源");
    }

    private static Map<String, String> cellMapOrder = new LinkedHashMap<>();

    static {
        cellMapOrder.put("orderID", "订单ID");
        cellMapOrder.put("requireOrderCode", "需求订单编码");
        cellMapOrder.put("districtName", "物流区");
        cellMapOrder.put("buyersTypeName", "买家类型");
        cellMapOrder.put("orderSource", "订单来源");
        cellMapOrder.put("orderType", "订单类型");
        cellMapOrder.put("buyersCode", "买家编码");
        cellMapOrder.put("buyersName", "买家名称");
        cellMapOrder.put("frozenGoodsHousekeep", "冻品管家");
        cellMapOrder.put("orderTime", "订单创建时间");
        cellMapOrder.put("orderQty", "订单数量");
        cellMapOrder.put("orderAmount", "订单总金额(元)");
        cellMapOrder.put("orderStatus", "订单状态");
    }

    /**
     * @param basePageParam
     * @return
     * @throws Exception
     */
    public Workbook export1(BasePageParam basePageParam) throws Exception {
        Workbook workBook = new SXSSFWorkbook(100); // 创建一个工作簿
        Sheet sheet = workBook.createSheet("订单明细表");// 创建一个工作表，名为：第一页
        CellStyle contentStyle = workBook.createCellStyle();// 背景色  内容
        contentStyle.setBorderBottom(CellStyle.BORDER_THIN); // 底部边框
        contentStyle.setBorderRight(CellStyle.BORDER_THIN); // 右边边框
        CellStyle tiltleStyle = workBook.createCellStyle();// 背景色  标题
        tiltleStyle.setFillForegroundColor(IndexedColors.PALE_BLUE.getIndex());
        tiltleStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
        tiltleStyle.setAlignment(CellStyle.ALIGN_CENTER);// 字体居中
        tiltleStyle.setBorderRight(contentStyle.getBorderRight());
        tiltleStyle.setBorderBottom(contentStyle.getBorderBottom());
        int cellSize = cellMap.size();
        for (int i = 0; i < cellSize; i++) {//  设置多少列
            sheet.setColumnWidth((short) i, 5000);
        }
        Row title = sheet.createRow((short) 0);// 创建一个单元格，从0开始
        Cell cell[] = new Cell[cellSize];// 构造一个数组设置第一行之后的单元格
        int cellTitleIndex = 0;
        for (String titleName : cellMap.values()) {
            cell[cellTitleIndex] = title.createCell(cellTitleIndex);
            cell[cellTitleIndex].setCellStyle(tiltleStyle);
            cell[cellTitleIndex].setCellValue(titleName);
            cellTitleIndex++;
        }
        /**
         * 设置 订单类型 不能为 买手销售订单
         */
        basePageParam.setFilterObject("salesParty", OrderConst.OrderType.BUYER_SALE_ORDER);
        List<OrderAndDetail> OrderAndDetailList = this.getOrderAndDetail(basePageParam);//  从数据查询的数据
        short fmt = HSSFDataFormat.getBuiltinFormat("0.00");
        CellStyle style = workBook.createCellStyle();
        style.setBorderBottom(CellStyle.BORDER_THIN);
        style.setBorderLeft(CellStyle.BORDER_THIN);
        style.setBorderTop(CellStyle.BORDER_THIN);
        style.setBorderRight(CellStyle.BORDER_THIN);
        if (!CollectionUtils.isEmpty(OrderAndDetailList)) {
            for (int i = 0; i < OrderAndDetailList.size(); i++) {// 循环list中的数据  一个对象一行数据
                OrderAndDetail bean = OrderAndDetailList.get(i);
                Row dataRow = sheet.createRow(i + 1);
                Cell data[] = new Cell[cellSize];
                int cellDataIndex = 0;
                for (String tableProperty : cellMap.keySet()) {
                    data[cellDataIndex] = dataRow.createCell(cellDataIndex);
                    data[cellDataIndex].setCellStyle(contentStyle);
                    cellDataIndex++;
                }
                data[0].setCellValue(bean.getOrderID());
                data[1].setCellValue(bean.getShipId());
                data[2].setCellValue(bean.getOrderCode());
                data[3].setCellValue(bean.getOrderType());
                data[4].setCellValue(bean.getOrderTime().substring(0, 10));
                data[5].setCellValue(bean.getOrderTime().substring(11, 19));
                data[6].setCellValue(bean.getOrderStatus());
                data[7].setCellValue(bean.getBuyerCode());
                data[8].setCellValue(bean.getBuyersName());
                data[9].setCellValue(bean.getBuyersTypeName());
                data[10].setCellValue(bean.getMarkt());
                data[11].setCellValue(bean.getReceiverAddr());
                data[12].setCellValue(bean.getReceiverTel());
                data[13].setCellValue(bean.getFrozenGoodsHousekeep());

                if (null == bean.getOrderAmount()) {
                    data[14].setCellValue("");//  订单金额 数值类型
                } else {
                    data[14].setCellValue(Double.parseDouble(bean.getOrderAmount().replace(",", "")));//  订单金额 数值类型
                    style.setDataFormat(fmt);
                    data[14].setCellStyle(style);
                }

                data[15].setCellValue(bean.getOrderDetailId());
                data[16].setCellValue(bean.getClassCode());
                data[17].setCellValue(bean.getClassName());
                data[18].setCellValue(bean.getBreedCode());
                data[19].setCellValue(bean.getBreedName());
                data[20].setCellValue(bean.getFeatureCode());
                data[21].setCellValue(bean.getFeatrueName());
                data[22].setCellValue(bean.getNormsName());
                data[23].setCellValue(bean.getPdCode());
                data[24].setCellValue(bean.getPdName());
                data[25].setCellValue(bean.getPdGradeName());

                if (0 == bean.getPrice()) {
                    data[26].setCellValue("");//数值类型
                } else {
                    data[26].setCellValue(bean.getPrice());//数值类型
                    style.setDataFormat(fmt);
                    data[26].setCellStyle(style);
                }

                if (null == bean.getOrderQty()) {
                    data[27].setCellValue("");//数值类型
                } else {
                    data[27].setCellValue(Double.parseDouble(bean.getOrderQty().replace(",", "")));//数值类型
                }

                if (null == bean.getOrderDetailAmount()) {
                    data[28].setCellValue("");//数值类型
                } else {
                    data[28].setCellValue(Double.parseDouble(bean.getOrderDetailAmount().replace(",", "")));//数值类型
                    style.setDataFormat(fmt);
                    data[28].setCellStyle(style);
                }

                data[29].setCellValue(bean.getSupplierName());

                if (null == bean.getSuppQty()) {
                    data[30].setCellValue("");//数值类型
                } else {
                    data[30].setCellValue(Double.parseDouble(bean.getSuppQty().replace(",", "")));//数值类型
                }

                if (null == bean.getSendQty()) {
                    data[31].setCellValue("");//数值类型
                } else {
                    data[31].setCellValue(Double.parseDouble(bean.getSendQty().replace(",", "")));//数值类型
                }

                if (null == bean.getReceiveQty()) {
                    data[32].setCellValue("");//数值类型
                } else {
                    data[32].setCellValue(Double.parseDouble(bean.getReceiveQty().replace(",", "")));//数值类型
                }

                if (null == bean.getCancelQty()) {
                    data[33].setCellValue("");//数值类型
                } else {
                    data[33].setCellValue(Double.parseDouble(bean.getCancelQty().replace(",", "")));//数值类型
                }

                if (null == bean.getReturnQty()) {
                    data[34].setCellValue("");//数值类型
                } else {
                    data[34].setCellValue(Double.parseDouble(bean.getReturnQty().replace(",", "")));//数值类型
                }

                if (null == bean.getRejectionQty()) {
                    data[35].setCellValue("");//数值类型
                } else {
                    data[35].setCellValue(Double.parseDouble(bean.getRejectionQty().replace(",", "")));//数值类型
                }

                data[36].setCellValue(bean.getSendTime());
                data[37].setCellValue(bean.getRecevicedTime());
                // <!--zhang_qiang  end:2017-2-17 start-->
                data[38].setCellValue(bean.getSalesParty());
                // <!--zhang_qiang  end:2017-2-17 end-->
                data[39].setCellValue(bean.getOrderSource());
            }
        }
        return workBook;

    }

    /**
     * @param so151401BeanList
     * @return
     * @throws Exception
     */
    public Workbook exportOrder(List<SO151401Bean> so151401BeanList) throws Exception {
        Workbook workBook = new SXSSFWorkbook(100); // 创建一个工作簿
        Sheet sheet = workBook.createSheet("订单列表数据");// 创建一个工作表，名为：第一页
        CellStyle contentStyle = workBook.createCellStyle();// 背景色  内容
        contentStyle.setBorderBottom(CellStyle.BORDER_THIN); // 底部边框
        contentStyle.setBorderRight(CellStyle.BORDER_THIN); // 右边边框
        CellStyle tiltleStyle = workBook.createCellStyle();// 背景色  标题
        tiltleStyle.setFillForegroundColor(IndexedColors.PALE_BLUE.getIndex());
        tiltleStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
        tiltleStyle.setBorderLeft(CellStyle.BORDER_THIN);
        tiltleStyle.setAlignment(CellStyle.ALIGN_CENTER);// 字体居中
        tiltleStyle.setBorderRight(contentStyle.getBorderRight());
        tiltleStyle.setBorderBottom(contentStyle.getBorderBottom());
        int cellSize = cellMapOrder.size();
        for (int i = 0; i < cellSize; i++) {//  设置多少列
            sheet.setColumnWidth((short) i, 5000);
        }
        Row title = sheet.createRow((short) 0);// 创建一个单元格，从0开始
        Cell cell[] = new Cell[cellSize];// 构造一个数组设置第一行之后的单元格
        int cellTitleIndex = 0;
        for (String titleName : cellMapOrder.values()) {
            cell[cellTitleIndex] = title.createCell(cellTitleIndex);
            cell[cellTitleIndex].setCellStyle(tiltleStyle);
            cell[cellTitleIndex].setCellValue(titleName);
            cellTitleIndex++;
        }
        short fmt = HSSFDataFormat.getBuiltinFormat("0.00");
        short fmtNone = HSSFDataFormat.getBuiltinFormat("0");
        CellStyle style = workBook.createCellStyle();
        style.setBorderBottom(CellStyle.BORDER_THIN);
        style.setBorderLeft(CellStyle.BORDER_THIN);
        style.setBorderTop(CellStyle.BORDER_THIN);
        style.setBorderRight(CellStyle.BORDER_THIN);
        CellStyle styleNone = workBook.createCellStyle();
        styleNone.setBorderBottom(CellStyle.BORDER_THIN);
        styleNone.setBorderLeft(CellStyle.BORDER_THIN);
        styleNone.setBorderTop(CellStyle.BORDER_THIN);
        styleNone.setBorderRight(CellStyle.BORDER_THIN);
        Double allOrderAmount = 0d;
        Double allOrderQty = 0d;
        if (!CollectionUtils.isEmpty(so151401BeanList)) {
            for (int i = 0; i < so151401BeanList.size(); i++) { // 循环list中的数据  一个对象一行数据
                SO151401Bean bean = so151401BeanList.get(i);
                Row dataRow = sheet.createRow(i + 1);
                Cell data[] = new Cell[cellSize];
                int cellDataIndex = 0;
                for (String tableProperty : cellMapOrder.keySet()) {
                    data[cellDataIndex] = dataRow.createCell(cellDataIndex);
                    data[cellDataIndex].setCellStyle(contentStyle);
                    cellDataIndex++;
                }
                data[0].setCellValue(bean.getOrderId());
                data[1].setCellValue(bean.getOrderCode());
                data[2].setCellValue(bean.getDistrictName());
                data[3].setCellValue(bean.getBuyersTypeName());
                data[4].setCellValue(bean.getOrderSource());
                data[5].setCellValue(bean.getOrderType());
                data[6].setCellValue(bean.getBuyersCode());
                data[7].setCellValue(bean.getBuyersName());
                data[8].setCellValue(bean.getFrozenGoodsHousekeep());
                data[9].setCellValue(DateTimeUtil.formatDate(DateTimeUtil.FORMAT_DATE_YYYYMMDD, bean.getOrderTime()));
                if (StringUtil.isEmpty(bean.getOrderQty())) {
                    data[10].setCellValue("");//  订单数量 数值类型
                } else {
                    allOrderQty += Double.parseDouble(bean.getOrderQty().replace(",", ""));
                    data[10].setCellValue(Double.parseDouble(bean.getOrderQty().replace(",", "")));//  订单数量 数值类型
                    styleNone.setDataFormat(fmtNone);
                    data[10].setCellStyle(styleNone);
                }
                if (StringUtil.isEmpty(bean.getOrderAmount())) {
                    data[11].setCellValue("");//  订单金额 数值类型
                } else {
                    allOrderAmount += Double.parseDouble(bean.getOrderAmount().replace(",", ""));
                    data[11].setCellValue(Double.parseDouble(bean.getOrderAmount().replace(",", "")));//  订单金额 数值类型
                    style.setDataFormat(fmt);
                    data[11].setCellStyle(style);
                }
                data[12].setCellValue(bean.getOrderStatus());
            }
        }

        // 合计行
        Row lastRow = sheet.createRow(so151401BeanList.size() + 1);
        Cell data[] = new Cell[13];
        data[9] = lastRow.createCell(9);
        data[9].setCellStyle(tiltleStyle);
        data[9].setCellValue("合计:");
        // 订单数量合计
        data[10] = lastRow.createCell(10);
        styleNone.setDataFormat(fmtNone);
        data[10].setCellStyle(styleNone);
        data[10].setCellValue(allOrderQty);
        // 订单金额合计
        style.setDataFormat(fmt);
        data[11] = lastRow.createCell(11);
        data[11].setCellStyle(style);
        data[11].setCellValue(allOrderAmount);
        return workBook;

    }

    interface SqlId {
        static final String SQL_ID_FIND_DISTRIC_TLIST = "findDistrictList";
        static final String SQL_ID_FIND_ORDERTYPE = "findOrderType";
        static final String SQL_ID_FIND_ORDERDETAIL = "findOrderDetail";
        static final String SQL_ID_FIND_FINDFOOD = "findFood";
        static final String SQL_ID_FIND_FINDTEL = "findTer";
        //Modify for bug#1154 at 2016/07/13 by wang_jianzhou Start.
        static final String SQL_ID_GET_TOTAL_AMOUNT_AND_QTY = "getTotalAmountAndQty";
        static final String SQL_ID_GET_CURRENT_PAGE_AMOUNT_AND_QTY = "getCurrentPageAmountAndQty";
        //Modify for bug#1154 at 2016/07/13 by wang_jianzhou end.
       /* static final String SQL_ID_FIND_ORDERSOURCE = "findOrderSource";*/
        String SQL_ID_MODIFY_ORDER_STU = "modifyOrderStu";
        String SQL_ID_MODIFY_ORDER_DETAIL_STU = "modifyOrderDetailStu";
        String SQL_ID_MODIFY_ORDER_AVA_STU = "modifyOrderAvaStu";
        // <!--zhang_qiang  end:2017-2-17 start-->
        String SQL_ID_MODIFY_GET_DETAIL_List = "getDetailList";
        // <!--zhang_qiang  end:2017-2-17 end-->
    }


    private static Logger logger = LoggerFactory.getLogger(SO151401Logic.class);

    public List<SO151401Bean> findDistrict() {

        List<SO151401Bean> districtList = super.findList(SqlId.SQL_ID_FIND_DISTRIC_TLIST, null);
        return districtList;
    }

    public List<SO151401Bean> findOrderType() {
        List<SO151401Bean> orderTypes = super.findList(SqlId.SQL_ID_FIND_ORDERTYPE, null);
        return orderTypes;
    }

    //Modify for bug#1154 at 2016/07/13 by wang_jianzhou Start.
    //查询总数量，总金额
    public SO151401Bean getTotalAmountAndQty(BasePageParam basePageParam) {
        SO151401Bean so151401Bean = super.findOne(SqlId.SQL_ID_GET_TOTAL_AMOUNT_AND_QTY, basePageParam);
        return so151401Bean;
    }

    //查询当前页总数量，总金额
    public SO151401Bean getCurrentPageAmountAndQty(BasePageParam basePageParam) {
        SO151401Bean so151401Bean = super.findOne(SqlId.SQL_ID_GET_CURRENT_PAGE_AMOUNT_AND_QTY, basePageParam);
        return so151401Bean;
    }
    //Modify for bug#1154 at 2016/07/13 by wang_jianzhou end.
   /* public List<SO151401Bean> findOrderSource(){
        List<SO151401Bean> orderSources = super.findList(SqlId.SQL_ID_FIND_ORDERSOURCE,null);
        return  orderSources;
    }*/

    /**
     * 获取订单页面假数据
     * ruweifeng
     *
     * @return PageResult<OM141101Bean>
     */
    public PageResult<SO151401Bean> findOrderList() {

        PageResult<SO151401Bean> result = new PageResult<SO151401Bean>();
        logger.info("获取假数据");
        List<SO151401Bean> list = new ArrayList<SO151401Bean>();
        SO151401Bean om1 = new SO151401Bean();// 假数据,获取订单列表中的数据
        om1.setOrderId("1");// 订单ID
        om1.setRequireOrderCode("001-20111010110011-1");// 获取需求订单编码
        om1.setBuyersCode("20111010110011");// 获取买家的编码
        om1.setBuyersName("张三");// 买家姓名
        om1.setBuyersType("菜场买家");
        om1.setAuxiliaryCode("28");// 时间编码
        om1.setSendWarehouseName("上海张江分库");// 发货仓库
        om1.setOrderSource("神农客平台");// 订单来源
        om1.setOrderAmount("3999.00");// 总金额
        om1.setOrderType("分销");// 订单类型
        om1.setOrderTime(DateTimeUtil.parseDate("2016-01-09 14:29:19", "yyyy-MM-dd HH:mm:ss"));// 订单创建时间
        om1.setOrderStatus("待付款");// 订单状态
        om1.setDistrictCode("上海");
        list.add(om1);

        SO151401Bean om2 = new SO151401Bean();// 假数据,获取订单列表中的数据
        om2.setOrderId("2");// 订单ID
        om2.setRequireOrderCode("001-10111010110101-12");// 获取订单的编号
        om2.setBuyersCode("10111010110101");// 获取买家的编号
        om2.setBuyersName("李四");// 卖家姓名
        om2.setBuyersType("分销买家");
        om2.setAuxiliaryCode("34");// 时间编码
        om2.setOrderTime(DateTimeUtil.parseDate("2016-01-01 17:10:09", "yyyy-MM-dd HH:mm:ss"));// 订单创建时间
        om2.setSendWarehouseName("南京钟山分库");// 发货仓库
        om2.setOrderSource("神农客平台");// 订单来源
        om2.setOrderAmount("6000.00");// 总金额
        om2.setOrderStatus("全部收货");// 订单状态
        om2.setOrderType("分销");// 订单类型
        om2.setDistrictCode("上海");
        list.add(om2);

        SO151401Bean om3 = new SO151401Bean();// 假数据,获取订单列表中的数据
        om3.setOrderId("3");// 订单ID
        om3.setRequireOrderCode("001-30111010110251-26");// 获取订单的编号
        om3.setBuyersCode("30111010110251");// 获取买家的编号
        om3.setBuyersName("王五");// 卖家姓名
        om3.setBuyersType("团膳买家");
        om3.setAuxiliaryCode("24");// 时间编码
        om3.setDistrictCode("上海");
        om3.setOrderTime(DateTimeUtil.parseDate("2016-01-08 12:20:09", "yyyy-MM-dd HH:mm:ss"));// 订单创建时间
        om3.setSendWarehouseName("深圳分仓库");// 发货仓库
        om3.setOrderSource("美侍客平台");// 订单来源
        om3.setOrderAmount("60000.00");// 总金额
        om3.setOrderStatus("全部发货");// 订单状态
        om3.setOrderType("第三方");
        list.add(om3);
        result.setData(list);// 设置分页
        result.setRecordsTotal(list.size());// 获取订单个数
        return result;

    }


    /**
     * @param basePageParam 查询参数
     */
    public Workbook expor(BasePageParam basePageParam) throws Exception {
        Workbook workBook = new SXSSFWorkbook(100); // 创建一个工作簿
        Sheet sheet = workBook.createSheet("订单明细表");// 创建一个工作表，名为：第一页


        CellStyle contentStyle = workBook.createCellStyle();// 背景色  内容
        contentStyle.setBorderBottom(CellStyle.BORDER_THIN); // 底部边框
        contentStyle.setBorderRight(CellStyle.BORDER_THIN); // 右边边框

        CellStyle tiltleStyle = workBook.createCellStyle();// 背景色  标题
        tiltleStyle.setFillForegroundColor(IndexedColors.PALE_BLUE.getIndex());
        tiltleStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
        tiltleStyle.setAlignment(CellStyle.ALIGN_CENTER);// 字体居中

        tiltleStyle.setBorderRight(contentStyle.getBorderRight());
        tiltleStyle.setBorderBottom(contentStyle.getBorderBottom());

        for (int i = 0; i < 32; i++) {//  设置多少行
            sheet.setColumnWidth((short) i, 5000);
        }
        Row row = sheet.createRow((short) 0);// 创建一个单元格，从0开始
        Cell cell[] = new Cell[32];// 构造一个数组设置第一行之后的单元格
        for (int i = 0; i < 32; i++) {
            cell[i] = row.createCell(i);
            cell[i].setCellStyle(tiltleStyle);// 设置颜色
        }
        cell[0].setCellValue("订单ID");
        cell[1].setCellValue("订单编码");
        cell[2].setCellValue("订单类型");
        cell[3].setCellValue("下单时间");
        cell[4].setCellValue("订单状态");
        cell[5].setCellValue("买家名称");

        cell[6].setCellValue("市场");
        cell[7].setCellValue("收货地址");
        cell[8].setCellValue("电话");


        cell[9].setCellValue("冻品管家");

        cell[10].setCellValue("订单明细ID");
        cell[11].setCellValue("产品类型");
        cell[12].setCellValue("产品类型名称");
        cell[13].setCellValue("产品品种");
        cell[14].setCellValue("产品品种名称");
        cell[15].setCellValue("特征编码");
        cell[16].setCellValue("特征名称");
        cell[17].setCellValue("产品包装名称");
        cell[18].setCellValue("产品编码");
        cell[19].setCellValue("产品名称");
        cell[20].setCellValue("产品等级名称");
        cell[21].setCellValue("产品单价");
        cell[22].setCellValue("订单数量");
        cell[23].setCellValue("供应商名称");
        cell[24].setCellValue("供货数量");
        cell[25].setCellValue("发货数量");
        cell[26].setCellValue("收货数量");
        cell[27].setCellValue("取消数量");
        cell[28].setCellValue("退货数量");
        cell[29].setCellValue("拒收数量");
        cell[30].setCellValue("发货时间");
        cell[31].setCellValue("收货时间");
        List<OrderAndDetail> OrderAndDetailList = new ArrayList<>();
        List<OrderAndDetail> list1 = this.getOrderAndDetail(basePageParam);
        OrderAndDetailList.addAll(list1);
        if (OrderAndDetailList != null && OrderAndDetailList.size() > 0) {
            for (int i = 0; i < OrderAndDetailList.size(); i++) {// 循环list中的数据
                OrderAndDetail bean = OrderAndDetailList.get(i);
                Row dataRow = sheet.createRow(i + 1);
                Cell data[] = new Cell[32];
                for (int j = 0; j < 32; j++) {
                    data[j] = dataRow.createCell(j);
                    data[j].setCellStyle(contentStyle);
                }
                data[0].setCellValue(bean.getOrderID());
                data[1].setCellValue(bean.getOrderCode());
                data[2].setCellValue(bean.getOrderType());
                data[3].setCellValue(bean.getOrderTime());
                data[4].setCellValue(bean.getOrderStatus());
                data[5].setCellValue(bean.getBuyersName());

                data[6].setCellValue(this.getMarktName(bean.getBuyerId(), bean.getBuyerType()));
                data[7].setCellValue(bean.getReceiverAddr());
                data[8].setCellValue(bean.getReceiverTel());

                data[9].setCellValue(bean.getFrozenGoodsHousekeep());
                data[10].setCellValue(bean.getOrderDetailId());
                data[11].setCellValue(bean.getClassCode());
                data[12].setCellValue(bean.getClassName());
                data[13].setCellValue(bean.getBreedCode());
                data[14].setCellValue(bean.getBreedName());
                data[15].setCellValue(bean.getFeatureCode());
                data[16].setCellValue(bean.getFeatrueName());
                data[17].setCellValue(bean.getNormsName());
                data[18].setCellValue(bean.getPdCode());
                data[19].setCellValue(bean.getPdName());
                data[20].setCellValue(bean.getPdGradeName());
                data[21].setCellValue(bean.getPrice());
                data[22].setCellValue(bean.getOrderQty());
                data[23].setCellValue(bean.getSupplierName());
                data[24].setCellValue(bean.getSuppQty());
                data[25].setCellValue(bean.getSendQty());
                data[26].setCellValue(bean.getReceiveQty());
                data[27].setCellValue(bean.getCancelQty());
                data[28].setCellValue(bean.getReturnQty());
                data[29].setCellValue(bean.getRejectionQty());
                data[30].setCellValue(bean.getSendTime());
                data[31].setCellValue(bean.getRecevicedTime());

            }
        }
        return workBook;

    }


    /**
     * @param buyerId
     * @param buyType
     * @return
     */
    public String getMarktName(String buyerId, String buyType) {
        BasePageParam baseParam = new BasePageParam();
        baseParam.getFilterMap().put("buyerId", buyerId);
        String marktName = "";
        List<OrderAndDetail> list = null;
        if ((!StringUtil.isEmpty(buyType)) && (!StringUtil.isEmpty(buyerId))) {
            if (BusinessConst.BuyerType.Distribution.equals(buyType)) {// ter
                list = this.getTerMarketNamel(baseParam);
            } else if (BusinessConst.BuyerType.Market.equals(buyType)) {// food
                list = this.getFoodMarketNamel(baseParam);
            }
            if (list != null && list.size() > 0) {
                if (list.get(0) != null) {
                    marktName = list.get(0).getMarkt();
                }
            }
        }
        return marktName;
    }


    /**
     * @param basePageParam
     * @return
     */
    @Transactional(readOnly = true)
    public List<OrderAndDetail> getFoodMarketNamel(BasePageParam basePageParam) {
        List<OrderAndDetail> list = super.findList(SqlId.SQL_ID_FIND_FINDFOOD, basePageParam);
        return list;
    }


    /**
     * @param basePageParam
     * @return
     */
    @Transactional(readOnly = true)
    public List<OrderAndDetail> getTerMarketNamel(BasePageParam basePageParam) {
        List<OrderAndDetail> list = super.findList(SqlId.SQL_ID_FIND_FINDTEL, basePageParam);
        return list;
    }


    /**
     * @param bean
     * @param propertyName
     * @return
     */
    public String getValueByName(OrderAndDetail bean, String propertyName) throws InvocationTargetException, IllegalAccessException {

        //  添加几个特殊的字段
        String name = null;
        Class orderAndDetailCla = bean.getClass();
        Method[] methods = orderAndDetailCla.getMethods();
        String methodName = "get" + this.captureName(propertyName);
        for (Method method : methods) {
            if (propertyName.equals("markt")) {// 特殊处理  市场
                name = this.getMarktName(bean.getBuyerId(), bean.getBuyerType());
            } else {
                if (method.getName().equals(methodName)) {
                    name = (String) method.invoke(bean);
                }
            }

        }
        return name;
    }


    /**
     * @param name
     * @return
     */
    public String captureName(String name) {
        name = name.substring(0, 1).toUpperCase() + name.substring(1);
        return name;

    }

    /**
     * @param basePageParam
     * @return
     */
    @Transactional(readOnly = true)
    public List<OrderAndDetail> getOrderAndDetail(BasePageParam basePageParam) {
        List<OrderAndDetail> list = super.findList(SqlId.SQL_ID_FIND_ORDERDETAIL, basePageParam);
        return this.setSalesParty(list);
    }


    // <!--zhang_qiang  end:2017-2-17 start-->

    /**
     * @param list
     * @return
     */
    public List<OrderAndDetail> setSalesParty(List<OrderAndDetail> list) {
        Map<String, OrderAndDetail> map = this.getDetailMap(list);
        if (!CollectionUtils.isEmpty(list)) {
            for (OrderAndDetail orderAndDetail : list) {
                String salesParty = null;
                String orderType = orderAndDetail.getOrderType();
                if ("买手囤货订单".equals(orderType)) {// 买手囤货
                    salesParty = "平台";
                } else if ("分销订单".equals(orderType)) {// 分销
                    String orderDetailId = orderAndDetail.getOrderDetailId();
                    OrderAndDetail dbOrderDetail = map.get(orderDetailId);
                    if (dbOrderDetail!=null&&!StringUtil.isEmpty(dbOrderDetail.getOrderID())) {// 订单关系表中 childOrderId= 该订单明细的订单id 说明该明细是买手的    买手销售
                        salesParty =dbOrderDetail.getSalesParty();
                    } else {
                        salesParty = "平台";
                    }
                }
                orderAndDetail.setSalesParty(salesParty);
            }
        }
        return list;
    }
    // <!--zhang_qiang  end:2017-2-17 end-->


    // <!--zhang_qiang  end:2017-2-17 start-->

    /**
     * 获取 detail map  通过数据库查询
     *
     * @param list
     * @return
     */
    public Map<String, OrderAndDetail> getDetailMap(List<OrderAndDetail> list) {
        Map<String, OrderAndDetail> map = new HashMap<>();
        BaseParam baseParam = new BaseParam();
        baseParam.getFilterMap().put("list", list);
        List<OrderAndDetail> dbList = this.findList(SqlId.SQL_ID_MODIFY_GET_DETAIL_List, baseParam);
        if (!CollectionUtils.isEmpty(dbList)) {
            for (OrderAndDetail orderAndDetail : dbList) {
                map.put(orderAndDetail.getOrderDetailId(), orderAndDetail);
            }
        }
        return map;
    }
    //查询按钮
// <!--zhang_qiang  end:2017-2-17 end-->

    /**
     * @param basePageParam
     * @return PageResult
     */
    public PageResult<SO151401Bean> search(BasePageParam basePageParam) {
        PageResult<SO151401Bean> results = this.findPage(basePageParam, SO151401Bean.class);
        if (results.getData().size() > NumberConst.IntDef.INT_ZERO) {
            SO151401Bean totalBean = new SO151401Bean();
            totalBean = this.getTotalAmountAndQty(basePageParam);
            SO151401Bean currentBean = new SO151401Bean();
            currentBean = this.getCurrentPageAmountAndQty(basePageParam);
            results.getData().get(0).setCurrentPageAmount(currentBean.getCurrentPageAmount());
            results.getData().get(0).setCurrentPageQty(currentBean.getCurrentPageQty().replace(".00", ""));
            results.getData().get(0).setTotalQty(totalBean.getTotalQty().replace(".00", ""));
            results.getData().get(0).setTotalAmount(totalBean.getTotalAmount());
            for (int i = 0; i < results.getData().size(); i++) {
                String orderQty = results.getData().get(i).getOrderQty().replace(".00", "");
                results.getData().get(i).setOrderQty(orderQty);
            }
        }
        return results;
    }

    @Transactional
    public void modifyOrderStu(SO151401Bean bean) {
        bean.setOrderStu(StatusConst.OrderStatusDef.CONFIRM);
        bean.setOrderDetailStu(StatusConst.OrderDetailStatusDef.CONFIRM);
        bean.setOrderAvaStu(StatusConst.OrderDetailAvailabilityStatusDef.CONFIRM);
        super.modify(SqlId.SQL_ID_MODIFY_ORDER_STU, bean);
        super.modify(SqlId.SQL_ID_MODIFY_ORDER_DETAIL_STU, bean);
        super.modify(SqlId.SQL_ID_MODIFY_ORDER_AVA_STU, bean);
    }

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

}