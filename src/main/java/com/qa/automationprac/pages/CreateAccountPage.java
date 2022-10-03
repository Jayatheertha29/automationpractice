package com.qa.automationprac.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.automationpractice.utils.EleUtil;

public class CreateAccountPage {

	private WebDriver driver;
	private EleUtil eleUtil;
	public CreateAccountPage(WebDriver driver) {
		this.driver=driver;
		eleUtil = new EleUtil(driver);
	}
	private By titleMr = By.xpath("(//div[@class='clearfix']//div[@class='radio-inline']//div)[1]");
	private By titleMrs = By.xpath("(//div[@class='clearfix']//div[@class='radio-inline']//div)[2]");
	private By firstName = By.id("customer_firstname");
	private By lastName = By.id("customer_lastname");
	private By email = By.id("email");
	private By pwd = By.id("passwd");
	private By days = By.xpath("//select[@id='days']//option");
	private By month = By.xpath("//select[@id='months']//option");
	private By year = By.xpath("//select[@id='years']//option");
	private By newsLetter = By.id("newsletter");
	private By offers = By.id("optin");
	private By fn = By.id("firstname");
	private By ln = By.id("lastname");
	private By address = By.id("address1");
	private By city = By.id("city");
	private By state = By.xpath("//select[@id='id_state']//option");
	private By pincode = By.xpath("//input[@name='postcode']");
	private By country = By.xpath("(//select[@id='id_country']//option)");
	private By phone = By.id("phone_mobile");
	private By futAdd = By.id("alias");
	private By register = By.xpath("//button[@id='submitAccount']/span");
	
	public void doRegister(String gender, String firstName, String lastName, String pwd, String days, String month, String year, String fn, String ln,
			 String address, String city, String state, String pincode, String country, String phone, String futAdd) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		if(gender.equals("mr")) {
			eleUtil.doClick(titleMr);
		}
		else {
			eleUtil.doClick(titleMrs);
		}
		eleUtil.doSendKeys(this.firstName, firstName);
		eleUtil.doSendKeys(this.lastName, lastName);
	//	eleUtil.doSendKeys(this.email, email);
		eleUtil.doSendKeys(this.pwd, pwd);
		eleUtil.selectDropDownFromList(this.days, days);
		eleUtil.selectDropDownFromList(this.month, month);
		eleUtil.selectDropDownFromList(this.year, year);
		eleUtil.doClick(newsLetter);
		eleUtil.doClick(offers);
		eleUtil.doSendKeys(this.fn, fn);
		eleUtil.doSendKeys(this.ln, ln);
		eleUtil.doSendKeys(this.address, address);
		eleUtil.doSendKeys(this.city, city);
		eleUtil.selectDropDownFromList(this.state, state);
		eleUtil.doSendKeys(this.pincode, pincode);
		eleUtil.selectDropDownFromList(this.country, country);
		eleUtil.doSendKeys(this.phone, phone);
		eleUtil.doSendKeys(this.futAdd, futAdd);
		eleUtil.doClick(register);
	}
	
	
}
