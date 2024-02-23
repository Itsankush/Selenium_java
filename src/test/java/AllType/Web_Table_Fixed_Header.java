package AllType;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Web_Table_Fixed_Header {

	@Test
	public void Task1() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\al10917\\eclipse-workspace\\selenium_Automation\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// Locate the table element
		WebElement table = driver.findElement(By.xpath("(//table[@id='product'])[2]"));

		// Locate the header row
		WebElement headerRow = table.findElement(By.tagName("thead")).findElement(By.tagName("tr"));

		// Get all header columns
		List<WebElement> headerColumns = headerRow.findElements(By.tagName("th"));

		// Print the header text
		for (WebElement headerColumn : headerColumns) {
			String header = headerColumn.getText();
			if (header.equals("Amount"))
				System.out.print(header + "\t");
		}

		// Get all rows from the table
		List<WebElement> rows = table.findElements(By.tagName("tr"));

		// Iterate through rows
		for (WebElement row : rows) {
			// Get all columns from the current row
			List<WebElement> columns = row.findElements(By.tagName("td"));
			
			// Iterate through columns
			for (WebElement column : columns) {
				System.out.println(columns.get(3).getText().trim());
			}

		}

		// Move to the next line for the next row
		System.out.println();
	}
}
