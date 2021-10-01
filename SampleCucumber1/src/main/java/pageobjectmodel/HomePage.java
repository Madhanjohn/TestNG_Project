package pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public static WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}	
	
	@FindBy(id = "nav-link-accountList-nav-line-1")
	private WebElement SignIn;
	
	@FindBy(id = "ap_email")
	private WebElement username;
	
	@FindBy(id = "continue")
	private WebElement continuee;
	
	@FindBy(id = "ap_password")
	private WebElement password;
	
	@FindBy(id = "signInSubmit")
	private WebElement submit;
	

	public WebElement getUsername() {
		return username;
	}

	public WebElement getContinuee() {
		return continuee;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getSubmit() {
		return submit;
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public WebElement getSignIn() {
		return SignIn;
	}
	

}
