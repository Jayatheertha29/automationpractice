package com.qa.automationprac.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.automationpractice.utils.EleUtil;

public class ResultsPage {

	private WebDriver driver;
	private EleUtil eleUtil;
	public ResultsPage(WebDriver driver) {
		this.driver=driver;
		eleUtil = new EleUtil(driver);
	}
	private By prodList = By.xpath("//div[@id='center_column']//ul[@class='product_list grid row']/li");
	private By prodName = By.xpath("//div[@id='center_column']//ul[@class='product_list grid row']/li//div[@class='right-block']/h5[@itemprop='name']/a");
	
	public int prodCountList() {
		 int count = eleUtil.getElements(prodList).size();
		 System.out.println(count);
		 return count;
	}
	public ProdInfoPage prodClick(String productName) {
		List<WebElement> prodList = eleUtil.getElements(prodName);
		for(WebElement e : prodList) {
			String text = e.getText();
			System.out.println(text);
			if(text.equals(productName)) {
				e.click();
				break;
			}
		}
		return new ProdInfoPage(driver);
	}
	
	
	
	
	
}
