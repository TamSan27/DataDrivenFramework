package com.practice.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.practice.base.TestBase;
import com.relevantcodes.extentreports.LogStatus;

public class CustomerLogin extends TestBase{

	@BeforeClass
	public void clickCustomerLOgin() {
		click("CustomerLoginBtn");
		
	}
	
	@Test
	public void customerLoginPage() throws InterruptedException {
		
		//we can check the defaulted value, by using getFirstSelectedOption() or /option[@selected] by using selected attribute in xpath
		Select se = new Select(driver.findElement(By.xpath("//option[text()='---Your Name---']//parent::select")));
		WebElement wb = se.getFirstSelectedOption();
		String text = wb.getText();
		System.out.println(text);
		
		click("CusSelectionBtn");
		String customerName = temp.getProperty("Dynamic CustomerName");
		driver.findElement(By.xpath("//option[text()='"+customerName+"']")).click();
		
		click("LoginBtn");
		
		Thread.sleep(3000);
		Assert.assertTrue(isElementPresent(By.xpath(or.getProperty("WelcomeLogo"))), "Element is not visible");
	   
		String customerNameWelPage = driver.findElement(By.xpath(or.getProperty("CusName"))).getText();
	    if(customerNameWelPage.equalsIgnoreCase(customerName)) {
	    	test.log(LogStatus.PASS, "Customer name verified");
	    	latestTest.log(LogStatus.PASS, "Customer name verified");
	    }else {
	    	test.log(LogStatus.FAIL, "Customer name not verified");
	    	latestTest.log(LogStatus.FAIL, "Customer name not verified");
	    }
	
	  String accountNo = temp.getProperty("accountNo");
	    String accountNoWelPage = driver.findElement(By.xpath(or.getProperty("CusName"))).getText();
	    if(customerNameWelPage.equalsIgnoreCase(accountNo)) {
	    	test.log(LogStatus.PASS, "account no verified");
	    	latestTest.log(LogStatus.PASS, "account noverified");
	    }else {
	    	test.log(LogStatus.FAIL, "account no is not expected");
	    	latestTest.log(LogStatus.FAIL, "account no not verified");
	    }
	}
	
}
