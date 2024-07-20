package com.vtiger.common;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageActions 
{
	private WebDriver driver;
	WebDriverWait wait;
	
	public PageActions(WebDriver driver) {
		this.driver=driver;
		wait = new WebDriverWait(driver,Duration.ofSeconds(20));
	}
	
	public void setText(WebElement ele, String val)
	{
		try
		{
			wait.until(ExpectedConditions.visibilityOf(ele));
			ele.clear();
			ele.sendKeys(val);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void setText(By ele, String val)
	{
		try
		{
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(ele)));
			driver.findElement(ele).clear();
			driver.findElement(ele).sendKeys(val);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void setText(String ele, String val)
	{
		try
		{
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(ele))));
			driver.findElement(By.xpath(ele)).clear();
			driver.findElement(By.xpath(ele)).sendKeys(val);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void click_element(WebElement ele)
	{
		try
		{
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			ele.click();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void element_Exist(WebElement ele)
	{
		try
		{
			wait.until(ExpectedConditions.visibilityOf(ele));
			ele.isDisplayed();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void selectText(WebElement ele, String val)
	{
		try
		{
			wait.until(ExpectedConditions.visibilityOf(ele));
			Select se = new Select(ele);
			se.deselectByVisibleText(val);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
