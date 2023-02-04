package org.crm.vtiger.evs.beta.marketing.accounts;

import org.crm.vtiger.evs.beta.Util.WebDriverUtil;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.PageFactory;

public class AccountsCreationPage extends AccountCreationObjectReposetary {
	private WebDriverUtil utl;


	public void accountBasicInfo() {
		utl.sendKey(acc_name, "AEAL");
		utl.click(acc_assignTo);
	}
	
		
	public AccountsDetailsPage accountSave() {
		utl.click(save);
		try {
		utl.alertAccept();
		}catch(NoAlertPresentException e) {
			System.out.println("Item is Unique");
		}
		AccountsDetailsPage adp=new AccountsDetailsPage();
		return adp;
	}
	public AccountsCreationPage accountCancel() {
		utl.click(cancel);
		return this;
	}
	public AccountsCreationPage(WebDriverUtil utl) {

		this.utl=utl;
		PageFactory.initElements(utl.getdriver(), this);
	}

}
