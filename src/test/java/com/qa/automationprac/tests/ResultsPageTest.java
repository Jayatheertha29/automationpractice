package com.qa.automationprac.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.automationpractice.utils.Constants;

public class ResultsPageTest extends BaseTest{

	
	@BeforeClass
	public void resultsPageSetup() {
		loginPage.login(prop.getProperty("un"), prop.getProperty("pwd"));
		myAccountPage.enterValueAndSearch("dress");
	}
	@Test(priority=1)
	public void prodCountListTest() {
		int count = resultsPage.prodCountList();
		System.out.println(count);
		Assert.assertEquals(count, 7);
	}
	@Test(priority=2)
	public void ProdClickTest() {
		prodInfoPage = resultsPage.prodClick("Blouse");
		Assert.assertEquals(prodInfoPage.getTitle(), Constants.PROD_INFO_PAGE);
	}
	
	
}
