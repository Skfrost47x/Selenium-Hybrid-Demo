package codenbox.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import codenbox.TestBase.Base;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;

public class LoginTest extends Base {

	@Test (groups= {"Regression"})
	public void verify_login() {
		logger.info("*******Starting Registration Test*********");
		// homepage
		HomePage hm = new HomePage(driver);
		logger.info("Clicked on My Account link");
		hm.clickMyAccount();

		logger.info("Clicked on My Login link");
		hm.clickLogin();

		// login page
		LoginPage lp = new LoginPage(driver);
		logger.info("Entered email for login");
		
		lp.setEmail(prop.getProperty("myEmail"));
		logger.info("Entered password for login");
		lp.setPass(prop.getProperty("myPassword"));
		logger.info("clicked on login btn");
		lp.clickLoginBtn();

		// my account page
		MyAccountPage myact = new MyAccountPage(driver);
		logger.info("Account page verification");
		SoftAssert sa = new SoftAssert();

		myact.isMyAccountExist(); // true
		sa.assertTrue(myact.isMyAccountExist());
		//System.out.println("Login Test Failed");
		logger.info("login test failed");
		sa.assertAll();
	}
}
