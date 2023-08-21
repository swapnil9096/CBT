package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

	public static ExtentReports getReportObject()
	{
		String path = System.getProperty("user.dir")+"/src/test/resources/Reports/index.html";
		
		ExtentSparkReporter sparker = new ExtentSparkReporter(path);
		sparker.config().setReportName("CBT Automation Report");
		sparker.config().setDocumentTitle("Tests Result");
		
		ExtentReports extent = new ExtentReports();
		
		extent.attachReporter(sparker);
		extent.setSystemInfo("Tester", "Swapnil Bobade");
//		extent.setSystemInfo("Sprint No:", "2");
//		extent.setSystemInfo("Build No:", "1");
		
		return extent;
	}
	
}
