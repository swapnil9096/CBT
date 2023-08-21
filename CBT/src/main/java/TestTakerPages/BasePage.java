package TestTakerPages;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	
	public Properties prop;
	public static WebDriver driver;
	
	
	//Reading properties file
	public BasePage()
	{	
		
		String fileName = System.getProperty("user.dir") + "//src//main//resources//config.properties";
		try {
			FileInputStream fis = new FileInputStream(fileName);
			prop = new Properties();
			prop.load(fis);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Error in file path...!!");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error in file loading...!!");
		}
	}
	
	
	
	public void initialize()
	{
		
		//Initialize driver
		String browser = prop.getProperty("browser");
		
		if(browser.equalsIgnoreCase("CHROME"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		}else if(browser.equals("EDGE"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			
		}else 
			throw new RuntimeException("Invalid Browser...!!");
		
		
		//Hitting URL
		driver.navigate().to(prop.getProperty("url"));		
		
		//maximize window 
		boolean window = Boolean.valueOf(prop.getProperty("maximize"));
		if(window)
			driver.manage().window().maximize();
		
		
		//applying implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(prop.getProperty("implicit"))));
		
	}
	
	
	public String getScreenshot(String testCaseName) 
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		
		File source = ts.getScreenshotAs(OutputType.FILE);
		
		String file =System.getProperty("user.dir") + "\\src\\test\\resources\\Reports\\" + testCaseName + ".png";

		try {
			FileUtils.copyFile(source, new File(file));
		} catch (IOException e) 
		{
			e.printStackTrace();
			System.out.println("Error in copying file...!!");
		}

		return file; 
	}
	
	
	
}
