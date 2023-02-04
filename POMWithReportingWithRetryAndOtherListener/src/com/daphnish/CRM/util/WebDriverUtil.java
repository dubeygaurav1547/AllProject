package com.daphnish.CRM.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.daphnish.CRM.pages.login.LoginPage;
import com.google.common.io.Files;


public class WebDriverUtil {

	private  WebDriver driver;
	private WebDriverWait expWait;
	private Properties prop;
	public Properties getPeoperties() {
		return prop;
	}

	private ExtentReports er;
	private ExtentTest et;

	public WebDriver getdriver() {
		return driver;
	}


	public void initilizeExtentReport(String filePathAndName,String reportName,String documentTitle,String testerName) {

		ExtentHtmlReporter ehreport=new ExtentHtmlReporter(filePathAndName+".html");
		ehreport.config().setReportName(reportName);
		ehreport.config().setDocumentTitle(documentTitle);
		ehreport.config().setTheme(Theme.DARK);
		er=new ExtentReports();
		er.setSystemInfo("TesterName", testerName);
		er.setSystemInfo("OS", "Window-10");
		er.attachReporter(ehreport);

	}
	public void createTest(String tsName) {

		et=er.createTest(tsName);

	}
	public void flushReport() {
		er.flush();
	}
	public void configProperties() {

		InputStream is=null;
		try {
			is = new FileInputStream("config.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		prop=new Properties();
		try {
			prop.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public WebDriverUtil() {
		configProperties();
	}

	/*Description-For Browser Launching
	 * Parameter Type-String
	 * Work-It will Launch Browser And Delete All Cookies And also provide implicitly wait
	 * Return Value Purpose-.....
	 */

	public void launchBroWser(String browserType){
		if(browserType.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
			//			DesiredCapabilities dc=null;
			//			dc.setPlatform(Platform.WINDOWS);
			//			dc.setBrowserName("");
			driver=new ChromeDriver();
			//			new RemoteWebDriver(new URL("hiub url"), dc);

			//			et.log(Status.INFO, "Chrome Browser has been Launched");

		}else if(browserType.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "driver\\geckodriver.exe");
			driver=new FirefoxDriver();
			//			et.log(Status.INFO, "FireFox Browser has been Launched");
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


	}


	public void visibilityOfElement(WebElement weObj,int timeInSecond) {
		expWait=new WebDriverWait(driver, Duration.ofSeconds(timeInSecond));
		expWait.until(ExpectedConditions.visibilityOf(weObj));

		et.log(Status.INFO, weObj.getText()+" is visible");
	}

	/*Purpose-For Hitting URL
	 * Parameter Type-String
	 * Work-It will Hit the URL
	 * Return Value Purpose-.....
	 */
	public void geturl(String inputUrl) {
		driver.get(inputUrl);
		//		et.log(Status.INFO, " Url has been opened");

	}
	/*Purpose-For Hitting URL
	 * Parameter Type-String
	 * Work-It will Hit the URL
	 * Return Value Purpose-.....
	 */
	public void navigateUrl(String inputUrl) {
		driver.navigate().to(inputUrl);
		et.log(Status.INFO, " Url has been opened");
	}

	/*Purpose-For Clicking
	 * Parameter Type-WebElement
	 * Work-It will click on element
	 * Return Value Purpose-.....
	 */
	public void click(WebElement we,String ElementName) {
		try {
			we.click();
		}catch(ElementClickInterceptedException e) {
			try {
				Actions ac=new Actions(driver);
				ac.click().build().perform();
			}catch(ElementNotInteractableException f) {
				JavascriptExecutor js=(JavascriptExecutor)driver;
				js.executeScript("arguments[0].click()", we);
			}
		}
		et.log(Status.INFO, " Clicked on "+ElementName);		
	}

	/*Purpose-For Sending Massage
	 * Parameter Type-WebElement,String
	 * Work-It will Send Massage on any EditBox
	 * Return Value Purpose-.....
	 */
	public void sendKey(WebElement we,String inputData,String ElementBox) {
		try {
			we.clear();
			we.sendKeys(inputData);
		}catch(ElementNotInteractableException e) {
			try {
				Actions ac=new Actions(driver);
				ac.sendKeys(we, inputData);
			}catch(Exception f) {
				f.printStackTrace();
				JavascriptExecutor js=(JavascriptExecutor)driver;
				js.executeScript("arguments[0].value='"+inputData+"'", we);

			}
		}
		et.log(Status.INFO, inputData+" is inputed on "+ElementBox+" Box");
	}
	/*Purpose-For Selecting Dropdown
	 * Parameter Type-WebElement,String
	 * Work-It will Select Dropdown options by visibleText Or Value
	 * Return Value Purpose-.....
	 */
	public void selectByVisibleTextOrValue(WebElement we,String visibleTextOrValue) {
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		Select sc=new Select(we);
		try {

			sc.selectByVisibleText(visibleTextOrValue);

		}catch(NoSuchElementException e) {
			sc.selectByValue(visibleTextOrValue);	
		}catch(ElementNotInteractableException e) {
			sc.selectByVisibleText(visibleTextOrValue);
		}
		et.log(Status.INFO, sc.getFirstSelectedOption().getText()+" is Selected");
	}

	public String getDropdownOption(WebElement we) {
		Select sc=new Select(we);
		String optionText=null;
		List <WebElement>lo=sc.getOptions();
		for(int i=0;i<lo.size();i++) {
			optionText=lo.get(i).getText();

		}
		et.log(Status.INFO, optionText+" is fetched");
		return optionText;
	}


	/*Purpose-For Selecting Dropdown
	 * Parameter Type-WebElement,int
	 * Work-It will Select Dropdown options by indexNo.
	 * Return Value Purpose-.....
	 */
	public void selectByIndex(WebElement we,int index) {
		Select sc=new Select(we);
		try {
			sc.selectByIndex(index);	
		}catch(IndexOutOfBoundsException e) {
			e.printStackTrace();

		}
		et.log(Status.INFO, sc.getFirstSelectedOption()+" is Selected");
	}
	/*Purpose-For mouse hover-over
	 * Parameter Type-WebElement
	 * Work-Mouse will move on given Element
	 * Return Value Purpose-.....
	 */
	public void moveToElement(WebElement we) {
		Actions ac=new Actions(driver);
		ac.moveToElement(we).build().perform();
		et.log(Status.INFO, "Mouse is moved on "+we.getText());
	}

	/*Purpose-For RightClick
	 * Parameter Type-WebElement
	 * Work-Right Click on element
	 * Return Value Purpose-.....
	 */
	public void rightClickByWebElement(WebElement we) {
		Actions ac=new Actions(driver);
		ac.contextClick(we).build().perform();
		et.log(Status.INFO, "Right click on "+we.getText());
	}

	/*Purpose-For Window Handle By title
	 * Parameter Type-String
	 * Work-If our window focus change then we move focus on that window Where we work
	 * Return Value Purpose-.....
	 */
	public void windowHandlesByTitle(String expectedTitle) {
		Set<String> handleValues=driver.getWindowHandles();
		Iterator<String> values=	handleValues.iterator();
		while(values.hasNext()) {
			String val=values.next();
			driver.switchTo().window(val);
			String actualTitle=	driver.getTitle();
			if(actualTitle.contains(expectedTitle)) {
				break;
			}
		}
		et.log(Status.INFO, "Window focus has been moved");
	}

	/*Purpose-For Window Handle By URL
	 * Parameter Type-String
	 * Work-If our window focus change then we move focus on that window Where we work
	 * Return Value Purpose-.....
	 */
	public void windowHandlesByURL(String expectedURL) {
		Set<String>handleValues= driver.getWindowHandles();
		for(String values:handleValues) {
			driver.switchTo().window(values);
			String actualUrl=	driver.getCurrentUrl();
			if(actualUrl.contains(expectedURL)) {
				break;
			}
		}
		et.log(Status.INFO, "Window focus has been moved");
	}

	/*Purpose-For Handling Frame
	 * Parameter Type-String
	 * Work-By using this method we move on that frame Where Our Element Exist
	 * Return Value Purpose-.....
	 */
	public void frameHandleByNameOrId(String NameOrId) {
		driver.switchTo().frame(NameOrId);
		et.log(Status.INFO, "focus has been moved on another Frame");

	}

	/*Purpose-For Handling Frame
	 * Parameter Type-String
	 * Work-By using this method we move on that frame Where Our Element Exist
	 * Return Value Purpose-.....
	 */
	public void frameHandleByFrameXpath(WebElement we) {
		driver.switchTo().frame(we);
		et.log(Status.INFO, "focus has been moved on another Frame");
	}

	/*Purpose-For Existing from frame
	 * Parameter Type-....
	 * Work-By using this method we exit from frame
	 * Return Value Purpose-.....
	 */
	public void frameExit() {
		driver.switchTo().defaultContent();
		et.log(Status.INFO, "Exit from Frame");
	}

	/*Purpose-For fetching the InnerText
	 * Parameter Type-WebElement
	 * Work-By using this method we will fetch the innerText of Any WebElement
	 * Return Value Purpose-It will return String type value.
	 */
	public String getText(WebElement we) {
		String actualText=we.getText();
		et.log(Status.INFO, actualText+" is Fetched");
		return actualText;
	}
	public String getTextValidation(WebElement we,String expectedText,String snapShotName) {
		String actualText=we.getText();
		if(actualText.equalsIgnoreCase(expectedText)) {
			et.log(Status.PASS, " Validation is passed where actualText is "+actualText+" and expected Text is "+expectedText);
		}else {
			et.log(Status.FAIL, " Validation is Failed where actualText is "+actualText+" and expected Text is "+expectedText);
			String imgPath=takesSnapShot(snapShotName);
			attachSnapshotToExtentReport(imgPath);
		}

		return actualText;
	}

	/*Purpose-For fetching Title
	 * Parameter Type-....
	 * Work-By using this method we will fetch the title  of Any WebPage
	 * Return Value Purpose-It will return String type value.
	 */
	public String getTitle() {
		String actualTitle=driver.getTitle();
		et.log(Status.INFO, actualTitle+" is Fetched");
		return actualTitle;
	}


	/*Purpose-For fetching URL
	 * Parameter Type-....
	 * Work-By using this method we will fetch the URL  of Any WebPage
	 * Return Value Purpose-It will return String type value.
	 */
	public String getURL() {
		String actualUrl=	driver.getCurrentUrl();
		et.log(Status.INFO, actualUrl+" is Fetched");
		return actualUrl;
	}


	/*Purpose-For verifying Element is enable or not
	 * Parameter Type-WebElement
	 * Work-By using this method we will verify any element is enable or not.
	 * Return Value Purpose-It will return String type value.
	 */
	public boolean isEnable(WebElement we) {
		boolean status=we.isEnabled();
		if(status) {
			et.log(Status.PASS, we.getText()+" is Enabled");
		}else {
			et.log(Status.FAIL, we.getText()+" is not Enabled");

			//			String imgPath=takesSnapShot(snapShotName);
			//			attachSnapshotToExtentReport(imgPath);
		}
		return status;
	}
	public boolean cheakDisable(WebElement we,String snapShotName) {
		boolean status=we.isEnabled();
		if(status) {
			et.log(Status.FAIL, we.getText()+" is Enabled");

			String imgPath=takesSnapShot(snapShotName);
			attachSnapshotToExtentReport(imgPath);
		}else {
			et.log(Status.PASS, we.getText()+" is not Enabled");
		}
		return status;
	}


	/*Purpose-For verifying Element is visible or not
	 * Parameter Type-WebElement
	 * Work-By using this method we will verify any element is visible or not.
	 * Return Value Purpose-It will return String type value.
	 */
	public boolean isDisplay(WebElement we,String snapShotName) {
		boolean status=	we.isDisplayed();
		if(status) {
			et.log(Status.PASS, we.getText()+" is Displayed on UI");
		}else {
			et.log(Status.FAIL, we.getText()+" is not Displayed on UI");

			String imgPath=takesSnapShot(snapShotName);
			attachSnapshotToExtentReport(imgPath);
		}
		return status;
	}

	public boolean isNotDisplay(WebElement we,String snapShotName) {
		boolean status=	we.isDisplayed();
		if(status) {
			et.log(Status.FAIL, we.getText()+" is Displayed on UI");

			String imgPath=takesSnapShot(snapShotName);
			attachSnapshotToExtentReport(imgPath);
		}else {
			et.log(Status.PASS, we.getText()+" is not Displayed on UI");
		}
		return status;
	}

	/*Purpose-For verifying any radio button or cheakbox is selected or not
	 * Parameter Type-WebElement
	 * Work-By using this method we will verify any radio button or cheakbox is selected or not.
	 * Return Value Purpose-It will return String type value.
	 */
	public boolean isSelected(WebElement we,String snapShotName) {
		boolean status=	we.isSelected();
		if(status) {
			et.log(Status.PASS, we.getText()+" is Selected");
		}else {
			et.log(Status.FAIL, we.getText()+" is not Selected");

			String imgPath=takesSnapShot(snapShotName);
			attachSnapshotToExtentReport(imgPath);
		}
		return status;
	}

	public boolean isNotSelected(WebElement we,String snapShotName) {
		boolean status=	we.isSelected();
		if(status) {
			et.log(Status.FAIL, we.getText()+" is Selected");

			String imgPath=takesSnapShot(snapShotName);
			attachSnapshotToExtentReport(imgPath);
		}else {
			et.log(Status.PASS, we.getText()+" is not Selected");
		}
		return status;
	}


	/*Purpose-For clicking any element by using Actions Class
	 * Parameter Type-
	 * Work-By using this method we will click on any element.
	 * Return Value Purpose-
	 */
	/*  public void click() {
		Actions ac=new Actions(Driver);
		ac.click().build().perform();

	}
	 */



	public boolean alertAccept() {
		driver.switchTo().alert().accept();
		et.log(Status.INFO, "Alert is accepted");
		return true;
	}
	public boolean alertDenied() {
		driver.switchTo().alert().dismiss();
		et.log(Status.INFO, "Alert is Denied");
		return true;
	}

	public String dateAndTime() {
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MMM/yyyy hh_mm_ss");
		String time=sdf.format(new Date());
		return time;

	}

	public String takesSnapShot(String SnapshotName) {

		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);

		String time=dateAndTime();

		File destinationPath=new File("reports\\"+SnapshotName+time+".jpeg");
		try {
			Files.copy(source, destinationPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return destinationPath.getAbsolutePath();
		//		return source.getAbsolutePath();

	}
	public void attachSnapshotToExtentReport(String imgPath) {
		try {
			et.addScreenCaptureFromPath(imgPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void validation(String actualText,String ExpectedText) {
		if(actualText.equals(ExpectedText)) {
       System.out.println(et.log(Status.PASS, "text are matched where actualText is "+actualText+" and expected is "+ExpectedText));
		}else {
			System.out.println(et.log(Status.FAIL, "text are mismatch where actualText is "+actualText+" and expected is "+ExpectedText));
		}
	}

	public void closeBrowser() {
		driver.close();
		et.log(Status.INFO, "Browser has been closed");
	}

}
