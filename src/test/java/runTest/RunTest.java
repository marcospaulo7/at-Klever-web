package runTest;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true,
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        plugin = {"pretty", "json:reports/cucumber.json"},
        features = {"./src/test/resources/feature"},
        glue = {"web.Klever.steps", "web.Klever.configuration"},
        tags = "@smokeTest")


public class RunTest {
}
