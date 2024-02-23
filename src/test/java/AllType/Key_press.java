package AllType;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.Keys;

public class Key_press {

	@Test
	public void Task1() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\al10917\\eclipse-workspace\\selenium_Automation\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://the-internet.herokuapp.com/key_presses");

		WebElement target = driver.findElement(By.xpath("//input[@id='target']"));

		target.sendKeys(Keys.BACK_SPACE);

		String result = driver.findElement(By.xpath("//p[@id='result']")).getText();
		String[] res = result.split(" ");

		String act = res[res.length - 1];
		Assert.assertEquals(act, "BACK_SPACE");
	}

}
