package com.qa.automationpractice.utils;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EleUtil {
    private WebDriver driver;
	
    public EleUtil(WebDriver driver) {
    	this.driver=driver;
    }
	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	public String getText(By locator) {
		return getElement(locator).getText();
	}
	public void doClear(By locator) {
		driver.findElement(locator).clear();
	}
	public void doSendKeys(By locator, String value) {
		doClear(locator);
		getElement(locator).sendKeys(value);
	}
	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	public void doClick(By locator) {
		driver.findElement(locator).click();
	}
	public String getTitle() {
		return driver.getTitle();
	}
	public String getUrl() {
		return driver.getCurrentUrl();
	}
	public boolean isDisplayed(By loactor) {
		return driver.findElement(loactor).isDisplayed();
	}
	public void getAttributes(By locator, String value) {
		List<WebElement> linksList = getElements(locator);
		for(WebElement e : linksList) {
			String links = e.getAttribute(value);
			System.out.println(links);
	}
	}
	public  void getLinksText(By locator) {
		List<WebElement> linksList = getElements(locator);
		System.out.println(linksList.size());
		List<String> stext = new ArrayList<String>();
		for(WebElement e : linksList) {
			String text = e.getText();
			stext.add(text);
			if(!text.isEmpty()) {
				System.out.println(text);
			}
	}	
		for(int i=0; i<=linksList.size(); i++) {
			String text1 = linksList.get(i).getText();
			if(!text1.isEmpty()) {
				System.out.println(text1);
			}
		}
	}
	public void selectDropDownFromList(By locator, String value) {
		List<WebElement> eleList = getElements(locator);
		for(WebElement e : eleList) {
			String text = e.getText();
			System.out.println(text);
			if(text.equals(value)) {
				e.click();
				break;
			}
			
		}
	}
	
	
	
	
	
	
	
	
}
