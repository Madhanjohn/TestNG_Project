package com.stepdefinition;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
//import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;
//import org.apache.poi.util.CommonsLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.testng.log4testng.Logger;

import com.excel.ExcelUtility;
import com.runner.TestRunner1;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import log4jExamples.BasicConfigure;
import pageobjectmodel.HomePage;

public class StepDefinition {
	
	//public static WebDriver driver = TestRunner1.driver;
	public static HomePage hm= new HomePage(TestRunner1.driver);
	ExcelUtility excell = new ExcelUtility("C:\\Users\\PC\\Desktop\\Madhan Course\\Esclipe\\SampleCucumber1\\User_Details.xlsx");
	static Logger logger = Logger.getLogger(StepDefinition.class);
	
	@Given("^Print welcome msg in console$")
	public void print_welcome_msg_in_console() throws Throwable {
		System.out.println("Welcome to ecommerce website");
	}
		
	@When("^User Enter urlname in address bar \"([^\"]*)\"$")
	public void user_Enter_urlname_in_address_bar(String urlname) throws Throwable {
	//	PropertyConfigurator.configure("log4j.properties");
		logger.info("Logger files");
		 TestRunner1.driver.get(urlname);
		 logger.info(urlname);
		// driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
		 hm.getSignIn().click();
		 Thread.sleep(2000);
	}
	
	@When("^User Enter username and password$")
	public void user_Enter_username_and_password() throws Throwable {
		logger.info("username entered");
		List<Map<String, String>> exdata = excell.getTestDataInMap();
	   hm.getUsername().sendKeys(exdata.get(0).get("Email"));
	   hm.getContinuee().click();
	   hm.getPassword().sendKeys(exdata.get(0).get("Password"));
	   Thread.sleep(2000);
	   
	   	}

	@Then("^User Enter Flipcart homepage$")
	public void user_Enter_Flipcart_homepage() throws Throwable {
		logger.info("password entered");
	  hm.getSubmit().click();
	  
	}
	
	@When("^User enter urlname in address bar \"([^\"]*)\"$")
	public void user_enter_urlname_in_address_bar(String urlName) throws Throwable {
		WebDriver driver =TestRunner1.driver;
	    driver.get(urlName);
	    logger.info(urlName);
	    driver.manage().window().maximize();
	    Thread.sleep(3000);
	    
	}

	@Then("^User enter the product in search option$")
	public void user_enter_the_product_in_search_option() throws Throwable {
		logger.debug("debug");
		   logger.warn("warn");
		   logger.error("error");
		   logger.fatal("fatal");
	   // driver.findElement(By.id("search_box")).sendKeys("Boys Dress");
	//	driver.findElement(By.cssSelector("input.input-text L14_9e")).sendKeys("boys dress");
	    		
	}
	
	



}
