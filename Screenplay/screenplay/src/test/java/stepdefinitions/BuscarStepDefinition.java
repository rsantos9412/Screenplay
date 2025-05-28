package stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import screenplay.tasks.AbrirNavegador;
import screenplay.tasks.BuscarEnNavegador;
import screenplay.questions.ResultadoDeBusqueda;
import screenplay.utils.DriverConfig;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.containsString;


public class BuscarStepDefinition {

    @Managed
    //(driver = "chrome", uniqueSession = true, options = "--start-maximized")
    private WebDriver driver;

    private Actor usuario;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        usuario = Actor.named("Carlos");
        usuario.can(BrowseTheWeb.with(driver));
    }

    @Dado("que Carlos está en la página de Wikipedia")
    public void queCarlosEstáEnLaPáginaDeWikipedia() {
        //hisBrowser = new DriverConfig().newDriver();
        //usuario.can(BrowseTheWeb.with(hisBrowser));
        usuario.attemptsTo(AbrirNavegador.enLaPaginaPrincipal("https://es.wikipedia.org"));
    }

    @Cuando("busca el término {string}")
    public void buscaElTérmino(String termino) {
        usuario.attemptsTo(BuscarEnNavegador.elTermino(termino));
    }

    @Entonces("debería ver un artículo relacionado con {string}")
    public void deberíaVerUnArtículoRelacionadoCon(String terminoEsperado) {
        usuario.should(seeThat(ResultadoDeBusqueda.es(),containsString(terminoEsperado)));
    }

}
