package org.crm.vtiger.evs.beta.tsLayer;

import java.util.List;

import org.crm.vtiger.evs.beta.homePage.HomePageLanding;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Setting_TestCases extends BaseTestCaseLayer{

	@Test
	public void ts001varifySettingModuleManagerCheakboxes() {
		
		HomePageLanding hpl=new HomePageLanding(utl);
		hpl.settings();
		hpl.clickSettingModuleManager();
		List<WebElement> cheakBox=utl.getdriver().findElements(By.xpath("//table[@id='modmgr_standard']//a//img[contains(@title,'Disable')]"));
		for(int i=0;i<cheakBox.size();i++) {
			WebElement singleCheak=cheakBox.get(i);
		boolean status=utl.isSelected(singleCheak);
		Assert.assertEquals(status, true);
	}
	}
	
	
}
