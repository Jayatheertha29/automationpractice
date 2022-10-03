package com.qa.automationprac.tests;

import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProdInfoPageTest extends BaseTest{

	@BeforeClass
	public void resultsPageSetup() {
		loginPage.login(prop.getProperty("un"), prop.getProperty("pwd"));
		myAccountPage.enterValueAndSearch("dress");
		resultsPage.prodClick("Blouse");
	}
	
	@Test(priority=1)
	public void headerTest() {
		String prodHeader = prodInfoPage.header();
		System.out.println(prodHeader);
		Assert.assertEquals(prodHeader, "Blouse");
	}
	@Test(priority=2)
	public void priceTest() {
		String price = prodInfoPage.price();
		System.out.println(price);
		Assert.assertEquals(price, "$27.00");
	}
	@Test(priority=3)
	public void prodMetaDataTest() {
		List<String> text = prodInfoPage.getProdMetaData();
		System.out.println(text);
		
	}
	@Test(priority=4)
	public void addToCartTest() {
		prodInfoPage.prodAddToCart();
	}
	@Test(priority=5)
	public void checkOutTest() {
		prodInfoPage.checkOut();
	}
	
	
}
