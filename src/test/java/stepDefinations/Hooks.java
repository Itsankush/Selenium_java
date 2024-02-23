package stepDefinations;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

	@Before("@Hooks")
	public void before_all_Scenario() {
		System.out.println("Before all scenario");
	}

	@After("@Hooks")
	public void after_all_Scenario() {
		System.out.println("After all Scenario");
	}
}
