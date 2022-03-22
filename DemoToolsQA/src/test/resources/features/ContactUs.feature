Feature: Como usuario
  Quiero contactar al equipo de soporte
  con el fin de que atiendan mi PQR

  @TestCustomerCare
  Scenario: Diligencio formulario Customer Care de manera exitosa
    Given que el usuario se encuentra en el modula Contact US
    When el usuario llena el fomulario en todos los campos y confirma la accion
    Then el sistema debera mostrar en pantalla mensaje de agradecimiento

  @TestCustomerCare
  Scenario: No se diligencia formulario Customer Care
    Given que el usuario se encuentra en el modula Contact US
    When el usuario no llena ningun campo del formulario y confirma la accion
    Then el sistema debera mostrar mensajes de advertencia por campos obligatorios

