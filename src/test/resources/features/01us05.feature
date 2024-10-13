Feature: US05: Ingreso a la aplicacion web
  
  @US05-CP01
  Scenario: CP01 - Mostrar pantalla inicio sesion por ingresar al sistema con sesion inactiva
    Given ir a la pagina de login
    Then ingresar credenciales validas
    And click al boton ingresar
    #comentario

  @US05-CP02
  Scenario: CP02 - Mostrar TYC actualizado por primer acceso al sistema con credenciales validas
    Given ir a la pagina de login
    Then ingresar credenciales validas
    And click al boton ingresar

#  @US05-CP03 no aplica, es necesario acceder a una cuenta correo para validar
#  Scenario: CP03 - Obtener correo adjuntando TYC aceptado por usuario

  @US05-CP04
  Scenario: CP04 - Mostrar pantalla principal correspondiente al perfil del usuario por inicio de sesion exitoso y TYC aceptado
    Given ir a la pagina de login
    Then ingresar credenciales validas
    And click al boton ingresar
    
  @US05-CP05
  Scenario: CP05 - Mostrar TYC actualizado por primer acceso al sistema con credenciales validas sin permitir avanzar hasta aceptarlo
    Given ir a la pagina de login
    Then ingresar credenciales validas
    And click al boton ingresar

  @US05-CP06
  Scenario: CP06 - Mostrar TYC actualizado por primer acceso al sistema con credenciales validas usando cuenta de google
    Given ir a la pagina de login
    Then ingresar credenciales validas
    And click al boton ingresar

  @US05-CP07
  Scenario: CP07 - Mostrar mensaje por cuenta inactiva al usar credenciales de cuenta inactiva
	Given ir a la pagina de login
    Then ingresar credenciales validas
    And click al boton ingresar 
    
  @US05-CP08
  Scenario: CP08 - Mostrar mensaje por usar credenciales invalidas o incorrectas
    Given ir a la pagina de login
    Then ingresar credenciales validas
    And click al boton ingresar

  @US05-CP09
  Scenario: CP09 - Mostrar mensaje por usar credenciales de cuenta inexistente
    Given ir a la pagina de login
    Then ingresar credenciales validas
    And click al boton ingresar
    
#  @US05-CP10 no aplica, se debe consulta a base de datos
#  Scenario: CP03 - Mostrar logs de auditoria por inicio de sesion
