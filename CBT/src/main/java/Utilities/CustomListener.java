package Utilities;

import org.openqa.selenium.WebDriver;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import TestTakerPages.BasePage;

public class CustomListener extends BasePage implements ITestListener,ISuiteListener{
	
ExtentTest test;
	
	ExtentReports extent = ExtentReporterNG.getReportObject();//Getting the object of extent Report
	
	public void onTestStart(ITestResult result)
	{
		System.out.println("OnTestStart method executed : " + result.getMethod().getMethodName());
		test = extent.createTest(result.getMethod().getMethodName());
	}
	
	public void onTestFailure(ITestResult result)
	{
		System.out.println("Test Case Failed : " + result.getName());
		test.fail(result.getThrowable());
		
		// get screenshot and attach a report
			try {
				driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
			} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
				e.printStackTrace();
				System.out.println("Error in getting object...!!");
			}
		
		String filePath = getScreenshot(result.getMethod().getMethodName());
		test.addScreenCaptureFromPath(filePath,result.getMethod().getMethodName());
		
	}
	
	public void onTestSkipped(ITestResult result)
	{
		System.out.println("onTestSkipped method executed : " + result.getMethod());
		
	}
	public void onTestFailedButWithinSuccessPercentage(ITestResult result)
	{
		//ignore
	}
	public void onTestFailedWithTimeout(ITestResult result)
	{
		onTestFailure(result);
	}
	
	public void onStart(ITestContext context)
	{
		System.out.println("Test Start....!!");
	}
	
	public void onFinish(ITestContext context)
	{
		System.out.println("Finish..");
		extent.flush();
	}
}
