package codenbox.TestBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class Base {

	public static WebDriver driver;
	public Logger logger;
	public Properties prop;
	public FileInputStream fs;

	// will run before every test cases
	// will make sure about the browser trigger everytime
	@BeforeMethod(alwaysRun = true) // (groups= {"Sanity", "Regression"})
	@Parameters({ "OS", "Browser" })
	public void setup(String osname, String browserName) throws IOException {
		prop = new Properties();
		fs = new FileInputStream("./src//test//resources//data.properties"); // will connect with the file
		prop.load(fs); // will load the file

		logger = LogManager.getLogger(); // load log4j from xml

		
			switch (browserName.toLowerCase()) {
			case "chrome":
				driver = new ChromeDriver(); // Chrome driver & browser
				break;
			case "chromeheadless":
				ChromeOptions options = new ChromeOptions();
				options.addArguments("headless");
				driver = new ChromeDriver(options);
				break;
			case "firefox":
				driver = new FirefoxDriver();
				break;
			case "edge":
				driver = new EdgeDriver();
				break;
			default:
				System.out.println("Browser doesn't exist");
				return;
			}
			

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		// driver.get("https://tutorialsninja.com/demo/");
		driver.get(prop.getProperty("baseUrl"));
	}
	
	//will run end of each test csae
	@AfterMethod(alwaysRun = true) // (groups= {"Sanity", "Regression"})
	public void tearDown() {
		driver.quit();
	}

	public String getRandomString() {
		return RandomStringUtils.randomAlphabetic(6);
	}

	public String getRandomNum() {
		return RandomStringUtils.randomNumeric(10);
	}

	public String getRandomAlphaNumeric() {
		String StringValue = RandomStringUtils.randomAlphabetic(4);
		String numericValue = RandomStringUtils.randomNumeric(3);
		return (StringValue + numericValue + "*");
	}
	
	public String getScreenshot(String methodName) throws IOException {
		String currentTimeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		File srcFile=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\"+methodName+"_"+currentTimeStamp+".png";
		File targetFile=new File(targetFilePath);
		FileUtils.copyFile(srcFile, targetFile);
		return targetFilePath; 
	}

}
