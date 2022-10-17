package com.crm.Generic_utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class excel_utility {
	/**
	 * this method used to get data from the excel sheet
	 * @param sheetname
	 * @param Rownum
	 * @param cellnum
	 * @return
	 * @throws Throwable
	 * @prashanth
	 */
public String getdatafromexcel(String sheetname,int Rownum,int cellnum ) throws Throwable
{
	FileInputStream fis1=new FileInputStream("./Book.xlsx");
	Workbook book=WorkbookFactory.create(fis1);
	Sheet sheet = book.getSheet(sheetname);
	Row row = sheet.getRow(Rownum);
	Cell cell = row.getCell(cellnum);
	String data = cell.getStringCellValue();
	return data;
	
}
}
