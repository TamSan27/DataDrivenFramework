package com.practice.testcases;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.practice.base.TestBase;
import com.relevantcodes.extentreports.LogStatus;

public class CustomerLogin extends TestBase {

	@BeforeClass
	public void clickCustomerLOgin() {
		click("CustomerLoginBtn");

	}

	@Test
	public void customerLoginPage() throws InterruptedException {

		// we can check the defaulted value, by using getFirstSelectedOption() or
		// /option[@selected] by using selected attribute in xpath
		Select se = new Select(driver.findElement(By.xpath("//option[text()='---Your Name---']//parent::select")));
		WebElement wb = se.getFirstSelectedOption();
		String text = wb.getText();
		System.out.println(text);

		click("CusSelectionBtn");
		String customerName = temp.getProperty("DynamicCustomerName");
		driver.findElement(By.xpath("//option[text()='" + customerName + "']")).click();

		click("LoginBtn");

		Thread.sleep(3000);
		Assert.assertTrue(isElementPresent(By.xpath(or.getProperty("WelcomeLogo"))), "Element is not visible");

		String customerNameWelPage = driver.findElement(By.xpath(or.getProperty("CusName"))).getText();
		if (customerNameWelPage.equalsIgnoreCase(customerName)) {
			Assert.assertTrue(true);
			test.log(LogStatus.PASS, "Customer name verified");
			latestTest.log(LogStatus.PASS, "Customer name verified");
		} else {
			Assert.assertTrue(false);
			test.log(LogStatus.FAIL, "Customer name not verified");
			latestTest.log(LogStatus.FAIL, "Customer name not verified");
		}

		String customerAccountNumber = driver.findElement(By.xpath(or.getProperty("AccountNumber"))).getText();
		if (customerAccountNumber.equalsIgnoreCase(temp.getProperty("DynamicAccountNo"))) {
			Assert.assertTrue(true);
			test.log(LogStatus.PASS, "Account number verified from Drop down");
			latestTest.log(LogStatus.PASS, "Account number verified from Drop down");
		}
		else {
			Assert.assertTrue(false);
			test.log(LogStatus.FAIL, "Account number is not verified from Drop down");
			latestTest.log(LogStatus.FAIL, "Account number is not verified from Drop down");
		}
		List<WebElement> webEl = driver.findElements(By.xpath(
				"//strong[text()=' Welcome ']/parent::div/following-sibling::div[text()='Account Number : ']/strong"));
		ArrayList<String> arList = new ArrayList<String>();

		for (WebElement wbL : webEl) {
			arList.add(wbL.getText());
		}
		String accountNo = temp.getProperty("DynamicAccountNo");
		
				Assert.assertEquals(arList.get(0), temp.getProperty("DynamicAccountNo"));
				test.log(LogStatus.PASS, "account no verified");
				latestTest.log(LogStatus.PASS, "account no verified");
				Assert.assertEquals(arList.get(1), "0");
				test.log(LogStatus.PASS, "balance is verified");
				latestTest.log(LogStatus.PASS, "balance is verified");
				Assert.assertEquals(arList.get(2), temp.getProperty("DynamicCurrValue"));
				test.log(LogStatus.PASS, "Currency is verified");
				latestTest.log(LogStatus.PASS, "Currency is verified");
			}
		
		/*
		 * if(arList.get(0).equalsIgnoreCase(temp.getProperty("DynamicAccountNo"))) {
		 * Assert.assertTrue(true); test.log(LogStatus.PASS, "account no verified");
		 * latestTest.log(LogStatus.PASS, "account noverified"); } else {
		 * Assert.assertTrue(false); test.log(LogStatus.FAIL,
		 * "account no is not expected"); latestTest.log(LogStatus.FAIL,
		 * "account no not verified"); } if(arList.get(1).equalsIgnoreCase("0")) {
		 * Assert.assertTrue(true); test.log(LogStatus.PASS, "balance is verified");
		 * latestTest.log(LogStatus.PASS, "balance is verified"); } else {
		 * Assert.assertTrue(false); test.log(LogStatus.FAIL,
		 * "balance is not expected"); latestTest.log(LogStatus.FAIL,
		 * "balance not verified"); }
		 */

		/*
		 * String accountNoWelPage =
		 * driver.findElement(By.xpath(or.getProperty("CusName"))).getText();
		 * if(customerNameWelPage.equalsIgnoreCase(accountNo)) {
		 * Assert.assertTrue(true); test.log(LogStatus.PASS, "account no verified");
		 * latestTest.log(LogStatus.PASS, "account noverified"); }else {
		 * Assert.assertTrue(false); test.log(LogStatus.FAIL,
		 * "account no is not expected"); latestTest.log(LogStatus.FAIL,
		 * "account no not verified"); }
		 */
	

}
