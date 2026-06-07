package com.blazedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage {

	private WebDriver driver;

	public HomePage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "fromPort")
	private WebElement departureCityDropdown;

	@FindBy(name = "toPort")
	private WebElement destinationCityDropdown;

	@FindBy(css = "input[type='submit']")
	private WebElement findFlightsButton;

	public void selectDepartureCity(String city) {

		Select select = new Select(departureCityDropdown);

		select.selectByVisibleText(city);
	}

	public void selectDestinationCity(String city) {

		Select select = new Select(destinationCityDropdown);

		select.selectByVisibleText(city);
	}

	public void clickFindFlights() {

		findFlightsButton.click();
	}
}