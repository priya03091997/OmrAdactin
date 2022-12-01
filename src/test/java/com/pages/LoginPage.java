package com.pages;

import java.awt.AWTException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class LoginPage extends BaseClass {

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// private webElement
	@FindBy(id = "username")
	private WebElement txtUserName;
	@FindBy(id = "password")
	private WebElement txtPassword;
	@FindBy(id = "login")
	private WebElement btnLogin;
	@FindBy(className = "auth_error")
	private WebElement errorMsg1;

	// getters
	public WebElement getTxtUserName() {
		return txtUserName;
	}

	public WebElement getTxtPassword() {
		return txtPassword;
	}

	public WebElement click() {
		return btnLogin;
	}

	public WebElement getErrorMsg1() {
		return errorMsg1;
	}

	public void login(String userName, String password) {

		elementSendKeys(getTxtUserName(), userName);
		elementSendKeys(getTxtPassword(), password);
		elementClick(btnLogin);
	}

	public void loginWithEnterKey(String userName, String password) throws AWTException {

		elementSendKeys(getTxtUserName(), userName);
		elementSendKeys(getTxtPassword(), password);
		enter();

	}

}