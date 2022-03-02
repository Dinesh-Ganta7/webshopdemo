package pages.pageFactory;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pages.basePage.BasePage;
import utils.helper.CommonMethods;

public class SummaryPage extends BasePage {
	
	public SummaryPage(WebDriver driver) {
		super(driver);
		
	}
	CommonMethods helpers = new CommonMethods(getDriver());

	@FindBy(css=".cart_navigation  a[title='Proceed to checkout']")
	WebElement proceedToCheckoutBtn;
	
	@FindBy(css="a[title='Continue shopping']")
	WebElement continueShoppingButton;
	
	
	//------------------------Helper Methods--------------------------- 
	
	//clicks proceed to checkout 
	public void proceedToCheckout() {
		helpers.explicitlyWaitUntilElementVisible(proceedToCheckoutBtn);
		proceedToCheckoutBtn.click();
	}
	
	//clicks continue shopping
	public void continueShopping() {
		continueShoppingButton.click();
	}
}
