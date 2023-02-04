package org.crm.vtiger.evs.beta.base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BaseObjectReposetry {
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
	protected WebElement save;
	@FindBy(xpath="(//input[@title='Cancel [Alt+X]'])[1]")
	protected WebElement cancel;
}
