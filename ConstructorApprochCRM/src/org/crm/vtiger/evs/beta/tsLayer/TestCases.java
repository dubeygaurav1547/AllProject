package org.crm.vtiger.evs.beta.tsLayer;

import org.crm.vtiger.evs.beta.Util.WebDriverUtil;
import org.crm.vtiger.evs.beta.homePage.AboutUs;
import org.crm.vtiger.evs.beta.homePage.HomePageLanding;
import org.crm.vtiger.evs.beta.homePage.SignOutPage;
import org.crm.vtiger.evs.beta.inventry.invoice.InvoiceCreationPage;
import org.crm.vtiger.evs.beta.inventry.invoice.InvoiceLandingPage;
import org.crm.vtiger.evs.beta.inventry.submodule.InventrySubModule;
import org.crm.vtiger.evs.beta.login.LoginPage;
import org.crm.vtiger.evs.beta.login.Matching;
import org.crm.vtiger.evs.beta.marketing.accounts.AccountsCreationPage;
import org.crm.vtiger.evs.beta.marketing.accounts.AccountsLandingPage;
import org.crm.vtiger.evs.beta.marketing.campagn.CampaignCreationPage;
import org.crm.vtiger.evs.beta.marketing.campagn.CampaignLandingPage;
import org.crm.vtiger.evs.beta.marketing.submodules.MarketingSubModules;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCases extends BaseTestCaseLayer{

	@Test(priority = 2,groups = {"smoke","regression"})
	public void tsInvoiceCreation() {
		HomePageLanding hpl=new HomePageLanding(utl);
		hpl.inventry(utl);
		InventrySubModule ism=new InventrySubModule(utl);
		ism.invoiceClick(utl);
		InvoiceLandingPage ilp=new InvoiceLandingPage(utl);
		ilp.invoiceCreation(utl);
		InvoiceCreationPage icp=new InvoiceCreationPage(utl);
		icp.inputBasicInformation(utl);
		icp.save(utl);
		

	}

	@Test(priority = 1,groups= {"smoke"},enabled = true)
	public void tsMarketingCampaignCreation() {

		HomePageLanding homepg=new HomePageLanding(utl);
		homepg.marketing(utl);
		MarketingSubModules submarketing=new MarketingSubModules(utl);

		submarketing.campaign(utl);
		CampaignLandingPage camplandpg=new CampaignLandingPage(utl);
		camplandpg.createCampaign(utl);
		CampaignCreationPage campcreationpg=new CampaignCreationPage(utl);
		campcreationpg.basicInformationCreation(utl);

	}
	@Test(groups= {"regression"})
	public void tsHomePageAboutUs() {
		HomePageLanding homepg =new HomePageLanding(utl);
		homepg.openAboutUs(utl);
		AboutUs aboutus=new AboutUs(utl);
		aboutus.windowHandle();
		aboutus.closeAboutus();
	}
	@Test(enabled = true, groups= {"smoke"})
	public void tsAccount() {

		HomePageLanding homepg =new HomePageLanding(utl);
		homepg.marketing(utl);
		MarketingSubModules mrs=new MarketingSubModules(utl);
		mrs.account(utl);
		AccountsLandingPage ld=new AccountsLandingPage(utl);
		ld.accountCreation(utl);
		AccountsCreationPage cr=new AccountsCreationPage(utl);
		cr.accountName(utl);
		cr.accountAssignTo(utl);


	}

}
