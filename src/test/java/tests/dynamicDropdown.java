package tests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class dynamicDropdown {
	WebDriver driver;

	@Test
	public void launchWebsite() {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver(option);
//		Explicit wait
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		String url = "https://www.goibibo.com/";
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector(".icClose")).click();
		driver.findElement(By.cssSelector(".sc-jlwm9r-1")).click();
		// dynamic drop down
		// From location
		WebElement from = driver.findElement(
				By.cssSelector("div[class='sc-jQrDum hXFakb'] p[class='sc-eLwHnm hHxEGr fswWidgetPlaceholder']"));

		Actions action = new Actions(driver);
		action.moveToElement(from).click().moveToElement(from, 200, 0).sendKeys("BOM").build().perform();
//		wait.until(ExpectedConditions
//				.elementToBeClickable(By.xpath("div[class='sc-cidDSM cXGIAa'] p[class='sc-bYoBSM eyNSEu fswWidgetPlaceholder']"))).click();
		List<WebElement> fromList = driver
				.findElements(By.xpath("//ul[@id='autoSuggest-list'] //li[@role='presentation']"));

		for (WebElement frm : fromList)
			if (frm.getText().contains("Chhatrapati Shivaji International Airport"))
				frm.click();

		driver.findElement(By.cssSelector(".sc-eWfVMQ.diuirR")).click();

		// To location
		WebElement to = driver.findElement(
				By.cssSelector("div[class='sc-jQrDum hgeZJA'] p[class='sc-eLwHnm hHxEGr fswWidgetPlaceholder']"));

		action.moveToElement(to).click().moveToElement(to, 200, 0).sendKeys("del").build().perform();

		List<WebElement> toList = driver
				.findElements(By.xpath("//ul[@id='autoSuggest-list'] //li[@role='presentation']"));

		for (WebElement To : toList)
			if (To.getText().contains("Indira Gandhi International Airport"))
				To.click();

	}
}
