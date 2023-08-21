package TestTakerPages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;

import AdminPages.AdminLoginPage;
import AdminPages.HomePage;

public class LoginPage extends BasePage{
	
	HomePage hp = new HomePage();
	AdminLoginPage alp = new AdminLoginPage();
	
	public LoginPage()
	{
		super();
		
	}
	
	
	By examNumber = By.cssSelector("input[type='text']");
	By password = By.cssSelector("input[type='password']");
	By loginBtn = By.cssSelector("button[type='submit']");
	By error = By.cssSelector("div[class='error']");
	
	public void enterUserName(String num)
	{
		driver.findElement(examNumber).sendKeys(num);
	}
	
	public void enterPassword(String pass)
	{
		driver.findElement(password).sendKeys(pass);
	}
	
	public DashBoard clickOnLoginBtn()
	{
		driver.findElement(loginBtn).click();
		try {
		if(driver.findElement(error).isDisplayed())
		{
			driver.switchTo().newWindow(WindowType.TAB).get("https://gastrodoctor-dev.edulabcbt.com/#/auth/login");
			
			Set<String> win = driver.getWindowHandles();
			Iterator<String> iter = win.iterator();
			String parWin = iter.next();
			String childWin = iter.next();
			
			driver.switchTo().window(childWin);
			
			alp.getClearLogin();
			
			driver.switchTo().window(parWin);
			driver.findElement(loginBtn).click();
			
		}
		}catch(Exception e)
		{
			//ignore
		}
		return new DashBoard();
	}
	
	
}
