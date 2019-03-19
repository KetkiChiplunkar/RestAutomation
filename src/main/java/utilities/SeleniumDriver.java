package utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.Before;

public class SeleniumDriver {
	
	/**
	 * This Singleton class pattern in which Constructor is set as private. In order to access the constructor of the 
	 * class we need to call the method name setDriver to get the driver instance.
	 */

	private static SeleniumDriver seleniumDriver;

	static WebDriver driver =null;

	public static int TIMEOUT = 30;
	private static WebDriverWait waitDriver;
 
	/**
	 * This is a private constructor
	 */
	private SeleniumDriver() {
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		waitDriver = new WebDriverWait(driver, TIMEOUT);
		driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);

	}
	
	/**
	 * Method to access the object of the class
	 */

	
	public static void setDriver() {
		if (seleniumDriver == null) {
			seleniumDriver = new SeleniumDriver();
		}

	}

	/**
	 * Once the class is called, the driver is accessible
	 * @param url
	 */
	public  static void openPage(String url) {
//		setDriver();
		driver.get(url);

	}

	public static WebDriver getDriver() {
		return driver;
	}


public void tearDown(){
	
	if(driver!=null){
	driver.close();
	driver.quit();
	}
seleniumDriver=null;
}


}
