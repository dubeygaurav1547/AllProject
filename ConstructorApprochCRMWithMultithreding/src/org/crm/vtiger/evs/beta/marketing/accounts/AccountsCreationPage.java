package org.crm.vtiger.evs.beta.marketing.accounts;

import org.crm.vtiger.evs.beta.Util.WebDriverUtil;
import org.openqa.selenium.support.PageFactory;

public class AccountsCreationPage extends AccountCreationObjectReposetary {
	
	public void accountName(WebDriverUtil utl) {
		utl.sendKey(acc_name,"Google");
	}
	public void accountAssignTo(WebDriverUtil utl) {
		utl.click(acc_assignTo);
	}
	public void accountSave(WebDriverUtil utl) {
		utl.click(save);
	}
	public void accountCancel(WebDriverUtil utl) {
		utl.click(cancel);
	}
	public AccountsCreationPage(WebDriverUtil utl) {
PageFactory.initElements(utl.getdriver(), this);
	}

}
