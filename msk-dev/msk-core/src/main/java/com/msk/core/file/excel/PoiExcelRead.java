package com.msk.core.file.excel;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.msk.core.utils.PoiUtils;

public class PoiExcelRead {
    /** Excel Sheet */
    private Sheet sheet;
    /** Start Row */
    private int startRow;

	public PoiExcelRead(Workbook workbook, int sheetIndex, int startRow) {
        sheet = workbook.getSheetAt(sheetIndex);
        this.startRow = startRow;
    }

    public <T> List<T> readExcel(ExcelReadColumn<T> readColumn) {
        List<T> excelDataList = new ArrayList<T>();
        int rowNum = sheet.getLastRowNum();
        for (; startRow <= rowNum; startRow++) {
            Row row = PoiUtils.getRow(sheet, startRow);
            T data = readColumn.readColumn(row);
            excelDataList.add(data);
        }
        return excelDataList;
}

}
