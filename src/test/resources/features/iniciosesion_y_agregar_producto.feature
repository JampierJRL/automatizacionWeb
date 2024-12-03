Feature: Inicio de sesión y agregar producto al carrito

  @InicioSesion
  Scenario: El usuario agrega un producto al carrito
    Given el usuario esta en la pagina de inicio para iniciar sesion y agregar productos
    And el usuario inicia sesion con el nombre de usuario "janpierrodriguez" y contrasenia "123456"
    When selecciona un producto de la lista
    And lo agrega al carrito
    Then el producto se agrega al carrito correctamente