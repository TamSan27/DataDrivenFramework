package com.practice.utilities;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.practice.base.TestBase;
import com.relevantcodes.extentreports.LogStatus;

public class Customer extends TestBase {

	public static void CustomerCheck(String customerFirName) throws InterruptedException {

		// String customerName = temp.getProperty("Dynamic CustomerFirstName");
		click("CustomerBtn");
		Thread.sleep(2000);
		driver.findElement(By.xpath(or.getProperty("SearchCustBtn"))).sendKeys(customerFirName);
		Assert.assertTrue(isElementPresent(By.xpath("//td[text()='" + customerFirName + "']")),
				"Element is not visible right now");
        
	}
}
