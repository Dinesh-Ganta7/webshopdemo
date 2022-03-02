package utils;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportFactory {
	static ExtentReports report;
	
	
	public static String addScreenCapture(WebDriver driver) throws IOException {
		TakesScreenshot takeScreenshot = (TakesScreenshot) driver;
		File sourceFile = takeScreenshot.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+ "/resources/reports/screenshots/"+System.currentTimeMillis()+".jpg";
		File destFile = new File(path);
		FileUtils.copyFile(sourceFile, destFile);
		return path;
		 
			
			
	}
	
	public static ExtentReports startReport() {
		report = new ExtentReports();
		LocalDateTime date = LocalDateTime.now();
		DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("dd-MM-yyyy-HH-mm-ss");
		String path = System.getProperty("user.dir")+ "\\resources\\reports\\index.html" + formatter.format(date);
		ExtentSparkReporter spark = new ExtentSparkReporter(path);
		spark.config().setReportName("MyStore Demo App Test Report");
		spark.config().setDocumentTitle("MyStore Demo App Test Report");
		report.attachReporter(spark);
		report.setSystemInfo("Tester", "Dinesh.G");
		report.setSystemInfo("WebSite Name", "My Store");
		report.setSystemInfo("WebPage Url", "http://automationpractice.com/index.php/");
		return report;
		
	}
	
	public static void endReport() {
		report.flush();
	}
}
