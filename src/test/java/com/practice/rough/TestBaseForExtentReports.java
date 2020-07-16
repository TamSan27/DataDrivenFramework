package com.practice.rough;
import static com.practice.base.TestBase.report;
import static com.practice.base.TestBase.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.practice.utilities.ExcelReader;

public class TestBaseForExtentReports {

	

		public static WebDriver driver;
		public static Properties config = new Properties();
		public static Properties or = new Properties();
		public static FileInputStream fis,fip;
		public static ExcelReader excel;
		public static ExtentSparkReporter sparkReporter;
		public static ExtentReports latestReport;
		public static ExtentTest latestTest;
		
		
	@BeforeSuite
	public void setUp() throws IOException {
		
		fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Config.properties");	
		config.load(fis);
		
		fip = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\OR.properties");	
		or.load(fip);
		
		excel = new ExcelReader("C:\\Users\\gowthaman\\git\\DataDrivenFramework\\src\\test\\resources\\testdata\\TestDataNew.xlsx");
	   
		sparkReporter = new ExtentSparkReporter("C:\\Users\\gowthaman\\git\\DataDrivenFramework\\test-output\\ExtentReports4\\LatestReports\\LastRun.html");
		sparkReporter.config().setDocumentTitle("Appium Automation");
		sparkReporter.config().setReportName("Automation Execution Report");
		sparkReporter.config().setTheme(com.aventstack.extentreports.reporter.configuration.Theme.DARK);
		latestReport = new ExtentReports();
		latestReport.attachReporter(sparkReporter);
		latestReport.setSystemInfo("Application Name", "ExtentReport");
	//	latestReport.setSystemInfo("Platform", System.getProperty(“os.name”));
		latestReport.setSystemInfo("Environment", "QA");
	    latestTest = latestReport.createTest("Test Sample with version 4");
		
		if(driver==null) {
			if(config.getProperty("browser").equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\chromedriver.exe");
			driver = new ChromeDriver();
			}
			
			driver.get(config.getProperty("testsiteurl"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("waitingperiod")), TimeUnit.SECONDS);
		}
		
	}

	public boolean isElementPresent(By by) {
		try
		{
			driver.findElement(by);
			return true;
		}catch(NoSuchElementException e) {
		return false;
		}
		
		
	}

	@AfterSuite
	public void tearDown() {
		
		if(driver!=null) {
			driver.quit();
		}
		
		//latestReport.endTest(latestTest);
		
		latestReport.flush();
			
	}

	}

// to get the version 4 Extent reports , refer this - https://journeyofquality.com/category/custom-extent-reports-in-selenium-testng/
