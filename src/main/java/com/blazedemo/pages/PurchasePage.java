package com.blazedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PurchasePage {

	private WebDriver driver;

	public PurchasePage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	// Purchase Page Verification

	@FindBy(tagName = "h2")
	private WebElement flightHeader;

	@FindBy(xpath = "//p[contains(.,'Price')]")
	private WebElement totalCost;

	// Passenger Details

	@FindBy(id = "inputName")
	private WebElement inputName;

	@FindBy(id = "address")
	private WebElement address;

	@FindBy(id = "city")
	private WebElement city;

	@FindBy(id = "state")
	private WebElement state;

	@FindBy(id = "zipCode")
	private WebElement zipCode;

	// Payment Details

	@FindBy(id = "creditCardNumber")
	private WebElement creditCardNumber;

	@FindBy(id = "creditCardMonth")
	private WebElement creditCardMonth;

	@FindBy(id = "creditCardYear")
	private WebElement creditCardYear;

	@FindBy(id = "nameOnCard")
	private WebElement nameOnCard;

	// Purchase Button

	@FindBy(css = "input[value='Purchase Flight']")
	private WebElement purchaseFlightButton;

	public boolean verifyFlightDetails() {

		return flightHeader.isDisplayed() && totalCost.isDisplayed() && purchaseFlightButton.isDisplayed();
	}

	public void enterPassengerDetails(String name, String addressValue, String cityValue, String stateValue,
			String zipValue) {

		inputName.sendKeys(name);
		address.sendKeys(addressValue);
		city.sendKeys(cityValue);
		state.sendKeys(stateValue);
		zipCode.sendKeys(zipValue);
	}

	public void enterPaymentDetails(String cardNumber, String month, String year, String cardHolderName) {

		creditCardNumber.clear();
		creditCardNumber.sendKeys(cardNumber);

		creditCardMonth.clear();
		creditCardMonth.sendKeys(month);

		creditCardYear.clear();
		creditCardYear.sendKeys(year);

		nameOnCard.sendKeys(cardHolderName);
	}

	public void completeBooking(String name, String addressValue, String cityValue, String stateValue, String zipValue,
			String cardNumber, String month, String year, String cardHolderName) {

		enterPassengerDetails(name, addressValue, cityValue, stateValue, zipValue);

		enterPaymentDetails(cardNumber, month, year, cardHolderName);
	}

	public void clickPurchaseFlight() {

		purchaseFlightButton.click();
	}
}