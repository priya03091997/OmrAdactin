package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CancelBookingPage extends BookingConfirmPage {

	public CancelBookingPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "order_id_text")
	private WebElement txtSearchOrderId;

	@FindBy(id = "search_hotel_id")
	private WebElement btnGo;

	@FindBy(xpath = "(//input[@type='button'])[1]")
	private WebElement btnCancel;

	@FindBy(xpath = "//td/label[@id='search_result_error']")
	private WebElement lblCancel;

	public WebElement getTxtSearchOrderId() {
		return txtSearchOrderId;
	}

	public WebElement getBtnGo() {
		return btnGo;
	}

	public WebElement getBtnCancel() {
		return btnCancel;
	}

	public WebElement getLblCancel() {
		return lblCancel;
	}

	public void cancellingOrderId(String orderId) throws InterruptedException {
		elementClick(getClkBookedItinerary());
		elementSendKeys(getTxtSearchOrderId(), orderId);
		elementClick(getBtnGo());
		elementClick(getBtnCancel());
		clickOkAlert();

	}
	
	public void cancellingOrderId1() throws InterruptedException {
		elementSendKeys(getTxtSearchOrderId(), bookingOrderID());
		elementClick(getBtnGo());
		elementClick(getBtnCancel());
		clickOkAlert();

	}

}
