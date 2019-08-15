package com.qa.pageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	WebDriver driver;
	JavascriptExecutor js;

	public HomePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}



	@FindBy(id="searchDropdownBox")
	@CacheLookup
	WebElement btn_searchDropdownBox;

	@FindBy(id="twotabsearchtextbox")
	@CacheLookup
	WebElement txtSearchData;

	@FindBy(xpath="//input[@type='submit']")
	@CacheLookup
	WebElement button_Go;

	@FindBy(xpath=" //span[contains(text(),'Data Structures and Algorithms Made Easy: Data Str')]")
	@CacheLookup
	WebElement first_Record;

	@FindBy(xpath=" //div[@class='sims-fbt-checkbox-label']//span[contains(text(),'Data Structures and Algorithms Made Easy: Data Str')]")
	@CacheLookup
	WebElement book_Title;

	@FindBy(xpath="//span[@class='a-size-base a-color-price a-color-price']")
	@CacheLookup
	WebElement price_PaperbackEdition;

	@FindBy(xpath="//span[@class='a-color-secondary']//span[contains(text(),'0.00')]")
	@CacheLookup
	WebElement price_KindleEdition;

	@FindBy(xpath="//a[@class='a-link-normal contributorNameID']")
	@CacheLookup
	WebElement nameof_Author;





	public void clickOnsearchDropdownBox(){
		Select drpCountry = new Select(driver.findElement(By.id("searchDropdownBox")));
		drpCountry.selectByVisibleText("Books");				
	}

	public void  enterSearchTextData(String data)
	{
		txtSearchData.sendKeys(data);
	}

	public void clickOnSearchButton()
	{
		button_Go.click();
	}	

	public void clickOnFirstRecord() 
	{
		first_Record.click();

	}

	public void titleOfBook()
	{


		book_Title.getText();
	}

	public void priceOfPaperbackEdition()
	{
		price_PaperbackEdition.getText();
	}

	public void priceOfKindleEdition()
	{
		price_KindleEdition.getText();
	}


	public void nameofAuthor()
	{
		nameof_Author.getText();
	}





}