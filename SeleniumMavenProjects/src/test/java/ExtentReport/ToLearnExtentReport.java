package ExtentReport;

import java.time.LocalDateTime;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ToLearnExtentReport
{
	@Test
	public void createReport()
	{
		String timestamp = LocalDateTime.now().toString().replace(":","-");
		//STep1: Create an instance of ExtentSparkReporter
		ExtentSparkReporter spark=new ExtentSparkReporter("./HTML-REPORTS/"+timestamp+"ExtentReport.html");
		
		//Step2: Create an instance of ExtentReports
		ExtentReports extReport=new ExtentReports();
		
		//Step3: attach ExtentSparkReporter to ExtentReports
		extReport.attachReporter(spark);
		
		//Step4: Create an instance of ExtentTest
		ExtentTest test = extReport.createTest("createReport");
		
		//Step5: call log() to provide Status and message
		test.log(Status.PASS,"message added into Report");
		test.log(Status.INFO,"adding info status");
		
		//Step 6: call flush()
		extReport.flush();
	}

}
