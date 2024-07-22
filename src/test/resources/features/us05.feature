Feature: US05: Ingreso a la aplicacion web
  Scenario: CP05 - Cuando hay TyC pendientes se seguira hasta que se acepte los TyC
    Given ir a la pagina de login
    Then click al boton registrar

  Scenario: CP08 - Iniciar sesión con una cuenta no valida
    Given ir a la pagina de login
    Then click al boton registrar