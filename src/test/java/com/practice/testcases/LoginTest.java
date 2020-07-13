package com.practice.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.practice.base.TestBase;

public class LoginTest extends TestBase {

	@Test
	public void login()
	{
		driver.findElement(By.xpath(or.getProperty("BankManagerLoginBtn"))).click();
		
		Assert.assertTrue(isElementPresent(By.xpath(or.getProperty("HomeBtn"))),"Element is not visible right now");
	}
}
