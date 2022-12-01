package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class SearchHotelPage  extends BaseClass{
	
	
	public SearchHotelPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "location")
	private WebElement location;
	@FindBy(id = "hotels")
	private WebElement hotel;
	@FindBy(id = "room_type")
	private WebElement roomType;
	@FindBy(id = "room_nos")
	private WebElement roomNos;
	@FindBy(id = "datepick_in")
	private WebElement dateIn;
	@FindBy(id = "datepick_out")
	private WebElement dateOut;
	@FindBy(id = "adult_room")
	private WebElement adults;
	@FindBy(id = "child_room")
	private WebElement childs;
	@FindBy(id = "Submit")
	private WebElement btnSearch;
	@FindBy(name ="username_show")
	private WebElement successMsg1;
	
	@FindBy(id ="checkin_span")
	private WebElement errorMsg2;
	
	@FindBy(id ="checkout_span")
	private WebElement errorMsg3;
	
	@FindBy(id = "location_span")
	private WebElement errorMsg4;
	
	
	public WebElement getLocation() {
		return location;
	}

	public WebElement getHotel() {
		return hotel;
	}

	public WebElement getRoomType() {
		return roomType;
	}

	public WebElement getRoomNos() {
		return roomNos;
	}

	public WebElement getDateIn() {
		return dateIn;
	}

	public WebElement getDateOut() {
		return dateOut;
	}

	public WebElement getAdults() {
		return adults;
	}

	public WebElement getChilds() {
		return childs;
	}

	public WebElement getBtnSearch() {
		return btnSearch;
	}

	public WebElement getSuccessMsg1() {
		return successMsg1;
	}

	public WebElement getErrorMsg2() {
		return errorMsg2;
	}

	public WebElement getErrorMsg3() {
		return errorMsg3;
	}

	public WebElement getErrorMsg4() {
		return errorMsg4;
	}

	public void searchHotels(String txtPlace, String txtHotel, String roomType, String noOfRooms, 
	    String checkInDate, String checkOutDate, String adultsPerRoom, String childsPerRoom) {
		WebElement location = getLocation();
		selectOptionByText(location, txtPlace);
		
		WebElement hotel = getHotel();
		selectOptionByText(hotel, txtHotel);
		
		WebElement roomTyp = getRoomType();
		selectOptionByText(roomTyp, roomType);
		
		WebElement roomNo = getRoomNos();
		elementSendKeys(roomNo, noOfRooms);

		WebElement inDate = getDateIn();
		inDate.click();
		inDate.clear();
		inDate.sendKeys(checkInDate);

		WebElement outDate = getDateOut();
		outDate.click();
		outDate.clear();
		outDate.sendKeys(checkOutDate);

		WebElement adultRoom = getAdults();
		elementSendKeys(adultRoom, adultsPerRoom);
		
		WebElement childRoom = getChilds();
		elementSendKeys(childRoom, childsPerRoom);
		
		WebElement elementSubmit = getBtnSearch();
		elementClick(elementSubmit);
	}
	
	public void searchHotels(String txtPlace, String noOfRooms, String checkInDate, String checkOutDate, String adultsPerRoom) {
		WebElement location = getLocation();
		selectOptionByText(location, txtPlace);
				
		WebElement roomNo = getRoomNos();
		elementSendKeys(roomNo, noOfRooms);
		
		WebElement inDate = getDateIn();
		inDate.click();
		inDate.clear();
		inDate.sendKeys(checkInDate);

		WebElement outDate = getDateOut();
		outDate.click();
		outDate.clear();
		outDate.sendKeys(checkOutDate);

		WebElement adultRoom = getAdults();
		elementSendKeys(adultRoom, adultsPerRoom);
		
		WebElement elementSubmit = getBtnSearch();
		elementClick(elementSubmit);
	}
	
	public void searchHotels() {
		WebElement elementSubmit = getBtnSearch();
		elementClick(elementSubmit);
	}
}
