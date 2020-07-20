package com.practice.utilities;

import java.io.File;  
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;  
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
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
	int rows;
	int cols;
	String cellValue;
	String Sheetname="Sheet1";
	//String path = "C:\\Users\\gowthaman\\git\\DataDrivenFramework\\src\\test\\resources\\testdata\\TestData.xlsx";
	
	
	public ExcelReader(String path) throws IOException{
			file = new File(path);   
		 fis = new FileInputStream(file); 
		 wb = new XSSFWorkbook(fis);			
	}
	   
		
	public int getRowNumber(String sheetName) {
		 sheet = wb.getSheet(sheetName);
		 rows = sheet.getLastRowNum();
		return rows;
			}
		
	public int getColNumber(String sheetName) {
		 sheet = wb.getSheet(sheetName);
		 row = sheet.getRow(0);
		 cols = row.getLastCellNum();
		return cols;
	}
	public String getCellData(String sheetName,int rowNo,int colNo) {
		 sheet = wb.getSheet(sheetName);
		 row = sheet.getRow(rowNo);
		 cell = row.getCell(colNo);
		
		 if(cell.getCellType() == CellType.NUMERIC) {
			     cellValue = NumberToTextConverter.toText(cell.getNumericCellValue());
			}
		 else {
			  cellValue = cell.getStringCellValue();
		 }
		 
		 System.out.println(cellValue);
		
		return cellValue;
			
	}
	
	public String getCurrencyData(String firstName) {
		sheet=wb.getSheet(Sheetname);
		for(int i=0;i<getRowNumber("Sheet1");i++) {
			row=sheet.getRow(i);
			cell = row.getCell(0);
			cellValue=cell.getStringCellValue();
			if(cellValue.equalsIgnoreCase(firstName))
			{
				cell=row.getCell(3);
				cellValue =cell.getStringCellValue();
			}
			
			//System.out.println();
			
		}
			
	//	row=sheet.getRow(rownum)
		
		return cellValue;
		
		
	}
	

}





