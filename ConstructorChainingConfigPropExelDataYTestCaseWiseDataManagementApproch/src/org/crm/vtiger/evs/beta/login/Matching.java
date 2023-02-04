package org.crm.vtiger.evs.beta.login;

import org.crm.vtiger.evs.beta.Util.WebDriverUtil;

public class Matching {
	

	public void titleMatch(WebDriverUtil utl,String expectedTitle,String PageName) {
		
		String actualTitle=utl.getTitle();

		if(actualTitle.contains(expectedTitle)) {
			System.out.println(PageName+"Title Matched");
		}else {
			System.out.println(PageName+" title not matched");
		}

	}
	public void urlMatch(WebDriverUtil utl,String expectedURL,String PageName) {
		String actualURL=utl.getURL();

		if(actualURL.contains(expectedURL)) {
			System.out.println(PageName+"URL Matched");
		}else {
			System.out.println(PageName+" URL not matched");
		}


	}
}
