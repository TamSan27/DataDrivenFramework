package com.practice.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.practice.base.TestBase;
import com.practice.utilities.ExcelReader;

public class AddCustomerLoginTest extends TestBase {

	
	  @Test(dataProvider="AddCustomers") public void addCustomers(String frstNm,String LstNM,String pstCde) {
	  
		  driver.findElement(By.xpath(or.getProperty("BankManagerLoginBtn"))).click();
		  driver.findElement(By.xpath(or.getProperty("AddCustomerBtn"))).click();;
	      driver.findElement(By.xpath(or.getProperty("FirstNmTxtBx"))).sendKeys(frstNm);
	      driver.findElement(By.xpath(or.getProperty("LastNmTxtBx"))).sendKeys(LstNM);
	      driver.findElement(By.xpath(or.getProperty("PostCdTxtBx"))).sendKeys(pstCde);
	      driver.findElement(By.xpath(or.getProperty("AddCustSubBtn"))).click();;
	  }
	  
	 @DataProvider(name="AddCustomers") public Object[][] addCustomerDetails() throws IOException {
		
	  int rows = excel.getRowNumber("Sheet1");
	  int cols = excel.getColNumber("Sheet1");
	  
	  Object[][] data = new Object[rows][cols];
	  
	  System.out.println(rows);
      System.out.println(cols);	  
	  for(int row=1;row<=rows;row++) {
		  for(int col=0;col<cols;col++) {
		  data[row-1][col] =  excel.getCellData("Sheet1", row, col); 
		System.out.println(data[row-1][col]);  
	  } 
	  
	  }
	  
	  return data;
	  
	 
	 }
	 

	/*
	 * public static void main(String[] args) throws IOException { String path =
	 * "C:\\Users\\gowthaman\\git\\DataDrivenFramework\\src\\test\\resources\\testdata\\TestData.xlsx";
	 * ExcelReader excel = new ExcelReader(path);
	 * 
	 * int rows = excel.getRowNumber("Sheet1"); int cols =
	 * excel.getColNumber("Sheet1"); String cellValue = excel.getCellData("Sheet1",
	 * 1, 0);
	 * 
	 * 
	 * }
	 */
}
