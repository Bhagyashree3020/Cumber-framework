package com.vtiger.stepdefinations;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.vtiger.pages.LoginPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginStepDefinations extends BaseDefination
{
	@Before
	public void getScenarioName(Scenario scenario) 
	{
		TCName = scenario.getName();
		initiation();
	}
	/*@After
	public void closeBrowser()
	{
		driver.quit();
	}*/
	
	
		
	@Given("user should be on login page")
	public void user_should_be_on_login_page() {
		
		launchApp();
	   lp = new LoginPage(driver);
		
	}
	@When("user enters valid credentials")
	public void user_enters_valid_credentials() {
	    //driver.findElement(By.name("user_name")).sendKeys("admin");
	    //driver.findElement(By.name("user_password")).sendKeys("admin");
	    lp.setUsername(prop.getProperty("userid"));
	    lp.setpassword(prop.getProperty("password"));
	
	}
	@When("click on Login button")
	public void click_on_login_button() {
		//driver.findElement(By.name("Login")).click();
		lp.click();
	}
	@Then("user should be navigated to home page")
	public void user_should_be_navigated_to_home_page() {
		driver.findElement(By.linkText("Home")).isDisplayed();

	}
	@Then("user can click logout link")
	public void user_can_click_logout_link() {
		driver.findElement(By.linkText("Logout")).click();

	}
	@When("user enters invalid credentials")
	public void user_enters_invalid_credentials() {
		driver.findElement(By.name("user_name")).sendKeys("admin12");
	    driver.findElement(By.name("user_password")).sendKeys("admin23");
	}
	@Then("validate error message on login page")
	public void validate_error_message_on_login_page() {
		driver.findElement(By.xpath("//*[contains(text),'You must specify')]")).isDisplayed();
	}
	@When("user enters userid as {string} and password as {string} credentials")
	public void user_enters_userid_as_and_password_as_credentials(String uid, String pwd) {
		driver.findElement(By.name("user_name")).clear();
		driver.findElement(By.name("user_name")).sendKeys(uid);
		driver.findElement(By.name("user_password")).clear();
	    driver.findElement(By.name("user_password")).sendKeys(pwd);
	}

}
