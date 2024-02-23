package AllType;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Alert_handling2 {
	String actual_msg1 = "Hello Ankush, share this practice page and share your knowledge";
	String actual_msg2 = "Hello Ankush, Are you sure you want to confirm?";

	@Test
	public void Task1() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\al10917\\eclipse-workspace\\selenium_Automation\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		// Alert handling
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Ankush");
		driver.findElement(By.xpath("//input[@id='alertbtn']")).click();

		Alert alert1 = driver.switchTo().alert();
		String msg1 = alert1.getText();
		System.out.println(msg1);
		Assert.assertEquals(msg1, actual_msg1);
		alert1.accept();
		System.out.println("***Alert accepted***");

		// Alert handling
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Ankush");
		driver.findElement(By.xpath("//input[@id='confirmbtn']")).click();

		Alert alert2 = driver.switchTo().alert();
		String msg2 = alert2.getText();
		System.out.println(msg2);
		Assert.assertEquals(msg2, actual_msg2);
		alert2.dismiss();
		System.out.println("***Alert dismissed***");

	}

}
