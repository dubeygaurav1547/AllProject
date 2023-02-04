package com.daphnish.CRM.pages.login;

import java.util.Properties;

import org.openqa.selenium.support.PageFactory;

import com.daphnish.CRM.pages.homePage.HomePageLanding;
import com.daphnish.CRM.util.WebDriverUtil;

public class LoginPage extends LoginPageObjectReposetary {

	private WebDriverUtil utl;
	private Properties prop;

	public HomePageLanding validLogin() {

		prop=utl.getPeoperties();
		String usr=prop.getProperty("userName");
		String pwd=prop.getProperty("password");
		utl.sendKey(user_name, usr,"UserName ");
		utl.sendKey(password, pwd,"PassWord");
		utl.click(login,"Login btn");		
		return new HomePageLanding(utl);
	}
	public LoginPage invalidLogin() {

		prop=utl.getPeoperties();
		//		Object userName=prop.setProperty("user", "555");
		//		String pwd=prop.setProperty("password", "555kjnjk").toString();
		utl.sendKey(user_name, "min","UserName ");
		utl.sendKey(password, "1545","PassWord");
		utl.click(login,"Login btn");
		return this;
	}
	public LoginPage(WebDriverUtil utl) {
		this.utl=utl;
		PageFactory.initElements(utl.getdriver(), this);
	}


}
