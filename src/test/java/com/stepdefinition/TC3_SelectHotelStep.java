package com.stepdefinition;

import org.junit.Assert;

import com.base.BaseClass;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.Then;

public class TC3_SelectHotelStep extends BaseClass {
	PageObjectManager pom = new PageObjectManager();

	@Then("User should select hotel name followed by clicking continue button")
	public void userShouldSelectHotelNameFollowedByClickingContinueButton() {
		pom.getSelectHotelPage().selectHotel();
	}

	@Then("User should verify after select hotel name success message {string}")
	public void userShouldVerifyAfterSelectHotelNameSuccessMessage(String string) {
		Assert.assertEquals("Verify the Success Message After Select a Hotel", string,
				pom.getBookHotelPage().getSuccessMsg3().getText());
	}

	@Then("User should click continue button without selecting hotel name")
	public void userShouldClickContinueButtonWithoutSelectingHotelName() {
		pom.getSelectHotelPage().clickContinue();
	}

	@Then("User should verify after click continue button error message {string}")
	public void userShouldVerifyAfterClickContinueButtonErrorMessage(String string) {
		Assert.assertEquals("Verify the Error Message after do not select any Hotel", string,
				pom.getSelectHotelPage().getErrorMsg5().getText());
	}
}