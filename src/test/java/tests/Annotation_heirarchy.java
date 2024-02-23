package tests;

import org.testng.annotations.*;

public class Annotation_heirarchy {

	@Test
	void test() {
		System.out.println("Test");

	}

	@BeforeTest
	void Beforetest() {
		System.out.println("Before Test");

	}

	@AfterTest
	void Aftertest() {
		System.out.println("After Test");

	}

	@BeforeSuite
	void BeforeSuite() {
		System.out.println("Before Suite");

	}

	@AfterSuite
	void AfterSuite() {
		System.out.println("After Suite");

	}

	@BeforeClass
	void BeforeClass() {
		System.out.println("Before Class");

	}

	@AfterClass
	void AfterClass() {
		System.out.println("After Class");

	}

	@BeforeMethod
	void BeforeMethod() {
		System.out.println("Before Method");

	}

	@AfterMethod
	void AfterMethod() {
		System.out.println("After Method");

	}

}
