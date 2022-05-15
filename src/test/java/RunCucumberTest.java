import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        publish = true, glue = "cucumber.steps",
        dryRun = false,
        monochrome = true,
        tags = "@negative" ,
        plugin = {"pretty", "json:target/cucumber-report/cucumber.json"}
)

public class RunCucumberTest {


}