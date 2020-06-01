package com.practice.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.practice.base.TestBase;

public class LoginTest extends TestBase {

	@Test
	public void login()
	{
		driver.findElement(By.xpath(or.getProperty("BankManagerLogin"))).click();
		
	}
}
