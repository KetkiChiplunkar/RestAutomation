package pagesLocator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class carSearchPage {
	@FindBy(xpath = "//a[@class='buy-used-car-link']")
	public WebElement buyUsedCar;
	@FindBy(xpath = "//a[contains(text(),'Become Our Partner')]")
	public WebElement becomePartner;
	@FindBy(how = How.XPATH, xpath = "//span/a[contains(text(),'Branches')]")
	public WebElement branches;
	@FindBy(xpath="//a[contains(text(),'View all used cars here')]")
    public WebElement viewAllUsedCars;
    @FindBy(xpath="//*[contains(text(),'View Used Cars')]")
    public WebElement viewUsedCarButton;
    @FindBy(xpath="//*[contains(text(),'Select Model')]")
    public WebElement selectCarModel;
    @FindBy(xpath="//*[contains(text(),'Select Budget')]")
    public WebElement selectBudget;
   @FindBy(xpath="//ul[@class='nav nav-tabs branchTabs']")
   public WebElement findAllBranches;
   
   

}
