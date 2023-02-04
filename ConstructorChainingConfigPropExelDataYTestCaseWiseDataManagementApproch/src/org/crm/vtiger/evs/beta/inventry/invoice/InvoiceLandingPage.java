package org.crm.vtiger.evs.beta.inventry.invoice;

import org.crm.vtiger.evs.beta.Util.WebDriverUtil;
import org.crm.vtiger.evs.beta.homePage.HomePageLanding;
import org.openqa.selenium.support.PageFactory;

public class InvoiceLandingPage extends InvoiceLandingPageOR {

	private WebDriverUtil utl; 

	public InvoiceCreationPage invoiceCreation() {
		utl.click(createBtn);
		InvoiceCreationPage icp=new InvoiceCreationPage(utl);
		return icp;

	}
	public InvoiceLandingPage(WebDriverUtil utl) {
		this.utl=utl;
		PageFactory.initElements(utl.getdriver(), this);
	}

}
