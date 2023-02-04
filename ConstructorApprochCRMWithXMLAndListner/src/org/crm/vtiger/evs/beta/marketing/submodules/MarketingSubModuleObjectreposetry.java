package org.crm.vtiger.evs.beta.marketing.submodules;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MarketingSubModuleObjectreposetry {
	@FindBy(linkText="Campaigns")
	protected WebElement camp;
	@FindBy(linkText="Accounts")
	protected WebElement acc;
}
