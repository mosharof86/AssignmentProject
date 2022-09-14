package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.FBLoginPage;

public class RightClick extends BaseClass {
	
	
	@Test(priority=4)
	public void RightClick_ForgotenAccount() throws InterruptedException
	{
				
		FBLoginPage lnp = new FBLoginPage(driver);
		
		test=extent.createTest("Page Heading and PlaceHolder validation");
		
		test.createNode("Right click on the link text, \"Forgoten Account\"");
		//WebElement forgotenPassword = driver.findElement(By.xpath("//a[contains(text(),'Forgotten account?')]"));
		Actions action = new Actions(driver);
		action.contextClick((WebElement) lnp.Link_ForgotenAccount()).build();
		action.perform();		
		Thread.sleep(2000);
		
		test.createNode(" Validate right click is working as expected");
		String expectedTitle= "";
		String actualTitle= driver.getTitle();
		System.out.println(actualTitle);
		
		driver.quit();
		
	}


}
