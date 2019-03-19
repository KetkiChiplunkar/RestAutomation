package pagesAction;

import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import pagesLocator.carSearchPage;
import utilities.SeleniumDriver;

public class usedCarSearchAction {

	carSearchPage carSearchHomePage;

	public usedCarSearchAction() {
		this.carSearchHomePage = new carSearchPage();
		PageFactory.initElements(SeleniumDriver.getDriver(), carSearchHomePage);

	}

	public void searchUsedCars() {
		Select selectModel = new Select(carSearchHomePage.selectCarModel);
		selectModel.selectByIndex(1);
		Select selectBudget = new Select(carSearchHomePage.selectBudget);
		selectBudget.selectByIndex(1);
		carSearchHomePage.viewUsedCarButton.click();
		
	}

	public void viewUsedCars()throws Exception {
		Thread.sleep(2000);
		//Actions action = new Actions(SeleniumDriver.getDriver());
//	action.moveToElement(carSearchHomePage.buyUsedCar).click();
//		action.moveToElement(carSearchHomePage.viewUsedCarButton).click();
//		action.moveToElement(carSearchHomePage.branches).click().build();
		String ref = carSearchHomePage.branches.getAttribute("href");
		System.out.println("href is "+ref);
		
	}

	public void viewAllUsedCars() {
		carSearchHomePage.buyUsedCar.click();
		carSearchHomePage.viewAllUsedCars.click();
	}

}