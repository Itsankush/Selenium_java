package AllType;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utility.startDriver;

public class Launch extends startDriver {

	@BeforeTest
	void initializeDriver() {
		driver = start();
	}

	@Test
	void launch() {
		driver.get("https://the-internet.herokuapp.com/");
	}

}
