package com.practice.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.practice.base.TestBase;
import com.relevantcodes.extentreports.LogStatus;

public class Customer extends TestBase{
	
//@Test
public static void CustomerCheck(String customerFirName) throws InterruptedException {
	
	//   String customerName = temp.getProperty("Dynamic CustomerFirstName");
	//driver.findElement(By.xpath(or.getProperty("CustomerBtn"))).click();
	click("CustomerBtn");
	Thread.sleep(2000);
	driver.findElement(By.xpath(or.getProperty("SearchCustBtn"))).sendKeys(customerFirName);
	if(isElementPresent(By.xpath("//td[text()='"+customerFirName+"']")))
	{
		test.log(LogStatus.PASS, "test case is passed");
		latestTest.log(LogStatus.PASS, "test case is passed");
	}else
	{
		System.out.println("Trest case customer entered");
		test.log(LogStatus.FAIL, "test case is failed");
		latestTest.log(LogStatus.FAIL, "test case is failed");
	}
	Assert.assertTrue(isElementPresent(By.xpath("//td[text()='"+customerFirName+"']")),"Element is not visible right now");
	
	

}}
