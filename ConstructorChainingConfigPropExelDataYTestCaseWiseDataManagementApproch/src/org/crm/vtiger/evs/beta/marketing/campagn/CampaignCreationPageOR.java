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
	@FindBy(xpath="//input[@name='sponsor']")
	protected WebElement sponcer;
	@FindBy(xpath="//input[@name='numsent']")
	protected WebElement nump_sent;
	@FindBy(xpath="//input[@name='targetsize']")
	protected WebElement target_size;
	@FindBy(xpath="//input[@name='budgetcost']")
	protected WebElement budget;
	@FindBy(xpath="//input[@name='actualcost']")
	protected WebElement actual_cost;
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
	protected WebElement save;
	@FindBy(xpath="(//input[@title='Cancel [Alt+X]'])[1]")
	protected WebElement cancel;
	
}
