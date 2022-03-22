package co.com.sofka.runner.ParaBank;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        publish = true,
        features = {"src/test/resources/features/LogIn.feature"},
        glue = "co.com.sofka.stepdefinition.ParaBank"
)
public class LogInTestCucumber {
}