package org.crm.vtiger.evs.beta.inventry.invoice;

import org.crm.vtiger.evs.beta.Util.WebDriverUtil;
import org.crm.vtiger.evs.beta.homePage.HomePageLanding;
import org.openqa.selenium.support.PageFactory;

public class InvoiceLandingPage extends InvoiceLandingPageOR {
	
	public void invoiceCreation(WebDriverUtil utl) {
		utl.click(createBtn);
				
	}
	public InvoiceLandingPage(WebDriverUtil utl) {
PageFactory.initElements(utl.getdriver(), this);
	}

}
