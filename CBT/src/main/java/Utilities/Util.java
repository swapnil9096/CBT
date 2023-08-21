package Utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestTakerPages.BasePage;

public class Util extends BasePage{

	
	public void explicitWait(By by)
	{	
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(Integer.parseInt(prop.getProperty("explicit"))));
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
	}
	
	
}
