package utils.helper;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonMethods {

	WebDriverWait wait;
	WebDriver driver;

	public CommonMethods(WebDriver driver) {
		this.driver = driver;
	}

	public void explicitlyWaitUntilElementVisible(WebElement element) {

		wait = new WebDriverWait(driver, Duration.ofMillis(7000));
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	public void explicitlyWaitUntilElementClickable(WebElement element) {

		wait = new WebDriverWait(driver, Duration.ofMillis(5000));
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}
	
	public void JSScrollIntoView(WebElement element) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView();", element);
	}
	
	public void actionsMove(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}

}
