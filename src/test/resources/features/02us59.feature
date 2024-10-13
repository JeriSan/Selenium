Feature: US59: Configuracion perfil de usuario WEB
# Sprint 2  
  @US59-CP07 
  Scenario: CP07 - Ingresar contraseñas, debe cumplir con el patrón de contraseñas
    Given ir a la pagina de login
    Then ingresar credenciales validas hans
    Then click al boton ingresar
    Then verificar si configuracion usuario es habilitado
    Then click configuracion usuario
    Then click datos de cliente de configuracion
    Then click tab contrasena
    
	When ingresar claves sin mayuscula en perfil
	Then verificar claves sin mayuscula en perfil
	Then verificar si boton siguiente de password esta habilitado en perfil
	Then click boton guardar de password en perfil
	And verificar si mensaje por politica es mostrado
    
    When ingresar claves sin numero en perfil
	Then verificar claves sin numero en perfil
	Then verificar si boton siguiente de password esta habilitado en perfil
	Then click boton guardar de password en perfil
	And verificar si mensaje por politica es mostrado

    When ingresar claves sin caracter especial en perfil
	Then verificar claves sin caracter especial en perfil
	Then verificar si boton siguiente de password esta habilitado en perfil
	Then click boton guardar de password en perfil
	And verificar si mensaje por politica es mostrado
	
	When ingresar claves 7 caracteres en perfil
	Then verificar claves sin 8 caracteres en perfil
	Then verificar si boton siguiente de password esta habilitado en perfil
	Then click boton guardar de password en perfil
	And verificar si mensaje por politica es mostrado
	
	When ingresar claves con espacio en perfil
	Then verificar claves sin espacio en blanco en perfil
	Then verificar si boton siguiente de password esta habilitado en perfil
	Then click boton guardar de password en perfil
	And verificar si mensaje por politica es mostrado
	
	When ingresar claves con secuencias en perfil
	Then verificar claves sin secuencias en perfil
	Then verificar si boton siguiente de password esta habilitado en perfil
	Then click boton guardar de password en perfil
	And verificar si mensaje por politica es mostrado
	
	When ingresar claves sin minuscula en perfil
	Then verificar claves sin minuscula en perfil
	Then verificar si boton siguiente de password esta habilitado en perfil
	Then click boton guardar de password en perfil
	And verificar si mensaje por politica es mostrado
	
	When ingresar claves diferentes en perfil
	Then verificar claves iguales en perfil
	Then verificar si boton siguiente de password esta habilitado en perfil
	Then click boton guardar de password en perfil
	And verificar si mensaje por politica es mostrado
	
	Then click boton cancelar de password en perfil
	Then click configuracion usuario
    And click cerrar sesion de configuracion
    