package AllType;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class iframe_handling {

	@Test
	public void Task1() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\al10917\\eclipse-workspace\\selenium_Automation\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		Actions action = new Actions(driver);
		driver.get("http://the-internet.herokuapp.com/iframe");

		WebElement frame1 = driver.findElement(By.id("mce_0_ifr"));
		driver.switchTo().frame(frame1);
		WebElement content = driver.findElement(By.id("tinymce"));
		String val = content.getText();

		for (int i = 0; i < val.length(); i++) {
			content.sendKeys(Keys.BACK_SPACE);
		}

		content.sendKeys("Hello World");
		content.sendKeys(Keys.CONTROL + "A");
		driver.switchTo().defaultContent();
		WebElement bold = driver.findElement(By.xpath("//button[@title='Bold']"));
		bold.click();

	}

}
