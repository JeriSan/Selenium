Feature: US10: Tablero de Indicadores web
# Sprint 2  
  @US10-CP10 
  Scenario: CP10 - informacion en idioma especifico por preferencia de usuario
    Given ir a la pagina de login
    Then ingresar credenciales validas abdiel
    Then click al boton ingresar
    Then verificar si configuracion usuario es habilitado
    Then click configuracion usuario
    Then click datos de cliente de configuracion
    Then seleccionar idioma diferente al actual
    Then click boton guardar de editar perfil
    Then click boton guardar de confirmacion editar perfil
    Then verificar cambio de idioma de indicadores
    Then click configuracion usuario
    And click cerrar sesion de configuracion
