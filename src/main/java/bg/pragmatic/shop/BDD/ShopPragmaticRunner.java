package bg.pragmatic.shop.BDD;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(plugin = { "progress", "html:target/cucumber-html-report" },
        features = "src/main/resources")

public class ShopPragmaticRunner extends AbstractTestNGCucumberTests {

}
