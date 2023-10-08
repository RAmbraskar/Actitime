package com.actitime.genericlibrary;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.actitime.pom.LoginPage;

public class Baseclass {
	Filelibrary f =new Filelibrary();
	public static WebDriver driver;
	
	@BeforeSuite
	public void Databaseconnection() {
		Reporter.log("Database Connection",true);
	} 
	
	@BeforeClass
	public void LaunchBrowser() throws IOException {
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String URL = f.readDatafrompropertyfile("url");
		driver.get("URL");	
		Reporter.log("browser launched",true);
	}
	
	@BeforeMethod
	public void Login() throws IOException {
		LoginPage lp=new LoginPage(driver);
		String un = f.readDatafrompropertyfile("username");
		String pw = f.readDatafrompropertyfile("password");
		lp.getUntbx().sendKeys(un);
		lp.getPwtbx().sendKeys(pw);
		lp.getLgbtn().click();
		Reporter.log("Logged in successfully",true);
	}
	
	@AfterMethod
	public void logout() {
		driver.findElement(By.id("logoutLink")).click();
		Reporter.log("logged in successfully",true);	
	}
	
	@AfterClass
	public void closebrowser() {
		driver.close();
		Reporter.log("browser closed",true);
	}
	
	@AfterSuite
	public void Databasedisconnected () {
		Reporter.log("Database Disconnected",true);
	}
	
	
}
