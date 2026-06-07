package com.blazedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlightSelectionPage {

	private WebDriver driver;

	public FlightSelectionPage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	@FindBy(tagName = "table")
	private WebElement flightsTable;

	@FindBy(xpath = "(//input[@value='Choose This Flight'])[1]")
	private WebElement chooseFlightButton;

	public boolean areFlightsDisplayed() {

		return flightsTable.isDisplayed();
	}

	public void chooseFirstFlight() {

		chooseFlightButton.click();
	}
}