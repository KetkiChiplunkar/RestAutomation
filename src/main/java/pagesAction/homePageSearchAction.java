package pagesAction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import pagesLocator.homePageSearch;
import utilities.SeleniumDriver;

public class homePageSearchAction {

public homePageSearch carSearchHomePage =null;
//WebDriver driver ;

public homePageSearchAction(){
	this.carSearchHomePage= new homePageSearch();
	//this.driver = SeleniumDriver.getDriver();
	PageFactory.initElements(SeleniumDriver.getDriver(), carSearchHomePage);
}


public void selectCarMake(String emailAddress, String mobileNumber)throws Exception{
	Thread.sleep(5000);
	carSearchHomePage.brandDropDown.click();
	carSearchHomePage.selectBrand.click();
	carSearchHomePage.modelDropDown.click();
	carSearchHomePage.selectModal.click();
	carSearchHomePage.yearDropDown.click();
	carSearchHomePage.selectYear.click();
	carSearchHomePage.variantDropDown.click();
	carSearchHomePage.selectVariants.click();
	carSearchHomePage.carRegisterState.click();
	carSearchHomePage.kmDriven.click();
	carSearchHomePage.kmDrivenalready.click();
	carSearchHomePage.emailAddress.sendKeys(emailAddress);
	carSearchHomePage.mobileNumber.sendKeys(mobileNumber);
	carSearchHomePage.getPriceButton.click();
}




}