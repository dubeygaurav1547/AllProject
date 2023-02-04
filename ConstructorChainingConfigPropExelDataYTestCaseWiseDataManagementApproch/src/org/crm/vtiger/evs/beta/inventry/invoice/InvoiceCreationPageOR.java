package org.crm.vtiger.evs.beta.inventry.invoice;

import org.crm.vtiger.evs.beta.base.BaseObjectReposetry;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InvoiceCreationPageOR extends BaseObjectReposetry {
	
	@FindBy(xpath="//input[@name='subject']")
	protected WebElement subject_name;
	@FindBy(xpath="//input[@name='customerno']")
	protected WebElement customer_Name;
	@FindBy(xpath="//input[@name='exciseduty']")
	protected WebElement excise_duty;
	@FindBy(xpath="(//img[@alt='Select'])[3]")
	protected WebElement account_name;
	@FindBy(xpath="//input[@name='vtiger_purchaseorder']")
	protected WebElement purchase_order;
	@FindBy(xpath="//input[@name='vtiger_purchaseorder']")
	protected WebElement sale_commision;
	@FindBy(xpath="//textarea[@name='bill_street']")
	protected WebElement billing_add;
	@FindBy(xpath="(//input[@name='cpy'])[2]")
	protected WebElement copy_billing_add;
    @FindBy(xpath="//img[@id='searchIcon1']")
	protected WebElement item_name;
    @FindBy(xpath="//input[@id='qty1']")
    protected WebElement item_quantity;
    @FindBy(linkText = "PM")
    protected WebElement account_name_item;
    @FindBy(linkText = "Iphone")
    protected WebElement item_name_text;
}
