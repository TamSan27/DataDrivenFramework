package com.practice.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.practice.base.TestBase;
import com.relevantcodes.extentreports.LogStatus;

public class LoginTest extends TestBase {

	@Test
	public void login()
	{
		driver.findElement(By.xpath(or.getProperty("BankManagerLoginBtn"))).click();
		
		try {
	Assert.assertTrue(isElementPresent(By.xpath(or.getProperty("HomeBtn"))),"Element is not visible right now");
	
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Test case failed");
		}
		}
}
