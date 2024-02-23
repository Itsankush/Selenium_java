package tests;

import org.testng.annotations.Test;

public class testNG_tags {
	@Test(description = "This is C Test", groups = "smoke")
	void Ctest() {
		System.out.println("C");

	}

	@Test(dependsOnGroups = "smoke", dependsOnMethods = "Atest")
	void Btest() {
		System.out.println("B");

	}

	@Test(priority = 0)
	void Atest() {
		System.out.println("A");

	}

	@Test(groups = "smoke")
	void Dtest() {
		System.out.println("D");

	}

	@Test(groups = "smoke")
	void Etest() {
		System.out.println("E");

	}

	@Test(description = "Final method")
	void Ftest() {
		System.out.println("F");

	}

}
