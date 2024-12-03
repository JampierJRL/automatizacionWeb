package com.nttdata.testing.Pages;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

@DefaultUrl("https://www.demoblaze.com/")
public class HomePage extends PageObject {
  public static final Target BTN_SIGN_UP = Target.the("Boton para hacer el registro")
  .located(By.id("signin2"));    public static final Target REGISTER_MODAL = Target.the("Modal de registro")
  .located(By.id("signInModalLabel"));    public static final Target INP_USERNAME = Target.the("Nombre de usuario")
  .located(By.id("sign-username"));    public static final Target INP_PASSWORD = Target.the("Contraseña")
  .located(By.id("sign-password"));    public static final Target BTN_REGISTRAR = Target.the("Boton Registrar")
  .located(By.xpath("//button[text()='Sign up']"));    //  LOG IN
  public static final Target BTN_LOGIN = Target.the("Botón para iniciar sesión")
          .located(By.id("login2"));
  public static final Target LOGIN_MODAL = Target.the("Modal para iniciar sesión")
          .located(By.id("logInModalLabel"));
  public static final Target INP_LOGIN_USERNAME = Target.the("Campo de usuario para iniciar sesión")
          .located(By.id("loginusername"));
  public static final Target INP_LOGIN_PASSWORD = Target.the("Campo de contraseña para iniciar sesión")
          .located(By.id("loginpassword"));
  public static final Target BTN_INICIAR_SESION = Target.the("Botón para iniciar sesión")
          .located(By.xpath("//button[text()='Log in']"));

  public static final Target PRODUCT_LIST = Target.the("Lista de productos")
          .located(By.xpath("//div[@id='tbodyid']//a//img"));


  public static final Target BTN_ADD_TO_CART = Target.the("Botón de 'Add to Cart'")
          .located(By.xpath("//a[@id='add-to-cart']"));
}