package tests;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class windowHandles_Example {
	WebDriver driver;

	@Test
	public void task() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.get("https://www.qaclickacademy.com/");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		for (int i = 0; i < 20; i++) {
			js.executeScript("window.open();");
		}

		// get window handles and close specific window
		Set<String> id = driver.getWindowHandles();
		for (String handle : id) {

			driver.switchTo().window(handle);
			String windowTitle = driver.getTitle();
			if (windowTitle.contains("QAClick Academy - A Testing Academy to Learn, Earn and Shine")) {

				driver.close();
				break;
			}
		}
	}
}
