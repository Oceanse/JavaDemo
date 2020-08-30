package hellocucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(format = "pretty", features = {"src/test/resources/hellocucumber/is_it_friday_yet.feature"})
public class CucumberTest {
}
