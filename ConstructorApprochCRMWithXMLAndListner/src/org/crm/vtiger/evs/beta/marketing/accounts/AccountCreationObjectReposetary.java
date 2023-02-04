package org.crm.vtiger.evs.beta.marketing.accounts;

import org.crm.vtiger.evs.beta.base.BaseObjectReposetry;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountCreationObjectReposetary extends BaseObjectReposetry{

	@FindBy(xpath="//input[@name='accountname']")
	protected WebElement acc_name;
	@FindBy(xpath="//input[@value='T']")
	protected WebElement acc_assignTo;
}
