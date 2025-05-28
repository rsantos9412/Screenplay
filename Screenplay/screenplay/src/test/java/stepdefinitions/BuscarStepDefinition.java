package stepdefinitions;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import screenplay.tasks.AbrirNavegador;
import screenplay.tasks.BuscarEnNavegador;
import screenplay.questions.ResultadoDeBusqueda;
import screenplay.utils.DriverConfig;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.containsString;


public class BuscarStepDefinition {
    @Managed(driver = "chrome", uniqueSession = true, options = "--start-maximized")
    WebDriver hisBrowser;

    private Actor carlos = Actor.named("Carlos");

    @Dado("que Carlos está en la página de Wikipedia")
    public void queCarlosEstáEnLaPáginaDeWikipedia() {
        hisBrowser = new DriverConfig().newDriver();
        carlos.can(BrowseTheWeb.with(hisBrowser));

        carlos.attemptsTo(AbrirNavegador.enLaPaginaPrincipal("https://es.wikipedia.org"));
    }

    @Cuando("busca el término {string}")
    public void buscaElTérmino(String termino) {
        carlos.attemptsTo(BuscarEnNavegador.elTermino(termino));
    }

    @Entonces("debería ver un artículo relacionado con {string}")
    public void deberíaVerUnArtículoRelacionadoCon(String terminoEsperado) {
        carlos.should(seeThat(ResultadoDeBusqueda.es(),containsString(terminoEsperado)));
    }

}
