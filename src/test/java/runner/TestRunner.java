package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\java\\features",plugin = {"pretty","html:target/testReport/report.html"}, glue= "stepDefination",tags = "@reg")
public class TestRunner {
	
//	feature---> path of the feature file
//	plugin---> for report generation (json report), 
//	glue---> define the tags
//	dryRun---> true or false (it check the all files are defined properly if not the will not run)
//	monochrome--->  console more readable
	
		
	}
