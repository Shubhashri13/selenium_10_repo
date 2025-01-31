package ExtentReport;

import java.time.Duration;
import java.util.Base64;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ToLearnScreenShot 
{
	@Test
	public void screenShot()
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://demowebshop.tricentis.com/");
		TakesScreenshot ts=(TakesScreenshot) driver;
		String screenshot = ts.getScreenshotAs(OutputType.BASE64);
		
		ExtentSparkReporter spark=new ExtentSparkReporter("./HTML-REPORTS/ExtentReportScreen.html");
		ExtentReports extReport=new ExtentReports();
		extReport.attachReporter(spark);
		ExtentTest test = extReport.createTest("screenShot");
		test.log(Status.PASS, "Screenshot adding into Report");
		test.addScreenCaptureFromBase64String(screenshot);
		extReport.flush();
		
		
		}

}
