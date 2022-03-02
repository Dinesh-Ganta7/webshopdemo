package pages.basePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	
	private WebDriver driver;
	
	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public BasePage(WebDriver driver) {
		this.setDriver(driver);
		PageFactory.initElements(driver, this);
	}

}
