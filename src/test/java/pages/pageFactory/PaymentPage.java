package pages.pageFactory;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pages.basePage.BasePage;
import utils.helper.CommonMethods;

public class PaymentPage extends BasePage{
	
	public PaymentPage(WebDriver driver) {
		super(driver);
	}
	
	CommonMethods helpers = new CommonMethods(getDriver());

	@FindBy(css="a[title='Pay by bank wire']")
	WebElement payByBankWire;
	
	@FindBy(css="a[title='Pay by check.']")
	WebElement payByCheck;
	
	@FindBy(css=".cart_navigation button")
	WebElement confirmOrderButton;
	
	@FindBy(css=".cheque-indent")
	WebElement orderStatusText;
	
	@FindBy(css="#order_step+div")
	WebElement statusBoxDiv;
	

	
	//-----------helper methods ----------------- 
	
	//clicks pay by bank wire payment method
	public void selectPayByBankWire() {
		helpers.explicitlyWaitUntilElementVisible(payByBankWire);
		payByBankWire.click();
	}
	
	//clicks pay by check payment method 
	public void payByCheck() {
		helpers.explicitlyWaitUntilElementVisible(payByCheck);
		payByCheck.click();
	}
	
	public void confirmOrder() {
		confirmOrderButton.click();
	}
	
	public boolean orderStatusCheck() {
		System.out.println(statusBoxDiv.getText().split("-")[5]);
		return orderStatusText.isDisplayed();
		
	}
	
	public String getOrderId() {
		return orderStatusText.getText()  + statusBoxDiv.getText().split("-")[5];
	}

}
