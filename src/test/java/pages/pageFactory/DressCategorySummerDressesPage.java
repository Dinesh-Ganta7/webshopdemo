package pages.pageFactory;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pages.basePage.BasePage;
import utils.helper.CommonMethods;

public class DressCategorySummerDressesPage extends BasePage {
	
	public DressCategorySummerDressesPage(WebDriver driver) {
		super(driver);
	}
	
	CommonMethods helpers = new CommonMethods(getDriver());

	//printed summer dress product's html div container
	@FindBy(css=".product_list>:nth-child(2)")
	WebElement printedSummerDressDiv;
	
	@FindBy(css=".product_list>:nth-child(2)>div>:nth-child(2)>.button-container>a[title='Add to cart']")
	WebElement printedSummerDressAddToCartButton;
	
	@FindBy(css=".continue")
	WebElement continueShoppingBtn;
	
	
	//----------------Helper methods----------------------- 
	
	public void addProductToCart() {
		helpers.explicitlyWaitUntilElementVisible(printedSummerDressDiv);
		helpers.JSScrollIntoView(printedSummerDressDiv);
		helpers.actionsMove(printedSummerDressDiv);
		if(printedSummerDressAddToCartButton.isEnabled()) {
			helpers.explicitlyWaitUntilElementVisible(printedSummerDressAddToCartButton);
			printedSummerDressAddToCartButton.click();
			helpers.explicitlyWaitUntilElementVisible(continueShoppingBtn);
			continueShoppingBtn.click();
		}
	}
	
	

}
