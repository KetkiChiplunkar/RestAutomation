package pagesAction;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import pagesLocator.LoginLocator;
import utilities.SeleniumDriver;

public class LoginAction {

	public LoginLocator loginLocator = null;

	public LoginAction() {
		this.loginLocator = new LoginLocator();
		PageFactory.initElements(SeleniumDriver.getDriver(), loginLocator);
	}

	public void clickSignInLink() {
		loginLocator.HelloSignIn.click();
	}

	public void clickSignIn() {
		loginLocator.signIn.click();
	}

	public void enterEmail(String emailAddress) {
		loginLocator.enterEmailAddress.sendKeys(emailAddress);
	}

	public void enterPassword(String password) {
		loginLocator.enterPassword.sendKeys(password);
	}

	public void clickContinue() {
		loginLocator.clickContinue.click();
	}

	public void clickSignInButton() {
		loginLocator.clickSubmit.click();
	}

	public String getLoggedInUser() {

		return loginLocator.getLoggedInUser.getText();
	}

	public void selectSearchCategory(String selectCategory) {

		loginLocator.selectSearchIn.click();
		Select select = new Select(loginLocator.selectSearchIn);
		select.selectByVisibleText(selectCategory);

	}

	public void enterSearchText(String searchTerm) {
		loginLocator.enterSearchTerm.sendKeys(searchTerm);
	}

	public void clickOnSearch() {

		loginLocator.clickSearchGlass.click();
	}

	public String getSearchText() {
		return loginLocator.getSearchResult.getText();
	}

	public void SignOut() {
		loginLocator.signOut.click();
	}

	public void yourOrder() {
		Actions action = new Actions(SeleniumDriver.getDriver());
		action.moveToElement(loginLocator.yourOrderLink).click().perform();

	}

}
