package com.caidongmei.alumniassociation.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelUploadUtil {
	/**
	 * @author WangJin
	 */
	//��ȡ�ϴ���Excel����
	public static HSSFWorkbook getExcel(File file) {
		HSSFWorkbook hssfWorkbook =null;
		try {
			hssfWorkbook = new HSSFWorkbook(new FileInputStream(
					file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return hssfWorkbook;
	}

	// ȡ�õ�Ԫ���ֵ
	public static String getCellValue(HSSFCell cell) {
		String cellValue = null;
		if (cell != null) { // һ��Ҫ�пգ������յ�cell�����쳣
			switch (cell.getCellType()) {
			case 0:
				cellValue = String.valueOf((int) cell.getNumericCellValue());
				break;
			case 1:
				cellValue = cell.getStringCellValue();
				break;
			case 2:
				cellValue = String.valueOf(cell.getDateCellValue());
				break;
			case 3:
				cellValue = "";
				break;
			case 4:
				cellValue = String.valueOf(cell.getBooleanCellValue());
				break;
			case 5:
				cellValue = String.valueOf(cell.getErrorCellValue());
				break;
			}
		}
		return cellValue;
	}
}
