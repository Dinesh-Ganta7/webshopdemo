package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import framework.BaseTest;
import pages.pageFactory.AddressPage;
import pages.pageFactory.AuthenticationPage;
import pages.pageFactory.DressCategorySummerDressesPage;
import pages.pageFactory.HomePage;
import pages.pageFactory.PaymentPage;
import pages.pageFactory.ShippingPage;
import pages.pageFactory.SummaryPage;
import pages.pageFactory.TShirtsCategoryPage;
import pages.pageFactory.WomenCategoryEveningDressesPage;
import utils.DataFactory;

public class CreateOrderTest extends BaseTest {

	@Test(priority = 1)
	public void login() throws IOException {

		HomePage home = new HomePage(driver);
		AuthenticationPage authenticationPage = new AuthenticationPage(driver);
		home.clickSignin();
		authenticationPage.enterCreateAccountEmail(DataFactory.getCellData(1, 3, 0), "login");
		authenticationPage.enterPassword(DataFactory.getCellData(1, 4, 0));
		authenticationPage.clickSignin();
		Assert.assertTrue(
				home.checkSignInSuccess(DataFactory.getCellData(1, 1, 0) + " " + DataFactory.getCellData(1, 2, 0)),
				"Login Failed");

	}

	@Test(priority = 2)
	public void addToCart() {
		HomePage home = new HomePage(driver);
		WomenCategoryEveningDressesPage womenCatEveningDresses = new WomenCategoryEveningDressesPage(driver);
		DressCategorySummerDressesPage dressesCatSummerDresses = new DressCategorySummerDressesPage(driver);
		TShirtsCategoryPage tShirtsCat = new TShirtsCategoryPage(driver);

		// Adding products from evening dresses category
		home.selectEveningDressesCategory();
		womenCatEveningDresses.addProductToCart();

		// Adding products from summerDress category
		home.selectSummerDressesCategory();
		dressesCatSummerDresses.addProductToCart();

		// Adding products from t-shirts category
		home.selectTShirtsCategory();
		tShirtsCat.addProductToCart();

		Assert.assertTrue(home.cartQuantityCheck(), "Required items are not added to the cart!!");

	}

	@Test(priority = 3)
	public void checkout() {
		HomePage home = new HomePage(driver);
		SummaryPage summary = new SummaryPage(driver);
		AddressPage address = new AddressPage(driver);
		PaymentPage payment = new PaymentPage(driver);
		ShippingPage shipping = new ShippingPage(driver);

		home.clickCheckOutButton();

		summary.proceedToCheckout();
		address.proceedToCheckout();
		shipping.checkTermsOfService();
		shipping.proceedToCheckout();
		payment.selectPayByBankWire();
		payment.confirmOrder();

		Assert.assertTrue(payment.orderStatusCheck(), "Order not placed!");
		BaseTest.setOrderId(payment.getOrderId());

	}

	@Test(priority = 4)
	public void logout() {
		HomePage home = new HomePage(driver);
		home.logout();
		Assert.assertTrue(home.logoutSuccess(), "Logout failed");
	}

}
