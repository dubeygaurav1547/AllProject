package org.crm.vtiger.evs.beta.inventry.invoice;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InvoiceLandingPageOR {

	@FindBy(xpath="//img[@title='Create Invoice...']")
	protected WebElement createBtn;
}
