package AllType;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

//Robot class provides a way to simulate keyboard and mouse actions at the OS level
//handling native OS pop-ups or performing keyboard shortcuts
public class Robot_class_Usage {

	@Test
	public void Task1() throws AWTException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\al10917\\eclipse-workspace\\selenium_Automation\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// admin:admin@ represents the username and password for basic authentication
		driver.get("http://the-internet.herokuapp.com/key_presses");

		driver.findElement(By.id("target")).click();

		Robot robot = new Robot();

		// Simulate pressing and releasing the 'A' key
		robot.keyPress(KeyEvent.VK_A);
		robot.keyRelease(KeyEvent.VK_A);

		// Simulate pressing and releasing the left mouse button
		robot.mousePress(KeyEvent.BUTTON2_DOWN_MASK);
		robot.mouseRelease(KeyEvent.BUTTON2_DOWN_MASK);

	}

}
