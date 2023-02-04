package org.crm.vtiger.evs.beta.tsLayer;

import org.crm.vtiger.evs.beta.homePage.AboutUs;
import org.crm.vtiger.evs.beta.homePage.HomePageLanding;
import org.crm.vtiger.evs.beta.inventry.invoice.InvoiceCreationPage;
import org.crm.vtiger.evs.beta.inventry.invoice.InvoiceDetailsPage;
import org.crm.vtiger.evs.beta.inventry.invoice.InvoiceLandingPage;
import org.crm.vtiger.evs.beta.inventry.submodule.InventrySubModule;
import org.crm.vtiger.evs.beta.marketing.accounts.AccountsCreationPage;
import org.crm.vtiger.evs.beta.marketing.accounts.AccountsDetailsPage;
import org.crm.vtiger.evs.beta.marketing.accounts.AccountsLandingPage;
import org.crm.vtiger.evs.beta.marketing.campagn.CampaignCreationPage;
import org.crm.vtiger.evs.beta.marketing.campagn.CampaignDetailsPage;
import org.crm.vtiger.evs.beta.marketing.campagn.CampaignLandingPage;
import org.crm.vtiger.evs.beta.marketing.submodules.MarketingSubModules;
import org.testng.annotations.Test;

public class TestCases extends BaseTestCaseLayer{

	@Test(priority = 1,groups = {"smoke","regression"})
	public void tsInvoiceCreation() {
		HomePageLanding hpl=new HomePageLanding(utl);
		InventrySubModule ism=	hpl.inventry();
		InvoiceLandingPage ilp=ism.invoiceClick();
		InvoiceCreationPage icp=ilp.invoiceCreation();
		icp.inputBasicInformation();
		InvoiceDetailsPage idp=icp.save();
	}

	@Test(priority = 2,groups= {"smoke"},enabled = true)
	public void tsMarketingCampaignCreation() {

		HomePageLanding homepg=new HomePageLanding(utl);
		MarketingSubModules submarketing=homepg.marketing();

		CampaignLandingPage camplandpg=submarketing.campaign();
		CampaignCreationPage campcreationpg=camplandpg.createCampaign();
		campcreationpg.basicInformationCreation();
		CampaignDetailsPage cdp=campcreationpg.saveCamp();

	}
	@Test(priority=3,groups= {"regression"})
	public void tsHomePageAboutUs() {
		HomePageLanding homepg =new HomePageLanding(utl);
		homepg.openAboutUs();
		AboutUs aboutus=new AboutUs(utl);
		aboutus.windowHandle();
		aboutus.closeAboutus();
	}
	@Test(priority=4,enabled = true, groups= {"smoke"})
	public void tsAccount() {

		HomePageLanding homepg =new HomePageLanding(utl);
		MarketingSubModules mrs=homepg.marketing();
		AccountsLandingPage alp=mrs.account();
		AccountsCreationPage cr=alp.accountCreation();
		cr.accountBasicInfo();;
		AccountsDetailsPage adp=cr.accountSave();


	}

}
