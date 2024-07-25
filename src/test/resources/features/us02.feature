Feature: US02: Registro de Usuario Web
  @US02-CP01
  Scenario: CP01 - El sistema debe eliminar los espacios en blanco al inicio y al final del valor ingresado
    Given ir a la pagina de login
    Then click al boton registrar
    Then Llenar formulario con espacios en blanco al inicio y al final de cada campo
    And  click boton siguiente de nueva cuenta

  @US02-CP02
  Scenario: CP02 - El usuario no ingresa todos los campos obligatorios
    Given ir a la pagina de login
    Then click al boton registrar
    Then El usuario no ingresa todos los campos obligatorios
    And click al boton siguiente

  @US02-CP05
  Scenario: CP05 - El correo no cumple con la estructura de correo
    Given ir a la pagina de login
    Then click al boton registrar
    Then El correo no cumple con la estructura de correo
    And click al boton siguiente

  @US02-CP06
  Scenario: CP06 - Ingresar datos invalidos en el campo celular
    Given ir a la pagina de login
    Then click al boton registrar
    Then Ingresar datos invalidos en el campo celular
    And click al boton siguiente

  @US02-CP08
  Scenario: CP08 - Registro con cuenta google con un correo no existente
    Given ir a la pagina de login
    Then click al boton registrar google
    Then Registro con cuenta google con un correo no existente
    And click al boton siguiente

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
