package org.crm.vtiger.evs.beta.login;

import org.crm.vtiger.evs.beta.Util.WebDriverUtil;
import org.crm.vtiger.evs.beta.homePage.HomePageLanding;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends LoginPageObjectReposetary {

	public void validLogin(WebDriverUtil utl) {
		
		utl.sendKey(user_name, "admin");
		utl.sendKey(password, "admin");
        utl.click(login);		
        Matching match=new Matching();
        match.titleMatch(utl,"admin - My Home Page - Home - vtiger CRM 5 - Commercial Open Source CRM","HomePage");
	
	}
	public LoginPage invalidLogin(WebDriverUtil utl) {
		
		utl.sendKey(user_name, "min");
		utl.sendKey(password, "1545");
        utl.click(login);
        Matching match=new Matching();
        match.titleMatch(utl,"admin - My Home Page - Home - vtiger CRM 5 - Commercial Open Source CRM","HomePage");
        
        return this;
	}
public LoginPage(WebDriverUtil utl) {
	PageFactory.initElements(utl.getdriver(), this);
}

	
}
