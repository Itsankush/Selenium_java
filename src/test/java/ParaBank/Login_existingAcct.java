package ParaBank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login_existingAcct {
	@Test
	public void launch() {
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC");
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("BCAdmin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Test123!");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}

}
