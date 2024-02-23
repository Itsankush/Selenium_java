package AllType;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Drag_and_Drop {

	@Test
	public void Task1() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\al10917\\eclipse-workspace\\selenium_Automation\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://the-internet.herokuapp.com/");

		driver.findElement(By.xpath("//a[@href='/drag_and_drop']")).click();
		WebElement Source = driver.findElement(By.xpath("//div[@id='column-a']"));
		WebElement Target = driver.findElement(By.xpath("//div[@id='column-b']"));

		Actions action = new Actions(driver);

		// build().perform() :- together ensures that the sequence of actions you've
		// defined using the Actions class is compiled into a single action and then
		// executed as a complete unit
		action.dragAndDrop(Source, Target).build().perform();

	}

}