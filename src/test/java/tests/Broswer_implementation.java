package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Broswer_implementation implements Browser {
	WebDriver driver;
	String url = "https://www.guru99.com/";
	String url2 = "https://saucelabs.com/";

	@Test(priority = 0)
	void init() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\al10917\\eclipse-workspace\\selenium_Automation\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Override
	@Test(priority = 1)
	public void launchBrowser() {
		driver.get(url);

	}

	@Override
	@Test(priority = 2)
	public void navigateTo() {
		driver.navigate().to(url2);

	}

}
