package testrunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resource/features",
		glue={"stepdefs"},
//		tags = "@BE",
		plugin = {"json:target/cucumber.json","pretty", "html:target/cucumber-pretty"},
		publish = true,
		monochrome = true
)
public class TestRunner {

}
