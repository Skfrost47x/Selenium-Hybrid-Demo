package codenbox.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import codenbox.TestBase.Base;
import codenbox.utilities.DataProviders;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;

public class LoginDataDrivenTest extends Base {
	
	@Test (dataProvider="testDemo", dataProviderClass=DataProviders.class, groups= {"Sanity", "Regression"})
	
	public void verify_loginDDT(String userName, String password, String expResult) {
		
		logger.info("*******Starting Registration Test*********");
		//HomePage
		HomePage hm = new HomePage(driver);
		logger.info("Clicked on My Account link");
		hm.clickMyAccount();
		logger.info("Clicked on My Login link");
		hm.clickLogin();
		
		//login Page
		LoginPage lp = new LoginPage(driver);
		logger.info("Entered email for login");
		lp.setEmail(userName);
		logger.info("Entered password for login");
		lp.setPass(password);
		logger.info("clicked on login btn");
		lp.clickLoginBtn();
		
		MyAccountPage myact = new MyAccountPage(driver);
		boolean targetPage = myact.isMyAccountExist();
		
		/* Data is invalid:
		 * login success -> logout : test fail
		 * login failed -> test pass
		 * ==================
		 * Data is valid:
		 * login success -> logout : test pass
		 * login failed -> test fail
		 */
		
		logger.info("****validation for invalid result*****");
		if (expResult.equalsIgnoreCase("invalid")) {
			if(targetPage==true) {
				myact.clickLogout();
				Assert.assertTrue(false);
			}else {
				Assert.assertTrue(true);
			}
		}
		
		logger.info("****validation for valid result*****");
		if (expResult.equalsIgnoreCase("valid")) {
			if(targetPage==true) {
				myact.clickLogout();
				Assert.assertTrue(true);
			}else {
				Assert.assertTrue(false);
			}
		}
		
		logger.info("****completed LoginDDTest*****");
	}

}
