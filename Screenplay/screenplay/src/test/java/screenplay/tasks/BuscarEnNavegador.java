package screenplay.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;
import screenplay.ui.BuscarPage;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class BuscarEnNavegador implements Task {
    private final String termino;

    public BuscarEnNavegador(String termino) {
        this.termino = termino;
    }

    public static BuscarEnNavegador elTermino(String termino) {
        return instrumented(BuscarEnNavegador.class, termino);
    }

    @Override
    @Step("{0} busca el término '#termino' en Wikipedia")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue(termino).into(BuscarPage.CAMPO_BUSQUEDA),Click.on(BuscarPage.BOTON_BUSCAR));
    }
}
