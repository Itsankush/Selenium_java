package tests;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dyn_Dropdown {
	WebDriver driver;
	WebDriverWait wait;

	@Test
	public void dropdown() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		// Explicit wait
		wait = new WebDriverWait(driver, 10);
		driver.get("https://www.nike.com/");
		driver.manage().window().maximize();
		SoftAssert soft = new SoftAssert();

		String title = "Nike. Just Do It. Nike IN";
		soft.assertEquals(driver.getTitle(), title);

		driver.findElement(By.xpath("//input[@id='VisualSearchInput']")).sendKeys("shoes"); // Search
		WebElement ele = driver.findElement(By.xpath(
				"//div[@class='pre-login-btns d-lg-flx flx-ai-lg-c']/..//span[@id='hf_title_joinus_membership']"));
		wait.until(ExpectedConditions.visibilityOf(ele)); // Wait until

		// Store all matching elements in list
		List<WebElement> shoes = driver.findElements(By.xpath("//li[@role='option']"));
//		// Select exact what you want from above list
		for (WebElement s : shoes)
			if (s.getText().contains("running shoes"))
				s.click();
	}

}
