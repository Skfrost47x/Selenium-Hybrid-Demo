package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BaseComponents {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	// Locators

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement email;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement pass;

	@FindBy(xpath = "//input[@value='Login']")
	WebElement loginBtn;

	// Action method

	public void setEmail(String usersEmail) {
		email.sendKeys(usersEmail);
	}

	public void setPass(String usersPass) {
		pass.sendKeys(usersPass);
	}

	public void clickLoginBtn() {
		loginBtn.click();
	}

}
