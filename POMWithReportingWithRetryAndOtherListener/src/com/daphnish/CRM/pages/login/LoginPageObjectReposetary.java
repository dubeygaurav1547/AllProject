package com.daphnish.CRM.pages.login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageObjectReposetary {

	@FindBy(xpath="//input[@name='user_name']")
	protected WebElement user_name;
	@FindBy(xpath="//input[@name='user_password']")
	protected WebElement password;
    @FindBy(xpath="//input[@name='Login']")
	protected WebElement login;
	

}
