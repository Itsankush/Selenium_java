package stepDefinations;

import io.cucumber.java.en.Given;

public class Hooks_Demo {

	@Given("^this is first scenario$")
	public void method_one() {
		System.out.println("This is first scenario");
	}

	@Given("^this is second scenario$")
	public void method_two() {
		System.out.println("This is second scenario");
	}

	@Given("launch browser")
	public void launch() {
		System.out.println("Browser Launch!!!");
	}
}
