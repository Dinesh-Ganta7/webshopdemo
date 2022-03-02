package pages.pageFactory;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.ui.Select;


import pages.basePage.BasePage;
import utils.helper.CommonMethods;

public class CreateAccountPage extends BasePage {

	public CreateAccountPage(WebDriver driver) {
		super(driver);

	}
	CommonMethods helpers = new CommonMethods(getDriver());
	@FindBy(id = "id_gender1")
	WebElement maleRadioEl;

	@FindBy(id = "id_gender2")
	WebElement femaleRadioEl;

	@FindBy(id = "customer_firstname")
	WebElement customerFirstname;

	@FindBy(id = "customer_lastname")
	WebElement customerLastname;

	@FindBy(id = "email")
	WebElement email;

	@FindBy(id = "passwd")
	WebElement password;

	// Date of birth day select
	@FindBy(id = "days")
	WebElement days;

	// Date of birth month select
	@FindBy(id = "months")
	WebElement months;

	// Date of birth year select
	@FindBy(id = "years")
	WebElement year;

	@FindBy(id = "newsletter")
	WebElement newsletterCheckbox;

	@FindBy(id = "optin")
	WebElement specialOffersCheckbox;

	@FindBy(id = "firstname")
	WebElement addressFirstname;

	@FindBy(id = "lastname")
	WebElement addressLastname;

	@FindBy(id = "company")
	WebElement companyEl;

	@FindBy(id = "address1")
	WebElement addressEl;

	@FindBy(id = "city")
	WebElement cityEl;

	@FindBy(id = "id_state")
	WebElement stateSelect;

	@FindBy(id = "postcode")
	WebElement zipCode;

	@FindBy(id = "id_country")
	WebElement countrySelect;

	@FindBy(id = "phone_mobile")
	WebElement phone;
	
	@FindBy(id="alias")
	WebElement referenceAddress;

	@FindBy(id = "submitAccount")
	WebElement submitBtn;
	

	// --------------------------Helper Methods---------------------------

	// Selects title
	public void selectTitle(String title) {
        
		if (title.equals("Mr")) {
			helpers.explicitlyWaitUntilElementVisible(maleRadioEl);
			maleRadioEl.click();
		} else {
			helpers.explicitlyWaitUntilElementVisible(femaleRadioEl);
			femaleRadioEl.click();
		}

	}

	// Enters firstname
	// argument type have address or customer
	public void enterFirstName(String firstname, String type) {

		if (type.equals("address")) {
			addressFirstname.sendKeys(firstname);// enters firstname for address
		} else {
			customerFirstname.sendKeys(firstname);// enters firstname for customer
		}
	}

	// Enters lastname
	// argument type have address or customer
	public void enterLastName(String firstname, String type) {

		if (type.equals("address")) {
			addressLastname.sendKeys(firstname);// enters laststname for address
		} else {
			customerLastname.sendKeys(firstname);// enters lastname for customer
		}
	}

	// Enters email
	public void enterEmail(String email) {
		this.email.sendKeys(email);
	}

	// Enters password
	public void enterPassword(String password) {
		this.password.sendKeys(password);
	}

	// Selects birth day
	public void selectBirthDay(String day) {
		Select birthDaySelect = new Select(days);
		birthDaySelect.selectByValue(day);
	}

	// Selects birth month
	public void selectBirthMonth(String month) {
		Select birthMonthSelect = new Select(months);
		birthMonthSelect.selectByValue(month);
	}

	// Selects birth year
	public void selectBirthYear(String year) {
		Select birthYearSelect = new Select(this.year);
		birthYearSelect.selectByValue(year);
	}

	// Clicks News Letter Checkbox
	public void checkNewsLetterSignup() {
		newsletterCheckbox.click();
	}

	// Enters Address
	public void enterAddress(String address) {
		addressEl.sendKeys(address);
	}

	// Enters City
	public void enterCity(String city) {
		cityEl.sendKeys(city);
	}

	// Selects State
	public void selectState(String state) {
		Select stateSelector = new Select(stateSelect);
		stateSelector.selectByVisibleText(state);
	}

	// Selects Country
	public void selectCountry(String country) {
		Select countrySelector = new Select(countrySelect);
		countrySelector.selectByVisibleText(country);
	}

	// Enters Zipcode
	public void enterZipcode(String zip) {
		zipCode.sendKeys(zip);
	}
	
	//Enters mobile number
	public void enterMobileNumber(String mobile) {
		phone.sendKeys(mobile);
	}
    
	//Enters reference address
	public void enterReferenceAddress(String address) {
		referenceAddress.sendKeys(address);
	}
	
	//Submits Account 
	public void submitAccount() {
		submitBtn.click();
	}
	
}
