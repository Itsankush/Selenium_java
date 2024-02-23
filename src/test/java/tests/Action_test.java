package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Action_test {
	WebDriver d;
	Actions actions;

	@BeforeTest
	public void actions() {
		WebDriverManager.edgedriver().setup();
		d = new EdgeDriver();
		d.get("http://www.qaclickacademy.com/");
		actions = new Actions(d);
	}

	@Test
	public void hover_Over() {
		WebElement button = d.findElement(By.cssSelector("div[class='button float-left'] a[class='main-btn']"));
		// Hover over button
		actions.moveToElement(button).build().perform();
		// drag and drop action
		actions.dragAndDrop(button, button).build().perform();
	}

	@Test
	public void doubleClick() {
		WebElement email = d
				.findElement(By.xpath("//div[@class='cont']//span[contains(text(),'info@qaclickacademy.com')]"));
		// DoubleClick
		actions.doubleClick(email).build().perform();
	}

	@Test
	public void rightClick() {
		WebElement button = d.findElement(By.cssSelector("div[class='button float-left'] a[class='main-btn']"));
		// Right Click
		actions.contextClick(button).build().perform();
	}

}
