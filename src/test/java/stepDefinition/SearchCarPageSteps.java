package stepDefinition;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import pagesAction.homePageSearchAction;
import pagesAction.usedCarSearchAction;
import utilities.SeleniumDriver;


public class SearchCarPageSteps {
	
	homePageSearchAction homePageSearchAction = new homePageSearchAction();
	usedCarSearchAction carSearch = new usedCarSearchAction();
	//selectCarMake
	//SeleniumDriver selenium;
	//WebDriver driver;

	@Before
	public void set(){
		SeleniumDriver.setDriver();
	}
	
@Given("^User navigates to the Car24 HomePage$")
public void navigateToURL(){
	
	SeleniumDriver.openPage("https://www.cars24.com/");
	
	}

@When("^the user enters its Search criteria$")
public void enterSearchCritria()throws Exception{
	carSearch.viewUsedCars() ;
	//homePageSearchAction.selectCarMake("abc@abc.com", "07312345634");
	
}
@Then("^the user gets the search result for the given search criteria$")
public void userSearchResult(){
	//selenium.tearDown();
	
}
}
