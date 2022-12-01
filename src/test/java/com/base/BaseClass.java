package com.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static  WebDriver driver;

	public void implicitWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	}

	public void elementVisibility(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static String getProjectPath() {
		String path = System.getProperty("user.dir");
		return path;
	}
	
	public String projectPath() {
		String path = System.getProperty("user.dir");
		return path;
	}

	public static String getPropertyFileValue(String key) throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		properties.load(new FileInputStream(getProjectPath() + "\\Config\\Config.properties"));
		String value = (String) properties.get(key);
		return value;
	}

	public static void getAllDriver(String browser) {
		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "ie":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		}
	}
	public byte[] screenshot() {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		byte[] screenshotAs = screenshot.getScreenshotAs(OutputType.BYTES);
		return screenshotAs;
		
	}

	// 1
	public void getDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	// 2
	public static void enterApplnUrl(String url) {
		driver.get(url);
	}

	// 3
	public static void maximizeWindow() {
		driver.manage().window().maximize();
	}

	// 4
	public void elementSendKeys(WebElement element, String data) {
		elementVisibility(element);
		element.sendKeys(data);
	}

	// 5
	public void elementSendKeysJs(WebElement element, String data) {
		elementVisibility(element);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguements[0].setAttribute('value','" + data + "')", element);
	}

	// 6
	public void elementClick(WebElement element) {
		elementVisibility(element);
		element.click();
	}

	// 7
	public String getWindowTitle() {
		String title = driver.getTitle();
		return title;
	}

	// 8
	public WebElement findElementById(String attributeValue) {
		WebElement element = driver.findElement(By.id(attributeValue));
		return element;
	}

	// 9
	public WebElement findElementByName(String attributeValue) {
		WebElement element = driver.findElement(By.name(attributeValue));
		return element;
	}

	// 10
	public WebElement findElementByClassName(String attributeValue) {
		WebElement element = driver.findElement(By.className(attributeValue));
		return element;
	}

	// 11
	public WebElement findElementByXpath(String attributeValue) {
		WebElement element = driver.findElement(By.xpath(attributeValue));
		return element;
	}

	// 12
	public WebElement findElementByCssSelector(String attributeValue) {
		WebElement element = driver.findElement(By.cssSelector(attributeValue));
		return element;
	}

	// 13
	public WebElement findElementBylinkText(String attributeValue) {
		WebElement element = driver.findElement(By.linkText(attributeValue));
		return element;
	}

	// 14
	public WebElement findElementByPartialLinkText(String attributeValue) {
		WebElement element = driver.findElement(By.partialLinkText(attributeValue));
		return element;
	}

	// 15
	public WebElement findElementByTagName(String attributeValue) {
		WebElement element = driver.findElement(By.tagName(attributeValue));
		return element;
	}

	// 16
	public static void closeWindow() {
		driver.close();
	}

	// 17
	public void quitWindow() {
		driver.quit();
	}

	// 18
	public String elementGetText(WebElement element) {
		elementVisibility(element);
		String text = element.getText();
		return text;
	}

	// 19
	// 99% value --> get inserted value from textbox
	public String elementGetAttributeValue(WebElement element) {
		elementVisibility(element);
		String attribute = element.getAttribute("value");
		return attribute;
	}

	// 1% value --> get inserted value from textbox
	public String elementGetAttributeValue(WebElement element, String attributeName) {
		elementVisibility(element);
		String attribute = element.getAttribute(attributeName);
		return attribute;
	}

	// 20
	public void selectOptionByText(WebElement element, String text) {
		elementVisibility(element);
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	// 21
	public void selectOptionByAttribute(WebElement element, String value) {
		elementVisibility(element);
		Select select = new Select(element);
		select.selectByValue(value);
	}

	// 22
	public void selectOptionByIndex(WebElement element, int index) {
		elementVisibility(element);
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	// 23
	public String getOptions(WebElement element) {
		elementVisibility(element);
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		WebElement webElement = options.get(5);
		String text = webElement.getText();
		return text;
	}

	// 24
	public String getAllSelectedOptions(WebElement element) {
		elementVisibility(element);
		Select select = new Select(element);
		List<WebElement> options = select.getAllSelectedOptions();
		String text = options.get(1).getText();
		return text;
	}

	// 25
	public String getFirstSelectedOption(WebElement element) {
		elementVisibility(element);
		Select select = new Select(element);
		WebElement options = select.getFirstSelectedOption();
		String text = options.getText();
		return text;
	}

	// 26
	public void isMultiple(WebElement element) {
		elementVisibility(element);
		Select select = new Select(element);
		select.isMultiple();
	}

	// 27
	public void deSelectOptionByText(WebElement element, String text) {
		elementVisibility(element);
		Select select = new Select(element);
		select.deselectByVisibleText(text);
	}

	// 28
	public void deSelectOptionByAttribute(WebElement element, String value) {
		elementVisibility(element);
		Select select = new Select(element);
		select.deselectByValue(value);
	}

	// 29
	public void deSelectOptionByIndex(WebElement element, int index) {
		elementVisibility(element);
		Select select = new Select(element);
		select.deselectByIndex(index);
	}

	// 30
	public void deSelectAll(WebElement element) {
		elementVisibility(element);
		Select select = new Select(element);
		select.deselectAll();
	}

	// 31
	public String elementGetText(WebElement element, String value) {
		elementVisibility(element);
		String text = element.getAttribute(value);
		return text;
	}

	// 32
	public void minimizeWindow() {
		driver.manage().window().maximize();
	}

	// 33
	public void elementClickButtonByJs(WebElement element) {
		elementVisibility(element);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguements[0].click()", element);
	}

	// 34
	public void clickOkAlert() {
		driver.switchTo().alert().accept();
	}

	// 35
	public void clickCancelAlert() {
		driver.switchTo().alert().dismiss();
	}

	// 36
	public void AcceptAndOkAlert(String data) {
		driver.switchTo().alert().sendKeys(data);
		driver.switchTo().alert().accept();
	}

	// 37
	public void SwtichToFrameByIndex(int index) {
		driver.switchTo().frame(index);
	}

	// 38
	public void SwitchToFrameById(String id) {
		driver.switchTo().frame(id);
	}

	// 39
	public void SwitchToMainPageFromFrame() {
		driver.switchTo().defaultContent();
	}

	// 40
	public String GetParentWindowId() {
		String id = driver.getWindowHandle();
		return id;
	}

	// 41
	public Set<String> getAllWindowsId() {
		Set<String> id = driver.getWindowHandles();
		return id;
	}

	// 42
	public void SwitchToWindowById(String Id) {
		driver.switchTo().window(Id);
	}

	// 43
	public void SwitchToWindowByTitle(String title) {
		driver.switchTo().window(title);
	}

	// 44
	public void SwitchTowindowByUrl(String url) {
		driver.switchTo().window(url);
	}

	// 45
	public void navigateBack() {
		driver.navigate().back();
	}

	// 46
	public void navigateForward() {
		driver.navigate().forward();
	}

	// 47
	public void navigateRefresh() {
		driver.navigate().refresh();
	}

	// 48
	public void navigateToUrl(String url) {
		driver.navigate().to(url);
	}

	// 49
	public void moveToElement(WebElement element) {
		elementVisibility(element);
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}

	// 50
	public void dragAndDrop(WebElement element1, WebElement element2) {
		elementVisibility(element1);
		Actions action = new Actions(driver);
		action.dragAndDrop(element1, element2).perform();
	}

	// 51
	public void takeScreenShot(WebElement element) {
		elementVisibility(element);
		File a = element.getScreenshotAs(OutputType.FILE);
	}

	// 52
	public void rightClick(WebElement element) {
		elementVisibility(element);
		Actions action = new Actions(driver);
		action.contextClick(element).perform();
	}

	// 53
	public void doubleClick(WebElement element) {
		elementVisibility(element);
		Actions action = new Actions(driver);
		action.doubleClick(element).perform();
	}

	// 54
	public String getPageSource() {
		String text = driver.getPageSource();
		return text;
	}

	// 55
	public String getTagName(WebElement element) {
		elementVisibility(element);
		String text = element.getTagName();
		return text;
	}

	// 56
	public String getCssValue(WebElement element, String value) {
		elementVisibility(element);
		String text = element.getCssValue(value);
		return text;
	}

	// 57
	public Dimension getSize(WebElement element) {
		elementVisibility(element);
		Dimension size = element.getSize();
		return size;
	}

	// 58
	public void getConnection(String url) throws SQLException {
		DriverManager.getConnection(url);
	}

	// 59
	public void clear(WebElement element) {
		elementVisibility(element);
		element.clear();
	}

	// 60
	public boolean isEnabled(WebElement element) {
		elementVisibility(element);
		boolean enabled = element.isEnabled();
		return enabled;
	}

	// 61
	public boolean isDisplayed(WebElement element) {
		elementVisibility(element);
		boolean displayed = element.isDisplayed();
		return displayed;
	}

	// 62
	public void submit(WebElement element) {
		elementVisibility(element);
		element.submit();
	}

	// 63
		public String getData(String sheetName, int rowNum, int cellNum) throws IOException {
			String data = "";
			File file = new File("C:\\Users\\DELL\\eclipse-workspace\\DemoFrame\\excel\\Demo8.xlsx");
			FileInputStream fileInputStream = new FileInputStream(file);
			Workbook workbook = new XSSFWorkbook(fileInputStream);
			Sheet sheet = workbook.getSheet(sheetName);
			Row row = sheet.getRow(rowNum);
			Cell cell = row.getCell(cellNum);
			CellType type = cell.getCellType();

			switch (type) {
			case STRING:
				data = cell.getStringCellValue();
				break;
			case NUMERIC:
				if (DateUtil.isCellDateFormatted(cell)) {
					Date dateCellValue = cell.getDateCellValue();
					SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
					data = dateFormat.format(dateCellValue);
				} else {
					double numericCellValue = cell.getNumericCellValue();
					BigDecimal valueOf = BigDecimal.valueOf(numericCellValue);
					data = valueOf.toString();
				}
				break;
			default:
				break;
			}
			return data;
			
			
		}

		// 64
		public String getData(String sheetName, int rowNum, int cellNum, String oldData, String newData)
				throws IOException {
			File file = new File("C:\\Users\\Praveen\\eclipse-workspace\\MavenFramework\\Excel\\Adactin Login.xlsx");
			FileInputStream fileInputStream = new FileInputStream(file);
			Workbook workbook = new XSSFWorkbook(fileInputStream);
			Sheet sheet = workbook.getSheet(sheetName);
			Row row = sheet.getRow(rowNum);
			Cell cell = row.getCell(cellNum);
			String value = cell.getStringCellValue();
			if (value.equals(oldData)) {
				cell.setCellValue(newData);
			}
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			workbook.write(fileOutputStream);
			return newData;
		}

		// 65
		public String getDataFromCell(String sheetName, int rowNum, int cellNum) throws IOException {
			String data = "";
			File file = new File("C:\\Users\\DELL\\eclipse-workspace\\DemoFrame\\excel\\Demo8.xlsx");
			FileInputStream fileInputStream = new FileInputStream(file);
			Workbook workbook = new XSSFWorkbook(fileInputStream);
			Sheet sheet = workbook.getSheet(sheetName);
			Row row = sheet.getRow(rowNum);
			Cell cell = row.getCell(cellNum);
			String stringCellValue = cell.getStringCellValue();
			CellType type = cell.getCellType();
			switch (type) {
			case STRING:
				data = cell.getStringCellValue();
				break;
			case NUMERIC:
				if (DateUtil.isCellDateFormatted(cell)) {
					Date dateCellValue = cell.getDateCellValue();
					SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
					data = dateFormat.format(dateCellValue);
				} else {
					double numericCellValue = cell.getNumericCellValue();
					BigDecimal valueOf = BigDecimal.valueOf(numericCellValue);
					data = valueOf.toString();
				}
				break;
			default:
				break;
			}
			return stringCellValue;
		}
					
			   //69
			    public void updateData(String sheetName, int rowNum, int cellNum, String oldData, String newData) throws IOException 
			    {
				File file = new File("C:\\Users\\DELL\\eclipse-workspace\\DemoFrame\\excel\\Hoteldata.xlsx");
				FileInputStream fileInputStream = new FileInputStream(file);
				Workbook workbook = new XSSFWorkbook(fileInputStream);
				Sheet sheet = workbook.getSheet(sheetName);
				Row row = sheet.getRow(rowNum);
				Cell cell = row.getCell(cellNum);
				String value = cell.getStringCellValue();
				if(value.equals(oldData)) {
				cell.setCellValue(newData);
				}
				FileOutputStream out= new FileOutputStream(file);
				workbook.write(out);
			    }
			    
			    
			    //70
			    public void writeData(String sheetName, int rowNum, int cellNum, String Data) throws IOException 
			    {
				File file = new File("C:\\Users\\DELL\\eclipse-workspace\\DemoFrame\\excel\\Demo8.xlsx");
				FileInputStream fileInputStream = new FileInputStream(file);
				Workbook workbook = new XSSFWorkbook(fileInputStream);
				Sheet sheet = workbook.getSheet(sheetName);
				Row row = sheet.getRow(rowNum);
				Cell cell = row.createCell(cellNum);
				cell.setCellValue(Data);
				
				FileOutputStream out= new FileOutputStream(file);
				workbook.write(out);
			    }

	// 71
	public static void enter() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

}