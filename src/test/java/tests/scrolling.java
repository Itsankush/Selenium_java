package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class scrolling {

	@Test
	void scrollDown() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Explicit wait
		// WebDriverWait wait = new WebDriverWait(driver, 5);
		String url = "https://www.spicejet.com/";
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement button = driver.findElement(By.xpath("//div[contains(text(),'Explore More')]"));
		// scroll according to pixel
		js.executeScript("window.scrollBy(0,100)", "");
		js.executeScript("window.scrollBy(0,500)", "");
		// scroll till element not found
		js.executeScript("arguments[0].scrollIntoView();", button);
		// scroll bottom of page
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}

}
