package interface_use;

import java.net.HttpURLConnection;

import org.testng.annotations.Test;

public class Test1 extends Broswer_implementation {
	Broswer_implementation obj = new Test1();
	String url = "abcd";

	@Test
	public void TestCase_001() {
		obj.init();
		obj.launchBrowser(url);
		obj.navigateTo(url);
	}
}
