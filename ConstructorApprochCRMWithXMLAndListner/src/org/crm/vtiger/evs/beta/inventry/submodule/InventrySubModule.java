package org.crm.vtiger.evs.beta.inventry.submodule;

import org.crm.vtiger.evs.beta.Util.WebDriverUtil;
import org.openqa.selenium.support.PageFactory;

public class InventrySubModule extends InventrySubModuleOR{

	public void invoiceClick(WebDriverUtil utl) {
		
		utl.click(invoice);
	}
	public InventrySubModule(WebDriverUtil utl) {
PageFactory.initElements(utl.getdriver(), this);
	}
}
