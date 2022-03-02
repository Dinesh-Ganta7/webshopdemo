package pages.pageFactory;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.basePage.BasePage;
import utils.helper.CommonMethods;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}


	WebDriverWait wait ;
	CommonMethods helpers = new CommonMethods(getDriver());

	@FindBy(id = "contact-link")
	WebElement contactLink;

	@FindBy(css = ".header_user_info a")
	WebElement signinLink;
	
	@FindBy(css="a[title='Log me out']")
	WebElement logoutLink;

	@FindBy(id = "search_query_top")
	WebElement searchBarEl;

	@FindBy(css = ".shopping_cart>a:nth-of-type(1)")
	WebElement cartEl;
   
	@FindBy(css=".shopping_cart>a:nth-of-type(1) span[class='ajax_cart_quantity']")
	WebElement cartQuantity;
	
	@FindBy(id="button_order_cart")
	WebElement cartCheckOutBtn;
	
	
	// Menu Women Category
	@FindBy(css = "a[title='Women']")
	WebElement womenMenu;

	// Women category Sub Menu Sections

	@FindBy(css = ".submenu-container a[title='T-shirts']")
	WebElement womenSubMenuTopsTShirtsSection;

	@FindBy(css = ".submenu-container a[title='Blouses']")
	WebElement womenSubMenuTopsBlousesSection;

	@FindBy(css = ".submenu-container :nth-child(2) a[title='Casual Dresses']")
	WebElement womenSubMenuDressesCasualDressesSection;

	@FindBy(css = ".sf-menu :nth-child(1) .submenu-container :nth-child(2) a[title='Evening Dresses']")
	WebElement womenSubMenuDressesEveningDressesSection;

	@FindBy(css = ".submenu-container :nth-child(2) a[title='Summer Dresses']")
	WebElement womenSubMenuDressesSummerDressesSection;

	// Menu dresses category
	@FindBy(css = ".sf-menu>li:nth-child(2)>a")
	WebElement dressesMenu;

	// Menu category sub-menu items
	@FindBy(css = ".sf-menu>:nth-child(2)>ul>:nth-child(1)")
	WebElement dressesCategoryCasualDressesSubmenu;

	@FindBy(css = ".sf-menu>:nth-child(2)>ul>:nth-child(2)")
	WebElement dressesCategoryEveningDressesSubmenu;

	@FindBy(css = ".sf-menu>:nth-child(2)>ul>:nth-child(3)")
	WebElement dressesCategorySummerDressesSubmenu;

	// Menu T-Shirts Category
	@FindBy(css = ".sf-menu>li:nth-child(3)>a")
	WebElement tShirtsMenu;

	@FindBy(css = "a[title='View my customer account']")
	WebElement customerName;

	// --------------------Helper methods--------------------------

	// Clicks Signin Link
	public void clickSignin() {
		signinLink.click();
	}

	// Checks if signin is success
	public boolean checkSignInSuccess(String name) {
		return customerName.getText().equals(name);
	}

	// Selects Evening Dresses submenu from Women menu
	public void selectEveningDressesCategory() {
        helpers.explicitlyWaitUntilElementVisible(womenMenu);
        helpers.JSScrollIntoView(womenMenu);
		helpers.actionsMove(womenMenu);
		helpers.explicitlyWaitUntilElementClickable(womenSubMenuDressesEveningDressesSection);
		womenSubMenuDressesEveningDressesSection.click();
	}

	// Selects Summer Dress submen from Dresses menu
	public void selectSummerDressesCategory() {
		helpers.explicitlyWaitUntilElementVisible(dressesMenu);
		helpers.JSScrollIntoView(dressesMenu);
		helpers.actionsMove(dressesMenu);
		helpers.explicitlyWaitUntilElementClickable(dressesCategorySummerDressesSubmenu);
		dressesCategorySummerDressesSubmenu.click();

	}

	// Selects T-Shirts menu
	public void selectTShirtsCategory() {
		helpers.explicitlyWaitUntilElementVisible(tShirtsMenu);
		tShirtsMenu.click();
	}
	
	//Checks cart quantity
	public boolean cartQuantityCheck() {
		return cartQuantity.getText().equals("3");
	}
	
	//Clicks Checkout Button in cart
	public void clickCheckOutButton() {
		helpers.JSScrollIntoView(cartEl);
		helpers.actionsMove(cartEl);
		helpers.explicitlyWaitUntilElementVisible(cartCheckOutBtn);
		cartCheckOutBtn.click();
		
	}
	//Clicks logout
	public void logout() {
		logoutLink.click();
	}
	
	//Checks logout success
	public boolean logoutSuccess() {
		return signinLink.isDisplayed();
	}

}
