package pageObjects;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FBLoginPage {
	
WebDriver ldriver;	

	public FBLoginPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}	
		
	@FindBy(xpath="//div[contains(text(),'Log in to Facebook')]")
	WebElement HeadingLoginPage ;
	
	public String LoginPageHeading()
	{
		return HeadingLoginPage.getText();
	}
	
	@FindBy(xpath="//input[@id='email']")
	WebElement TxtFieldEmail ;
	
	public String getPlaceholderFldEmail()
	{
		return TxtFieldEmail.getAttribute("placeholder");
	}
	
	public void setTextFieldEmail(String email_or_phone)
	{
		TxtFieldEmail.sendKeys(email_or_phone);
	}
	
	public String getTextFieldEmail()
	{
		return TxtFieldEmail.getAttribute("value");
	}
	
	
	@FindBy(xpath="//input[@id='pass']")
	WebElement TxtFieldPassword ;
	
	public String getPlaceholderFldPassword()
	{
		return TxtFieldPassword.getAttribute("placeholder");
	}
	
	public void setTextFieldPassword(String password)
	{
		TxtFieldPassword.sendKeys(password);
	}
	
	public String getTextFieldPassword()
	{
		return TxtFieldPassword.getAttribute("value");
	}
	
	@FindBy(xpath="//button[@id='loginbutton']")
	WebElement BtnLogin;
	
	public String GetTxtBtnLogin()
	{
		return BtnLogin.getText();
	}
	public Point GetLocationBtnLogin()
	{
		return BtnLogin.getLocation();
	}
	public Dimension GetDimension()
	{
		return BtnLogin.getSize();
	}
	
	public Rectangle GetCoordandDim()
	{
		return BtnLogin.getRect();
	}
	
	public boolean IsDispBtnLogin()
	{
		return BtnLogin.isDisplayed();
	}
	
	public boolean IsEnblBtnLogin()
	{
		return BtnLogin.isEnabled();
	}
	
	public void ClickBtnLogin()
	{
		BtnLogin.click();
	}
	
	public Action DoubleClick_LoginButton()
	{
		BtnLogin.click();
		return null;
	}
	
	@FindBy(xpath="//body/div[@id='u_0_0_Lo']/div[@id='globalContainer']/div[@id='content']/div[1]/div[2]/div[2]/form[1]/div[1]/div[1]/div[2]")
	WebElement ValidationMessage;
	
	public String Get_ValidationMessage()
	{
		return ValidationMessage.getText();
	}
	
	@FindBy(xpath="//a[contains(text(),'Forgotten account?')]")
	WebElement LinkForgotenAccount;
	
	public Action Link_ForgotenAccount()
	{
		LinkForgotenAccount.click();
		return null;
	}
	
	@FindBy(css="body.UIPage_LoggedOut._-kb._605a.b_c3pyn-ahh.chrome.webkit.win.x1.Locale_en_GB.cores-gte4._19_u:nth-child(2) div._li:nth-child(2) div.uiContextualLayerParent:nth-child(1) div.fb_content.clearfix:nth-child(1) div._4-u5._30ny div.help_identify div.mvl.ptm.uiInterstitial._9np_.uiInterstitialLarge.uiBoxWhite:nth-child(3) div.uiHeader.uiHeaderBottomBorder.mhl.mts.uiHeaderPage.interstitialHeader div.clearfix.uiHeaderTop div:nth-child(2) > h2.uiHeaderTitle")
	WebElement TitleFindYourAccount;
	public String Title_FindYourAccount()
	{
		return TitleFindYourAccount.getText();
	}
}
