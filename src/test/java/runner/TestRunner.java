package runner;

import cucumber.api.CucumberOptions;
import tests.TestBase;

		@CucumberOptions(features = "src/test/java/features"
		,glue = {"stepDefintion"}
		,plugin = {"pretty","html:target/cucumber_html_report"})
	public class TestRunner extends TestBase {

}
