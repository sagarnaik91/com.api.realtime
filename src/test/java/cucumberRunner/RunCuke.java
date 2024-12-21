package cucumberRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/cucumberFeatureFiles",glue = {"cucumberStepDefinition"},plugin = {"html:target/cucumber-reports/cucumber-html-report.html"},tags = "@test2 or @test1")
public class RunCuke extends AbstractTestNGCucumberTests {
}
