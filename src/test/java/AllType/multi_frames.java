package AllType;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

// Not Working
public class multi_frames {
	@Test
	public void Task1() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\al10917\\eclipse-workspace\\selenium_Automation\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Actions action = new Actions(driver);
		driver.get("https://the-internet.herokuapp.com/nested_frames");
		WebElement frame1 = driver.findElement(By.xpath("//frame[@name='frame-top']"));
		driver.switchTo().frame(frame1);

		// Right
		WebElement frame2 = driver.findElement(By.xpath("//frame[@name='frame-right']"));
		driver.switchTo().frame(frame2);
		WebElement content = driver.findElement(By.xpath("//body[contains(text(),'RIGHT')]"));
		String val = content.getText();
		System.out.println(val);
		driver.switchTo().frame(frame1);
		// Middle
		WebElement frame3 = driver.findElement(By.xpath("//frame[@name='frame-middle']"));
		driver.switchTo().frame(frame3);
		WebElement content2 = driver.findElement(By.xpath("//body[contains(text(),'MIDDLE')]"));
		String val2 = content2.getText();
		System.out.println(val2);
	}
}
