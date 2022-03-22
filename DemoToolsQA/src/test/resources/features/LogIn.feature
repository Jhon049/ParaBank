Feature: Como usuario
  Quiero realizar LogIn en la plataforma
  con el fin de acceder a mis datos

  @TestLogIn
  Scenario: Se realiza LogIn con datos validos
    Given Usuario se encuentra en el Home principal
    When ingresa credenciales validas
    Then accede a la plataforma de manera exitosa

  @TestLogInInvalido
  Scenario: Se realiza LogIn con datos invalidos
    Given Usuario se encuentra en el Home principal
    When ingresa credenciales no validas
    Then valido mensaje de error
