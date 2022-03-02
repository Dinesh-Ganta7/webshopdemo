package pages.pageFactory;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pages.basePage.BasePage;
import utils.helper.CommonMethods;

public class AddressPage extends BasePage {
	
	public AddressPage(WebDriver driver) {
		super(driver);
	}
	CommonMethods helpers = new CommonMethods(getDriver());

	@FindBy(name = "processAddress")
	WebElement proceedToCheckoutBtn;
	
	@FindBy(css="a[title='Previous']")
	WebElement continueShopping;
	
	//------------------------Helper Methods--------------------------- 
	
		//clicks proceed to checkout 
		public void proceedToCheckout() {
			helpers.explicitlyWaitUntilElementVisible(proceedToCheckoutBtn);
			proceedToCheckoutBtn.click();
		}
		
		//clicks continue shopping
		public void continueShopping() {
			continueShopping.click();
		}

}
