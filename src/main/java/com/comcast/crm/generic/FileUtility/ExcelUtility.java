package com.comcast.crm.generic.FileUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	public String getDataFromExcel(String sheetname, int rownum, int celnum) throws Throwable {

		FileInputStream fis = new FileInputStream("./TestData/TestScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetname).getRow(rownum).getCell(celnum).toString();
		wb.close();

		return data;

	}

	public int getRowCount(String sheetname) throws Throwable {
		FileInputStream fis = new FileInputStream("./TestData/TestScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int rowcount = wb.getSheet(sheetname).getLastRowNum();
		wb.close();

		return rowcount;
	}

	public void writeDataBackToExcel(String sheetname, int rownum, int celnum, String data) throws Throwable {
		FileInputStream fis = new FileInputStream("./TestData/TestScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheetname).getRow(rownum).createCell(celnum);

		FileOutputStream fos = new FileOutputStream("./TestData/TestScriptData.xlsx");
		wb.write(fos);
		wb.close();

	}
}