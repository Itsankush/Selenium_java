package tests;

import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assertions_Demo {
	WebDriver driver;
	WebDriverWait wait;

	@Test
	public void assertions() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.nike.com/");
		driver.manage().window().maximize();

		// assertEquals: Check if equals
		String Exp_title = "Nike. Just Do It. Nike IN";
		String Act_title = driver.getTitle();
		assertEquals(Act_title, Exp_title);

		// assertNotEquals: Check if not equals
		String expectedText = "help";
		String actualText = driver.findElement(By.xpath("//a[@aria-controls='HelpMenuDropdown-Menu']")).getText();
		assertNotEquals(expectedText, actualText);

		// assertTrue: Check if true
		WebElement find_store = driver.findElement(By.cssSelector(".prl1-sm"));
		assertTrue(find_store.isEnabled());

		// assertFalse: This assertion checks if a given condition is false.
//		WebElement errorBox = driver.findElement(By.id("error-box"));
//		assertFalse(errorBox.isDisplayed());

		// assertSame
		WebElement Button1 = driver.findElement(By.xpath("//a[@title='Favourites']//*[name()='svg']"));
		WebElement Button2 = driver.findElement(By.xpath("//a[@title='Favourites']//*[name()='svg']"));
		assertSame(Button1, Button2);

	}

}
