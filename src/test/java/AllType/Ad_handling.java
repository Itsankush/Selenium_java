package AllType;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Ad_handling {

	@Test
	public void Task1() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\al10917\\eclipse-workspace\\selenium_Automation\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// admin:admin@ represents the username and password for basic authentication
		driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");

		WebElement msg = driver.findElement(By.tagName("p"));

		System.out.println(msg.getText());

	}

}
