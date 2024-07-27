package stepDefinition;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import basePage.BasePage;
import factory.LoginPageFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.ScreenshotUtility;

public class TestSteps {
	public WebDriver driver;
	private LoginPageFactory loginPage;
	
	@Given("user is on the login page")
	public void user_is_on_the_login_page() throws InterruptedException {
		driver = BasePage.getDriver("chrome");
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	    loginPage = new LoginPageFactory(driver);
	    driver.manage().window().maximize();
	    Thread.sleep(3000);
	    
	}

	@When("user enters valid user name and password")
	public void user_enters_valid_user_name_and_password() throws InterruptedException {
		loginPage.enterUsername("Admin");
		loginPage.enterPassword("admin123");
		 Thread.sleep(3000);
	    
	}

	@When("user clicks on the login button")
	public void user_clicks_on_the_login_button() throws InterruptedException {
		loginPage.clickSubmitButton();
		 Thread.sleep(3000);
	    
	}

	@Then("user is navigated to the dashboard")
	public void user_is_navigated_to_the_dashboard() {
		
	        String expectedUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
	        String actualUrl = loginPage.getCurrentURL();
	        try {
	            Assert.assertEquals(actualUrl, expectedUrl, "User is not on the expected login page URL.");
	        } catch (AssertionError e) {
	            ScreenshotUtility.takeScreenshot(driver, "screenshots/failure-screenshot.png");
	            throw e;  // Rethrow to allow Cucumber to handle the failure
	        } finally {
	            driver.quit();
	        }  
	    
	}


}
