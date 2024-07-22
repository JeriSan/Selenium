Feature: US02: Registro de Usuario Web

  Scenario: CP01 - El sistema debe eliminar los espacios en blanco al inicio y al final del valor ingresado
    Given ir a la pagina de login
    Then click al boton registrar
    Then Llenar formulario con espacios en blanco al inicio y al final de cada campo
    Then click al boton siguiente
    And ingresamos las claves

  Scenario: CP02 - Registro de usuario, debe completar todos los campos
    Given ir a la pagina de login
    Then click al boton registrar
    Then Llenar formulario con un campo vacio para mostrar mensaje que debe completar todos los campos
    And click al boton siguiente
