package testCases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;


import junit.framework.Assert;
import pageObjects.FBLoginPage;
import utilities.XLUtils;

public class FBLoginTest extends BaseClass{
	
	@Test(priority=1)
	public void LoginWithValidInput() throws InterruptedException, IOException
	{
		logger.info("FaceBook is open");
		
		FBLoginPage lnp = new FBLoginPage(driver);
		
		test=extent.createTest("Page Heading and PlaceHolder validation");
		
		test.createNode("Test Validation of Landing Page Title.\"Log in to Facebook\" is expected");
		Assert.assertEquals(driver.getTitle(), "Log in to Facebook");
		logger.info("Landing Page Title is :"+driver.getTitle());
		
		test.createNode("Page Heading Validation. \"Log in to Facebook\" is expected");
		Assert.assertEquals(lnp.LoginPageHeading(), "Log in to Facebook");
		logger.info("The Page Heading is:" + lnp.LoginPageHeading());
		

		test.createNode("Validate Placeholder of Email Field.\"Email address or phone number\" is expected");
		logger.info("Placeholder of Email Field is :"+lnp.getPlaceholderFldEmail());
		Assert.assertEquals(lnp.getPlaceholderFldEmail(), "Email address or phone number");	
		
		test.createNode("Validate Placeholder of Password Field. \"Password\" is expected");
		logger.info("Placeholder of Password Field is :"+lnp.getPlaceholderFldPassword());
		Assert.assertEquals(lnp.getPlaceholderFldPassword(), "Password");
		
		test.createNode("Validate The Text of Login Button. \"Log In\" is expected");
		logger.info("The Text of Login Button is :"+lnp.GetTxtBtnLogin());
		Assert.assertEquals(lnp.GetTxtBtnLogin(), "Log In");
		
		test.createNode("Validate The Login Button is Displayed or not. Displayed is expected");
		Assert.assertTrue(lnp.IsDispBtnLogin());
		logger.info("The Button is Displayed");
		
		test.createNode("Validate The Login Button is Enable or not. Enable is expected");
		Assert.assertTrue(lnp.IsEnblBtnLogin());
		logger.info("The Button is Enable");

	}
	
	@Test(dataProvider="FBLoginData", priority=2)
	public void LoginTestValidUserPass(String valUser, String valPwd, String invUser, String valdPwd, String vldUser, String invlPwd, String InvalidUser, String invalidPwd) throws InterruptedException, IOException
	{
		logger.info("Login test using valid user and password is start here");
		
		FBLoginPage lnp=new FBLoginPage(driver);
		
		test=extent.createTest("Login Test Using Valid Test Data");
		
		test.createNode("Enter Valid Email or Phone Number");		
		lnp.setTextFieldEmail(valUser);
		Thread.sleep(2000);
		Assert.assertEquals("mhsujan86@gmail.com", lnp.getTextFieldEmail());
		logger.info("The Text Field \"Email\" is Working Fine");
		
		test.createNode("Enter Valid Password");		
		lnp.setTextFieldPassword(valPwd);
		Thread.sleep(2000);
		Assert.assertEquals("sujan!cse", lnp.getTextFieldPassword());
		logger.info("The Text Field \"Password\" is Working Fine");
		
		
		test.createNode("Click on the Login Button");		
		lnp.ClickBtnLogin();
	}
	
	@Test(dataProvider="FBLoginData", priority=3)
	public void LoginTestValidUserInvPass(String valUser, String valPwd, String invUser, String valdPwd, String vldUser, String invlPwd, String InvalidUser, String invalidPwd) throws InterruptedException, IOException
	{
		logger.info("Login test using valid user and invalid password is start here");
		
		FBLoginPage lnp=new FBLoginPage(driver);
		
		test=extent.createTest("Login Test Using Valid user and Invalid password");
		
		test.createNode("Enter Valid Email or Phone Number");		
		lnp.setTextFieldEmail(vldUser);
		Thread.sleep(2000);
		Assert.assertEquals("mhsujan86@gmail.com", lnp.getTextFieldEmail());
		logger.info("The Text Field \"Email\" is Working Fine");
		
		test.createNode("Enter InValid Password");		
		lnp.setTextFieldPassword(invlPwd);
		Thread.sleep(2000);
		Assert.assertEquals("sujan!cse", lnp.getTextFieldPassword());
		logger.info("The Text Field \"Password\" is Working Fine");
		
		
		test.createNode("Click on the Login Button");		
		lnp.ClickBtnLogin();
	}
	
