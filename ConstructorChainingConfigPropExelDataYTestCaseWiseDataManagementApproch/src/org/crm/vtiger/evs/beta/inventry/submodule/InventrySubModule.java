package org.crm.vtiger.evs.beta.inventry.submodule;

import org.crm.vtiger.evs.beta.Util.WebDriverUtil;
import org.crm.vtiger.evs.beta.inventry.invoice.InvoiceLandingPage;
import org.openqa.selenium.support.PageFactory;

public class InventrySubModule extends InventrySubModuleOR{

	private WebDriverUtil utl;

	public InvoiceLandingPage invoiceClick() {

		utl.click(invoice);
		InvoiceLandingPage ilp=new InvoiceLandingPage(utl);
		return ilp;
	}
	public InventrySubModule(WebDriverUtil utl) {
		this.utl=utl;
		PageFactory.initElements(utl.getdriver(), this);
	}
}
