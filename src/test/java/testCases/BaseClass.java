package testCases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{
	public static String browser= "chrome";
	public static WebDriver driver;
	public String baseURL= "https://www.facebook.com/login.php";
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	public static Logger logger;
	
	
	@BeforeTest
	 public void setExtent() {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp		 
		String repName="Test-Report-"+timeStamp+".html";
		
		// specify location of the report
	  htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "\\test-output\\"+repName);
	  
	  htmlReporter.config().setDocumentTitle("Facebook Automation Test Report"); // Title of report
	  htmlReporter.config().setReportName("AssignmentProject Test Report"); // Name of the report
	  htmlReporter.config().setTheme(Theme.DARK);
	  
	  extent = new ExtentReports();
	  extent.attachReporter(htmlReporter);
	  
	  // Passing General information
	  extent.setSystemInfo("Host name", "localhost");
	  extent.setSystemInfo("Environemnt", "QA");
	  extent.setSystemInfo("user", "Mosharof Hossain");
	  extent.setSystemInfo("Browser", "Chrome");
	 }
	
	@AfterTest
	public void endReport() {
		extent.flush();
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException
	{
		logger= Logger.getLogger("eReturn Test");
		PropertyConfigurator.configure("log4j.properties");
		
		if(browser.equals("Firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}else if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}else if (browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		
		driver.get(baseURL);
		 
		driver.manage().window().maximize();
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	}
		
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		String dateName = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname +dateName+ ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
}
