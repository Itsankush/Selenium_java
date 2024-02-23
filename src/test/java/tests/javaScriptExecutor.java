package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class javaScriptExecutor {
	WebDriver driver;

	@Test
	public void task() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.get("https://www.qaclickacademy.com/");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.open();");
	}

}
