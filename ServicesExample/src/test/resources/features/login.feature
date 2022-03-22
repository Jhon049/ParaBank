Feature: Inicios de sesión
  Como un usuario registrado del sistema
  nececito validar que las operaciones de logueo y disponibilidad al sitio web
  para poder tener seguridad en el perfil de los usuarios

  Scenario: login exitoso
    Given el usuario esta en la pagina de inicio de sesion con el correo de usuario "eve.holt@reqres.in" y la contrasena "cityslicka"
    When cuando el usuario hace una peticion de inicio
    Then el usuario debera ver un codigo de respuesta exitoso y un token de respuesta
