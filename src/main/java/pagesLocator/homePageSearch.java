package pagesLocator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class homePageSearch {
	@FindBy(xpath="//span[contains(text(),'Brand')]")
	public WebElement brandDropDown;
	@FindBy(xpath="//span[contains(text(),'Model')]")
	public WebElement modelDropDown;
	@FindBy(xpath="//span[contains(text(),'Year')]")
	public WebElement yearDropDown;
	@FindBy(xpath="//span[contains(text(),'Variant')]")
	public WebElement variantDropDown;
	@FindBy(xpath="//span[contains(text(),'Car Reg. State')]")
	public WebElement carRegisterState;
	@FindBy(xpath="//span[contains(text(),'Km Driven')]")
	public WebElement kmDriven;
	@FindBy(xpath="//input[@id='lead-email']")
	public WebElement emailAddress;
	@FindBy(xpath="//input[@type='tel']")
	public WebElement mobileNumber;
	@FindBy(xpath="//span[contains(text(),'GET PRICE')]")
	public WebElement getPriceButton;
    @FindBy(xpath="//li[contains(text(),'Maruti Suzuki')]")
	public WebElement selectBrand;
    @FindBy(xpath="//li[contains(text(),'A Star')]")
	public WebElement selectModal;
    @FindBy(xpath="//li[contains(text(),'2015')]")
	public WebElement selectYear;
    @FindBy(xpath="//li[contains(text(),'LXI')]")
	public WebElement selectVariants;
    @FindBy(xpath="//li[contains(text(),'HR - Haryana')]")
	public WebElement regState;
    @FindBy(xpath="//li[contains(text(),'Up to 10000 km')]")
	public WebElement kmDrivenalready;

}
