package Guru.com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {
	protected WebDriver driver;

	Driver(WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver initializeDriver() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\al10917\\eclipse-workspace\\selenium_Automation\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
	}

	public void openPage(String url) {
		driver.get(url);
	}

}
