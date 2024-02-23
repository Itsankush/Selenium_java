package TestNG_dataProvider;

import org.testng.annotations.DataProvider;

public class dataProvider {

	@DataProvider(name = "data-provider")
	public Object[][] data() {
		return new Object[][] { { "Value Passed" } };
	}
}
