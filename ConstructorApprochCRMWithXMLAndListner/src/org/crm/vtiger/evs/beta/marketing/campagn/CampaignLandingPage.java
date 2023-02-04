package org.crm.vtiger.evs.beta.marketing.campagn;

import org.crm.vtiger.evs.beta.Util.WebDriverUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignLandingPage {

	@FindBy(xpath="//img[@alt='Create Campaign...']")
	private WebElement create_camp;
	
	
	public WebElement createCamp() {
		return create_camp;
	}
	
	public void createCampaign(WebDriverUtil utl) {
		
		utl.click(createCamp());
	}
	public CampaignLandingPage(WebDriverUtil utl) {
		PageFactory.initElements(utl.getdriver(), this);
	}
}
