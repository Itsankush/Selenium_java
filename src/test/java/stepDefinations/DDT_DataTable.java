package stepDefinations;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;
import io.cucumber.datatable.DataTable;

public class DDT_DataTable {
	public static WebDriver driver;

	@Given("^User is on input Page$")
	public void launch() throws Throwable {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\al10917\\eclipse-workspace\\selenium_Automation\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://the-internet.herokuapp.com/inputs");
	}

	@When("User enters input")
	public void user_enters_input(DataTable dataTable) {
		List<List<String>> data = dataTable.asLists();
		driver.findElement(By.xpath("//input[@type='number']")).sendKeys(data.get(0).get(0));
		driver.findElement(By.xpath("//input[@type='number']")).sendKeys(data.get(1).get(0));
		driver.findElement(By.xpath("//input[@type='number']")).sendKeys(data.get(2).get(0));
	}

	@Then("^Success$")
	public void success() throws Throwable {
		System.out.println("Login Successfully");
	}

}
