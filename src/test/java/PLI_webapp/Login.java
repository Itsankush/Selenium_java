package PLI_webapp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Login {

	@Test
	public void Task1() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\al10917\\eclipse-workspace\\selenium_Automation\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		WebDriverWait wait = new WebDriverWait(driver, 10);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://pdc-dev1.lottery.ie/");

		WebElement accept_cookie = driver.findElement(By.xpath("//button[@title='Accept Cookies']"));
		wait.until(ExpectedConditions.elementToBeClickable(accept_cookie));
		accept_cookie.click();

		driver.findElement(By.linkText("Sign In")).click();

		WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
		username.click();
		username.sendKeys("evtest+2004@mkodo.com");

		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		password.click();
		password.sendKeys("Accion123");
		js.executeScript("window.scrollBy(0,300)", "");
		WebElement Submit = driver.findElement(By.xpath("//button[@id='signInButton']"));

		wait.until(ExpectedConditions.elementToBeClickable(Submit));

		Submit.click();

		WebElement btn = driver.findElement(By.xpath("(//a[@role='button'])[1]"));
		wait.until(ExpectedConditions.elementToBeClickable(btn));
		btn.click();
		WebElement account = driver.findElement(By.xpath(
				"//div[@class='relative mt-0.5 flex items-center']//span[@class='text-blue-700'][normalize-space()='M']"));
		wait.until(ExpectedConditions.elementToBeClickable(account));
		account.click();

		WebElement Financial_txn = driver.findElement(By.linkText("Financial Transactions"));
		wait.until(ExpectedConditions.elementToBeClickable(Financial_txn));
		Financial_txn.click();

		String msg = driver.findElement(By.xpath("//div[@class='max-w-xs font-bold text-lg']")).getText();

		System.out.println(msg);

	}

}
