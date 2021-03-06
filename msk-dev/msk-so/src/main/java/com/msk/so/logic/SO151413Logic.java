package com.msk.so.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BasePageParam;
import com.msk.core.utils.StringUtil;
import com.msk.so.bean.SO151413Bean;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sjj 买手囤货库存余额统计Logic
 */
@Service
public class SO151413Logic extends BaseLogic {

    /**
     * logger
     *
     * @author sjj
     */

    private static Map<String, String> cellMap = new LinkedHashMap<>();

    static {
        cellMap.put("slCodeDis", "买手编码");
        cellMap.put("slShowName", "买手名称");
        cellMap.put("classesName", "产品分类");
        cellMap.put("breedName", "品种名称");
        cellMap.put("featureName", "特征名称");
        cellMap.put("pdCode", "产品编码");
        cellMap.put("pdName", "产品名称");
        cellMap.put("pdGradeName", "产品等级");
        cellMap.put("orderQty", "囤货数量");
        cellMap.put("leftQty", "剩余数量");
    }

    /**
     * @param basePageParam
     * @return
     * @throws Exception
     */
    public Workbook exportOrder(BasePageParam basePageParam) throws Exception {
        Workbook workBook = new SXSSFWorkbook(100); // 创建一个工作簿
        Sheet sheet = workBook.createSheet("买手囤货库存余额统计表");// 创建一个工作表，名为：第一页
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

        //  从数据查询的数据
        List<SO151413Bean> so151413BeanList = super.findList(basePageParam);

        short fmt = HSSFDataFormat.getBuiltinFormat("0.00");
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
        if (!CollectionUtils.isEmpty(so151413BeanList)) {
            for (int i = 0; i < so151413BeanList.size(); i++) { // 循环list中的数据  一个对象一行数据
                SO151413Bean bean = so151413BeanList.get(i);
                Row dataRow = sheet.createRow(i + 1);
                Cell data[] = new Cell[cellSize];
                int cellDataIndex = 0;
                for (String tableProperty : cellMap.keySet()) {
                    data[cellDataIndex] = dataRow.createCell(cellDataIndex);
                    data[cellDataIndex].setCellStyle(contentStyle);
                    cellDataIndex++;
                }
                data[0].setCellValue(bean.getSlCodeDis());
                data[1].setCellValue(bean.getSlShowName());
                data[2].setCellValue(bean.getClassesName());
                data[3].setCellValue(bean.getBreedName());
                data[4].setCellValue(bean.getFeatureName());
                data[5].setCellValue(bean.getPdCode());
                data[6].setCellValue(bean.getPdName());
                data[7].setCellValue(bean.getPdGradeName());
                if (StringUtil.isEmpty(bean.getOrderQty())) {
                    data[8].setCellValue("");//  订单数量 数值类型
                } else {
                    data[8].setCellValue(Double.parseDouble(bean.getOrderQty().replace(",", "")));//  囤货数量
                    styleNone.setDataFormat(fmt);
                    data[8].setCellStyle(styleNone);
                }
                if (StringUtil.isEmpty(bean.getLeftQty())) {
                    data[9].setCellValue("");//  订单金额 数值类型
                } else {
                    data[9].setCellValue(Double.parseDouble(bean.getLeftQty().replace(",", "")));//  剩余数量
                    style.setDataFormat(fmt);
                    data[9].setCellStyle(style);
                }
            }
        }
        return workBook;

    }

    interface SqlId {
    }


    private static Logger logger = LoggerFactory.getLogger(SO151413Logic.class);

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

}