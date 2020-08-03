package com.practice.rough;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class TestExcelWithList {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		File file = new File("C:\\Users\\gowthaman\\Desktop\\New.xlsx");
		File outputFile = new File("C:\\Users\\gowthaman\\Desktop\\New Output.xlsx");
		FileOutputStream fos = new FileOutputStream(outputFile);
		XSSFWorkbook wbO =  new XSSFWorkbook();
		XSSFSheet sheetO = wbO.createSheet("Tam");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Sheet1");
		int rowCount = sheet.getLastRowNum();
		
		/*
		 * Iterator<Row> itr = sheet.iterator(); List<String> data = new
		 * ArrayList<String>();
		 * 
		 * while(itr.hasNext()) { Row row = itr.next(); Iterator<Cell> itc =
		 * row.cellIterator();
		 * 
		 * while(itc.hasNext()) { Cell cell = itc.next();
		 * data.add(cell.getStringCellValue()); }
		 * 
		 * 
		 * 
		 * }
		 */
		List<String> data = new ArrayList<String>();
		for(int i=1;i<=rowCount;i++) {
		Row row = sheet.getRow(i);
		int colCount = row.getLastCellNum();
		for(int j=0;j<colCount;j++) {
		Cell cell = row.getCell(j);
		data.add(cell.getStringCellValue());
		System.out.println("Col Count is :"+colCount);
		}
		}
		for(String str:data) {
			System.out.println("The value is:"+str);
		}
		System.out.println(rowCount);
		
		
		 LinkedHashMap<Integer, List<String>> hashMap = new LinkedHashMap<Integer, List<String>>();
		 
		 
		 for(int i=0;i<=rowCount;i++) {
				Row row = sheet.getRow(i);
				int colCount = row.getLastCellNum();
				List dataL = new LinkedList();
				for(int j=0;j<colCount;j++) {
				Cell cell = row.getCell(j);
			
				if(cell.getCellType()== CellType.STRING) {
					String value = cell.getStringCellValue();
					if(j==2) {
						 value = value.substring(0, value.length()-1);
					}
				dataL.add(value);
				}
				/*
				 * else { String st1 = NumberToTextConverter.toText(cell.getNumericCellValue());
				 * //double st = cell.getNumericCellValue(); String number = st1.substring(0,
				 * st1.length()-2); System.out.println("Converted number i:"+number);
				 * dataL.add(number); }
				 */
					
				System.out.println("Col Count is :"+colCount);
				}
				hashMap.put(i, dataL);
				System.out.println("Row is going to iterate");
		
	}
		 
		 for (Map.Entry<Integer, List<String>> ent : hashMap.entrySet()) {
				System.out.print(ent.getKey() + "-->" + ent.getValue());
				System.out.println();
			}
		
		 int i=0;
		 for(Map.Entry<Integer, List<String>> ent : hashMap.entrySet()) {
			 List<String> dataNew = new LinkedList<String>();
			 Row row = sheetO.createRow(i); 
			 dataNew = ent.getValue();
			 int j=0;
			 for(String st:dataNew) {
				
				 Cell cell = row.createCell(j);
				 cell.setCellValue(st);
			//	 sheetO.createRow(0).createCell(j).setCellValue(st); //this won't work
				 System.out.println("Print the value from Map "+i+j+":"+st);
				j++;
			 }
			 i++;
			 }
		 wbO.write(fos);
		 fos.flush();
		 fos.close();
	}
}
