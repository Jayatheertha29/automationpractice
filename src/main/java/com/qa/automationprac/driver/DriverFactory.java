package com.qa.automationprac.driver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public WebDriver driver;
	public Properties prop;
	public OptionsManager optionsManager;
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
	public WebDriver init_Driver(Properties prop) {
		String browsername = prop.getProperty("browser");
		System.out.println("browser name is : " + browsername);
		optionsManager=new OptionsManager(prop);
		if(browsername.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(optionsManager.getChromeOptions());
		//	tlDriver.set(new ChromeDriver(optionsManager.getChromeOptions()));
		}
		else if (browsername.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(optionsManager.getFirefoxOptions());
		//	tlDriver.set(new FirefoxDriver(optionsManager.getFirefoxOptions()));
		}
		else {
			System.out.println("plz pass the right browser");
		}
//	getDriver().manage().window().maximize();
//	getDriver().manage().deleteAllCookies();
//	getDriver().get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		return driver;
	}
//	public static synchronized WebDriver getDriver() {
//		return tlDriver.get();
//	}
	public Properties init_prop() {
		prop = new Properties();
		FileInputStream ip = null;
		String envName = System.getProperty("env");
		if(envName == null) {
			System.out.println("running on prod environment ...");
			try {
				ip = new FileInputStream("./src/test/resources/config/Config.properties");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		else {
			System.out.println("running on specific environment : " + envName);
			try {
			switch (envName) {
			case "qa":
				ip = new FileInputStream("./src/test/resources/config/Config.properties");
				break;
			case "dev":
				ip = new FileInputStream("./src/test/resources/config/Config.properties");
				break;
			case "stage":
				ip = new FileInputStream("./src/test/resources/config/Config.properties");
				break;
			case "uat":
				ip = new FileInputStream("./src/test/resources/config/Config.properties");
				break;	

			default:
				System.out.println("plz pass the right env name");
				break;
			}
			}
			catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			try {
				prop.load(ip);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return prop;
	}
	public String getScreenShot() {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"/screenshots/"+System.currentTimeMillis()+".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}
	
	
	
	
	
}
