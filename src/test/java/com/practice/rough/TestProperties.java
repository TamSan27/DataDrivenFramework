package com.practice.rough;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;


public class TestProperties {

	@Test
	public void test() throws IOException {
		// TODO Auto-generated method stub

	Properties config = new Properties();
	
	FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Config.properties");	
	
	config.load(fis);
	System.out.println(config.getProperty("browser"));
	}
	
	

}
