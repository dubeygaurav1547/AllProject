package org.crm.vtiger.evs.beta.marketing.campagn;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CampaignCreationPageOR {

	@FindBy(xpath="//input[@name='campaignname']")
	protected WebElement camp_name;
	@FindBy(xpath="//input[@value='T']")
	protected WebElement asign_to;
	@FindBy(xpath="//select[@name='campaigntype']")
	protected WebElement camp_type;
	@FindBy(xpath="//input[@name='targetaudience']")
	protected WebElement target_audeance;
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
	protected WebElement save;
	@FindBy(xpath="(//input[@title='Cancel [Alt+X]'])[1]")
	protected WebElement cancel;
	
}
