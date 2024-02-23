package TestNG_dataProvider;

import org.testng.annotations.Test;

public class access_dataProvider_data {

	@Test(dataProvider = "data-provider", dataProviderClass = dataProvider.class)
	void get_dataProvider_data(String val) {
		System.out.println(val);
	}
}
