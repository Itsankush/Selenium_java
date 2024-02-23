package stepDefinations;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class testOne_feature {
	WebDriver driver;
	WebDriverWait wait;
	File src;
	JavascriptExecutor js;
	

	@Given("Open website")
	public void open_qaclickacademy_website() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		// Explicit wait
		wait = new WebDriverWait(driver, 10);
		driver.get("http://www.qaclickacademy.com/");
		driver.manage().window().maximize();
		js = (JavascriptExecutor) driver;

	}

	@When("Click on Blog")
	public void click_on_blog() {
		// Wait until blog option is visible
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//a[@href='https://www.qaclickacademy.com/blog']")));
		driver.findElement(By.xpath("//a[@href='https://www.qaclickacademy.com/blog']")).click();
	}

	@When("Click on Contact")
	public void Click_on_Contact() {
		driver.findElement(By.xpath("(//a[@href='contactus.html'])[1]")).click();
		js.executeScript("window.scrollBy(0,500)", "");
	}

	@Then("^add (.+) (.+) (.+) & other details$")
	public void add_details(String name, String email, String subject) {
		// Wait until "Keep in touch" text is visible
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[normalize-space()='Keep in touch']")));
		driver.findElement(By.xpath("//input[@placeholder='Your name']")).sendKeys(name);
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@placeholder='Subject']")).sendKeys(subject);
		driver.findElement(By.xpath("//input[@placeholder='Phone']")).sendKeys("1231231230");
		driver.findElement(By.xpath("//textarea[@placeholder='Messege']")).sendKeys("Trying automation");
	}

	@Then("Go to java-interview-questions blog and add comment")
	public void java_interview_questions() {
		// Wait until pop up is visible
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='NO THANKS']")));
		driver.findElement(By.xpath("//button[normalize-space()='NO THANKS']")).click();
		driver.findElement(By.cssSelector("h2[class='title'] a[title='JAVA INTERVIEW QUESTIONS']")).click();
		driver.findElement(By.cssSelector("#comment")).sendKeys("Very usefull");
		driver.findElement(By.cssSelector("#author")).sendKeys("Automation");
		driver.findElement(By.cssSelector("#email")).sendKeys("java@gmail.com");

	}

	@Then("Go to Appium tutorial - An Introduction blog and add comment")
	public void appium_tutorial() {
		// Wait until pop up is visible
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='NO THANKS']")));
		driver.findElement(By.xpath("//button[normalize-space()='NO THANKS']")).click();
		driver.findElement(By.cssSelector("h2[class='title'] a[title='Appium tutorial – An Introduction']")).click();
		driver.findElement(By.cssSelector("#comment")).sendKeys("Very usefull");
		driver.findElement(By.cssSelector("#author")).sendKeys("Automation");
		driver.findElement(By.cssSelector("#email")).sendKeys("appium@gmail.com");
	}

	@Then("take screenshot1")
	public void take_screenshot1() throws IOException {
		src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("target/ScreenShot/snap_blog.jpg")); // Refresh project
	}

	@Then("take screenshot2")
	public void take_screenshot2() throws IOException {
		src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("target/ScreenShot/snap_contact.jpg")); // Refresh project
	}

	@Then("take screenshot3")
	public void take_screenshot3() throws IOException {
		src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("target/ScreenShot/snap_contact.jpg")); // Refresh project
	}

	@Then("close")
	public void close() {
		driver.close();
	}
}
