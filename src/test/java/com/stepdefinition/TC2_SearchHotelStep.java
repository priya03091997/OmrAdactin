package com.stepdefinition;

import org.junit.Assert;
import com.base.BaseClass;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.Then;

public class TC2_SearchHotelStep extends BaseClass {
	PageObjectManager pom = new PageObjectManager();

	@Then("User should search hotels {string},{string},{string},{string},{string},{string},{string} and {string}")
	public void userShouldSearchHotelsAnd(String string, String string2, String string3, String string4, String string5,
			String string6, String string7, String string8) {
		pom.getSearchHotelPage().searchHotels(string, string2, string3, string4, string5, string6, string7, string8);
	}

	@Then("User should verify after search hotels success message {string}")
	public void userShouldVerifyAfterSearchHotelsSuccessMessage(String expLoginSucMsg) throws InterruptedException {
		Assert.assertEquals("Verify After Search Hotel", expLoginSucMsg,
				pom.getSelectHotelPage().getSuccessMsg2().getText());
	}

	@Then("User should enter only mandatory fields {string},{string},{string},{string} and {string}")
	public void userShouldEnterOnlyMandatoryFieldsAnd(String string1, String string2, String string3, String string4,
			String string5) {
		pom.getSearchHotelPage().searchHotels(string1, string2, string3, string4, string5);
	}

	@Then("User should verify after entering invalid date error message {string} and {string}")
	public void userShouldVerifyAfterEnteringInvalidDateErrorMessageAnd(String inDateErrorMsg, String outDateErrorMsg)
			throws InterruptedException {
		Assert.assertEquals("Verify the Check-In Date", inDateErrorMsg,
				pom.getSearchHotelPage().getErrorMsg2().getText());
		Assert.assertEquals("Verify the Check-Out Date", outDateErrorMsg,
				pom.getSearchHotelPage().getErrorMsg3().getText());
	}

	@Then("User should click search button")
	public void userShouldClickSearchButton() {
		pom.getSearchHotelPage().searchHotels();
	}

	@Then("User should verify after clickling search button error message {string}")
	public void userShouldVerifyAfterClicklingSearchButtonErrorMessage(String lncErrorMsg) throws InterruptedException {
		Assert.assertEquals("Verify the Error Message after not Giving Any Fields", lncErrorMsg,
				pom.getSearchHotelPage().getErrorMsg4().getText());
	}

}