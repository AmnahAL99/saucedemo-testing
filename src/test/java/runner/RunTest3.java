package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features/action.feature"},
        glue = {"stepdefinitions"},

        tags = "@Test3",
        plugin = {"pretty",
                "html:target/RegressionReport.html",
                "json:target/RegressionReport.json",
                "junit:target/RegressionReport.xml",

                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}

)
public class RunTest3 {
}
