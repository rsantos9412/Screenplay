package screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import screenplay.ui.BuscarPage;

public class ResultadoDeBusqueda implements Question<String> {
    public static ResultadoDeBusqueda es() {
        return new ResultadoDeBusqueda();
    }

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(BuscarPage.TITULO_RESULTADO).answeredBy(actor);
    }
}
