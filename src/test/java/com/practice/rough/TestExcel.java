package com.practice.rough;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;


public class TestExcel {

public static void main(String[] args) throws IOException {
File file = new File("C:\\Users\\gowthaman\\git\\DataDrivenFramework\\src\\test\\resources\\testdata\\TestDataNew.xlsx");
FileInputStream fis = new FileInputStream(file);
XSSFWorkbook wb = new XSSFWorkbook(fis);
XSSFSheet sheet = wb.getSheet("Sheet1");
int rowCount = sheet.getLastRowNum();

System.out.println("row count is:"+rowCount);
XSSFRow  row;
Cell cell;
 row = sheet.getRow(0);
 cell = row.getCell(0);
String zeroth = cell.getStringCellValue();
System.out.println("zeroth"+zeroth);

row = sheet.getRow(1);
cell = row.getCell(0);
String first= cell.getStringCellValue();
System.out.println("first"+first);


	//sheet=wb.getSheet(Sheetname);
	String cellValue = null,cuuValue = null;
	for(int i=1;i<rowCount;i++) {
		row=sheet.getRow(i);
		cell = row.getCell(0);
		cellValue=cell.getStringCellValue();
		if(cellValue.equalsIgnoreCase("Tam")) {
			System.out.println("inside");
			cell=row.getCell(3);
			cellValue=cell.getStringCellValue();
			cuuValue=cell.getStringCellValue();
			//System.out.println(cuuValue);
		}
		
		
	}
	System.out.println(cuuValue);
	System.out.println(cellValue);
		
//	row=sheet.getRow(rownum)
	
	
	
	
}

	

}

