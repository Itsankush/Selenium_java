package interface_use;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Broswer_implementation implements Browser {
	WebDriver driver;
	String url = "https://www.guru99.com/";
	String url2 = "https://saucelabs.com/";

	void init() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\al10917\\eclipse-workspace\\selenium_Automation\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Override
	public void launchBrowser(String url) {
		driver.get(url);
		
	}

	@Override
	public void navigateTo(String url_nav) {
		driver.navigate().to(url_nav);
		
	}

}
