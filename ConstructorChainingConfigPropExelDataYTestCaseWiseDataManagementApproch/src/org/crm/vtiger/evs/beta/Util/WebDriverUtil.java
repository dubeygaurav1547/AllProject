package org.crm.vtiger.evs.beta.Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.crm.vtiger.evs.beta.login.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtil {

	private  WebDriver driver;
	private WebDriverWait expWait;
	private WebDriverUtil utl;
	private Properties prop;
	private JavascriptExecutor js;
	private Actions ac;

	public WebDriver getdriver() {
		return driver;
	}

	public Properties getProperties() {
		return prop;
	}

	public WebDriverUtil() {
		loadConfig();
	}

	public void loadConfig() {
		prop=new Properties();
		//File f=new File("config.properties");
		FileInputStream fis=null;
		try {
			fis = new FileInputStream("config.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/*Description-For Browser Launching
	 * Parameter Type-String
	 * Work-It will Launch Browser And Delete All Cookies And also provide implicitly wait
	 * Return Value Purpose-.....
	 */

	public void launchBroWser(String browserType) {
		if(browserType.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
			driver=new ChromeDriver();


		}else if(browserType.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "driver\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	public void login(String URL) {
		driver.get(URL);
	}

	public void explicitlyWait(By xpath) {
		expWait=new WebDriverWait(driver, Duration.ofSeconds(5));
		expWait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
	}

	public boolean waitUntilElementIsvisible(WebElement we) {
		expWait=new WebDriverWait(driver, Duration.ofSeconds(10));
		expWait.until(ExpectedConditions.visibilityOf(we));
		return true;
		
	}
	/*Purpose-For Hitting URL
	 * Parameter Type-String
	 * Work-It will Hit the URL
	 * Return Value Purpose-.....
	 */
	public void url(String inputUrl) {
		driver.get(inputUrl);
	}
	/*Purpose-For Hitting URL
	 * Parameter Type-String
	 * Work-It will Hit the URL
	 * Return Value Purpose-.....
	 */
	public void navigateUrl(String inputUrl) {
		driver.navigate().to(inputUrl);
	}

	/*Purpose-For Clicking
	 * Parameter Type-WebElement
	 * Work-It will click on element
	 * Return Value Purpose-.....
	 */
	public void click(WebElement we) {
		Dimension d=we.getSize();
		int h=d.getHeight();
		int w=d.getWidth();
		if(we.isDisplayed() && h>0 && w>0 ) {
			try {
				we.click();
			}catch(ElementNotInteractableException e) {
				try {
					ac=new Actions(driver);
					ac.click().build().perform();
				}catch(Exception f) {
					js=(JavascriptExecutor)driver;
					js.executeScript("arguments[0].click()", we);
				}
			}
		}else {
			System.out.println("Btn is not Displayed");
		}
	}
	


	/*Purpose-For Sending Massage
	 * Parameter Type-WebElement,String
	 * Work-It will Send Massage on any EditBox
	 * Return Value Purpose-.....
	 */
	public void ExlsendKey(WebElement we,String dataName) {
		ExelReader er=new ExelReader();
		String dataValue=er.DataMap.get(dataName);
		try {
			we.click();
			we.clear();
			we.sendKeys(dataValue);
		}catch(ElementNotInteractableException e) {
			try {
				e.printStackTrace();
				Actions ac=new Actions(driver);
				ac.sendKeys(we, dataValue);
			}catch(ElementNotInteractableException f) {
				f.printStackTrace();
				js=(JavascriptExecutor)driver;
				js.executeScript("arguments[0].value="+dataValue+"", we);
			}


		}
	}
	public void sendKey(WebElement we,String inputData) {
		try {
			we.click();
			we.clear();
			we.sendKeys(inputData);
		}catch(ElementNotInteractableException e) {
			try {
				e.printStackTrace();
				Actions ac=new Actions(driver);
				ac.sendKeys(we, inputData);
			}catch(ElementNotInteractableException f) {
				f.printStackTrace();
				js=(JavascriptExecutor)driver;
				js.executeScript("arguments[0].value="+inputData+"", we);
			}


		}
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
		}
	}

	//	/*Purpose-For Selecting Dropdown
	//	 * Parameter Type-WebElement,String
	//	 * Work-It will Select Dropdown options by valueAttribute
	//	 * Return Value Purpose-.....
	//	 */
	//	public void selectByValue(WebElement we,String value) {
	//		Select sc=new Select(we);
	//		sc.selectByValue(value);	
	//	}


	/*Purpose-For Selecting Dropdown
	 * Parameter Type-WebElement,int
	 * Work-It will Select Dropdown options by indexNo.
	 * Return Value Purpose-.....
	 */
	public void selectByIndex(WebElement we,int index) {
		Select sc=new Select(we);
		sc.selectByIndex(index);	
	}

	/*Purpose-For mouse hover-over
	 * Parameter Type-WebElement
	 * Work-Mouse will move on given Element
	 * Return Value Purpose-.....
	 */
	public void moveToElement(WebElement we) {
		Actions ac=new Actions(driver);
		ac.moveToElement(we).build().perform();
	}

	/*Purpose-For RightClick
	 * Parameter Type-WebElement
	 * Work-Right Click on element
	 * Return Value Purpose-.....
	 */
	public void rightClickByWebElement(WebElement we) {
		Actions ac=new Actions(driver);
		ac.contextClick(we).build().perform();
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
			if(actualTitle.equalsIgnoreCase(expectedTitle)) {
				break;
			}
		}
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

	}

	/*Purpose-For Handling Frame
	 * Parameter Type-String
	 * Work-By using this method we move on that frame Where Our Element Exist
	 * Return Value Purpose-.....
	 */
	public void frameHandleByNameOrId(String NameOrId) {
		driver.switchTo().frame(NameOrId);

	}

	/*Purpose-For Handling Frame
	 * Parameter Type-String
	 * Work-By using this method we move on that frame Where Our Element Exist
	 * Return Value Purpose-.....
	 */
	public void frameHandleByFrameXpath(WebElement we) {
		driver.switchTo().frame(we);

	}

	/*Purpose-For Existing from frame
	 * Parameter Type-....
	 * Work-By using this method we exit from frame
	 * Return Value Purpose-.....
	 */
	public void frameExit() {
		driver.switchTo().defaultContent();
	}

	/*Purpose-For fetching the InnerText
	 * Parameter Type-WebElement
	 * Work-By using this method we will fetch the innerText of Any WebElement
	 * Return Value Purpose-It will return String type value.
	 */
	public String getText(WebElement we) {
		String actualText=we.getText();
		return actualText;
	}

	/*Purpose-For fetching Title
	 * Parameter Type-....
	 * Work-By using this method we will fetch the title  of Any WebPage
	 * Return Value Purpose-It will return String type value.
	 */
	public String getTitle() {
		String actualTitle=driver.getTitle();
		return actualTitle;
	}


	/*Purpose-For fetching URL
	 * Parameter Type-....
	 * Work-By using this method we will fetch the URL  of Any WebPage
	 * Return Value Purpose-It will return String type value.
	 */
	public String getURL() {
		String actualUrl=	driver.getCurrentUrl();
		return actualUrl;
	}


	/*Purpose-For verifying Element is enable or not
	 * Parameter Type-WebElement
	 * Work-By using this method we will verify any element is enable or not.
	 * Return Value Purpose-It will return String type value.
	 */
	public boolean isEnable(WebElement we) {
		boolean status=we.isEnabled();
		return status;
	}


	/*Purpose-For verifying Element is visible or not
	 * Parameter Type-WebElement
	 * Work-By using this method we will verify any element is visible or not.
	 * Return Value Purpose-It will return String type value.
	 */
	public boolean isDisplay(WebElement we) {
		boolean status=	we.isDisplayed();
		return status;
	}

	/*Purpose-For verifying any radio button or cheakbox is selected or not
	 * Parameter Type-WebElement
	 * Work-By using this method we will verify any radio button or cheakbox is selected or not.
	 * Return Value Purpose-It will return String type value.
	 */
	public boolean isSelected(WebElement we) {
		boolean status=	we.isSelected();
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
		return true;
	}
	public boolean alertDenied() {
		driver.switchTo().alert().dismiss();
		return true;
	}

	public void closeBrowser() {
		try {
			driver.close();
		}catch(Exception e) {
			driver.quit();	
		}
	}


}
