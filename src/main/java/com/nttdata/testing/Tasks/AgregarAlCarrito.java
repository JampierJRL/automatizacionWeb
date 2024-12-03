package com.nttdata.testing.Tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.nttdata.testing.Pages.HomePage.BTN_ADD_TO_CART;  // Suponiendo que tienes una clase Page para la página del producto

public class AgregarAlCarrito implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(BTN_ADD_TO_CART, WebElementStateMatchers.isVisible()).forNoMoreThan(10).seconds()
        );

        actor.attemptsTo(
                Click.on(BTN_ADD_TO_CART)
        );
    }

    public static AgregarAlCarrito agregarProducto() {
        return new AgregarAlCarrito();
    }
}
