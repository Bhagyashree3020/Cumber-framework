package com.vtiger.stepdefinations;



import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LeadSteps extends BaseDefination
{
	@When("user click on new lead")
	public void user_click_on_new_lead() {
		 driver.findElement(By.linkText("New Lead")).click();
	}
	@When("fill all mandatory data and click on Save button")
	public void fill_all_mandatory_data_and_click_on_save_button() {
		driver.findElement(By.name("lastname")).sendKeys(dt.get(TCName).get("Last Name"));
		driver.findElement(By.name("company")).sendKeys(dt.get(TCName).get("Company"));
		driver.findElement(By.name("button")).click();
	}
	@Then("lead should create sucessfully.")
	public void lead_should_create_sucessfully() {
		driver.findElement(By.xpath("//td[text()='Last Name:']/following::td[1]")).getText().equals("Bhujbal1");
	}
	@When("user creates multiple lead with {string} and company {string} and verified")
	public void user_creates_multiple_lead_with_and_company_and_verified(String string, String string2, io.cucumber.datatable.DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    List<Map<String,String>> dt = dataTable.asMaps();
	    for(Map <String,String> m:dt)
	    {
	    driver.findElement(By.linkText("New Lead")).click();
	    driver.findElement(By.name("lastname")).sendKeys(m.get("lastname"));
		driver.findElement(By.name("company")).sendKeys(m.get("company"));
		driver.findElement(By.name("button")).click();
		driver.findElement(By.xpath("//td[text()='Last Name:']/following::td[1]")).getText().equals(m.get("lastname"));
	    }
	}
	@When("Click on logout")
	public void click_on_logout() {
	   driver.findElement(By.linkText("Logout")).click();
	}




}
