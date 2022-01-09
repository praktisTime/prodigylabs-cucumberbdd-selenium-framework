package net.prodigylabs.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "net/prodigylabs/steps",
        dryRun = false,
        tags = "",
        plugin = {
                "me.jvt.cucumber.report.PrettyReports:target",
        }
)
public class CukesRunner {

}
