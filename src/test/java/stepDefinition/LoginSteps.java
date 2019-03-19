package stepDefinition;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import pagesAction.LoginAction;
import utilities.SeleniumDriver;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSteps {

	LoginAction loginAction = new LoginAction();

	@Given("^Navigate to Amazon Account$")
	public void navigate_to_Gmail_Account() throws Throwable {
		SeleniumDriver.openPage("https://www.amazon.in/");
	loginAction.clickSignInLink();
		Thread.sleep(1000);
		// loginAction.clickSignIn();

	}

	@Given("^Enter valid username \"([^\"]*)\"$")
	public void enter_valid_username(String arg1) throws Throwable {
		Thread.sleep(1000);
		loginAction.enterEmail(arg1);
		loginAction.clickContinue();
	}

	@Given("^Enter valid password \"([^\"]*)\"$")
	public void enter_valid_password(String arg1) throws Throwable {
		loginAction.enterPassword(arg1);
		loginAction.clickSignInButton();
	}

	@Then("^user is successfully LoggedIn$")
	public void user_is_successfully_LoggedIn() throws Throwable {
		String logggedUser = loginAction.getLoggedInUser();
		Assert.assertTrue(logggedUser.contains("Ketki"));

	}

	@When("^user selects a Category and search with SearchText$")
	public void user_selects_a_Category_and_search_with_SearchText(
			DataTable data) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
		// E,K,V must be a scalar (String, Integer, Date, enum etc)
		List<Map<String, String>> map = data.asMaps(String.class, String.class);
		loginAction.selectSearchCategory(map.get(1).get("Category"));
		loginAction.enterSearchText(map.get(1).get("SearchText"));

	}

	@When("^the user click on SearchGlass$")
	public void the_user_click_on_SearchGlass() throws Throwable {
		loginAction.clickOnSearch();
	}

	@Then("^the user gets search result$")
	public void the_user_gets_search_result() throws Throwable {
		System.out.println("Searcg Result is as follows "+loginAction.getSearchText());
	}

	@Then("^the user sign out from Amazon$")
	public void user_is_successfully_LoggedOut() throws Throwable {
		Thread.sleep(1000);
		loginAction.yourOrder();
		
		loginAction.SignOut();

	}


}