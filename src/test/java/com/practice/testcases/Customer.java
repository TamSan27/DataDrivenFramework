package com.practice.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.practice.base.TestBase;
import com.relevantcodes.extentreports.LogStatus;

public class Customer extends TestBase{
	
@Test
public static void CustomerCheck() throws InterruptedException {
	
	   String customerName = temp.getProperty("Dynamic CustomerFirstName");
	driver.findElement(By.xpath(or.getProperty("CustomerBtn"))).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath(or.getProperty("SearchCustBtn"))).sendKeys(customerName);
	
	Assert.assertTrue(isElementPresent(By.xpath("//td[text()='"+customerName+"']")),"Element is not visible right now");
	
	
	
	
	test.log(LogStatus.PASS, "test case is passed");
	latestTest.log(LogStatus.PASS, "test case is passed");

}}
