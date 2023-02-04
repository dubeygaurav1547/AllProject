package org.crm.vtiger.evs.beta.marketing.submodules;

import org.crm.vtiger.evs.beta.Util.WebDriverUtil;
import org.crm.vtiger.evs.beta.marketing.accounts.AccountsLandingPage;
import org.crm.vtiger.evs.beta.marketing.campagn.CampaignLandingPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MarketingSubModules extends MarketingSubModuleObjectreposetry {

	
  private WebDriverUtil utl;
  
	public CampaignLandingPage campaign() {
		
		utl.moveToElement(camp);
		utl.click(camp);
		CampaignLandingPage clp=new CampaignLandingPage(utl);
		return clp;
		
	}
	public AccountsLandingPage account() {
		utl.moveToElement(acc);
		utl.click(acc);
		AccountsLandingPage alp=new AccountsLandingPage(utl);
		return alp;
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
		this.utl=utl;
		PageFactory.initElements(utl.getdriver(), this);
	}
}
