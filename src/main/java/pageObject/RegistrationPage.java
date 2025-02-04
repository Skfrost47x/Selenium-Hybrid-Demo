package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BaseComponents{

	// create constructor

	public RegistrationPage(WebDriver driver) {
		super(driver);
	}

	// create locators

	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement firstName;

	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement lastName;

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement email;

	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement telephone;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement password;

	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement confirmPassword;

	@FindBy(xpath = "//input[@name='agree']")
	WebElement policy;

	@FindBy(xpath = "//input[@value='Continue']")
	WebElement continuebtn;

	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;

	// action methods

	public void setFirstName(String myFName) {
		firstName.sendKeys(myFName);
	}

	public void setLastName(String myLName) {
		lastName.sendKeys(myLName);
	}

	public void setEmail(String myEmail) {
		email.sendKeys(myEmail);
	}

	public void setTelephone(String myTelephone) {
		telephone.sendKeys(myTelephone);
	}

	public void setPassword(String myPassword) {
		password.sendKeys(myPassword);
	}

	public void setConfirmPassword(String myPassword) {
		confirmPassword.sendKeys(myPassword);
	}

	public void checkPolicy() {
		policy.click();
	}

	public void clickContinue() {
		continuebtn.click();
	}

	public String getConfirmationMsg() {
		try {
			return msgConfirmation.getText();
		} catch (Exception e) {
			return e.getMessage();
		}
	}

}
