package com.practice.utilities;
import java.io.File;  
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;  
import org.apache.poi.ss.usermodel.Cell;  
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;  
import org.apache.poi.xssf.usermodel.XSSFWorkbook;  

public class ExcelReader {
	
	File file;
	FileInputStream fis ;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFRow row;
	Cell cell;
	String path = "C:\\Users\\gowthaman\\git\\DataDrivenFramework\\src\\test\\resources\\testdata\\TestData.xlsx";
	
	
	public ExcelReader() throws IOException{
			file = new File(path);   
		 fis = new FileInputStream(file); 
		 wb = new XSSFWorkbook(fis);			
	}
	   
	//XSSFSheet sheet = wb.getSheetAt(0); 
		
	public int getRowNumber(String sheetName) {
		 sheet = wb.getSheet(sheetName);
		int rows = sheet.getLastRowNum();
		return rows;
			}
		
	public int getColNumber(String sheetName) {
		 sheet = wb.getSheet(sheetName);
		 row = sheet.getRow(0);
		int cols = row.getLastCellNum();
		return cols;
	}
	
	public String getCellData(String sheetName,int rowNo,int colNo) {
		 sheet = wb.getSheet(sheetName);
		 row = sheet.getRow(rowNo);
		 cell = row.getCell(colNo);
		 String cellValue = cell.getStringCellValue();
		return cellValue;
		
		
	}
	
	}





