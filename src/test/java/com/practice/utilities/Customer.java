package com.practice.utilities;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.practice.base.TestBase;
import com.relevantcodes.extentreports.LogStatus;

public class Customer extends TestBase {

	public static void CustomerCheck(ArrayList<String> inputList) throws InterruptedException {

		// String customerName = temp.getProperty("Dynamic CustomerFirstName");
		click("CustomerBtn");
		Thread.sleep(2000);
		String customerFirName = inputList.get(0);
		driver.findElement(By.xpath(or.getProperty("SearchCustBtn"))).sendKeys(customerFirName);
		Assert.assertTrue(isElementPresent(By.xpath("//td[text()='" + customerFirName + "']")),
				"Element is not visible right now");
      
	//	ArrayList<String> lst = new ArrayList<String>();
		//lst.add(customerFirName);
	
		
	List<WebElement> wb =  driver.findElements(By.xpath("//td[text()='"+customerFirName+"']/parent::tr/td"));
		ArrayList<String> webList = new ArrayList<String>();
		
		for(WebElement w :wb){
			
			webList.add(w.getText());
		}
		
		
		for(String ar: webList) {
			System.out.println("The WebElement text are:"+ ar);
		}
		
		for(int i=0,j=0;i<webList.size()-1 & j<inputList.size();i++,j++) {
			String str = webList.get(i);
			String str1 = inputList.get(j);
			if(str.equalsIgnoreCase(str1)) {
				Assert.assertTrue(true);
			}
			else {
				Assert.assertTrue(false);
			}
			System.out.println("After The WebElement text are:"+str);
			System.out.println("After The WebElement text are:"+str1);
		}
	}
}
