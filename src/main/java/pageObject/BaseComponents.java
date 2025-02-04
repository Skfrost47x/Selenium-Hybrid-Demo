package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BaseComponents {
	

	WebDriver driver;

	// create constructor

	public BaseComponents(WebDriver driver) {
		this.driver = driver; // this is a keyword in java that defines class level variable
		PageFactory.initElements(driver, this);

	}

}
