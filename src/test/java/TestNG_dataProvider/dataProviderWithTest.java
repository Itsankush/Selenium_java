package TestNG_dataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProviderWithTest {
//Define data provider
	@DataProvider(name = "Static data-provider")
	public Object[][] static_data() {
		return new Object[][] { { "Ankush", "Yes" } };
	}

//Define data provider
	@DataProvider(name = "Dynamic data-provider")
	public Object[][] dynamic_data() {
		Object[][] obj = new Object[4][2];
		obj[0][0] = "Name";
		obj[0][1] = "Gender";
		obj[1][0] = "Ankush";
		obj[1][1] = "Male";
		obj[2][0] = "Arati";
		obj[2][1] = "Female";
		obj[3][0] = "Vaibhav";
		obj[3][1] = "Male";
		return obj;

	}

//Calling data provider to access data
	@Test(dataProvider = "Dynamic data-provider")
	void get_dataProvider_data(String val, String n) {
		System.out.println(val + " " + n);
	}
}
