package com.practice.testcases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.practice.base.TestBase;
import com.practice.utilities.ExcelReader;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

@Listeners(com.practice.listeners.ListenerTest.class)
public class AddCustomerLoginTest extends TestBase {

	
	@BeforeClass
	public void clickAddCustomers() {
		
	//	driver.findElement(By.xpath(or.getProperty("BankManagerLoginBtn"))).click();
		driver.findElement(By.xpath(or.getProperty("AddCustomerBtn"))).click();
	}

	@Test(dataProvider = "AddCustomers")
	public void addCustomers(String frstNm, String LstNM, String pstCde) throws InterruptedException, AWTException {

		driver.findElement(By.xpath(or.getProperty("FirstNmTxtBx"))).sendKeys(frstNm);
		driver.findElement(By.xpath(or.getProperty("LastNmTxtBx"))).sendKeys(LstNM);
		driver.findElement(By.xpath(or.getProperty("PostCdTxtBx"))).sendKeys(pstCde);
		driver.findElement(By.xpath(or.getProperty("AddCustSubBtn"))).click();
		test.log(LogStatus.PASS, "Object Clicked"+"AddCustSubBtn");

		Thread.sleep(3000);

		// Auto IT script need to be added , to Click ok for the Window based popup
		// Added this script in Robot class, Auto IT not able to find

	//	Robot robot = new Robot();
	//	robot.keyPress(KeyEvent.VK_ENTER);
		
		Alert alert = null;
		WebDriverWait wait = new WebDriverWait(driver,5);
	alert =	wait.until(ExpectedConditions.alertIsPresent());
	String alertText=alert.getText();
	System.out.println("text is:"+alertText);
	if(alertText.contains("Customer")) {
		test.log(LogStatus.PASS, "test case is passed");
		latestTest.log(LogStatus.PASS, "test case is passed");
	}
		alert.accept();
	
	}

	@DataProvider(name = "AddCustomers")
	public Object[][] addCustomerDetails() throws IOException {

		int rowCount = excel.getRowNumber("Sheet1");
		int colCount = excel.getColNumber("Sheet1");

		Object[][] data = new Object[rowCount][colCount];

		System.out.println(rowCount);
		System.out.println(colCount);
		for (int row = 1; row <= rowCount; row++) {
			for (int col = 0; col < colCount; col++) {
				data[row - 1][col] = excel.getCellData("Sheet1", row, col);
				System.out.println(data[row - 1][col]);
			}

		}

		return data;

	}

}
