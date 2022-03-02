package pages.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pages.basePage.BasePage;
import utils.helper.CommonMethods;

public class TShirtsCategoryPage extends BasePage{
	
	public TShirtsCategoryPage(WebDriver driver) {
		super(driver);
	}
	
	CommonMethods helpers = new CommonMethods(getDriver());

	@FindBy(css=".product_list>:nth-child(1)")
	WebElement fadedShortSleeveTshirtsDiv;
    
	@FindBy(css=".product_list>:nth-child(1)>div>:nth-child(2)>.button-container>a[title='Add to cart']")
	WebElement fadedShortSleeveTshirts;
	
	@FindBy(css=".continue")
	WebElement continueShoppingBtn;
	
	//-------------------Helper Methods---------------------- 
	
	public void addProductToCart() {
		helpers.explicitlyWaitUntilElementVisible(fadedShortSleeveTshirtsDiv);
		helpers.JSScrollIntoView(fadedShortSleeveTshirtsDiv);
		helpers.actionsMove(fadedShortSleeveTshirtsDiv);
		if(fadedShortSleeveTshirts.isEnabled()) {
			helpers.explicitlyWaitUntilElementVisible(fadedShortSleeveTshirts);
		    fadedShortSleeveTshirts.click();
		    helpers.explicitlyWaitUntilElementVisible(continueShoppingBtn);
			continueShoppingBtn.click();
		}
	}
	
}
