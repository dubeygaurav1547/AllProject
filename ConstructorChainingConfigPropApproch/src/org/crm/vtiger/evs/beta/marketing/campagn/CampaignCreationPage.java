package org.crm.vtiger.evs.beta.marketing.campagn;

import org.crm.vtiger.evs.beta.Util.WebDriverUtil;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignCreationPage extends CampaignCreationPageOR {

	private WebDriverUtil utl;

	public WebElement campName() {
		return camp_name;
	}

	public WebElement assignTo() {
		return asign_to;
	}
	public WebElement campType() {
		return camp_type;
	}
	public WebElement targetAudience() {
		return target_audeance;
	}
	public WebElement save() {
		return save;
	}
	public WebElement cancel() {
		return cancel;
	}

	
	public void basicInformationCreation() {

		utl.sendKey(campName(), "Covid Vaxin");
		utl.click(assignTo());
		utl.selectByVisibleTextOrValue(campType(),"Webinar");
		utl.sendKey(targetAudience(), "younger");
		
	}
	public CampaignDetailsPage saveCamp() {
		utl.click(save());
		try {
			utl.alertAccept();
		}catch(NoAlertPresentException e) {
			System.out.println("Unique");
		}
		CampaignDetailsPage cdp=new CampaignDetailsPage();
		return cdp;
	}
	public CampaignCreationPage cancelCamp() {
		utl.click(cancel());
		return this;
	}
	public CampaignCreationPage(WebDriverUtil utl) {
		this.utl=utl;
		PageFactory.initElements(utl.getdriver(), this);
	}
}
