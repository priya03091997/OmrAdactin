package com.stepdefinition;

import org.junit.Assert;

import com.base.BaseClass;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.Then;

public class TC5_CancelBookingStep extends BaseClass {

	PageObjectManager pom = new PageObjectManager();

	@Then("User should cancel Order Id")
	public void userShouldCancelOrderId() throws InterruptedException {
		pom.getCancelBookingPage().cancellingOrderId1();
	}

	@Then("User should verify after cancel Order Id success message {string}")
	public void userShouldVerifyAfterCancelOrderIdSuccessMessage(String string) {
		Assert.assertEquals("Verify the Cancel Order", string, pom.getCancelBookingPage().getLblCancel().getText());
	}

	@Then("User should cancel booking the existing {string}")
	public void userShouldCancelBookingTheExisting(String string) throws InterruptedException {
		pom.getCancelBookingPage().cancellingOrderId(string);
	}

}
