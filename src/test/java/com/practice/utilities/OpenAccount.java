package com.practice.utilities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.practice.base.TestBase;
import com.relevantcodes.extentreports.LogStatus;

public class OpenAccount extends TestBase {
	
	public static void openAccountForUser(String customerName, String currValue) throws InterruptedException {

		// String customerName = temp.getProperty("Dynamic CustomerName");Storing value of Property file in runtime & getting from another class

		click("OpenAccountBtn");
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(or.getProperty("CusNameSlctBtn"))));

		click("CusNameSlctBtn");
		driver.findElement(By.xpath("//select/option[text()='" + customerName + "']")).click();

		click("CurrencySlctBtn");
		driver.findElement(By.xpath("//select/option[text()='" + currValue + "']")).click();
		click("ProcessBtn");

		Alert alert = null;
		WebDriverWait wait1 = new WebDriverWait(driver, 5);
		alert = wait1.until(ExpectedConditions.alertIsPresent());
		String alertText = alert.getText();
		System.out.println("text is:" + alertText);
		String accountNo = alertText.substring(alertText.length()-4);
		temp.setProperty("DynamicAccountNo", accountNo);
		temp.setProperty("DynamicCurrValue", currValue);
		System.out.println("account nmber is:"+accountNo);
		if (alertText.contains("Account")) {
			test.log(LogStatus.PASS, "test case is passed");
			latestTest.log(LogStatus.PASS, "test case is passed");
		}
		alert.accept();

	}
}
