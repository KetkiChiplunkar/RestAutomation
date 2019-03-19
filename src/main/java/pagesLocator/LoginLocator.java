package pagesLocator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginLocator {
	
	@FindBy(how=How.XPATH, xpath="//span[contains(text(),'Hello. Sign in')]")
	public WebElement HelloSignIn;
	
	@FindBy(how=How.XPATH, xpath="//span[contains(text(),'Sign in')]")
	public WebElement signIn;
	
	@FindBy(how=How.XPATH, xpath="//input[@type='email']")
	public WebElement enterEmailAddress;
	
	@FindBy(how=How.XPATH, xpath="//input[@id='continue']")
	public WebElement clickContinue;
	
	@FindBy(how=How.XPATH, xpath="//input[@type='password']")
	public WebElement enterPassword;
	
	@FindBy(how=How.XPATH, xpath="//input[@id='signInSubmit']")
	public WebElement clickSubmit;
	
	@FindBy(how=How.XPATH, xpath="//span[@id='nav-your-amazon-text']")
	public WebElement getLoggedInUser;
	
	@FindBy(how=How.XPATH, xpath="//select[@title='Search in']")
	public WebElement selectSearchIn;
	
	@FindBy(how=How.XPATH, xpath="//div[@class='nav-search-field ']/input")
	public WebElement enterSearchTerm;
	
	@FindBy(how=How.XPATH, xpath="//div[@class='nav-search-submit nav-sprite']/input")
	public WebElement clickSearchGlass;
	
	@FindBy(how=How.XPATH, xpath="//span[@id='s-result-count']")
	public WebElement getSearchResult;
	
	@FindBy(how=How.XPATH, xpath="//span[contains(text(),'Sign Out')]")
	public WebElement signOut;
	
	@FindBy (how=How.XPATH, xpath="//span[contains(text(),'Your Orders')]")
	public WebElement yourOrderLink;

}
