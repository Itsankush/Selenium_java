package AllType;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Alert_handling {
	String actual_msg1 = "I am a JS Alert";
	String actual_msg2 = "I am a JS Confirm";
	String actual_msg3 = "I am a JS prompt";

	@Test
	public void Task1() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\al10917\\eclipse-workspace\\selenium_Automation\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://the-internet.herokuapp.com/javascript_alerts");

		// Alert handling 1
		driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
		Alert alert1 = driver.switchTo().alert();
		String msg1 = alert1.getText();
		System.out.println(msg1);
		Assert.assertEquals(msg1, actual_msg1);
		alert1.accept();
		System.out.println("***Alert accepted***");

		// Alert handling 2
		driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
		Alert alert2 = driver.switchTo().alert();
		String msg2 = alert2.getText();
		System.out.println(msg2);
		Assert.assertEquals(msg2, actual_msg2);
		alert2.dismiss();
		System.out.println("***Alert dismissed***");

		// Alert handling 3
		driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
		Alert alert3 = driver.switchTo().alert();
		String msg3 = alert3.getText();
		System.out.println(msg3);
		Assert.assertEquals(msg3, actual_msg3);
		alert3.sendKeys("I am Ankush.");
		alert2.accept();
		System.out.println("***Alert accepted***");
	}

}
