package com.daphnish.CRM.pages.marketing.account;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import com.daphnish.CRM.util.WebDriverUtil;

public class AccountsLandingPage extends AccountLandingPageObjectReposetry {

	private WebDriverUtil utl;



	public void clickAccountCreationBtn() {
		utl.click(acc_create,"Account Create btn");
	}
	public void clickAccountSearchIcon() {
		utl.click(acc_search_icon,"Account Search icon");
	}
	public void clickAccountCalender() {
		utl.click(acc_calender,"Account calender btn");
	}
	public void clickAccountImport() {
		utl.click(acc_import,"Account import btn");
	}
	public void clickAccountExport() {
		utl.click(acc_export,"Account export btn");
	}
	public void clickAccountSetting() {
		utl.click(acc_setting,"Account setting btn");
	}
	public void clickAccountSearchFor(String searchData) {
		utl.sendKey(acc_searchFor,""+searchData+"","Account Search Box");
	}
	public void accountSearchDropdown(String textOrvalue) {
		utl.selectByVisibleTextOrValue(acc_searchSelect, textOrvalue);
	}
	public void clickAccountSearchNowBtn() {
		utl.click(acc_searchNowBtn,"SearchNow btn");
	}
	public void cheakSearchFunctionality(String searchData,String valueOrVisibleText,String snapShotName) {
		clickAccountSearchFor(searchData);
		accountSearchDropdown(valueOrVisibleText);
		clickAccountSearchNowBtn();
		utl.isDisplay(utl.getdriver().findElement(By.xpath("//a[text()='"+searchData+"']")), snapShotName);
	}

	public AccountsLandingPage(WebDriverUtil utl) {
		this.utl=utl;
		PageFactory.initElements(utl.getdriver(), this);
	}	
}
