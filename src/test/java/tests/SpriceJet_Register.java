package tests;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SpriceJet_Register {
	WebDriver driver;
	WebDriverWait wait;

	@Test
	void loadWebsite() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		Actions action = new Actions(driver);
		// Explicit wait
		WebDriverWait wait = new WebDriverWait(driver, 10);
		String url = "https://www.spicejet.com/";
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Signup')]")));
		driver.findElement(By.xpath("//div[contains(text(),'Signup')]")).click();
		// Window switch
		Set<String> window = driver.getWindowHandles();
		Iterator<String> i = window.iterator();
		//String parent = i.next();
		String child = i.next();
		driver.switchTo().window(child);
		// on child window
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)", "");
		WebElement titleDropdown = driver.findElement(By.xpath("//select[@class='form-control form-select ']"));
		Select select1 = new Select(titleDropdown);
		select1.selectByValue("MR");
		driver.findElement(By.id("first_name")).sendKeys("Test");
		driver.findElement(By.id("last_name")).sendKeys("User");
		// js.executeScript("window.scrollBy(0,1000)", "");
		driver.findElement(By.id("dobDate")).click();
		// js.executeScript("arguments[0].scrollIntoView();", DOB);

		// Select month
		WebElement month = driver.findElement(By.cssSelector(".react-datepicker__month-select"));
		action.moveToElement(month).click();
		Select select2 = new Select(month);
		select2.selectByValue("11");
		// Select year
		WebElement year = driver.findElement(By.cssSelector(".react-datepicker__year-select"));
		action.moveToElement(year).click();
		Select select3 = new Select(year);
		select3.selectByValue("1997");
		// select date
		driver.findElement(By.xpath("//div[@aria-label='Choose Saturday, December 20th, 1997']")).click();
		driver.findElement(By.cssSelector("[type='tel']")).sendKeys("1231231231");
		
		driver.findElement(By.cssSelector("img[alt='register-image']")).click();
		driver.findElement(By.id("email_id")).sendKeys("ram@gmail.com");
		js.executeScript("window.scrollBy(0,300)", "");
		driver.findElement(By.id("new-password")).sendKeys("Myfirsttest@001");
		driver.findElement(By.id("c-password")).sendKeys("Myfirsttest@001");
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		// js.executeScript("window.scrollBy(0,200)", "");
		
		driver.findElement(By.id("email_id")).sendKeys("test@test.com");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Submit']")));
		WebElement submit=driver.findElement(By.xpath("//button[normalize-space()='Submit']"));
		
		action.moveToElement(submit).click();

		// js.executeScript("window.scrollBy(0,1000)", "");

		/*
		 * driver.findElement(By.xpath("//div[contains(text(),'Login')]")).click();
		 * driver.findElement(By.xpath("(//*[name()='circle'])[14]")).click();
		 * driver.findElement(By.xpath("//input[@type='email']")).sendKeys(
		 * "itsankush@gmail.com");
		 * driver.findElement(By.xpath("//input[@type='password']")).sendKeys(
		 * "Ankush123");
		 * driver.findElement(By.cssSelector("div[data-testid$='login-cta']")).click();
		 * String Err_message = "Please enter a valid email address";
		 * Assert.assertEquals(driver.findElement(By.
		 * linkText("Please enter a valid email address")).getText(), Err_message);
		 */
	}

}
