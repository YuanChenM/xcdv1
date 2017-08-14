package com.msk.so.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BasePageParam;
import com.msk.core.utils.DateTimeUtil;
import com.msk.core.utils.StringUtil;
import com.msk.so.bean.SO151202Bean;
import com.msk.so.bean.SO151401Bean;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * Created by zhao_chen1 on 2016/3/4.
 */
public class SO151202Logic extends BaseLogic {

    /**
     * SqlId. 方法名
     */
    interface SqlId {
        String SAVESTOCKSL = "saveStockSL";
    }
    private  static Map<String,String> cellMapStcokr=new LinkedHashMap<>();
    static {
        cellMapStcokr.put("lgcsCode","物流区编码");
        cellMapStcokr.put("lgcsName","物流区名称");
        cellMapStcokr.put("warehouseCode","仓库编码");
        cellMapStcokr.put("warehouseName","仓库名称");
        cellMapStcokr.put("salePlatform","销售平台");
        cellMapStcokr.put("slCode","卖家编码");
        cellMapStcokr.put("slName","卖家名称");
        cellMapStcokr.put("pdCode","产品编码");
        cellMapStcokr.put("pdName","产品名称");
        cellMapStcokr.put("stockCnt","可用库存");
    }

    /**
     * 更新库存量
     * @param param
     */
    public int saveStockSL(BasePageParam param) {
        int result = super.modify(SqlId.SAVESTOCKSL, param);
        return result;
    }


    /**
     * 
     * @param so151202BeanList
     * @return
     */
    public Workbook exprotStock(List<SO151202Bean> so151202BeanList){
        Workbook workBook = new SXSSFWorkbook(100); // 创建一个工作簿
        Sheet sheet = workBook.createSheet("卖家库存列表数据");// 创建一个工作表，名为：第一页

        CellStyle contentStyle = workBook.createCellStyle();// 背景色  内容
        contentStyle.setBorderBottom(CellStyle.BORDER_THIN); // 底部边框
        contentStyle.setBorderRight(CellStyle.BORDER_THIN); // 右边边框
        CellStyle  tiltleStyle = workBook.createCellStyle();// 背景色  标题
        tiltleStyle.setFillForegroundColor(IndexedColors.PALE_BLUE.getIndex());
        tiltleStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
        tiltleStyle.setBorderLeft(CellStyle.BORDER_THIN);
        tiltleStyle.setAlignment(CellStyle.ALIGN_CENTER);// 字体居中
        tiltleStyle.setBorderRight(contentStyle.getBorderRight());
        tiltleStyle.setBorderBottom(contentStyle.getBorderBottom());
        int cellSize= cellMapStcokr.size();
        for(int i=0;i<cellSize;i++){//  设置多少列
            sheet.setColumnWidth((short) i, 5000);
        }
        Row title = sheet.createRow((short) 0);// 创建一个单元格，从0开始
        Cell cell[] = new Cell[cellSize];// 构造一个数组设置第一行之后的单元格
        int cellTitleIndex=0;
        for(String titleName :cellMapStcokr.values()){
            cell[cellTitleIndex]=title.createCell(cellTitleIndex);
            cell[cellTitleIndex].setCellStyle(tiltleStyle);
            cell[cellTitleIndex].setCellValue(titleName);
            cellTitleIndex++;
        }
        CellStyle style =workBook.createCellStyle();
        style.setBorderBottom(CellStyle.BORDER_THIN);
        style.setBorderLeft(CellStyle.BORDER_THIN);
        style.setBorderTop(CellStyle.BORDER_THIN);
        style.setBorderRight(CellStyle.BORDER_THIN);
        CellStyle styleNone =workBook.createCellStyle();
        styleNone.setBorderBottom(CellStyle.BORDER_THIN);
        styleNone.setBorderLeft(CellStyle.BORDER_THIN);
        styleNone.setBorderTop(CellStyle.BORDER_THIN);
        styleNone.setBorderRight(CellStyle.BORDER_THIN);
        if(!CollectionUtils.isEmpty(so151202BeanList)){
            for (int i = 0; i < so151202BeanList.size(); i++) { // 循环list中的数据  一个对象一行数据
                SO151202Bean bean =  so151202BeanList.get(i);
                Row  dataRow = sheet.createRow(i + 1);
                Cell data[] = new Cell[cellSize];
                int cellDataIndex=0;
                for(String  tableProperty:cellMapStcokr.keySet()){
                    data[cellDataIndex] = dataRow.createCell(cellDataIndex);
                    data[cellDataIndex].setCellStyle(contentStyle);
                    cellDataIndex++;
                }
                data[0].setCellValue(bean.getLgcsCode());
                data[1].setCellValue(bean.getLgcsName());
                data[2].setCellValue(bean.getWarehouseCode());
                data[3].setCellValue(bean.getWarehouseName());
                data[4].setCellValue(bean.getSalePlatform());
                data[5].setCellValue(bean.getSlCodeDis());
                data[6].setCellValue(bean.getSlName());
                data[7].setCellValue(bean.getPdCode());
                data[8].setCellValue(bean.getPdName());
                data[9].setCellValue(bean.getStockCnt() == null ? 0 : bean.getStockCnt().intValue());

            }
        }
        sheet.autoSizeColumn((short) 8); //调整第三列宽度
        return workBook;
    }

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }





}
