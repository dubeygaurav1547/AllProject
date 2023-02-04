package org.crm.vtiger.evs.beta.tsLayer;
//String companyName2="tcs";
//String address2="bhadohi";
//String quantity2="40";
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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestCases extends BaseTestCaseLayer{

	@DataProvider
	public Object[][] provideInvoiceData() {
		///  data  wipro
//		Object companyName1="wipro";
//		Object address1="Mondh";
//		Object quantity1="20";
//		
//		Object companyName2="tcs";
//		Object address2="bhadohi";
//		Object quantity2="50";
//		
//		Object companyName3="hcl";
//		Object address3="varanasi";
//		Object quantity3="30";
//		
//		Object[] dataArray1= {companyName1, address1, quantity1};
//		Object[] dataArray2= {companyName2, address2, quantity2};
//		Object[] dataArray3= {companyName3, address3, quantity3};
//		Object[] dataArray4= {"nst", "noida", "60"};
//		Object[] dataArray5= {"evs", "dundwa", "70"};
				
		
		//Object[][] finalDataArray= {dataArray1, dataArray2, dataArray3, dataArray4, dataArray5};
//	      Object[][] finalDataArray=new Object[5][3];
//	      finalDataArray[0]=dataArray1;
//	      finalDataArray[1]=dataArray2;
//	      finalDataArray[2]=dataArray3;
//	      finalDataArray[3]=dataArray4;
//	      finalDataArray[4]=dataArray5;
	      
	      Object[][] finalDataArray=new Object[5][4];
	      finalDataArray[0][0]="infosys";
	      finalDataArray[0][1]="mondh";
	      finalDataArray[0][2]="20";
	      finalDataArray[0][3]="india";
	      
	      finalDataArray[1][0]="tcs";
	      finalDataArray[1][1]="bhadohi";
	      finalDataArray[1][2]="40";
	      finalDataArray[1][3]="usa";
	      
	      finalDataArray[2][0]="hcl";
	      finalDataArray[2][1]="varanasi";
	      finalDataArray[2][2]="26";
	      finalDataArray[2][3]="uk";
	      
	      finalDataArray[3][0]="evs";
	      finalDataArray[3][1]="noida";
	      finalDataArray[3][2]="36";
	      finalDataArray[3][3]="nepal";
	      
	      
	      finalDataArray[4][0]="hp";
	      finalDataArray[4][1]="banglore";
	      finalDataArray[4][2]="60";
	      finalDataArray[4][3]="srilanka";
	      
	      
	      ///   code   -------  Excel Automation Apache POI 
	      
	      
	      
	      
	      
		return finalDataArray;
				
		
		
		
	}
	
	
	
	@Test(dataProvider= "provideInvoiceData" ,priority = 2,groups = {"smoke","regression"})
	public void tsInvoiceCreation(Object compName, Object address, Object quantity, Object country) {
		
//	
//		 Object[][] finalDataArray=new Object[5][4];
//	      finalDataArray[0][0]="infosys";
//	      finalDataArray[0][1]="mondh";
//	      finalDataArray[0][2]="20";
//	      finalDataArray[0][3]="india";
//	      
//	      finalDataArray[1][0]="tcs";
//	      finalDataArray[1][1]="bhadohi";
//	      finalDataArray[1][2]="40";
//	      finalDataArray[1][3]="usa";
//	      
//	      finalDataArray[2][0]="hcl";
//	      finalDataArray[2][1]="varanasi";
//	      finalDataArray[2][2]="26";
//	      finalDataArray[2][3]="uk";
//	      
//	      finalDataArray[3][0]="evs";
//	      finalDataArray[3][1]="noida";
//	      finalDataArray[3][2]="36";
//	      finalDataArray[3][3]="nepal";
//	      
//	      
//	      finalDataArray[4][0]="hp";
//	      finalDataArray[4][1]="banglore";
//	      finalDataArray[4][2]="60";
//	      finalDataArray[4][3]="srilanka";
//		
//		for(int i=0; i<=finalDataArray.length-1;i++) {
//			Object[] dataArray=finalDataArray[i];
//			Object company=dataArray[0];
//			Object addressValue=dataArray[1];
//			Object quantityValue=dataArray[2];
//			Object countryName=dataArray[3];
		HomePageLanding hpl=new HomePageLanding(utl);
		hpl.inventry();
		InventrySubModule ism=new InventrySubModule(utl);
		ism.invoiceClick(utl);
		InvoiceLandingPage ilp=new InvoiceLandingPage(utl);
		ilp.invoiceCreation(utl);
		InvoiceCreationPage icp=new InvoiceCreationPage(utl);
		icp.inputBasicInformation(utl);
		icp.save(utl);
		//}

	}

	@Test(priority = 1,groups= {"smoke"},enabled = true)
	public void tsMarketingCampaignCreation() {

		HomePageLanding homepg=new HomePageLanding(utl);
		homepg.marketing();
		MarketingSubModules submarketing=new MarketingSubModules(utl);

		submarketing.campaign();
		CampaignLandingPage camplandpg=new CampaignLandingPage(utl);
		camplandpg.createCampaign();
		CampaignCreationPage campcreationpg=new CampaignCreationPage(utl);
		campcreationpg.basicInformationCreation();

	}
	@Test(groups= {"regression"})
	public void tsHomePageAboutUs() {
		HomePageLanding homepg =new HomePageLanding(utl);
		homepg.openAboutUs();
		AboutUs aboutus=new AboutUs(utl);
		aboutus.windowHandle();
		aboutus.closeAboutus();
	}
	@Test(enabled = true, groups= {"smoke"})
	public void tsAccount() {

		HomePageLanding homepg =new HomePageLanding(utl);
		homepg.marketing();
		MarketingSubModules mrs=new MarketingSubModules(utl);
		mrs.account();
		AccountsLandingPage ld=new AccountsLandingPage(utl);
		ld.accountCreation();
		AccountsCreationPage cr=new AccountsCreationPage(utl);
		cr.accountName("akash");
		cr.accountAssignTo();


	}

}
