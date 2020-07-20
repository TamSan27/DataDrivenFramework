package com.practice.base;

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

import com.practice.utilities.ExcelReader;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestBase {

	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties or = new Properties();
	public static Properties temp = new Properties();
	public static FileInputStream fis, fip, fir;
	public static ExcelReader excel;
	public static ExtentReports report;
	public static ExtentReports latestReport;
	public static ExtentTest test;
	public static ExtentTest latestTest;

	String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

	@BeforeSuite
	public void setUp() throws IOException {

		fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Config.properties");
		config.load(fis);

		fip = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\OR.properties");
		or.load(fip);

		excel = new ExcelReader(
				"C:\\Users\\gowthaman\\git\\DataDrivenFramework\\src\\test\\resources\\testdata\\TestDataNew.xlsx");

		report = new ExtentReports(
				"C:\\Users\\gowthaman\\git\\DataDrivenFramework\\test-output\\ExtentReports\\Reports " + timeStamp
						+ "\\" + timeStamp + ".html");
		latestReport = new ExtentReports(
				"C:\\Users\\gowthaman\\git\\DataDrivenFramework\\test-output\\ExtentReports\\LatestReports\\LastRun.html");
		latestTest = latestReport.startTest("Test");
		test = report.startTest("Test");

		fir = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\temp.properties");
		temp.load(fir);

		if (driver == null) {
			if (config.getProperty("browser").equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver.exe");
				driver = new ChromeDriver();
			}

			driver.get(config.getProperty("testsiteurl"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("waitingperiod")),
					TimeUnit.SECONDS);
		}

	}

	public static boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			latestTest.log(LogStatus.PASS, "Element Found");
			return true;
		} catch (Exception e) {
			latestTest.log(LogStatus.FAIL, "Element not Found");
			return false;
		}
	}
	
	public static void click(String buttonName)
	{
		driver.findElement(By.xpath(or.getProperty(buttonName))).click();
		test.log(LogStatus.PASS, buttonName+" is clicked");
		latestTest.log(LogStatus.PASS, buttonName+" is clicked");
		
	}

	@AfterSuite
	public void tearDown() {

		if (driver != null) {
			driver.quit();
		}

		report.endTest(test);
		report.flush();
		latestReport.endTest(latestTest);
		latestReport.flush();

	}

}
