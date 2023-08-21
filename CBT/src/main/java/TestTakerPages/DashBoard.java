package TestTakerPages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;

import Utilities.Util;

public class DashBoard extends BasePage{
	
	Util ut =new Util();
	
	public DashBoard()
	{
		super();
	}
	
	By cbtExamName = By.xpath("//div[@class='t-select__object-title']");
	By examInfoBtn = By.cssSelector(".button.button--bg-blue.button--radius-small");
	By nextBtn = By.xpath("//span[@class='icon-next carousel-control-next-icon']");
	By toStartTestBtn = By.cssSelector(".button.button--bg-blue.button--radius-medium");
	By testStartBtn = By.xpath("/html[1]/body[1]/app-root[1]/app-student[1]/app-exam-countdown[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/button[1]");
	By popUpNoBtn = By.xpath("//body/ngb-modal-window[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/button[1]");

	
	public String getCbtExamText()
	{
		return driver.findElement(cbtExamName).getText();
	}
	
	public void clickOnExamInfoBtn()
	{
		try {
			ut.explicitWait(examInfoBtn);
			driver.findElement(examInfoBtn).click();
		}catch(Exception e)
		{
			//ignore
		}
		driver.findElement(examInfoBtn).click();
	}
	
	public void ClickOnNextBtn()
	{
		for(int i=1;i<=12;i++)
		{
			ut.explicitWait(nextBtn);
			driver.findElement(nextBtn).click();
		}
	}
	
	public void clickOnToStartTestBtn()
	{
		driver.findElement(toStartTestBtn).click();
	}
	
	public void clickOnStartTestBtn()
	{
		try {
		driver.findElement(testStartBtn).click();
		}catch(Exception e)
		{
			//ignore
		}
		driver.findElement(testStartBtn).click();
	}
	
	public void clickOnPopUpNo()
	{
		try {
			driver.findElement(popUpNoBtn).click();
		}catch(ElementClickInterceptedException e)
		{
			//ignore
		}
		
	}
	
}
