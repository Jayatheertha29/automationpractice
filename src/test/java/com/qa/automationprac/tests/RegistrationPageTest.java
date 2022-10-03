package com.qa.automationprac.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RegistrationPageTest extends BaseTest{

	@Test
	public void createAccountTest() {
		registrationPage.createAcccount("jayatheertha1111@gmail.com");
	}
	@Test
	public void registerTest() {
		createAccountPage.doRegister("mr", "jaya", "khasnis", "jayak11", "10", "11", "2000", "jaya", "khasnis", "near reliance superMart", "new york", "New York", "00000", "United States", "9876543219", "near d mart");
	}
	
	
	
	
	
}
