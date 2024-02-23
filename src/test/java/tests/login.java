package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class login {
	WebDriver driver;
	WebDriverWait wait;

	@Test
	void loadWebsite() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		// Explicit wait
		WebDriverWait wait = new WebDriverWait(driver, 5);
		String url = "https://www.spicejet.com/";
		String email = "testautomation@gmail.com";
		String passwd = "Test@123";

		driver.get(url);
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(5, SECOND);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Login')]")));
		driver.findElement(By.xpath("//div[contains(text(),'Login')]")).click();
		driver.findElement(
				By.xpath("(//div[@class='css-76zvg2 r-homxoj r-ubezar r-1ozqkpa'][normalize-space()='Email'])[1]"))
				.click();
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys(email);

		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(passwd);

		driver.findElement(By.cssSelector("div[data-testid$='login-cta']")).click();

	}

}
