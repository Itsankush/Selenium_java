package SauceDemo_Tests;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class placeOrder_TC1 {
	WebDriver driver;
	WebDriverWait wait;
	File src;
	String exp = "Total: $10.79";

	@Test(priority = 1)
	// Positive flow to place order
	public void Launch_site() throws IOException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		// driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 10);

		src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
	}

	@Test(priority = 2)
	public void log_in() {
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("standard_user");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}

	@Test(priority = 3)
	public void goToCart() {
		driver.findElement(By.xpath("//button[@name='add-to-cart-sauce-labs-bike-light']")).click();
		driver.findElement(By.cssSelector("a[class='shopping_cart_link']")).click();
		driver.findElement(By.id("checkout")).click();
	}

	@Test(priority = 4)
	public void Submit() throws IOException {
		WebElement fname = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
		fname.sendKeys("Fname");
		WebElement lname = driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
		lname.sendKeys("Lname");
		WebElement zip = driver.findElement(By.xpath("//input[@placeholder='Zip/Postal Code']"));
		zip.sendKeys("400084");
		driver.findElement(By.xpath("//input[@type='submit']")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")));
		FileUtils.copyFile(src, new File("target/SauceDemo/orderPlaced.jpg")); // Refresh project
		String act = driver.findElement(By.xpath("//div[@class='summary_info_label summary_total_label']")).getText();

		Assert.assertEquals(act, exp);
		driver.findElement(By.id("finish")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("back-to-products")));
		FileUtils.copyFile(src, new File("target/SauceDemo/finalPage.jpg")); // Refresh project

	}

	@Test(priority = 5)
	public void verify_1() {
		String actual_msg = "Your order has been dispatched, and will arrive just as fast as the pony can get there!";
		String msg = driver.findElement(By.className("complete-text")).getText();
		Assert.assertEquals(msg, actual_msg);
	}

	@Test(priority = 6)
	public void verify_2() {
		String actual_msg = "Thank you for your order!";
		String msg = driver.findElement(By.className("complete-header")).getText();
		Assert.assertEquals(msg, actual_msg);
	}
}
