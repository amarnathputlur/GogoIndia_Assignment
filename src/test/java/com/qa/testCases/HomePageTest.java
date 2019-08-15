package com.qa.testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.qa.pageObjects.HomePage;
import com.qa.pageObjects.TestBase;

import junit.framework.Assert;

public class HomePageTest extends TestBase {

	@Test
	public void HomePageTest() throws InterruptedException  {

		driver.get(baseURL);
		logger.info("URL opened");

		HomePage home = new HomePage(driver);

		logger.info("clicking on searchDropdownBox ");
		home.clickOnsearchDropdownBox();
		Thread.sleep(2000);

		home.enterSearchTextData(inputdata);		
		logger.info("Enter search input data");

		home.clickOnSearchButton();		
		logger.info("clicking on search Button");

		home.clickOnFirstRecord();
		logger.info("clicking on first record");
		

		home.titleOfBook();
		logger.info("Title of the book ");


		home.priceOfPaperbackEdition();
		logger.info("Title of the book ");

		home.priceOfKindleEdition();
		logger.info("Title of the book ");

		home.nameofAuthor();
		logger.info("name of the author ");





	}



}
