package AdminPages;

import org.openqa.selenium.By;

import TestTakerPages.BasePage;
import Utilities.Util;

public class AdminLoginPage extends BasePage{
	
	public AdminLoginPage()
	{
		super();
	}
	
	
	By examNumber = By.cssSelector("input[type='text']");
	By password = By.cssSelector("input[type='password']");
	By loginBtn = By.cssSelector("button[type='submit']");
	By clearLoginLink = By.xpath("(//li[@routerlinkactive='active'])[5]");
	By exameeNumberTextBox = By.cssSelector("div[class='user_key_box pt-1']");
	By candidateSearch = By.xpath("(//input[@type='text'])[2]");
	By searchBtn = By.xpath("//*[@class='fas fa-search edu-search']");
	By radioBtn	= By.xpath("//input[@type='radio']");
	By chooseBtn = By.cssSelector(".btn.btn-edulabs.color-secondary");
	By clearLoginBtn = By.xpath("//button[@type='submit']");
	By confirmClearYesBtn = By.xpath("//button[@class='btn btn-success']");
	
	public void enterUserName(String num)
	{
		driver.findElement(examNumber).sendKeys(num);
	}
	
	public void enterPassword(String pass)
	{
		driver.findElement(password).sendKeys(pass);
	}
	
	public void clicOnloginBtn()
	{
		driver.findElement(loginBtn).click();
	}
	
	public HomePage getAdminLogin(String num, String pass)
	{
		enterUserName(num);
		enterPassword(pass);
		clicOnloginBtn();
		return new HomePage();
	}
	
	
	public void clickOnClearLogin()
	{
		driver.findElement(clearLoginLink).click();
	}
	
	public void clickOnExameeNumberTextBox()
	{
		driver.findElement(exameeNumberTextBox).click();
	}
	
	public void clickOnCandidateSearch()
	{
		driver.findElement(candidateSearch).sendKeys(prop.getProperty("examNumber"));
	}
	
	public void clickOnSearchBtn()
	{	Util ut = new Util();
		ut.explicitWait(searchBtn);
		driver.findElement(searchBtn).click();
	}
	
	public void clickOnExamNumerRadioBtn()
	{
		driver.findElement(radioBtn).click();
	}
	
	public void clickOnChooseBtn()
	{
		driver.findElement(chooseBtn).click();
	}
	
	public void clickOnClearLoginBtn()
	{
		driver.findElement(clearLoginBtn).click();
	}
	
	public void clickOnConfirmClearYesBtn()
	{
		driver.findElement(confirmClearYesBtn).click();
	}
	
	
	public void getClearLogin()
	{
		getAdminLogin(prop.getProperty("adminId"),prop.getProperty("adminPass"));
		clickOnClearLogin();
		clickOnExameeNumberTextBox();
		clickOnCandidateSearch();
		clickOnSearchBtn();
		clickOnExamNumerRadioBtn();
		clickOnChooseBtn();
		clickOnClearLoginBtn();
		clickOnConfirmClearYesBtn();
		driver.close();
	}
	
	
}
