package org.crm.vtiger.evs.beta.marketing.accounts;

import org.crm.vtiger.evs.beta.Util.WebDriverUtil;
import org.openqa.selenium.support.PageFactory;

public class AccountsLandingPage extends AccountLandingPageObjectReposetry {

	
	public void accountCreation(WebDriverUtil utl) {
		utl.click(acc_create);
	}
	public void accountSearch(WebDriverUtil utl) {
		utl.click(acc_search);
	}
	public void accountCalender(WebDriverUtil utl) {
		utl.click(acc_calender);
	}
	public void accountImport(WebDriverUtil utl) {
		utl.click(acc_import);
	}
	public void accountExport(WebDriverUtil utl) {
		utl.click(acc_export);
	}
	public void accountSetting(WebDriverUtil utl) {
		utl.click(acc_setting);
	}
	public void accountsearchFor(WebDriverUtil utl,String searchData) {
		utl.sendKey(acc_searchFor,""+searchData+"");
	}
	public void accountSearchSelect(WebDriverUtil utl,String textOrvalue) {
		utl.selectByVisibleTextOrValue(acc_searchSelect, textOrvalue);
	}
	public void accountSearchNowBtn(WebDriverUtil utl) {
		utl.click(acc_searchNowBtn);
	}
public AccountsLandingPage(WebDriverUtil utl) {
PageFactory.initElements(utl.getdriver(), this);
}	
}
