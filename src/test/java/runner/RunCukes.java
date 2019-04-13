package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        plugin={"pretty","json:target/RunCuke/cucmber_report.json"
        		,"html:target/RunCuke/cucumber-html-report","html:target/site/cucumber-pretty"
        		,"json:target/cucumber.json"},
        features = "src\\test\\resources\\Feature",
        		
        glue="stepDefinition",
       tags={"@Paypal_CreateOrder"}
        )


public class RunCukes extends AbstractTestNGCucumberTests {
	

}