	@Test(priority=4)
	public void DoubleClick_LoginButton() throws InterruptedException
	{
		logger.info("Double click test is start here");		
		
		FBLoginPage lnp = new FBLoginPage(driver);
		
		test=extent.createTest("Double click test");
		
		test.createNode("Double click on the login button");
		WebElement loginButton = driver.findElement(By.xpath("//button[@id='loginbutton']"));
		Actions action = new Actions(driver);
		action.doubleClick(loginButton).build().perform();
		Thread.sleep(1000);
		WebElement validationMsg = driver.findElement(By.xpath("//a[contains(text(),'Find your account and log in.')]"));

		Assert.assertEquals(validationMsg.getText(), "Find your account and log in.");
		logger.info("Double click test is passed");
			
	}
	
	@Test(priority=5)
	public void RightClick_ForgotenAccount() throws InterruptedException
	{
		logger.info("Right click test is start here");		
		
		FBLoginPage lnp = new FBLoginPage(driver);
		
		test=extent.createTest("Right click test");
		
		test.createNode("Right click on the link text, \"Forgoten Account\"");
		WebElement Link_ForgotenAccount = driver.findElement(By.xpath("//a[contains(text(),'Forgotten account?')]"));
		Actions action = new Actions(driver);
		action.contextClick(Link_ForgotenAccount).build().perform();				
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		logger.info("Rright click test is passed");
			
	}
	//Implement Positioning method getLocation() and getSize
	@Test(priority=6)
	public void ImplPositioningMethod()
	{
		logger.info("Get coordinate dimension value of elements test is start here");
		FBLoginPage lnp = new FBLoginPage(driver);
		
		test=extent.createTest("Test to get coordinate and dimension value");
		
		test.createNode("Test to get coordinate");
		logger.info("X coordinate is: " + lnp.GetLocationBtnLogin().getX());
		logger.info("Y coordinate is: " + lnp.GetLocationBtnLogin().getY());
		
		test.createNode("Test to get dimension");
		logger.info("Login Button Width is: " + lnp.GetDimension().getWidth());
		logger.info("Login Button Height is: " + lnp.GetDimension().getHeight());
		
	}
	
	//Implement Positioning method getRect()
	@Test(priority=7)
	public void ImplPositioningMethod2()
	{
		logger.info("Get coordinate and dimension using getRect start here");
		FBLoginPage lnp = new FBLoginPage(driver);
		
		test=extent.createTest("Test to using getRect method");
		
		test.createNode("Test to get coordinate");
		logger.info("X coordinate is: " + lnp.GetCoordandDim().x);
		logger.info("Y coordinate is: " + lnp.GetLocationBtnLogin().y);
		
		test.createNode("Test to get dimension");
		logger.info("Login Button Width is: " + lnp.GetCoordandDim().getWidth());
		logger.info("Login Button Height is: " + lnp.GetCoordandDim().getHeight());
	}
	
	
	
	@DataProvider(name="FBLoginData")
	String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/testData/TestData.xlsx";
		
		int rownum=XLUtils.getRowCount(path, "FBLoginData");// FBLoginData is sheet name of excel file
		int colcount=XLUtils.getCellCount(path,"FBLoginData",1);
		
		String testdata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				testdata[i-1][j]=XLUtils.getCellData(path,"FBLoginData", i,j);
			}
				
		}
	return testdata;
	}
	
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "TEST CASE FAILED IS: " + result.getName()); // to add name in extent report
			test.log(Status.FAIL, "TEST CASE FAILED IS: " + result.getThrowable()); // to add error/exception in extent report
			String screenshotPath = FBLoginTest.getScreenshot(driver, result.getName());
			test.addScreenCaptureFromPath(screenshotPath);// adding screen shot
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, "Test Case SKIPPED IS " + result.getName());
		}
		else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, "Test Case PASSED IS: " + result.getName());
		}
		//driver.quit();
	}

	public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException {
		String dateName = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);

		// after execution, you could see a folder "FailedTestsScreenshots" under src folder
		String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	} 

}
