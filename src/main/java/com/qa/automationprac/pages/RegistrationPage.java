package com.qa.automationprac.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.automationpractice.utils.EleUtil;

public class RegistrationPage {

	private WebDriver driver;
	private EleUtil eleUtil;
	public RegistrationPage(WebDriver driver) {
		this.driver=driver;
		eleUtil = new EleUtil(driver);
	}
	private By emailAdd = By.id("email_create");
	private By createAcc =By.xpath("//button[@id='SubmitCreate']/span");
	
	
	public CreateAccountPage createAcccount(String email) {
		eleUtil.doSendKeys(emailAdd, email);
		eleUtil.doClick(createAcc);
		return new CreateAccountPage(driver);
	}
	
	
	
	
	
	
	
	
}
