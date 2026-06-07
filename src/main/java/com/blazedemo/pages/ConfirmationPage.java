package com.blazedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage {

	private WebDriver driver;

	public ConfirmationPage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	@FindBy(tagName = "h1")
	private WebElement confirmationMessage;

	@FindBy(xpath = "//td[text()='Id']/following-sibling::td")
	private WebElement confirmationId;

	public String getConfirmationMessage() {

		return confirmationMessage.getText();
	}

	public String getBookingId() {

		return confirmationId.getText();
	}

	public boolean isBookingSuccessful() {

		return confirmationMessage.getText().contains("Thank you for your purchase today!");
	}
}