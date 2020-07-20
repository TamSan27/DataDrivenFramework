package com.practice.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.practice.base.TestBase;
import com.relevantcodes.extentreports.LogStatus;

public class Login extends TestBase {

	@Test
	public void login() {
		click("BankManagerLoginBtn");
		try {
			Assert.assertTrue(isElementPresent(By.xpath(or.getProperty("HomeBtn"))),
					"Element is not visible right now");
			test.log(LogStatus.PASS, "test case is passed");
			latestTest.log(LogStatus.PASS, "test case is passed");
		} catch (Exception e) {
			latestTest.log(LogStatus.FAIL, "Test case failed");
		}
	}
}
