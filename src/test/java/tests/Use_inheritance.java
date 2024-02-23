package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Use_inheritance {
	WebDriver driver;

	@BeforeClass
	public void setUp() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	public void waiting() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement button = driver.findElement(By.className("main-btn"));
		wait.until(ExpectedConditions.visibilityOf(button));

	}
}

// Child class
class LoginPageTest extends Use_inheritance {
	@Test
	public void loginTest() {
		driver.get("https://www.qaclickacademy.com/");
		// perform login tests
		LoginPageTest login = new LoginPageTest();
		login.waiting();
	}
}
