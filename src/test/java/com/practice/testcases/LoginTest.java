package com.practice.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.practice.base.TestBase;
import com.relevantcodes.extentreports.LogStatus;

public class LoginTest extends TestBase {

	@Test
	public void login() {
		click("BankManagerLoginBtn");
		try {
			Assert.assertTrue(isElementPresent(By.xpath(or.getProperty("HomeBtn"))),
					"Element is not visible right now");
			Assert.assertTrue(isElementPresent(By.xpath(or.getProperty("CustomerLoginBtn"))),
					"Element is not visible right now");
			Assert.assertTrue(isElementPresent(By.xpath(or.getProperty("HomeScreenLogo"))),
					"Element is not visible right now");
			String bankName = driver.findElement(By.xpath(or.getProperty("HomeScreenLogo"))).getText();
			if(bankName.equalsIgnoreCase("XYZ Bank")) {
				test.log(LogStatus.PASS, "Name verified");
				latestTest.log(LogStatus.PASS, "Name verified");
			}
			else
			{
				test.log(LogStatus.FAIL, "Name is not matching");
				latestTest.log(LogStatus.FAIL, "Name is not matching");
			}
			test.log(LogStatus.PASS, "test case is passed");
			latestTest.log(LogStatus.PASS, "test case is passed");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "test case is failed");
			latestTest.log(LogStatus.FAIL, "Test case failed");
		}
	}
}
