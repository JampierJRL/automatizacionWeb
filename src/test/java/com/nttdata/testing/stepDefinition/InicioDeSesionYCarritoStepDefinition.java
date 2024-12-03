package com.nttdata.testing.stepDefinition;

import com.nttdata.testing.Tasks.AgregarAlCarrito;
import com.nttdata.testing.Tasks.IniciarSesion;
import com.nttdata.testing.Tasks.NavigateTo;
import com.nttdata.testing.Tasks.SeleccionarProducto;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class InicioDeSesionYCarritoStepDefinition {

    private String productName;

    @Given("el {actor} esta en la pagina de inicio para iniciar sesion y agregar productos")
    public void elUsuarioEstaEnLaPaginaParaIniciarSesionYAgregarProductos(Actor actor) {
        actor.attemptsTo(NavigateTo.theHomePage());
    }

    @And("el usuario inicia sesion con el nombre de usuario {string} y contrasenia {string}")
    public void elUsuarioIniciaSesion(String username, String password) {
        theActorInTheSpotlight().attemptsTo(IniciarSesion.withCredentials(username, password));
    }

    @When("selecciona un producto de la lista")
    public void seleccionaUnProducto() {
        SeleccionarProducto seleccionarProducto = new SeleccionarProducto();
        theActorInTheSpotlight().attemptsTo(seleccionarProducto.fromList());
        productName = seleccionarProducto.getProductName();
    }

    @And("lo agrega al carrito")
    public void loAgregaAlCarrito() {
        theActorInTheSpotlight().attemptsTo(
                AgregarAlCarrito.agregarProducto()
        );
    }

    @Then("el producto se agrega al carrito correctamente")
    public void elProductoSeAgregaAlCarritoCorrectamente() {
        System.out.println("Producto agregado al carrito exitosamente");

    }
}
