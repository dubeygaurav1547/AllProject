package org.crm.vtiger.evs.beta.homePage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageLandingOR {

	@FindBy(linkText ="My Home Page")
	protected WebElement my_home_page;
	@FindBy(linkText = "Marketing")
	protected WebElement marketing;
	@FindBy(linkText = "Sales")
	protected WebElement sales;
	@FindBy(linkText = "Support")
	protected WebElement support;
	@FindBy(linkText = "Analytics")
	protected WebElement anaylytic;
	@FindBy(linkText = "Inventory")
	protected WebElement inventry;
	@FindBy(linkText = "Tools")
	protected WebElement tools;
	@FindBy(linkText = "Settings")
	protected WebElement setting;
	@FindBy(linkText = "Module Manager")
	protected WebElement module_manager;
	@FindBy(linkText="About Us")
	protected WebElement open_about_us;
	@FindBy(linkText="Feedback")
	protected WebElement open_feedback;
	@FindBy(linkText ="Sign Out")
	protected WebElement sign_out;
	
}
