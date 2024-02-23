package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class blog {

	public WebDriver driver;

	public blog(WebDriver driver) {
		this.driver = driver;
	}

	// normal way
	By blog = By.xpath("//a[@href='https://www.qaclickacademy.com/blog']");
	By popup = By.xpath("//button[normalize-space()='NO THANKS']");
	By select_blog = By.cssSelector("h2[class='title'] a[title='JAVA INTERVIEW QUESTIONS']");
	By comment = By.cssSelector("#comment");
	By author = By.cssSelector("#author");

	// Another way i.e. page factory method
	@FindBy(css = "#email")
	WebElement email;

	public void clickOnBlog() {
		driver.findElement(blog).click();
	}

}
