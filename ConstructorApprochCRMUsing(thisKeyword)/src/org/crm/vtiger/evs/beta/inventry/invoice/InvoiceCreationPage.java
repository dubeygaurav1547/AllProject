package org.crm.vtiger.evs.beta.inventry.invoice;

import org.crm.vtiger.evs.beta.Util.WebDriverUtil;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.PageFactory;

public class InvoiceCreationPage extends InvoiceCreationPageOR {

	public void inputBasicInformation(WebDriverUtil utl) {
		utl.sendKey(subject_name, "Wipro");
		utl.click(account_name);
		utl.windowHandlesByURL("http://localhost:8888/index.php?module=Accounts&action=Popup&popuptype=specific_account_address&form=TasksEditView&form_submit=false&fromlink=");
		utl.click(account_name_item);
		try {
			utl.alertAccept();
		}catch (NoAlertPresentException e) {
			System.out.println("Unique Item Selected");
		}
		utl.windowHandlesByURL("http://localhost:8888/index.php?module=Invoice&action=EditView&return_action=DetailView&parenttab=Inventory");
		utl.sendKey(billing_add, "Mondh S.R.N. Bhadohi");
		utl.click(copy_billing_add);
		utl.click(item_name);
		utl.windowHandlesByURL("http://localhost:8888/index.php?module=Products&action=Popup&html=Popup_picker&select=enable&form=HelpDeskEditView&popuptype=inventory_prod&curr_row=1&return_module=Invoice&currencyid=1");
		utl.click(item_name_text);
		utl.windowHandlesByURL("http://localhost:8888/index.php?module=Invoice&action=EditView&return_action=DetailView&parenttab=Inventory");
		utl.sendKey(item_quantity, "20");
	}
	public void save(WebDriverUtil utl) {
		utl.click(save);
	}
	public void cancel(WebDriverUtil utl) {
		utl.click(cancel);

	}
	public InvoiceCreationPage(WebDriverUtil utl) {
		PageFactory.initElements(utl.getdriver(), this);
	}
}
