package com.nttdata.testing.Tasks;

import com.nttdata.testing.Pages.HomePage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;

public class SeleccionarProducto implements Task {
    private String productName;
    private String productId;

    public static SeleccionarProducto fromList() {
        return new SeleccionarProducto();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        List<WebElementFacade> productos = HomePage.PRODUCT_LIST.resolveAllFor(actor);

        for (WebElementFacade producto : productos) {
            try {
                // Esperamos a que el producto sea visible
                actor.attemptsTo(
                        WaitUntil.the((Target) producto, WebElementStateMatchers.isVisible()).forNoMoreThan(10).seconds(),
                        Click.on(producto)
                );

                // Almacenar el nombre y el ID del producto seleccionado
                productName = producto.getText();  // Asegúrate de que esto es el nombre correcto
                productId = producto.getAttribute("href").split("idp_=")[1];  // Suponiendo que el ID está en el href (ajusta esto según sea necesario)

                // Comprobar si el nombre y el ID son válidos
                if (productName != null && !productName.isEmpty() && productId != null && !productId.isEmpty()) {
                    break;
                }
            } catch (Exception e) {
                // Si ocurre un error, intentamos con el siguiente producto
                continue;
            }
        }

        // Redirigir a la página del producto con su ID correspondiente
        if (productId != null) {
            String productUrl = "https://www.demoblaze.com/prod.html?idp_=" + productId;
            actor.attemptsTo(Open.url(productUrl));  // Abrir la URL del producto
        }
    }

    public String getProductName() {
        return productName;
    }

    public String getProductId() {
        return productId;
    }
}
