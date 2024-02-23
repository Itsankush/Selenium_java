package tests;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebElement_findElement {
	WebDriver driver;

	@Test
	public void find() throws IOException {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.qaclickacademy.com/");
		WebElement parent = driver.findElement(By.xpath("//div[@class='button float-left']"));
		File src = parent.getScreenshotAs(OutputType.FILE);
		System.out.println(parent.getText());
		parent.findElement(By.className("main-btn")).click();
		FileUtils.copyFile(src, new File("target/ScreenShot/ss.jpg"));
		driver.close();
	}
}
