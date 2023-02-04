package org.crm.vtiger.evs.beta.marketing.campagn;

import org.crm.vtiger.evs.beta.Util.WebDriverUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignLandingPage extends CampaignLandingPageOR {



	private WebDriverUtil utl;


	public WebElement createCamp() {
		return create_camp;
	}

	public CampaignCreationPage createCampaign() {

		utl.click(createCamp());
		CampaignCreationPage clp=new CampaignCreationPage(utl);
		return clp;
	}
	public CampaignLandingPage(WebDriverUtil utl) {
		this.utl=utl;
		PageFactory.initElements(utl.getdriver(), this);
	}
}
