package org.crm.vtiger.evs.beta.homePage;

import org.crm.vtiger.evs.beta.Util.WebDriverUtil;
import org.crm.vtiger.evs.beta.marketing.submodules.MarketingSubModules;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageLanding {
	@FindBy(linkText ="My Home Page")
	private WebElement my_home_page;
	@FindBy(linkText = "Marketing")
	private WebElement marketing;
	@FindBy(linkText = "Sales")
	private WebElement sales;
	@FindBy(linkText = "Support")
	private WebElement support;
	@FindBy(linkText = "Analytics")
	private WebElement anaylytic;
	@FindBy(linkText = "Inventory")
	private WebElement inventry;
	@FindBy(linkText = "Tools")
	private WebElement tools;
	@FindBy(linkText = "Settings")
	private WebElement setting;
	@FindBy(linkText="About Us")
	private WebElement open_about_us;
	@FindBy(linkText="Feedback")
	private WebElement open_feedback;
	@FindBy(linkText ="Sign Out")
	private WebElement sign_out;


	
	public WebElement myHomePageXpath() {
		return my_home_page;
	}
	public WebElement marketingXpath() {
		return marketing;
	}
	public WebElement salesXpath() {
		return sales;
	}
	public WebElement supportXpath() {
		return support;
	}
	public WebElement anaylyticXpath() {
		return anaylytic;
	}
	public WebElement inventryXpath() {
		return inventry;
	}
	public WebElement toolsXpath() {
		return tools;
	}
	public WebElement settingXpath() {
		return setting;
	}
	public WebElement aboutUsXpath() {
		return open_about_us;
	}
	public WebElement feedBackXpath() {
		return open_feedback;
	}
	public WebElement signOutXpath() {
		return sign_out;
	}
	public void myHomePage(WebDriverUtil utl) {
		utl.moveToElement(my_home_page);

	}
	public void marketing(WebDriverUtil utl) {
		utl.moveToElement(marketing);
	}
	public void sales(WebDriverUtil utl) {
		utl.moveToElement(sales);
	}
	public void support(WebDriverUtil utl) {
		utl.moveToElement(support);
	}
	public void analytics(WebDriverUtil utl) {
		utl.moveToElement(anaylytic);
	}
	public void inventry(WebDriverUtil utl) {
		utl.moveToElement(inventry);
	}
	public void tools(WebDriverUtil utl) {
		utl.moveToElement(tools);
	}
	public void settings(WebDriverUtil utl) {
		utl.moveToElement(setting);
	}
	public void openAboutUs(WebDriverUtil utl) {
		utl.click(open_about_us);
	}
	public void openFeedback(WebDriverUtil utl) {

		utl.click(open_feedback);
	}
	public void signOut(WebDriverUtil utl) {

		utl.click(sign_out);

	}
	public HomePageLanding(WebDriverUtil utl) {
		PageFactory.initElements(utl.getdriver(), this);
	}

}
