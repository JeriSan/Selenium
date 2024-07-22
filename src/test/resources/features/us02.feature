Feature: US02: Registro de Usuario Web

  Scenario: CP01 - El sistema debe eliminar los espacios en blanco al inicio y al final del valor ingresado
    Given ir a la pagina de login
    Then click al boton registrar
    Then Llenar formulario con espacios en blanco al inicio y al final de cada campo
    And  click al boton siguiente

  Scenario: CP02 - Registro de usuario, debe completar todos los campos
    Given ir a la pagina de login
    Then click al boton registrar
    Then Llenar formulario con un campo vacio para mostrar mensaje que debe completar todos los campos
    And click al boton siguiente

  Scenario: CP05 - Cuando el correo no cumple con la estructura
    Given ir a la pagina de login
    Then click al boton registrar
    Then Llenar formulario ingresando un correo que no cumple con la estructura


  Scenario: CP06 - Ingresar datos invalidos en el campo celular
    Given ir a la pagina de login
    Then click al boton registrar

  Scenario: CP08 - Ingresar con un correo no existente
    Given ir a la pagina de login
    Then click al boton registrar

  Scenario: CP010 - Ingresar contraseñas, debe cumplir con el patrón de contraseñas
    Given ir a la pagina de login
    Then click al boton registrar

  Scenario: CP011 - La contraseña y la confirmacion no coinciden
    Given ir a la pagina de login
    Then click al boton registrar

  Scenario: CP012 - Cumplimiento de las políticas de patrón de contraseñas
    Given ir a la pagina de login
    Then click al boton registrar

  Scenario: CP013 - Mostrar las opciones de SMS y WhatsApp para enviar el codigo de verificacion
    Given ir a la pagina de login
    Then click al boton registrar

  Scenario: CP014 - Ingresar codigo correcto luego enviar correo de activacion
    Given ir a la pagina de login
    Then click al boton registrar

  Scenario: CP015 - Ingresar codigo de validacion invalido
    Given ir a la pagina de login
    Then click al boton registrar

  Scenario: CP016 - Ingresar codigo de validacion no vigente
    Given ir a la pagina de login
    Then click al boton registrar
