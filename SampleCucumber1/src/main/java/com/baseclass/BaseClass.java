package com.baseclass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.bytebuddy.implementation.bytecode.ByteCodeAppender.Size;


public class BaseClass {
	
	public static WebDriver driver;

	public static WebDriver getProperty(String type) {
		if (type.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Driver\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if (type.equalsIgnoreCase("firefox")) {
			
			System.setProperty("webdriver.getko.driver", System.getProperty("user.dir"+"//Driver//chromedriver.exe"));
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		return driver;
	}

	public static void openLink(String url) {
		driver.get(url);
	}
	public static void clickOnElement(WebElement element) {
	//	clickOnElement(element);
		element.click();
	}
	
	public static void inputValues(WebElement element, String s) {
	//	inputValues(element, s);
		element.sendKeys(s);
	}
	
	public static void moveElement(WebElement element) {
		Actions ac = new Actions(driver);
		ac.moveToElement(element).build().perform();
	}
	public static void takesnap(String path) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File(path);
		FileUtils.copyFile(screenshotAs, destination);
	}
	
	public static void pageClose() {
		driver.close();
	}
	
	public static  void browserClose() {
		driver.quit();
	}
	
	public static  void navTo(String url) {
		driver.navigate().to(url);
	}
	
	public static  void navBack() {
		driver.navigate().back();
	}
	public static void refesh() {
		driver.navigate().refresh();
	}
	public static void navForward() {
		driver.navigate().forward();
	}
	
	public static void getTitle() {
		System.out.println(driver.getTitle());
	}
	
	public static void getCurrentUrl() {
		System.out.println(driver.getCurrentUrl());
	}
	
	public static void alertAccept() {
		Alert ale = driver.switchTo().alert();
		ale.accept();
	}
	

	public static void contextClick(WebElement element) {
		Actions ac = new Actions(driver);
		ac.contextClick(element).build().perform();
	}
	
	public static void keyDown() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
	}
	
	public static  void keyEnter() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	
	public static  void isMulti(WebElement element) {
		Select s = new Select(element);
		boolean multi = s.isMultiple();
		System.out.println("Is Multiple :"+multi);
	}
	
	private static void getOption(WebElement element) {
		Select s = new Select(element);
		List<WebElement> options = s.getOptions();
		for (WebElement alloptions : options) {
			String text = alloptions.getText();
			System.out.println(text);
	}
	}
	
	public static void dropdownSize(WebElement element,String sel) {
		Select s = new Select(element);
		List<WebElement> options = s.getOptions();
		int size = options.size();
		System.out.println("Size : "+size);
						
			}
	
	
	public static  void selectText(WebElement element,String opt,String option) {
		Select s = new Select(element);
		if (option=="value") {
			s.selectByValue(opt);
		}else if(option=="text")
		{
		s.selectByVisibleText(opt);
		}else if(option=="index"){
			int parseInt = Integer.parseInt(opt);
			s.selectByIndex(parseInt);
		}
	}
	
	
	public static void allSelectedOption(WebElement element) {
		Select s = new Select(element);
		List<WebElement> allSelectedOptions = s.getAllSelectedOptions();
		
		for (WebElement allselected : allSelectedOptions) {
			String text = allselected.getText();
			System.out.println(text);
		}
	}
	
	
	public static void getFirstSelected(WebElement element) {
		Select s = new Select(element);
		WebElement firstSelectedOption = s.getFirstSelectedOption();
		System.out.println(firstSelectedOption.getText());
	}
	

	public static  void implicitwait(int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
	
	public static void expli(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void framee(WebElement element) {
		driver.switchTo().frame(element);
	}
}