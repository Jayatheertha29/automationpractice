package com.qa.automationprac.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.automationprac.driver.DriverFactory;
import com.qa.automationprac.pages.CreateAccountPage;
import com.qa.automationprac.pages.LoginPage;
import com.qa.automationprac.pages.MyAccountPage;
import com.qa.automationprac.pages.ProdInfoPage;
import com.qa.automationprac.pages.RegistrationPage;
import com.qa.automationprac.pages.ResultsPage;

public class BaseTest {
    
	DriverFactory df;
	WebDriver driver;
	LoginPage loginPage;
	Properties prop;
	MyAccountPage myAccountPage;
	ResultsPage resultsPage;
	ProdInfoPage prodInfoPage;
	RegistrationPage registrationPage;
	CreateAccountPage createAccountPage;
	@BeforeTest
	public void setup() {
		df = new DriverFactory();
		prop = df.init_prop();
		driver = df.init_Driver(prop);
		loginPage = new LoginPage(driver);
		myAccountPage = new MyAccountPage(driver);
		resultsPage = new ResultsPage(driver);
		prodInfoPage = new ProdInfoPage(driver);
		registrationPage = new RegistrationPage(driver);
		createAccountPage = new CreateAccountPage(driver);
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	
	
	
}
