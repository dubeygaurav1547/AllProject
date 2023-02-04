package org.crm.vtiger.evs.beta.homePage;

import org.crm.vtiger.evs.beta.Util.WebDriverUtil;
import org.crm.vtiger.evs.beta.inventry.submodule.InventrySubModule;
import org.crm.vtiger.evs.beta.login.LoginPage;
import org.crm.vtiger.evs.beta.marketing.submodules.MarketingSubModules;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageLanding extends HomePageLandingOR {
	
	
	private WebDriverUtil utl;


	
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
	
	public void myHomePage() {
		utl.moveToElement(my_home_page);

	}
	public MarketingSubModules marketing() {
		utl.moveToElement(marketing);
		MarketingSubModules ms=new MarketingSubModules(utl);
		return ms;
	}
	public void sales() {
		utl.moveToElement(sales);
	}
	public void support() {
		utl.moveToElement(support);
	}
	public void analytics() {
		utl.moveToElement(anaylytic);
	}
	public InventrySubModule inventry() {
		utl.moveToElement(inventry);
		InventrySubModule is=new InventrySubModule(utl);
		return is;
	}
	public void tools() {
		utl.moveToElement(tools);
	}
	public void settings() {
		utl.moveToElement(setting);
	}
	public void openAboutUs() {
		utl.click(open_about_us);
	}
	public void openFeedback() {

		utl.click(open_feedback);
	}
	public LoginPage signOut() {
		
       if(utl.waitUntilElementIsvisible(anaylytic)) {
    	   utl.click(sign_out);
       }else {
    	   System.out.println("Element is visible");
       }
		
		LoginPage lp=new LoginPage(utl);
		return lp;

	}
	public HomePageLanding(WebDriverUtil utl) {
		this.utl=utl;
		PageFactory.initElements(utl.getdriver(), this);
	}

}
