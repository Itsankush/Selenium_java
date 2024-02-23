package TestNGListeners;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;

@Listeners(TestNGListeners.Listeners.class)

public class TestCase_Listener {
	public WebDriver driver;

	@Test(priority = 0)
	public void Landing_On_Google() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
	}

	@Test(priority = 1)
	public void Search() {
		driver.findElement(By.xpath("//textarea[@type='search']")).sendKeys("Hello World!!!");
	}

}
