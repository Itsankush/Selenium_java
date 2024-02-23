package utils;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class takeSnapShot {
	WebDriver driver;

	File take_snap() {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		return src;
	}

}
