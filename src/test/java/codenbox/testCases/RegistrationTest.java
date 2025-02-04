package codenbox.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import codenbox.TestBase.Base;
import codenbox.utilities.Retry;
import pageObject.HomePage;
import pageObject.RegistrationPage;

public class RegistrationTest extends Base {
	
	@Test (groups= {"Sanity", "Regression"}, retryAnalyzer=Retry.class)
	public void verify_registration () {
		logger.info("*******Starting Registration Test*********");
		
		HomePage hm = new HomePage(driver);
		
		logger.info("Clicked on My Account");
		hm.clickMyAccount(); //clicking on my account
		
		logger.info("Clicked on My Register Link");
		hm.clickRegister(); //Clicking on register
		
		RegistrationPage rg = new RegistrationPage(driver);
		
		logger.info("Input Registration Details");
		//rg.setFirstName("SK ABDUR RAHIM");
		rg.setFirstName(getRandomString().toUpperCase());
		//rg.setLastName("SHABBIR");
		rg.setLastName(getRandomString().toUpperCase());
		//rg.setEmail("skshabbir472x@gmail.com");
		rg.setEmail(getRandomString()+"@gmail.com");
		//rg.setTelephone("3477033532");
		rg.setTelephone(getRandomNum());
		//rg.setPassword("Mylv147852369");
		String enterPassword = getRandomAlphaNumeric();
		rg.setPassword(enterPassword);
		rg.setConfirmPassword(enterPassword);
		
		logger.info("Clicked on Privacy Policy");
		rg.checkPolicy();
		
		logger.info("Clicked on Continue button");
		rg.clickContinue();
		
		logger.info("Validating actual Vs expected message");
		String actualMsg = rg.getConfirmationMsg(); //confirmation Message
		if (actualMsg.equalsIgnoreCase("Your Account Has Been Created!")) {
			Assert.assertTrue(true);
		}else {
			System.out.println("Didn't match. Test fail");
			Assert.fail();
		}
		
		logger.info("Completed Registration Test");
		
	}
	
}
