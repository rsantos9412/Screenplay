package screenplay.tasks;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;


import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AbrirNavegador implements Task {

    private final String url;

    public AbrirNavegador(String url) {
        this.url = url;
    }

    public static AbrirNavegador enLaPaginaPrincipal(String url) {
        return instrumented(AbrirNavegador.class, url);
    }

    @Override
    @Step("{0} abre la página de Wikipedia en '#url'")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.url(url));
    }
}
