package com.stepdefinition;

import org.junit.Assert;

import com.base.BaseClass;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.Then;

public class TC4_BookHotelStep extends BaseClass {
	PageObjectManager pom = new PageObjectManager();

	@Then("User should book hotel {string} , {string} and {string}")
	public void userShouldBookHotelAnd(String string, String string2, String string3,
			io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
		pom.getBookHotelPage().bookHotel(string, string2, string3, dataTable);
		Thread.sleep(6000);
	}

	@Then("User should verify after booking success message {string} and save Order Id")
	public void userShouldVerifyAfterBookingSuccessMessageAndSaveOrderId(String string) {
		Assert.assertEquals("Verify the Success Message", string,
				pom.getBookingConfirmPage().getSuccessMsg4().getText());
	}

	@Then("User should click book now button")
	public void userShouldClickBookNowButton() {
		pom.getBookHotelPage().bookHotelWithoutAnyFields();
	}

	@Then("User should verify error message after click book now {string},{string},{string},{string},{string},{string} and {string}")
	public void userShouldVerifyErrorMessageAfterClickBookNowAnd(String string, String string2, String string3,
			String string4, String string5, String string6, String string7) {
		Assert.assertEquals("Verify the Error Message", string, pom.getBookHotelPage().getErrorMsg6().getText());
		Assert.assertEquals("Verify the Error Message", string2, pom.getBookHotelPage().getErrorMsg7().getText());
		Assert.assertEquals("Verify the Error Message", string3, pom.getBookHotelPage().getErrorMsg8().getText());
		Assert.assertEquals("Verify the Error Message", string4, pom.getBookHotelPage().getErrorMsg9().getText());
		Assert.assertEquals("Verify the Error Message", string5, pom.getBookHotelPage().getErrorMsg10().getText());
		Assert.assertEquals("Verify the Error Message", string6, pom.getBookHotelPage().getErrorMsg11().getText());
		Assert.assertEquals("Verify the Error Message", string7, pom.getBookHotelPage().getErrorMsg12().getText());
	}

}
