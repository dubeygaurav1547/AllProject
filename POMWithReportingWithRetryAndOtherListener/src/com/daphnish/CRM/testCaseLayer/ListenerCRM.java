package com.daphnish.CRM.testCaseLayer;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class ListenerCRM extends TestListenerAdapter{
	
	
	
	@Override
	public void onTestSuccess(ITestResult tr) {
		String name=tr.getName();
		System.out.println(name);
		
	}

}
