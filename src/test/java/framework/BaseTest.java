package framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import utils.ReportFactory;

public class BaseTest {

	public WebDriver driver;
	ExtentReports report;
	ExtentTest test;
	private static String orderSuccessId;

	DriverFactory remoteDriver = new DriverFactory();

	@Parameters("browserName")
	@BeforeTest
	public void getDriver(@Optional("Chrome") String browserName) throws IOException {
		driver = remoteDriver.getDriver(browserName);
		driver.manage().window().maximize();

		String filePath = System.getProperty("user.dir") + "/src/test/resources/config.properties";
		File file = new File(filePath);
		FileInputStream fis = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fis);
		String url = prop.getProperty("WebpageUrl");
		driver.get(url);
	}

	@AfterTest
	public void teardown() {
		remoteDriver.teardown();
	}

	@BeforeSuite
	public void startReports() {
		report = ReportFactory.startReport();
	}

	@BeforeMethod
	public void onStartTest(ITestResult result) {
		test = report.createTest(result.getMethod().getMethodName());
	}

	@AfterMethod
	public void getResult(ITestResult result) throws IOException {

		if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, "Test Passed");
			if(result.getMethod().getMethodName().equals("checkout")) {
				test.pass(orderSuccessId);
			}
		} else if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "Test Failed");
			String screenShotPath = ReportFactory.addScreenCapture(driver);
			test.fail(result.getThrowable(), MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
			
		}
		else if(result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, "Test Skipped");
			test.skip(result.getThrowable());
		}
	}

	@AfterSuite
	public void endReports() {
		ReportFactory.endReport();
	}
	
	public static void setOrderId(String orderId) {
		orderSuccessId = orderId;
	}

}
