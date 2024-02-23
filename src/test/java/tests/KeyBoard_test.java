package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyBoard_test {
	WebDriver d;
	Actions actions;
	JavascriptExecutor js;

	@BeforeTest
	public void actions() {
		WebDriverManager.chromedriver().setup();
		d = new ChromeDriver();
		d.get("http://www.qaclickacademy.com/");
		d.manage().window().maximize();
		actions = new Actions(d);
		js = (JavascriptExecutor) d;
	}

	@Test
	public void press_ENTER_key() {
		actions.sendKeys(Keys.ENTER).build().perform();
	}

	@Test
	public void Press_and_hold_key() {
		d.findElement(By.xpath("(//a[@href='contactus.html'])[1]")).click();
		js.executeScript("window.scrollBy(0,500)", "");
		d.findElement(By.xpath("//input[@placeholder='Your name']")).click();
		// Press Shift + send data
		actions.keyDown(Keys.SHIFT).sendKeys("ankush").keyUp(Keys.SHIFT).build().perform();
	}

	@Test
	public void Select_All() {
		d.findElement(By.xpath("(//a[@href='contactus.html'])[1]")).click();
		js.executeScript("window.scrollBy(0,500)", "");
		d.findElement(By.xpath("//input[@placeholder='Your name']")).sendKeys("Ankush");
		// Press ctrl + a
		actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
	}

}
