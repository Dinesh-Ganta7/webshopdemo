package pages.pageFactory;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import pages.basePage.BasePage;

public class AuthenticationPage extends BasePage{
	
	
	
	public AuthenticationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id="email_create")
	WebElement emailCreateEl;
	
	@FindBy(id="SubmitCreate")
	WebElement submitCreateAccountBtn;
	
	@FindBy(id="email")
	WebElement loginEmail;
	
	@FindBy(id="passwd")
	WebElement loginPassword;
	
	@FindBy(css="a[title='Recover your forgotten password']")
	WebElement forgotPasswordLink;
	
	@FindBy(id="SubmitLogin")
	WebElement submitLoginBtn;
	
	
	//---------------------Helper Methods---------------------- 
	
	
	
	//Enters email id
	//Parameter typeOEmail 'create' is an email for creating an account
	public void enterCreateAccountEmail(String email, String typeOfEmail) {
		
		
		if(typeOfEmail.equals("create")) {
			//Enters email to create new account
			emailCreateEl.sendKeys(email);
		}
		else {
			//Enters email to login
			loginEmail.sendKeys(email);
		}
		
		
	}
	
	//Enters password 
	public void enterPassword(String password) {
		loginPassword.sendKeys(password);
	}
	
	
	//clicks create account button 
	public void clickCreateAccountBtn() {
		submitCreateAccountBtn.click();
	}
	
	//clicks signin button
	public void clickSignin() {
		submitLoginBtn.click();
	}
	
	
	
}
