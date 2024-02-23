package AllType;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Switch_Tab {

	@Test
	public void Task1() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\al10917\\eclipse-workspace\\selenium_Automation\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// Switch windows
		WebElement op1 = driver.findElement(By.xpath("//a[@id='opentab']"));
		op1.click();

		Set<String> handles = driver.getWindowHandles();
		Iterator<String> i = handles.iterator();

		while (i.hasNext()) {
			driver.switchTo().window(i.next());
			String windowTitle = driver.getTitle();
			
			System.out.println("***inside while loop***");
			
			if (windowTitle.contains("Practice Page")) {
				break;
			}

		}
	}

}
