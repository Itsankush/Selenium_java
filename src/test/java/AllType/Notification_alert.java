package AllType;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Notification_alert {

	@Test
	public void Task1() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\al10917\\eclipse-workspace\\selenium_Automation\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/notification_message_rendered");

		WebElement url = driver.findElement(By.xpath("//a[contains(text(),'Click here')]"));
		url.click();

		WebElement alert = driver.findElement(By.xpath("//div[@id='flash']"));
		System.out.println(alert.getText());

		driver.findElement(By.xpath("//a[@class='close']")).click();
	}

}
