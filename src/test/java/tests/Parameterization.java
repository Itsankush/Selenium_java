package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Parameterization {
	private WebDriver driver;

	@BeforeTest
	@Parameters({ "browser" })
	public void launch(String browser) {
		switch (browser.toLowerCase()) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\al10917\\eclipse-workspace\\selenium_Automation\\driver\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
		default:
			throw new IllegalArgumentException("Invalid browser type provided: " + browser);
		}
	}

	@Test
	public void web() {
		driver.get("http://the-internet.herokuapp.com/");
	}
}
