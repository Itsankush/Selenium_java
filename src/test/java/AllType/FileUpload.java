package AllType;

//some issue with the html code of button
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Test;

public class FileUpload {

	@Test
	public void Task1() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\al10917\\eclipse-workspace\\selenium_Automation\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://the-internet.herokuapp.com/");

		driver.findElement(By.xpath("//a[@href='/upload']")).click();
		System.out.println("1");
		WebElement fileInput = driver.findElement(By.xpath("//input[@id='file-upload']"));
		System.out.println("2");
		// fileInput.click();
		System.out.println("3");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String filePath = "D:\\Automation\\My Intro.txt";
		System.out.println("4");
		// Here we need to use AutoIT to interact with windows file explorer.
		// need to write script and save it to .au3 extension.
		//
		try {
			Runtime.getRuntime().exec("D:\\Automation\\file_upload_script.exe");
			System.out.println("Inside try block");
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("5");
		driver.findElement(By.xpath("//input[@id='file-submit']")).click();

	}

}