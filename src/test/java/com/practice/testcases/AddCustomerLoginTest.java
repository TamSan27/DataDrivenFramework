package com.practice.testcases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.practice.base.TestBase;
import com.practice.utilities.ExcelReader;

public class AddCustomerLoginTest {
	
	/*
	 * @Test(dataProvider="AddCustomers") public void addCustomers(String
	 * frstNm,String LstNM,String pstCde) {
	 * 
	 * 
	 * }
	 * 
	 * @DataProvider(name="AddCustomers") public Object[][] addCustomerDetails() {
	 * int rows = excel.getRowNumber("AddCustomers"); int cols =
	 * excel.getColNumber("AddCustomers");
	 * 
	 * Object[][] data = new Object[rows-1][cols];
	 * 
	 * for(int row=2;row<=rows;row++) { for(int col=0;col<=cols;col++) { data[][] =
	 * excel.getCellData("AddCustomers", row, col); } }
	 * 
	 * return data;
	 * 
	 * 
	 * }
	 */
	
	public static void main(String[] args) throws IOException {
		
		ExcelReader excel = new ExcelReader();
		
		int rows = excel.getRowNumber("AddCustomers");
		 int cols = excel.getColNumber("AddCustomers");
		 String cellValue = excel.getCellData("AddCustomers", 2, 0);
				 
		
	}
}
