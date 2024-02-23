package tests;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class parentToChildSwitch {
	WebDriver driver;

	@Test
	void switchTo() {

		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.get("https://www.goibibo.com/");
		String parent = driver.getWindowHandle(); // parent window
		driver.findElement(By.linkText("Privacy Policy")).click();
		String child = driver.getWindowHandle(); // child window
		driver.switchTo().window(parent);
		//driver.switchTo().window(child);

	}

	@Test
	void switchTo_Iterator() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.get("https://www.goibibo.com/");
		driver.findElement(By.linkText("Privacy Policy")).click();
		Set<String> window = driver.getWindowHandles();
		Iterator<String> i = window.iterator();
		String parent = i.next();
		String child = i.next();
		driver.switchTo().window(parent);
		driver.switchTo().window(child);
	}

}
