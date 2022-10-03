package com.qa.automationprac.pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.automationpractice.utils.EleUtil;

public class ProdInfoPage {

	private WebDriver driver;
	private EleUtil eleUtil;
	private Map<String, String> prodInfoMap;
	public ProdInfoPage(WebDriver driver) {
		this.driver=driver;
		eleUtil = new EleUtil(driver);
	}
	private By prodHeader = By.xpath("//div[@class='pb-center-column col-xs-12 col-sm-4']/h1");
	private By prodPrice = By.xpath("(//div[@class='box-info-product']/div)[1]");
	private By addToCart = By.xpath("//div[@class='box-cart-bottom']//span");
	private By prodMetData = By.xpath("(//section[@class='page-product-box'])[1]//tbody/tr/td");
	private By checkOut = By.xpath("//div[@class='clearfix']//div[@class='button-container']//a");
	
	public String getTitle() {
		return eleUtil.getTitle();
	}
	public String header() {
		return eleUtil.getText(prodHeader);
	}
	public String price() {
		return eleUtil.getText(prodPrice);
	}
	public void prodAddToCart() {
		eleUtil.doClick(addToCart);
	}
	
	public List<String> getProdMetaData() {
		List<WebElement> prodData = eleUtil.getElements(prodMetData);
		List<String> prodText = new ArrayList<String>();
		for(WebElement e : prodData) {
			String text = e.getText();
			System.out.println(text);
			prodText.add(text);
		}
		return prodText;
	}
	public void checkOut() {
//		Alert alert = driver.switchTo().alert();
//		alert.accept();
		eleUtil.doClick(checkOut);
	}
	
}
