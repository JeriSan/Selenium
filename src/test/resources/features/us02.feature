Feature: US02: Registro de Usuario Web
  @US02-CP01
  Scenario: CP01 - El sistema debe eliminar los espacios en blanco al inicio y al final del valor ingresado
    Given ir a la pagina de login
    Then click al boton registrar
    Then ingresar campos Nueva cuenta con espacios en blanco al inicio y al final
    Then verificar campos Nueva cuenta sin espacios en blanco al inicio y al final
    Then verificar si boton siguiente de nueva cuenta es habilitado
    And click boton siguiente de nueva cuenta

  @US02-CP02
  Scenario: CP02 - El usuario no ingresa todos los campos obligatorios
    Given ir a la pagina de login
    Then click al boton registrar
    Then ingresar campos Nueva cuenta sin todos los campos obligatorios
    And verificar si boton siguiente de nueva cuenta es deshabilitado

  @US02-CP03
  Scenario: CP03 - El usuario se registra con un correo nuevo
    Given ir a la pagina de login
    Then click al boton registrar
    Then ingresar campos Nueva cuenta con correo nuevo
    And verificar si boton siguiente de nueva cuenta es deshabilitado
    
  @US02-CP05
  Scenario: CP05 - El correo no cumple con la estructura de correo
    Given ir a la pagina de login
    Then click al boton registrar
    Then ingresar campos Nueva cuenta con correo no cumple estructura
    And verificar si boton siguiente de nueva cuenta es deshabilitado

  @US02-CP06
  Scenario: CP06 - Ingresar datos invalidos en el campo celular
    Given ir a la pagina de login
    Then click al boton registrar
    Then ingresar campos Nueva cuenta con celular invalido
    And verificar si boton siguiente de nueva cuenta es deshabilitado

  @US02-CP08
  Scenario: CP08 - Registro con cuenta google con un correo no existente
    Given ir a la pagina de login
   # And click al boton registrar google
   # Then Registro con cuenta google con un correo no existente
   # And click al boton siguiente
  
  @US02-CP10
  Scenario: CP10 - Ingresar contraseñas, debe cumplir con el patrón de contraseñas
    Given ir a la pagina de login
    Then click al boton registrar
    Then ingresar nueva cuenta valida
    Then verificar si boton siguiente de nueva cuenta es habilitado
    Then click boton siguiente de nueva cuenta
    Then ingresar claves validas
    Then verificar check activo por cada politica
    Then verificar si boton siguiente de password esta habilitado
    And click boton siguiente de password

  @US02-CP11
  Scenario: CP11 - La contraseña y la confirmacion no coinciden
    Given ir a la pagina de login
    Then click al boton registrar
    Then ingresar nueva cuenta valida
    Then verificar si boton siguiente de nueva cuenta es habilitado
    Then click boton siguiente de nueva cuenta
    Then ingresar claves diferentes
    Then verificar politica claves iguales
    Then verificar mensaje error por politica claves iguales
    And verificar si boton siguiente de password esta deshabilitado

  @US02-CP12
  Scenario: CP12 - Cumplimiento de las políticas de patrón de contraseñas
    Given ir a la pagina de login
    Then click al boton registrar
    Then ingresar nueva cuenta valida
    Then verificar si boton siguiente de nueva cuenta es habilitado
    Then click boton siguiente de nueva cuenta
    
    When ingresar claves sin mayuscula
    Then verificar politica claves con mayuscula
    And verificar si boton siguiente de password esta deshabilitado
    When limpiar claves

    When ingresar claves sin numero
    Then verificar politica claves con numero
    And verificar si boton siguiente de password esta deshabilitado
    When limpiar claves
        
    When ingresar claves sin caracter especial
    Then verificar politica claves con caracer especial
    And verificar si boton siguiente de password esta deshabilitado
    When limpiar claves
        
    When ingresar claves 7 caracteres
    Then verificar politica claves con 8 caracteres
    And verificar si boton siguiente de password esta deshabilitado
    When limpiar claves
    
    When ingresar claves con espacio
    Then verificar politica claves sin espacio en blanco
    And verificar si boton siguiente de password esta deshabilitado
    When limpiar claves
    
    When ingresar claves con secuencias
    Then verificar politica claves sin secuencias
    And verificar si boton siguiente de password esta deshabilitado
    When limpiar claves
    
    When ingresar claves sin minuscula
    Then verificar politica claves con minuscula
    And verificar si boton siguiente de password esta deshabilitado
    When limpiar claves
    
    When ingresar claves diferentes
    Then verificar politica claves iguales
    And verificar si boton siguiente de password esta deshabilitado
  
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
