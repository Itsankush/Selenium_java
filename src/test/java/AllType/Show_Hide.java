package AllType;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Show_Hide {

	@Test
	public void Task1() {
		String exp = "input1input3";
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\al10917\\eclipse-workspace\\selenium_Automation\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");
		// Select radio option
		driver.findElement(By.xpath("//input[@id='displayed-text']")).sendKeys("input1");

		driver.findElement(By.xpath("//input[@id='hide-textbox']")).click();
		try {
			driver.findElement(By.xpath("//input[@id='displayed-text']")).sendKeys("input2");
		} catch (Exception e) {
			System.out.println("Test Pass");
		}

		driver.findElement(By.xpath("//input[@id='show-textbox']")).click();
		driver.findElement(By.xpath("//input[@id='displayed-text']")).sendKeys("input3");
	}

}
