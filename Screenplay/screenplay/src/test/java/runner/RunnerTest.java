package runner;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/buscar.feature",
        glue = {"stepdefinitions"},
        tags = "@casoBusqueda"
)

public class RunnerTest {
}
