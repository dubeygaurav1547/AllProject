package org.crm.vtiger.evs.beta.marketing.accounts;

import org.crm.vtiger.evs.beta.Util.WebDriverUtil;
import org.openqa.selenium.support.PageFactory;

public class AccountsLandingPage extends AccountLandingPageObjectReposetry {

	private WebDriverUtil utl;

	
	public void accountCreation() {
		utl.click(acc_create);
	}
	public void accountSearch() {
		utl.click(acc_search);
	}
	public void accountCalender() {
		utl.click(acc_calender);
	}
	public void accountImport() {
		utl.click(acc_import);
	}
	public void accountExport() {
		utl.click(acc_export);
	}
	public void accountSetting() {
		utl.click(acc_setting);
	}
	public void accountsearchFor(WebDriverUtil utl,String searchData) {
		utl.sendKey(acc_searchFor,""+searchData+"");
	}
	public void accountSearchSelect(WebDriverUtil utl,String textOrvalue) {
		utl.selectByVisibleTextOrValue(acc_searchSelect, textOrvalue);
	}
	public void accountSearchNowBtn() {
		utl.click(acc_searchNowBtn);
	}
public AccountsLandingPage(WebDriverUtil utl) {
	this.utl=utl;
PageFactory.initElements(utl.getdriver(), this);
}	
}
