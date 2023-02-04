package org.crm.vtiger.evs.beta.inventry.submodule;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InventrySubModuleOR {

	@FindBy(xpath="(//a[text()='Invoice'])[4]")
	protected WebElement invoice;
	
}
