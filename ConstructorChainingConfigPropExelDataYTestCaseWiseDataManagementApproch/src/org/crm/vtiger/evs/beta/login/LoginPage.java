package org.crm.vtiger.evs.beta.login;

import org.crm.vtiger.evs.beta.Util.WebDriverUtil;
import org.crm.vtiger.evs.beta.homePage.HomePageLanding;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends LoginPageObjectReposetary {

	private WebDriverUtil utl;


	public HomePageLanding validLogin(String userName,String pwd) {

		utl.sendKey(user_name, userName);
		utl.sendKey(password, pwd);
		utl.click(login);		
		Matching match=new Matching();
		match.titleMatch(utl,"admin - My Home Page - Home - vtiger CRM 5 - Commercial Open Source CRM","HomePage");

		HomePageLanding hpl=new HomePageLanding(utl);
		return hpl;
	}
	public LoginPage invalidLogin(String userName,String pwd) {

		utl.sendKey(user_name, userName);
		utl.sendKey(password, pwd);
		utl.click(login);
		Matching match=new Matching();
		match.titleMatch(utl,"admin - My Home Page - Home - vtiger CRM 5 - Commercial Open Source CRM","HomePage");

		return this;
	}
	public LoginPage(WebDriverUtil utl) {
		this.utl=utl;
		PageFactory.initElements(utl.getdriver(), this);
	}


}
