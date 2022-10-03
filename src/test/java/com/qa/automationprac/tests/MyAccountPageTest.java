package com.qa.automationprac.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.automationpractice.utils.Constants;

public class MyAccountPageTest extends BaseTest{

	@BeforeClass
	public void doLogin() {
		myAccountPage = loginPage.login(prop.getProperty("un"), prop.getProperty("pwd"));
	}
	@Test(priority=1)
	public void titleTest() {
		String title = myAccountPage.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, Constants.MY_ACCOUNT_PAGE_TITLE);
	}
	@Test(priority=2)
	public void urlTest() {
		String url = myAccountPage.getUrl();
		System.out.println(url);
		Assert.assertEquals(url, Constants.MY_ACCOUNT_PAGE_URL);
	}
	@Test(priority=3)
	public void nameTest() {
		boolean flag = myAccountPage.nameExist();
		System.out.println(flag);
		Assert.assertTrue(flag);
	}
	@Test(priority=4)
	public void myAccountTest() {
		List<String> list = myAccountPage.myAccount();
		System.out.println(list);
		Assert.assertEquals(list, Constants.myAccountText());
	}
	@DataProvider
	public Object[][] productData() {
		return new Object[][] {
			{"dress"},
			//{"night dress"},
		//	{"shorts"},
		};
	}
	@Test(priority=5, dataProvider = "productData")
	public void searchTest(String productname) {
		resultsPage = myAccountPage.enterValueAndSearch(productname);
		Assert.assertTrue(resultsPage.prodCountList()>0);
	}
	
	
	
}
