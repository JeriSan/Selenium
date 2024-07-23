Feature: US02: Registro de Usuario Web
  @US02-CP01	
  Scenario: CP01 - El sistema debe eliminar los espacios en blanco al inicio y al final del valor ingresado
    Given ir a la pagina de login
    Then click al boton registrar
    Then Llenar formulario con espacios en blanco al inicio y al final de cada campo
    And  click al boton siguiente
  
  @US02-CP02
  Scenario: CP02 - Registro de usuario, debe completar todos los campos
    Given ir a la pagina de login
    Then click al boton registrar
    Then Llenar formulario con un campo vacio para mostrar mensaje que debe completar todos los campos
    And click al boton siguiente
  
  @US02-CP05
  Scenario: CP05 - Cuando el correo no cumple con la estructura
    Given ir a la pagina de login
    Then click al boton registrar
    Then Llenar formulario ingresando un correo que no cumple con la estructura

  @US02-CP06
  Scenario: CP06 - Ingresar datos invalidos en el campo celular
    Given ir a la pagina de login
    Then click al boton registrar
  
  @US02-CP08
  Scenario: CP08 - Ingresar con un correo no existente
    Given ir a la pagina de login
    Then click al boton registrar
  
  @US02-CP10
  Scenario: CP10 - Ingresar contraseñas, debe cumplir con el patrón de contraseñas
    Given ir a la pagina de login
    Then click al boton registrar
    Then ingresar nueva cuenta valida
    Then verificar si boton siguiente esta habilitado
    Then click boton siguiente de nueva cuenta
    Then ingresar claves validas
    Then verificar si boton siguiente esta habilitado
    And click boton siguiente de password

  @US02-CP11
  Scenario: CP11 - La contraseña y la confirmacion no coinciden
    Given ir a la pagina de login
    Then click al boton registrar

  @US02-CP12
  Scenario: CP12 - Cumplimiento de las políticas de patrón de contraseñas
    Given ir a la pagina de login
    Then click al boton registrar
  
  @US02-CP13
  Scenario: CP13 - Mostrar las opciones de SMS y WhatsApp para enviar el codigo de verificacion
    Given ir a la pagina de login
    Then click al boton registrar
  
  @US02-CP14
  Scenario: CP14 - Ingresar codigo correcto luego enviar correo de activacion
    Given ir a la pagina de login
    Then click al boton registrar
  
  @US02-CP15
  Scenario: CP15 - Ingresar codigo de validacion invalido
    Given ir a la pagina de login
    Then click al boton registrar

  @US02-CP16
  Scenario: CP16 - Ingresar codigo de validacion no vigente
    Given ir a la pagina de login
    Then click al boton registrar
