package org.crm.vtiger.evs.beta.marketing.submodules;

import org.crm.vtiger.evs.beta.Util.WebDriverUtil;
import org.crm.vtiger.evs.beta.marketing.campagn.CampaignLandingPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MarketingSubModules extends MarketingSubModuleObjectreposetry {

	
  //private WebDriverUtil utl=new WebDriverUtil();
	public void campaign(WebDriverUtil utl) {
		
		utl.moveToElement(camp);
		utl.click(camp);
		
	}
	public void account(WebDriverUtil utl) {
		utl.moveToElement(acc);
		utl.click(acc);
	}
	public void contact() {

	}
	public void webmail() {

	}
	public void lead() {

	}
	public void calender() {

	}
	public void document() {

	}
	public MarketingSubModules(WebDriverUtil utl) {
		PageFactory.initElements(utl.getdriver(), this);
	}
}
