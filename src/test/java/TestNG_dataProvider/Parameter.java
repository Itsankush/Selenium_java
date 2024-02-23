package TestNG_dataProvider;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.*;

public class Parameter {
	WebDriver driver;

	@Test(priority = 3)
	@Parameters("browser")
	public void Test1(@Optional("***Optional value***") String x) {
		Reporter.log("***Test1 Start***");
		if (x.equalsIgnoreCase("chrome")) {
			System.out.println("Chrome");
		} else if (x.equalsIgnoreCase("edge")) {
			System.out.println("Edge");
		} else
			System.out.println(x);
		Reporter.log("***Test1 End***");
		System.out.println("Test Complete");
	}

	@Test(priority = 1)
	@Parameters("os")
	public void Test2(String x) {
		System.out.println("Test Started");
		if (x.equalsIgnoreCase("windows")) {
			System.out.println("Windows");
		} else if (x.equalsIgnoreCase("mac")) {
			System.out.println("MAC");
		}
	}

	@Test(priority = 2)
	@Parameters("env")
	public void Test3(String x) {
		if (x.equalsIgnoreCase("dev")) {
			System.out.println("DEV");
		} else if (x.equalsIgnoreCase("prod")) {
			System.out.println("PROD");
		}
	}
}
