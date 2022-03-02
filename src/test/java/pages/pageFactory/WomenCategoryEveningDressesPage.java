package pages.pageFactory;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pages.basePage.BasePage;
import utils.helper.CommonMethods;

public class WomenCategoryEveningDressesPage extends BasePage {

	public WomenCategoryEveningDressesPage(WebDriver driver) {
		super(driver);
	}

	CommonMethods helpers = new CommonMethods(getDriver());

	// printed dress product's html div container
	@FindBy(css = ".product_list>li>:nth-child(1)")
	WebElement printedDressDiv;

	@FindBy(css = ".product_list>li>:nth-child(1)>:nth-child(2)>.button-container>a:nth-of-type(1)")
	WebElement printedDressAddToCartButton;

	@FindBy(css = ".continue")
	WebElement continueShoppingBtn;

	// ----------------Helper methods-----------------------

	public void addProductToCart() {
		helpers.explicitlyWaitUntilElementVisible(printedDressDiv);

		JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
		jsExecutor.executeScript("arguments[0].scrollIntoView();", printedDressDiv);

		helpers.actionsMove(printedDressDiv);
		if (printedDressAddToCartButton.isEnabled()) {
			helpers.explicitlyWaitUntilElementVisible(printedDressAddToCartButton);
			helpers.explicitlyWaitUntilElementClickable(printedDressAddToCartButton);
			printedDressAddToCartButton.click();
			helpers.explicitlyWaitUntilElementVisible(continueShoppingBtn);
			continueShoppingBtn.click();
		}

	}

}
