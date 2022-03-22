Feature: Como usuario
  Quiero realizar Registro en la plataforma
  Para crear una cuenta

  @TestRegister
  Scenario: Se realiza Registro con datos completos
    Given Usuario ingreso al modulo Register
    When ingresa formulario completo
    Then registro de usuario exitoso

  @TestRegister
  Scenario: Se realiza registro no existoso
    Given Usuario ingreso al modulo Register
    When ingresa formulario incorrecto
    Then verifico que se muestre mensaje de error

