package AllType;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Web_Table {

	@Test
	public void Task1() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\al10917\\eclipse-workspace\\selenium_Automation\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		//
		// Locate the table element
        WebElement table = driver.findElement(By.id("product"));

        // Get all rows from the table
        List<WebElement> rows = table.findElements(By.tagName("tr"));
     
        // Iterate through rows
        for (WebElement row : rows) {
            // Get all columns from the current row
            List<WebElement> columns = row.findElements(By.tagName("td"));

            // Iterate through columns
            for (WebElement column : columns) {
                // Extract and print the text from each cell
                System.out.print(column.getText() + "\t");
            }

            // Move to the next line for the next row
            System.out.println();
        }
	}

}
