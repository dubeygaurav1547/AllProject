package org.crm.vtiger.evs.beta.tsLayer;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

public class AfterMassage implements ITestListener {
	
	@Test
	@Override
	public void onStart(ITestContext context) {
		System.out.println(context.getName()+"test case started");
	}
	@Test
	@Override
	public void onTestFailure(ITestResult result) {
		ITestListener.super.onTestFailure(result);
		System.out.println("The name of the testcase Fail is "+result.getName()+"");
		
	}
	@Test
	@Override
	public void onTestSuccess(ITestResult result) {
		
		ITestListener.super.onTestSuccess(result);
		System.out.println("The name of the testcase Pass is "+result.getName());
	}
	@Test
	@Override
	public void onTestSkipped(ITestResult result) {
		ITestListener.super.onTestSkipped(result);
		System.out.println("The name of the testcase Skipped is "+result.getName());
	}
}
