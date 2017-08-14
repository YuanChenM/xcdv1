package com.msk.core.file.excel;

import org.apache.poi.ss.usermodel.Row;

public interface ExcelReadColumn<T> {
	public T readColumn(Row row);
}
