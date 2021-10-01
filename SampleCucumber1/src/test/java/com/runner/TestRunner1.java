package com.runner;



import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.stepdefinition.StepDefinition;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)  
@CucumberOptions(features = "src\\test\\java\\com\\feature",glue= {"com.stepdefinition","hooks"},
				plugin = {"com.cucumber.listener.ExtentCucumberFormatter:Report/ExtentReport.html"})
public class TestRunner1 {
	
	
	public static WebDriver driver;
	static Logger logger = Logger.getLogger(TestRunner1.class);
	
	@BeforeClass
	public static void set_Up() {
		PropertyConfigurator.configure("log4j.properties");
		logger.info("Launch Browser");
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\PC\\Desktop\\Madhan Course\\Esclipe\\SampleCucumber1\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		
	}
	
	@AfterClass
	public static void tear_Down() {
		logger.info("close Browser");
		driver.close();
	}
	

}
