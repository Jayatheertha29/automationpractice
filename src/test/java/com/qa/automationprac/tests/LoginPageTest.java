package com.qa.automationprac.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.automationpractice.utils.Constants;

public class LoginPageTest extends BaseTest {
	
	@Test(priority=1)
	public void titleTest() {
		String title = loginPage.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
	}
	@Test(priority=2)
	public void urlTest() {
		String url = loginPage.getUrl();
		System.out.println(url);
		Assert.assertEquals(url, Constants.LOGIN_PAGE_URL);
	}
	@Test(priority=3)
	public void regEmailTest() {
		boolean flag = loginPage.regEmailExist();
		System.out.println(flag);
		Assert.assertTrue(flag);
	}
	@Test(priority=4)
	public void logoTest() {
		boolean flag = loginPage.logoExist();
		System.out.println(flag);
		Assert.assertTrue(flag);
	}
	@Test(priority=5)
	public void contactUsTest() {
		boolean flag = loginPage.contactUsExist();
		System.out.println(flag);
		Assert.assertTrue(flag);
	}
	@Test(priority=6)
	public void loginTest() {
		myAccountPage = loginPage.login(prop.getProperty("un"), prop.getProperty("pwd"));
		String title = myAccountPage.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, Constants.MY_ACCOUNT_PAGE_TITLE);
	}
	
	

}
