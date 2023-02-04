package org.crm.vtiger.evs.beta.Util;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportingClass {

	public static void main(String[] args) {
		
		ExtentHtmlReporter ehr=new ExtentHtmlReporter("reports\\result.html");
		ehr.config().setReportName("Vtiger Report");
		ehr.config().setDocumentTitle("Functional testing");
		ehr.config().setTheme(Theme.DARK);
		ExtentReports es=new ExtentReports();
		es.attachReporter(ehr);
		es.setSystemInfo("UserName", "EVS Group");
		es.setSystemInfo("OS", "Window10");
		
	ExtentTest et	= es.createTest("verify login functionality");
	et.log(Status.INFO, "Chrome is Launch");
	String actual="Login";
  String exp="xyz";
  if(actual.equalsIgnoreCase(exp)) {
	  et.log(Status.PASS, "TestCase is Pass Where actual"+actual+" and expected is"+exp);
  }
  else {
	  et.log(Status.FAIL, "TestCase is Pass Where actual"+actual+" and expected is"+exp);
  }
es.flush();
	}

}
