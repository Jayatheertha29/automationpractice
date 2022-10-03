package com.qa.automationprac.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginPageNegativeTest extends BaseTest{

	@DataProvider
	public  Object[][] loginNegativeData() {
		return new Object [][] {
			{"jayatheertha12@gmail.com", "auto@123"},
			{"123456789", "jaya@123"},
			{"@gmail.com", ""},
			{"", ""}
		};
	}
	
	
	
	@Test(dataProvider="loginNegativeData")
	public void loginNegativeTest(String username, String password) {
		//loginPage.loginWithWrongCred(username, password);
		Assert.assertFalse(loginPage.loginWithWrongCred(username, password));
	}
	
	
	
	//%JAVA_HOME%\bin
	
	
	
}
