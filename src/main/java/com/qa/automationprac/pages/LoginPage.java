package com.qa.automationprac.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.automationpractice.utils.EleUtil;

public class LoginPage {

	private WebDriver driver;
	private EleUtil eleUtil;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		eleUtil = new EleUtil(driver);
	}
	private By regEmail = By.id("email_create");
	private By logo = By.xpath("//div[@id='header_logo']/a");
	private By contactUs = By.xpath("//div[@id='contact-link']/a");
	private By loginEmail = By.xpath("(//div[contains(@class,'form-group')])[2]//input[@id='email']");
	private By loginPwd = By.xpath("//div[@class='form-group']//input[@id='passwd']");
	private By signinBtn = By.xpath("//span/i[@class='icon-lock left']");
	private By loginErrorMsg = By.xpath("(//div[@class='alert alert-danger'])[1]/p");
	public String getTitle() {
		return eleUtil.getTitle();
	}
	public String getUrl() {
		return eleUtil.getUrl();
	}
	public boolean regEmailExist() {
		return eleUtil.isDisplayed(regEmail);
	}
	public boolean logoExist() {
		return eleUtil.isDisplayed(logo);
	}
	public boolean contactUsExist() {
		return eleUtil.isDisplayed(contactUs);
	}
	public MyAccountPage login(String un, String pwd) {
		eleUtil.getElement(loginEmail).sendKeys(un);
		eleUtil.getElement(loginPwd).sendKeys(pwd);
		eleUtil.doClick(signinBtn);
		return new MyAccountPage(driver);
	}
	public boolean loginWithWrongCred(String un, String pwd) {
		System.out.println("login with wrong cred : " + un + " : " + pwd);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		eleUtil.doSendKeys(loginEmail, un);
		eleUtil.doSendKeys(loginPwd, pwd);
		eleUtil.getElement(signinBtn).click();
		String errorMsg = eleUtil.getText(loginErrorMsg);
		System.out.println(errorMsg);
		if(errorMsg.contains("There is 1 error")) {
			System.out.println("login failed ...");
			return false;
		}
		return true;
	}
	
	
	
	
	
}
