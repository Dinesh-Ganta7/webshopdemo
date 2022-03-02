package framework;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	private  WebDriver driver;
	
	public  WebDriver getDriver(String browserName) {
		if(driver == null) {
			setup(browserName);
		}
		return driver;
	}
	
	
	public  void setup(String browserName) {
		
		switch(browserName) {
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			
			ChromeOptions options = new ChromeOptions();
			Map<String, Object> prefs = new HashMap<>();
			prefs.put("download.default_directory", System.getProperty("user.dir") + "\\downloads\\");
			options.setExperimentalOption("prefs", prefs);
			
			driver = new ChromeDriver(options);
			break;
			
		case "Edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
			
		case "Firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		default:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		
	}
	
	public void teardown() {
		driver.quit();
	}

}
