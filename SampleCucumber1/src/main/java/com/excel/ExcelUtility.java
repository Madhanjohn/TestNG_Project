package com.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	public FileInputStream fi;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	String path=null;
	
	public ExcelUtility(String path) {
		this.path=path;
	}
	
	public int getRowCount(String sheetName) throws IOException  {
		fi= new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetName);
		int rowCount=sheet.getLastRowNum();
		workbook.close();
		fi.close();
		return rowCount;
	}
	
	public int getCellCount(String sheetName,int rownum) throws IOException  {
		fi= new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetName);
		row=sheet.getRow(rownum);
		int cellCount=row.getLastCellNum();
		workbook.close();
		fi.close();
		return cellCount;
		
	}
	
	public String getCellData(String sheetName, int rownum,int colnum) throws IOException  {
		fi= new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetName);
		row=sheet.getRow(rownum);
		cell=row.getCell(colnum);
		DataFormatter format= new DataFormatter();
		String data;
		data=format.formatCellValue(cell);
		workbook.close();
		fi.close();
		return data;
	}
	
	public List<Map<String,String>> getTestDataInMap() throws IOException {
		
		fi = new FileInputStream(path);
		Workbook wb = new XSSFWorkbook(fi);
		Sheet sheet = wb.getSheetAt(0);
		int lastRowNumber = sheet.getLastRowNum();
		System.out.println("RowNumber"+lastRowNumber);
		int lastColNumber = sheet.getRow(0).getLastCellNum();
		System.out.println("ColNumber"+lastColNumber );
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < lastColNumber ; i++) {
		
			Row row = sheet.getRow(0);
			Cell cell = row.getCell(i);
			String rowHeader = cell.getStringCellValue().trim();
			list.add(rowHeader);
			
		}
		System.out.println(list);
		List<Map<String, String>> testDataAllRows= new ArrayList<Map<String,String>>();
		//Map<String, String> testData=null;
		
		for (int j = 1; j <= lastRowNumber; j++) {
			Row row = sheet.getRow(j);
			Map<String, String> testData = new TreeMap<String, String>(String.CASE_INSENSITIVE_ORDER);
			for (int k = 0; k < lastColNumber; k++) {
				Cell cell = row.getCell(k);
				String colValue = cell.getStringCellValue().trim();
				testData.put((String) list.get(k), colValue);
				}
			testDataAllRows.add(testData);	
		}
		
		System.out.println(testDataAllRows);
		
		return testDataAllRows;
	}
	

}
