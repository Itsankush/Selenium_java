package tests;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class findElements_Xpaths {
	String url = "https://www.guru99.com/";
	WebDriver driver;

	@Test
	void test1() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\al10917\\eclipse-workspace\\selenium_Automation\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get(url);
		List<WebElement> list = driver.findElements(By.xpath("(//ul[@id='java_technologies'])[8]//li"));

		for (WebElement l : list) {
			String[] l1 = l.getText().toString().split(" ");
			String menu = l1[1];
			System.out.println(menu);

			if (menu.equals("NLTK")) {
				System.out.println("Pass");
				l.click();
			}
		}
	}

}
