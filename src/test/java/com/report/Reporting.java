package com.report;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.base.BaseClass;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class Reporting extends BaseClass {

	public static void generateJVMReport(String jsonFile) throws FileNotFoundException, IOException {

		// 1.Mention the file path to store the JVM report
		File file = new File(getProjectPath() + getPropertyFileValue("jvmreport"));

		// 2.Create the object for configuration class
		Configuration config = new Configuration(file, "Adactin Automation");

		// 3.k,v => some details like browser name& version,OS version,etc for designing
		// purpose
		config.addClassifications("Browser", "Chrome");
		config.addClassifications("Browser version", "107");
		config.addClassifications("OS", "10");
		config.addClassifications("Sprint", "35");

		// 4.Create the object for ReportBuilder class => pass the json file to fetch

		List<String> jsonFiles = new ArrayList<String>();
		jsonFiles.add(jsonFile);

		ReportBuilder builder = new ReportBuilder(jsonFiles, config);

		// 5.generate JVM report
		builder.generateReports();

	}

}