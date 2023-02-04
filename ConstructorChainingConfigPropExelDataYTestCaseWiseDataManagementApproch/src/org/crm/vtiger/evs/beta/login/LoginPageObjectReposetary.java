package org.crm.vtiger.evs.beta.login;

import org.crm.vtiger.evs.beta.Util.WebDriverUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObjectReposetary {

	@FindBy(xpath="//input[@name='user_name']")
	protected WebElement user_name;
	@FindBy(xpath="//input[@name='user_password']")
	protected WebElement password;
    @FindBy(xpath="//input[@name='Login']")
	protected WebElement login;
	
//    public WebElement userName() {
//		return user_name;
//	}
//    public WebElement password() {
//		return password;
//	}
//    public WebElement login() {
//		return login;
//	}
//    
}
