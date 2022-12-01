package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class SelectHotelPage extends BaseClass {

	public SelectHotelPage() {
		PageFactory.initElements(driver, this);
	}

	// private webElement
	@FindBy(id = "radiobutton_0")
	private WebElement btnSelect;
	@FindBy(id = "continue")
	private WebElement btnContinue;
	@FindBy(id = "radiobutton_span")
	private WebElement errorMsg5;

	@FindBy(className = "login_title")
	private WebElement successMsg2;

	public WebElement getBtnSelect() {
		return btnSelect;
	}

	public void setBtnSelect(WebElement btnSelect) {
		this.btnSelect = btnSelect;
	}

	public WebElement getBtnContinue() {
		return btnContinue;
	}

	public void setBtnContinue(WebElement btnContinue) {
		this.btnContinue = btnContinue;
	}

	public WebElement getErrorMsg5() {
		return errorMsg5;
	}

	public void setErrorMsg5(WebElement errorMsg5) {
		this.errorMsg5 = errorMsg5;
	}

	public WebElement getSuccessMsg2() {
		return successMsg2;
	}

	public void setSuccessMsg2(WebElement successMsg2) {
		this.successMsg2 = successMsg2;
	}

	public void selectHotel() {
		WebElement elementSelect = getBtnSelect();
		elementClick(elementSelect);
		WebElement elementContinue = getBtnContinue();
		elementClick(elementContinue);

	}

	public void clickContinue() {
		WebElement elementContinue = getBtnContinue();
		elementClick(elementContinue);
	}

}
