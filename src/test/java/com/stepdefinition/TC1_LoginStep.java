package com.stepdefinition;



import java.awt.AWTException;

import org.junit.Assert;


import com.base.BaseClass;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC1_LoginStep extends BaseClass{

	PageObjectManager pom = new PageObjectManager();

	@When("User should perform login {string} and {string} with Enter key")
	public void userShouldPerformLoginAndWithEnterKey(String userName, String password) throws AWTException {
		pom.getLoginPage().loginWithEnterKey(userName, password);
		
	}

	@Then("User should verify after login with invalid credential error message contains {string}")
	public void userShouldVerifyAfterLoginWithInvalidCredentialErrorMessageContains(String expLoginErrorMesage) throws InterruptedException {
		
		Assert.assertEquals("Verify After giving Wrong Username or Password", expLoginErrorMesage,
				pom.getLoginPage().getErrorMsg1().getText().split(" Click")[0]);
		
	}
	

}
