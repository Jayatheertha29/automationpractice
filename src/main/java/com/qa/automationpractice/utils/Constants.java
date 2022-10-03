package com.qa.automationpractice.utils;

import java.util.ArrayList;
import java.util.List;

public class Constants {

	public static final String LOGIN_PAGE_TITLE = "Login - My Store";
	public static final String LOGIN_PAGE_URL = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
	public static final String MY_ACCOUNT_PAGE_TITLE = "My account - My Store";
	public static final String MY_ACCOUNT_PAGE_URL = "http://automationpractice.com/index.php?controller=my-account";
	public static final String PROD_INFO_PAGE = "Blouse - My Store";
	
	public static List<String> myAccountText() {
		List<String> list = new ArrayList<String>();
		list.add("");
		list.add("");
		list.add("");
		list.add("");
		list.add("");
		return list;
	}
	
}
