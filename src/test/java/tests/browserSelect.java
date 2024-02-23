package tests;

import java.util.Scanner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class browserSelect {
	@Test
	void selectBrowser() {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter anyof choices from belwo options:");
		System.out.println("1. Chrome");
		System.out.println("2. Edge");
		int browser = in.nextInt();
		switch (browser) {
		case 1:
			WebDriverManager.chromedriver().setup();
			WebDriver driver1 = new ChromeDriver();
			driver1.get("https://www.spicejet.com/");
			break;
		case 2:
			WebDriverManager.edgedriver().setup();
			WebDriver driver2 = new EdgeDriver();
			driver2.get("https://www.spicejet.com/");
			break;

		}
	}

}
