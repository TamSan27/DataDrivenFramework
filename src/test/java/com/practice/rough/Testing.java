package com.practice.rough;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.practice.base.TestBase;

public class Testing extends TestBase{

	public static void main(String[] args) throws InterruptedException {
		
		try {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver.exe");
		driver = new ChromeDriver();
		
driver.get("https://jqueryui.com");	
driver.manage().window().maximize();
WebElement wb = driver.findElement(By.xpath("//a[text()='Accordion']"));
JavascriptExecutor jse = (JavascriptExecutor) driver;
jse.executeScript("arguments[0].scrollIntoView();", wb);

driver.findElement(By.linkText("Selectmenu")).click();

Thread.sleep(3000);

WebElement frame = driver.findElement(By.xpath("//iframe"));
driver.switchTo().frame(frame);

Select se = new Select(driver.findElement(By.xpath("//label[text()='Select a speed']/following-sibling::select[1]")));
List<WebElement> selectedValue = new ArrayList();
selectedValue= se.getOptions();
for(WebElement we:selectedValue) {
	String selectedV = we.getText();

System.out.println("selected value is:"+selectedV);	


}
String text = driver.findElement(By.xpath("//option[text()='Slower']")).getText();
System.out.println("gtext:"+text);
	

	}
		finally{
			driver.close();
		}
	}
	



}
