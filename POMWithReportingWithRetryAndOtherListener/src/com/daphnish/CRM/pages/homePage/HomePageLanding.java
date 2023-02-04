package com.daphnish.CRM.pages.homePage;

import org.openqa.selenium.support.PageFactory;

import com.daphnish.CRM.pages.marketing.account.AccountsLandingPage;
import com.daphnish.CRM.util.WebDriverUtil;

public class HomePageLanding extends HomePageLandingOR{

	private WebDriverUtil utl;


	public void navigateToMyHomePage() {
		utl.moveToElement(my_home_page);

	}
	public void navigateToMarketing() {
		utl.moveToElement(marketing);

	}
	public AccountsLandingPage navigateAndOpenMarketingAccounts() {
		utl.click(marketing_acc,"Marketing Account");

		return new AccountsLandingPage(utl);
	}
	public void navigateAndOpenMarketingCampaign() {
		utl.click(marketing_camp," Marketing Campaign");

	}
	public void navigateToSales() {
		utl.moveToElement(sales);

	}
	public void navigateToSupport() {
		utl.moveToElement(support);


	}
	public void navigateToAnalytics() {
		utl.moveToElement(anaylytic);

	}
	public void navigateToInventry() {
		utl.moveToElement(inventry);
	}
	public void navigateToTools() {
		utl.moveToElement(tools);
	}
	public void navigateTosettings() {
		utl.moveToElement(setting);
	}
	public void openAboutUs() {
		utl.click(open_about_us,"AboutUs");
	}
	public void openFeedback() {

		utl.click(open_feedback,"FeedBack");
	}
	public void signOut() {

		utl.click(sign_out,"SignOut");

	}
	public HomePageLanding(WebDriverUtil utl) {
		this.utl=utl;
		PageFactory.initElements(utl.getdriver(), this);
	}

}
