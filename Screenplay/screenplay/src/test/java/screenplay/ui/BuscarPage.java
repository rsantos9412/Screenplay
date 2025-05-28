package screenplay.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class BuscarPage {
    public static final Target CAMPO_BUSQUEDA = Target.the("Campo de búsqueda de Wikipedia").located(By.id("searchInput"));

    public static final Target BOTON_BUSCAR = Target.the("Botón de buscar en Wikipedia").located(By.cssSelector("button[type='submit']"));

    public static final Target TITULO_RESULTADO = Target.the("Título del artículo de resultado").located(By.id("firstHeading"));
}
