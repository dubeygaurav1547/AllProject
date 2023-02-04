package com.daphnish.CRM.testCaseLayer;


import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.daphnish.CRM.pages.homePage.HomePageLanding;
import com.daphnish.CRM.pages.marketing.account.AccountsLandingPage;

public class VerifyAccountSearchFunctionality extends BaseTestLayer{

	
	@Test(enabled=true,groups= {"smoke"},retryAnalyzer = FailedRetryAnalyzer.class)
	public void ts001verifyAccountSearchTakeData() {
		HomePageLanding hpl=new HomePageLanding(utl);
		hpl.navigateToMarketing();
		AccountsLandingPage alp=hpl.navigateAndOpenMarketingAccounts();
		alp.cheakSearchFunctionality("akash", "Account Name","Search Data");

	}
	@Test(groups = {"regression"},enabled=true)
	public void ts002verifyAccountSearchNowIsWrittenOnbtn() {

		HomePageLanding hpl=new HomePageLanding(utl);
		hpl.navigateToMarketing();
		AccountsLandingPage alp=hpl.navigateAndOpenMarketingAccounts();
		WebElement weSearchNowBtn=alp.searchNowbtn();
//        Assert.assertEquals(weSearchNowBtn, "Search");
		utl.getTextValidation(weSearchNowBtn, "Search","SearchBtn text");

	}

}
