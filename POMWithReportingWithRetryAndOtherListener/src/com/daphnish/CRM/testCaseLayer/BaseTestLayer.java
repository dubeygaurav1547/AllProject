package com.daphnish.CRM.testCaseLayer;

import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;
import com.daphnish.CRM.pages.homePage.HomePageLanding;
import com.daphnish.CRM.pages.login.LoginPage;
import com.daphnish.CRM.util.WebDriverUtil;

public class BaseTestLayer {

	protected WebDriverUtil utl;

	@BeforeSuite
	public void loadReport() {
		utl=new WebDriverUtil();
	}

	@Parameters({"browser"})
	@BeforeTest
	public void loadReport1(String browserName) {
		utl.initilizeExtentReport("reports\\result_"+browserName, "CRM", "Validation", "Er. Gaurav");
		System.out.println("Testing is start");
	}

	@BeforeClass
	public void launchBrowserAndHitURL() {
		utl.launchBroWser("chrome");
		utl.geturl("http://localhost:8888");
	}
	@AfterClass
	public void closeBrowser() {
		utl.closeBrowser();
	}
	@BeforeMethod
	public void login(Method  m) {
		String tsName=m.getName();
		utl.createTest(tsName);
		LoginPage lp=new LoginPage(utl);
		lp.validLogin();

	}
	@AfterMethod
	public void logOut(ITestResult result,Method m) {

		int status=result.getStatus();
		if(status==ITestResult.FAILURE) {
			String imgPath=utl.takesSnapShot(m.getName());
			utl.attachSnapshotToExtentReport(imgPath);
		}

		HomePageLanding hpl=new HomePageLanding(utl);
		hpl.signOut();
	}
	@AfterTest
	public void flushReport() {
		utl.flushReport();
	}
	@AfterSuite
	public void getReport() {
		utl.flushReport();

	}
}
