package stepDefinations;

import java.io.File;
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

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SpiceJet_Register {
	WebDriver driver;
	WebDriverWait wait;
	File src;
	JavascriptExecutor js;
	String parent, child;
	Actions action;

	@Given("Open spicejet website")
	public void open_spicejet_website() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		// Explicit wait
		wait = new WebDriverWait(driver, 10);
		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize();
		js = (JavascriptExecutor) driver;
		action = new Actions(driver);
	}

	@When("I click on signup")
	public void i_click_on_signup() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[contains(text(),'Signup')]")).click();
	}

	@Then("I enter all details")
	public void i_enter_all_details() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Set<String> window = driver.getWindowHandles();
		Iterator<String> i = window.iterator();
		parent = i.next();
		child = i.next();
		driver.switchTo().window(child);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)", "");
		WebElement titleDropdown = driver.findElement(By.xpath("//select[@class='form-control form-select ']"));
		Select select1 = new Select(titleDropdown);
		select1.selectByValue("MR");
		driver.findElement(By.id("first_name")).sendKeys("Test");
		driver.findElement(By.id("last_name")).sendKeys("User");
		// js.executeScript("window.scrollBy(0,1000)", "");
		driver.findElement(By.id("dobDate")).click();
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
		driver.findElement(By.id("email_id")).sendKeys("abc@test.com");
		js.executeScript("window.scrollBy(0,300)", "");
		driver.findElement(By.id("new-password")).sendKeys("Myfirsttest@001");
		driver.findElement(By.id("c-password")).sendKeys("Myfirsttest@001");
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		// js.executeScript("window.scrollBy(0,200)", "");

		driver.findElement(By.id("email_id")).sendKeys("user@test.com");

	}

	@Then("click on submit")
	public void click_on_submit() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Submit']")));
		WebElement submit = driver.findElement(By.xpath("//button[normalize-space()='Submit']"));
		action.moveToElement(submit).click();

	}

}
