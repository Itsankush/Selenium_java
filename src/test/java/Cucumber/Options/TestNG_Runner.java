package Cucumber.Options;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
features = "src/test/java/features", 
glue = "stepDefinations", 
plugin = { "pretty", "html:target/cucmber.html",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }, 
monochrome = true, 
tags = "@Hooks", 
publish = true
)

public class TestNG_Runner extends AbstractTestNGCucumberTests {

}
