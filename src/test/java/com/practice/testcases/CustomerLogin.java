package com.practice.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.practice.base.TestBase;

public class CustomerLogin extends TestBase{

	@BeforeClass
	public void clickCustomerLOgin() {
		click("CustomerLoginBtn");
		
	}
	
	@Test
	public void customerLoginPage() throws InterruptedException {
		
		click("CusSelectionBtn");
		String customerName = temp.getProperty("Dynamic CustomerName");
		driver.findElement(By.xpath("//option[text()='"+customerName+"']")).click();
		
		click("LoginBtn");
		
		Thread.sleep(3000);
		Assert.assertTrue(isElementPresent(By.xpath(or.getProperty("WelcomeLogo"))), "Element is not visible");
	}
	
}
