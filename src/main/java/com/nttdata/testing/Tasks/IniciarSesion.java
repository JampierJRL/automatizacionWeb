package com.nttdata.testing.Tasks;

import com.nttdata.testing.Pages.HomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class IniciarSesion implements Task {
    private final String username;
    private final String password;

    public IniciarSesion(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(HomePage.BTN_LOGIN),
                Enter.theValue(username).into(HomePage.INP_LOGIN_USERNAME),
                Enter.theValue(password).into(HomePage.INP_LOGIN_PASSWORD),
                Click.on(HomePage.BTN_INICIAR_SESION)
        );
    }

    public static Performable withCredentials(String username, String password) {
        return new IniciarSesion(username, password);
    }
}
