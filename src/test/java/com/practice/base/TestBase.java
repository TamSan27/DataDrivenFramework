package com.practice.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestBase {

	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties or = new Properties();
	public static FileInputStream fis;
	
@Test
public void setUp() throws IOException {
	
	if(driver==null) {
		
		fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Config.properties");	
		
		config.load(fis);
		System.out.println(config.getProperty("browser"));
		
		if(config.getProperty("browser")=="chrome") {
			System.setProperty("webdriver.driver.chrome", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
			driver.get("www.wewerwer");
		}
	}
	
}

@AfterSuite
public void tearDown() {
	
	
}

}
