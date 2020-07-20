package com.practice.testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.practice.base.TestBase;
import com.relevantcodes.extentreports.LogStatus;

public class OpenAccount extends TestBase{
	//@Test
	public static void openAccountForUser(String customerName,String CurrValue) throws InterruptedException {
		
		//System.out.println(temp.getProperty("Dynamic CustomerName")+"Value of the customer is");
	//String customerName = temp.getProperty("Dynamic CustomerName");
	//String cusFirstName =temp.getProperty("Dynamic CustomerFirstName");
	
//	driver.findElement(By.xpath(or.getProperty("OpenAccountBtn"))).click();
	click("OpenAccountBtn");
		Thread.sleep(2000);
	WebDriverWait wait = new WebDriverWait(driver,10);
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(or.getProperty("CusNameSlctBtn"))));
	
	//driver.findElement(By.xpath(or.getProperty("CusNameSlctBtn"))).click();
	click("CusNameSlctBtn");
	driver.findElement(By.xpath("//select/option[text()='"+customerName+"']")).click();
	
	//String currencyValue = excel.getCurrencyData(cusFirstName);
	
//	driver.findElement(By.xpath(or.getProperty("CurrencySlctBtn"))).click();
	click("CurrencySlctBtn");
	
	//driver.findElement(By.xpath("//select/option[text()='"+currencyValue+"']")).click();
	driver.findElement(By.xpath("//select/option[text()='"+CurrValue+"']")).click();
	//driver.findElement(By.xpath(or.getProperty("ProcessBtn"))).click();
	click("ProcessBtn");
	
	Alert alert = null;
	WebDriverWait wait1 = new WebDriverWait(driver,5);
alert =	wait1.until(ExpectedConditions.alertIsPresent());
String alertText=alert.getText();
System.out.println("text is:"+alertText);
if(alertText.contains("Account")) {
	test.log(LogStatus.PASS, "test case is passed");
	latestTest.log(LogStatus.PASS, "test case is passed");
}
	alert.accept();
	
	
	}
}
