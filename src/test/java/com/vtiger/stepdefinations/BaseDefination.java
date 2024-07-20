package com.vtiger.stepdefinations;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import com.vtiger.pages.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseDefination {
	public static WebDriver driver;
	public  LoginPage lp;
	public Properties prop;
	public static Map<String,Map<String,String>> dt;
	public static String TCName;
	
	public void initiation()
	{
		readproperties();
		dt = readExcelData(System.getProperty("user.dir")+"/src/test/resources/Data/TestData.xlsx","Sheet1");
		System.out.println(dt);
		launchApp();
		
		
	}
	public void launchApp()
	{
		if(prop.getProperty("browser").equals("chrome"))
		{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		}
		else if(prop.getProperty("browser").equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(prop.getProperty("browser").equals("headless"))
		{
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--headless=new");
			driver = new FirefoxDriver();
		}
		else
		{
			{
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			}
		}
		driver.get(prop.getProperty("AppUrl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(prop.getProperty("implicitwait"))));
		
	}
	
	public void readproperties()
	{
		prop = new Properties();
		try
		{
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/Data/testData.xlsx");
			prop.load(fis);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public Map<String,Map<String,String>> readExcelData(String file, String Sheet)
	{
		Map<String,Map<String,String>> dt = new HashMap<>();
		try
		{
			
		Fillo fillo = new Fillo();
		Connection connection=fillo.getConnection(file);
		String strQuery="Select * from "+Sheet;
		Recordset recordset = connection.executeQuery(strQuery);
		int rowcount = recordset.getCount();
		System.out.print("Rowcount = "+rowcount);
		List<String> lst = recordset.getFieldNames();
		int clmncount = lst.size();
		 
		while(recordset.next())
		{
			
			Map<String,String> rowdata = new HashMap<>();
			for(int i =0;i<clmncount;i++)
			{
				rowdata.put(lst.get(i), recordset.getField(lst.get(i)));
			}
			dt.put(recordset.getField("TCNAme"), rowdata);
		}
		recordset.close();
		connection.close();
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		 
		return dt;
	}
}
