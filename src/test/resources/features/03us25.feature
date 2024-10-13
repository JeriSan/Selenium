Feature: US25: Personalizar la Visualización de la Información web
# Sprint 3
  @US25-CP04
  Scenario: CP04 - Actualizar odometro menor al anterior
    Given ir a la pagina de login
    Then ingresar credenciales validas abdiel
    Then click al boton ingresar
    Then click panel Izquierdo
    Then verificar unidades disponibles en panel
    Then click detalle de Unidad
    Then ingresar Nuevo odometro menor al anterior
    Then verificar si actualizar cambios es habilitado
    Then click actualizar cambios
    And verificar si mensaje por odometro es mostrado
