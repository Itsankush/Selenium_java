package AllType;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Frame {

	@Test
	public void Task1() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\al10917\\eclipse-workspace\\selenium_Automation\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		//
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1200)", "");
		System.out.println("***scroll down***");
		WebElement frame = driver.findElement(By.xpath("//*[@name='iframe-name']"));

		// switching to frame
		driver.switchTo().frame(frame);
		System.out.println("***switched to frame***");
		js.executeScript("window.scrollBy(0,200)", "");

		String txt = driver.findElement(By.xpath("(//a[@class='btn btn-theme btn-sm btn-min-block'])[1]")).getText();
		System.out.println("***performing action in frame***");
		System.out.println(txt);

		// switching to default window
		driver.switchTo().defaultContent();
		System.out.println("***switched to default***");
		js.executeScript("window.scrollBy(0,0)", "");

		driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[1]")).click();
		System.out.println("***clicked on Home button***");

		driver.navigate().back();
		System.out.println("***back to main page***");
		System.out.println(driver.getCurrentUrl());
	}

}
