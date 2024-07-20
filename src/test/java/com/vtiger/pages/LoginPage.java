package com.vtiger.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.common.PageActions;

public class LoginPage extends PageActions
{
	public WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);	
	}
	@FindBy(name = "user_name")
	WebElement tb_uid;
	@FindBy(name = "user_password")
	WebElement tb_pwd;
	@FindBy(name = "Login")
	WebElement btn_login;
	@FindBy(name = "login_theme")
	WebElement dp_theme;
	
	
	/*
	 String uid ="user_name";
	 String pass ="user_password";
	 String login ="Login";
	 */
	/*
	 By uid =By.name("user_name");
	 By pass =By.name("user_password");
	 By login =By.name("Login");
	 */
	
	public boolean verifyTitle(String ExpectedTitle)
	{
		if(driver.getTitle().equals(ExpectedTitle))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public void login(String userid,String pwd,String theme)
	{
		//driver.findElement(By.name("user_name")).sendKeys(userid);
	   // driver.findElement(By.name("user_password")).sendKeys(pwd);
	   // driver.findElement(By.name("Login")).click();
	    setUsername(userid);
	    setpassword(pwd);
	    selectTheme(theme);
	    click();
	}
	public void login(String userid,String pwd)
	{
	    setUsername(userid);
	    setpassword(pwd);
	    click();
	}
	
	public void setUsername(String userid)
	{
		setText(tb_uid,userid);
		
	}
	public void setpassword(String pwd)
	{
		setText(tb_pwd,pwd);
		tb_pwd.sendKeys(pwd);
	}
	public void selectTheme(String theme)
	{
		selectText(dp_theme,theme);
	}
	public void click()
	{
		click_element(btn_login);
	}

}
