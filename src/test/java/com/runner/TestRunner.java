package com.runner;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.base.BaseClass;
import com.report.Reporting;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(tags = (""), publish = true, dryRun = false, plugin = { "pretty",
		"json:target\\Output.json" }, snippets = SnippetType.CAMELCASE, monochrome = true, features = "src\\test\\resources\\Features", glue = "com.stepdefinition")

public class TestRunner extends BaseClass {

	@AfterClass
	public static void afterClass() throws FileNotFoundException, IOException {
		// call the JVM report generation
		Reporting.generateJVMReport(getProjectPath() + getPropertyFileValue("jsonpath"));
	}

}