package com.stepdefinition;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.base.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class HooksClass extends BaseClass {

	@Before
	public void beforeScenario() throws FileNotFoundException, IOException {
		getAllDriver(getPropertyFileValue("browser"));
		enterApplnUrl(getPropertyFileValue("url"));
		maximizeWindow();
		implicitWait();
	}

	@After
	public void afterScenario(Scenario scenario) {

		scenario.attach(screenshot(), "images/png", "All scenario screenshot");
		quitWindow();
	}
}
