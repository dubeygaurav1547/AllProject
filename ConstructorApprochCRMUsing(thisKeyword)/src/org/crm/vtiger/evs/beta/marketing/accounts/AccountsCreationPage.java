package org.crm.vtiger.evs.beta.marketing.accounts;

import org.crm.vtiger.evs.beta.Util.WebDriverUtil;
import org.openqa.selenium.support.PageFactory;

public class AccountsCreationPage extends AccountCreationObjectReposetary {
	private WebDriverUtil utl;


	public void accountName(String account_name) {
		utl.sendKey(acc_name, account_name);
	}
	public void accountAssignTo() {
		utl.click(acc_assignTo);
	}
	public void accountSave() {
		utl.click(save);
	}
	public void accountCancel() {
		utl.click(cancel);
	}
	public AccountsCreationPage(WebDriverUtil utl) {

		this.utl=utl;
		PageFactory.initElements(utl.getdriver(), this);
	}

}
