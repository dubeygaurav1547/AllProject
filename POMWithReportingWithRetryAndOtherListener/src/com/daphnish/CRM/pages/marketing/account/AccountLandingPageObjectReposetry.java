package com.daphnish.CRM.pages.marketing.account;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.daphnish.CRM.pages.common.BaseObjectReposetry;

public class AccountLandingPageObjectReposetry extends BaseObjectReposetry{

	@FindBy(xpath="//img[@alt='Create Account...']")
	protected WebElement acc_create;
	@FindBy(xpath="//img[@alt='Search in Accounts...']")
	protected WebElement acc_search_icon;
	@FindBy(xpath="//img[@alt='Open Calendar...']")
	protected WebElement acc_calender;
	@FindBy(xpath="//img[@alt='Import Accounts']")
	protected WebElement acc_import;
	@FindBy(xpath="//img[@alt='Export Accounts']")
	protected WebElement acc_export;
	@FindBy(xpath="//img[@alt='Accounts Settings']")
	protected WebElement acc_setting;
	@FindBy(xpath="//input[@name='search_text']")
	protected WebElement acc_searchFor;
	@FindBy(xpath="(//select[@id='bas_searchfield'])[1]")
	protected WebElement acc_searchSelect;
	@FindBy(xpath="//input[@name='submit']")
	protected WebElement acc_searchNowBtn;

	public WebElement searchNowbtn() {
		return acc_searchNowBtn;
	}
}
