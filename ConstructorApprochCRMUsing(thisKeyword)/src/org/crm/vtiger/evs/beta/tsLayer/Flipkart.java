package org.crm.vtiger.evs.beta.tsLayer;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Flipkart {
	private WebDriver driver;

	@Test
	public void flipkartScenario() {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com/");
		List<WebElement> we=driver.findElements(By.xpath("//div[@class='IiD88i _351hSN']//label"));

		Assert.assertEquals(we.get(0).getText(),"Enter Email/Mobile number");

		Assert.assertEquals(we.get(1).getText(),"Enter Password");

		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		driver.findElement(By.xpath("//div[@class='xtXmba' and text()='Mobiles']")).click();
		Actions ac=new Actions(driver);

		ac.moveToElement(driver.findElement(By.xpath("//span[@class='_2I9KP_' and text()='Electronics']"))).build().perform();

		driver.findElement(By.xpath("//a[text()='Soundbars']")).click();
		WebElement product=driver.findElement(By.xpath("//a[@class='s1Q9rs']"));
		String text=product.getText();
		product.click();
		windowHandle("text");
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")).click();
		driver.findElement(By.xpath("//span[text()='Place Order']")).click();
		driver.findElement(By.xpath("//div[@class='IiD88i GtCYSF']//input")).sendKeys("dkyhgfhg");
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _20xBvF _3AWRsL']//span[text()='CONTINUE']")).click();
		String errorMassege=driver.findElement(By.xpath("//span[@class='_2YULOR']//span[text()='Please enter valid Email ID/Mobile number']")).getText();
		Assert.assertEquals(errorMassege, "Please enter valid Email ID/Mobile number");
		driver.close();
	}
	public void windowHandle(String expTitle) {
		Set<String> handlevalues=driver.getWindowHandles();
		Iterator<String>hndv =handlevalues.iterator();
		while(hndv.hasNext()) {
			String value=	hndv.next();
			driver.switchTo().window(value);
			String actualTitle=driver.getTitle();
			if(actualTitle.contains(expTitle)) {
				break;
			}
		}
	}

}

