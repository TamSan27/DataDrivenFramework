package com.practice.testcases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.practice.base.TestBase;
import com.practice.utilities.Customer;
import com.practice.utilities.ExcelReader;
import com.practice.utilities.OpenAccount;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

@Listeners(com.practice.listeners.ListenerTest.class) //listers for TestNG listeners
public class AddCustomer extends TestBase {

	@BeforeClass
	public void clickAddCustomers() {
		click("AddCustomerBtn");
	}

	@Test(dataProvider = "AddCustomers")
	public void addCustomers(String frstNm, String LstNM, String pstCde, String currValue)
			throws InterruptedException, AWTException {

		driver.findElement(By.xpath(or.getProperty("FirstNmTxtBx"))).sendKeys(frstNm);
		driver.findElement(By.xpath(or.getProperty("LastNmTxtBx"))).sendKeys(LstNM);
		driver.findElement(By.xpath(or.getProperty("PostCdTxtBx"))).sendKeys(pstCde);
		click("AddCustSubBtn");

		temp.setProperty("DynamicCustomerName", frstNm + " " + LstNM);// storing value in property file in runtime
		String customerName = frstNm + " " + LstNM;
		temp.setProperty("DynamicCustomerFirstName", frstNm);

		Thread.sleep(3000);

		// Auto IT script need to be added , to Click ok for the Window based popup
		// Added this script in Robot class, Auto IT not able to find

		// Robot robot = new Robot();
		// robot.keyPress(KeyEvent.VK_ENTER);

		Alert alert = null;
		WebDriverWait wait = new WebDriverWait(driver, 5);
		alert = wait.until(ExpectedConditions.alertIsPresent());
		String alertText = alert.getText();
		System.out.println("text is:" + alertText.length());
		
		if (alertText.contains("Customer")) {
			alert.accept();
			test.log(LogStatus.PASS, "test case is passed");
			latestTest.log(LogStatus.PASS, "test case is passed");
		}

		OpenAccount.openAccountForUser(customerName, currValue);
		ArrayList<String> inputList = new ArrayList<String>();
		inputList.add(frstNm);
		inputList.add(LstNM);
		inputList.add(pstCde);
		inputList.add(temp.getProperty("DynamicAccountNo"));
				
		Customer.CustomerCheck(inputList);

	}

	@DataProvider(name = "AddCustomers")
	public Object[][] addCustomerDetails() throws IOException {

		int rowCount = excel.getRowNumber("Sheet1");
		int colCount = excel.getColNumber("Sheet1");

		// Object[][] data = new Object[rowCount][colCount]; in the excel it is jsut one
		// row.
		Object[][] data = new Object[1][colCount];
	//	System.out.println(rowCount);
	//	System.out.println(colCount);
		for (int row = 4; row <= rowCount; row++) {
			for (int col = 0; col < colCount; col++) {
				data[row - 4][col] = excel.getCellData("Sheet1", row, col);
			}

		}

		return data;

	}
	
	@AfterClass
	public void clickHome() {
		
		click("HomeBtn");
	}

}
