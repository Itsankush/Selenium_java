package tests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class screenShot {
	WebDriverWait wait;
	WebDriver driver;

	@BeforeTest
	void start() {
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		String url = "https://www.goibibo.com/";
		driver.get(url);
	}

	@Test
	void openSite_3() {
		driver.get("https://www.spicejet.com/");
		driver.switchTo().alert().dismiss();
	}

	@Test
	void openSite_2() {
		driver.get(
				"https://stackoverflow.com/questions/51222724/how-to-select-an-option-from-a-dynamic-dropdown-using-selenium");
	}

	@Test
	void takeScreenShot() throws IOException {

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("target/ScreenShot/ss.jpg")); // Refresh project
	}

}
