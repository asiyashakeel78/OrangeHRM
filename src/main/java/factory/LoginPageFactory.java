package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory {
	private WebDriver driver;
	

	@FindBy(xpath = "//input[@name='username']")
	WebElement usernameField;
	
	@FindBy(xpath = "//input[@name='password']")
	WebElement passwordField;
	
	@FindBy(xpath = "//*[@type='submit']")
	WebElement submitField;
	
	
	//constructor
	
	public LoginPageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//page actions
	
	public void enterUsername(String UN) {
		usernameField.sendKeys(UN);
	}

	
	public void enterPassword(String PW) {
		passwordField.sendKeys(PW);
	}
	
	public void clickSubmitButton() {
		submitField.click();
	}
	
	public String getCurrentURL() {
		return driver.getCurrentUrl();
	}
}
