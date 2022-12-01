package com.stepdefinition;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CommonStep extends BaseClass {
	PageObjectManager pom = new PageObjectManager();

	@Given("User is on the Adactin login page")
	public void userIsOnTheAdactinLoginPage() throws FileNotFoundException, IOException {
		

	}

	@When("User should perform login {string} and {string}")
	public void userShouldPerformLoginAnd(String userName, String password) {
      pom.getLoginPage().login(userName, password);
	}

	@Then("User should verify after login success message {string}")
	public void userShouldVerifyAfterLoginSuccessMessage(String expLoginMesage) {
		WebElement textLoginMsg = pom.getSearchHotelPage().getSuccessMsg1();
		String getAtValueSuccess1 = elementGetAttributeValue(textLoginMsg);

		Assert.assertEquals("verify after login success message", expLoginMesage, getAtValueSuccess1);
		
	}
}
