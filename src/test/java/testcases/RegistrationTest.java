package testcases;

import java.io.IOException;



import org.testng.annotations.Test;

import framework.BaseTest;
import pages.pageFactory.AuthenticationPage;
import pages.pageFactory.CreateAccountPage;
import pages.pageFactory.HomePage;
import utils.DataFactory;

public class RegistrationTest extends BaseTest {
	
	
	public RegistrationTest() {
		super();
	}
	
	@Test()
	public void register() throws InterruptedException, IOException {
		AuthenticationPage authenticationPage  = new AuthenticationPage(driver);
		CreateAccountPage createAccount = new CreateAccountPage(driver);
		HomePage home = new HomePage(driver);
		
		//Data fields
		String address = DataFactory.getCellData(1, 10, 0);
		
		
		
		
		home.clickSignin();
		authenticationPage.enterCreateAccountEmail(DataFactory.getCellData(1, 3, 0), "create");
		authenticationPage.clickCreateAccountBtn();
		createAccount.selectTitle(DataFactory.getCellData(1, 0, 0));
		createAccount.enterFirstName(DataFactory.getCellData(1, 1, 0), "customer");
		createAccount.enterLastName(DataFactory.getCellData(1, 2, 0), "customer");
		createAccount.enterPassword(DataFactory.getCellData(1, 4, 0));
		createAccount.selectBirthDay(DataFactory.getCellData(1, 5, 0));
		createAccount.selectBirthMonth(DataFactory.getCellData(1, 6, 0));
		createAccount.selectBirthYear(DataFactory.getCellData(1, 7, 0));
		createAccount.checkNewsLetterSignup();
		createAccount.enterFirstName(DataFactory.getCellData(1, 8, 0), "address");
		createAccount.enterLastName(DataFactory.getCellData(1, 9, 0), "address");
		createAccount.enterAddress(address);
		createAccount.enterCity(DataFactory.getCellData(1, 11, 0));
		createAccount.selectState(DataFactory.getCellData(1, 12, 0));
		createAccount.enterZipcode(DataFactory.getCellData(1, 13, 0));
		createAccount.selectCountry(DataFactory.getCellData(1, 14, 0));
		createAccount.enterMobileNumber(DataFactory.getCellData(1, 15, 0));
		createAccount.enterReferenceAddress(address);
		createAccount.submitAccount();

		
			
	}
	
	
	

}
