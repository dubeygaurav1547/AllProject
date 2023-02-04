package org.crm.vtiger.evs.beta.tsLayer;

import org.crm.vtiger.evs.beta.Util.WebDriverUtil;
import org.crm.vtiger.evs.beta.homePage.HomePageLanding;
import org.crm.vtiger.evs.beta.login.LoginPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BaseTestCaseLayer {

	protected WebDriverUtil utl;	
	
	@BeforeTest
	public void report() {
		System.out.println("Testing is Start");
	}
	@AfterTest
	public void report1() {
		System.out.println("Testing is End");
	}

	@Parameters("browser")
	@BeforeClass
	public void tsLaunchBrowser(String browserName) {
		utl=new WebDriverUtil();
		utl.launchBroWser(browserName);
		utl.login("http://localhost:8888");

	}
	@AfterClass
	public void tsCloseBrowser() {
		utl.closeBrowser();

	}


	@Parameters({"userName","pwd"})
	@BeforeMethod
	public void tsloginPage(String userName,String pwd) {

		LoginPage lopg= new LoginPage(utl);
		//lopg.invalidLogin(utl);
		lopg.validLogin(userName,pwd);
	}
	@AfterMethod
	public void tslogout() {
		HomePageLanding hpl=new HomePageLanding(utl);
		hpl.signOut();

	}
}
