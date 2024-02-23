package AllType;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class JQueryUI_Menu {

	@Test
	public void Task1() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\al10917\\eclipse-workspace\\selenium_Automation\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		Actions action = new Actions(driver);

		driver.get("https://the-internet.herokuapp.com/jqueryui/menu");

		WebElement menu1 = driver.findElement(By.xpath("//a[contains(text(),'Enabled')]"));
		action.moveToElement(menu1).build().perform();
		// menu1.click();
		try {
			WebElement menu2 = driver.findElement(By.xpath("//li[@id='ui-id-4']"));
			action.moveToElement(menu2).build().perform();
			// menu2.click();

			WebElement menu3 = driver.findElement(By.xpath("//a[contains(text(),'PDF')]"));
			action.moveToElement(menu3).build().perform();
			menu3.click();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
