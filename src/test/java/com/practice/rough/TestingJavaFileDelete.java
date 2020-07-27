package com.practice.rough;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.google.common.io.Files;

public class TestingJavaFileDelete {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		/*
		 * try { Files.deleteIfExists(Paths.get("")); } catch(NoSuchFileException e) {
		 * System.out.println("No such file/directory exists"); }
		 * catch(DirectoryNotEmptyException e) {
		 * System.out.println("Directory is not empty."); } catch(IOException e) {
		 * System.out.println("Invalid permissions."); }
		 * 
		 * System.out.println("Deletion successful."); }
		 */
		
		
		File file = new File("C:\\Users\\gowthaman\\Music\\cola.xls"); 
         
	    	 if( file.delete())
	    	 {
	    	  System.out.println("File deleted successfully"); 
	      }
	    	 else { 
	    	  System.out.println("Failed to delete the file"); 
	        }
	    	 
	    		Map preference = new HashMap();
	    		preference.put("download.default_directory",
	    				"C:\\Users\\gowthaman\\Music");
	    		preference.put("download.prompt_for_download", false);
	    		ChromeOptions opt = new ChromeOptions();
	    		opt.setExperimentalOption("prefs", preference);
	    		System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver.exe");
	    		WebDriver driver = new ChromeDriver(opt);
	    		
	    		driver.get("http://www.principlesofeconometrics.com/excel.htm");
	    		driver.findElement(By.xpath("//a[text()='cola']")).click();
	    		
	    		Thread.sleep(2000);
	    		driver.close();
	}}
	    
		


