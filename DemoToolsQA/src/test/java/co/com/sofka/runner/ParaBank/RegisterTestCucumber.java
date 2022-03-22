package co.com.sofka.runner.ParaBank;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        publish = true,
        features = {"src/test/resources/features/Register.feature"},
        glue = "co.com.sofka.stepdefinition.ParaBank"
)
public class RegisterTestCucumber {
}