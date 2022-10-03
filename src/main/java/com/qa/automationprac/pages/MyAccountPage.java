package com.qa.automationprac.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.automationpractice.utils.EleUtil;

public class MyAccountPage {

	private WebDriver driver;
	private EleUtil eleUtil;
	
	public MyAccountPage(WebDriver driver) {
		this.driver=driver;
		eleUtil = new EleUtil(driver);
	}
	private By name = By.xpath("//div[@class='header_user_info']/a/span");
	private By myAccount = By.xpath("//div[@id='center_column']//div[@class='row addresses-lists']/div/ul/li/a/i");
	private By searchBox = By.xpath("//input[@id='search_query_top']");
	private By searchBtn = By.xpath("//button[@name='submit_search']");
	
	public String getTitle() {
		return eleUtil.getTitle();
	}
	public String getUrl() {
		return eleUtil.getUrl();
	}
	public boolean nameExist() {
		return eleUtil.isDisplayed(name);
	}
	public List<String> myAccount() {
		List<WebElement> myAccountList = eleUtil.getElements(myAccount);
		List<String> myList = new ArrayList<String>();
		for(WebElement e : myAccountList) {
			String text = e.getText();
			myList.add(text);
		}
		return myList;
	}
	public ResultsPage enterValueAndSearch(String prod) {
		eleUtil.doSendKeys(searchBox, prod);
		eleUtil.doClick(searchBtn);
		return new ResultsPage(driver);
	}
	
	
	
	
	
	
	
	
	
}
