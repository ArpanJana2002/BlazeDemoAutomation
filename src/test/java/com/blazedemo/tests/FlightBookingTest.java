package com.blazedemo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.blazedemo.base.BaseTest;
import com.blazedemo.pages.ConfirmationPage;
import com.blazedemo.pages.FlightSelectionPage;
import com.blazedemo.pages.HomePage;
import com.blazedemo.pages.PurchasePage;
import com.blazedemo.utils.ConfigReader;
import com.blazedemo.utils.JsonDataReader;
import com.blazedemo.utils.ScreenshotUtils;

public class FlightBookingTest extends BaseTest {

	@Test
	public void bookFlight() {

		HomePage homePage = new HomePage(driver);

		homePage.selectDepartureCity(ConfigReader.get("departureCity"));

		homePage.selectDestinationCity(ConfigReader.get("destinationCity"));

		homePage.clickFindFlights();

		FlightSelectionPage flightPage = new FlightSelectionPage(driver);

		Assert.assertTrue(flightPage.areFlightsDisplayed(), "Flights are not displayed");

		flightPage.chooseFirstFlight();

		PurchasePage purchasePage = new PurchasePage(driver);

		Assert.assertTrue(purchasePage.verifyFlightDetails(), "Flight details are missing");

		purchasePage.completeBooking(

				JsonDataReader.get("name"),

				JsonDataReader.get("address"),

				JsonDataReader.get("city"),

				JsonDataReader.get("state"),

				JsonDataReader.get("zipCode"),

				JsonDataReader.get("creditCardNumber"),

				JsonDataReader.get("creditCardMonth"),

				JsonDataReader.get("creditCardYear"),

				JsonDataReader.get("nameOnCard"));

		purchasePage.clickPurchaseFlight();

		ConfirmationPage confirmationPage = new ConfirmationPage(driver);

		Assert.assertTrue(confirmationPage.isBookingSuccessful(), "Booking Failed");

		System.out.println("================================");

		System.out.println("Flight Booking Successful");

		System.out.println("Booking ID : " + confirmationPage.getBookingId());

		System.out.println("================================");

		ScreenshotUtils.captureScreenshot(driver, "BookingSuccess");
	}
}