package co.com.sofka.stepdefinition;

import co.com.sofka.stepdefinition.setup.services.ServiceSetUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class LoginTestStepDefinition extends ServiceSetUp {

    public static final Logger LOGER = Logger.getLogger(LoginTestStepDefinition.class);
    private Response response;
    private RequestSpecification resquest;

    @Given("el usuario esta en la pagina de inicio de sesion con el correo de usuario {string} y la contrasena {string}")
    public void elUsuarioEstaEnLaPaginaDeInicioDeSesionConElCorreoDeUsuarioYLaContrasena(String email, String password) {
        try{
            generalSetUp();
            resquest = given()
                    .log()
                    .all()
                    .contentType(ContentType.JSON)
                    .body(body(email, password));
        } catch (Exception e){
            LOGER.error(e.getMessage(), e);
            Assertions.fail(e.getMessage());
        }
    }

    @When("cuando el usuario hace una peticion de inicio")
    public void cuandoElUsuarioHaceUnaPeticionDeInicio() {
        try{
            response = resquest.when()
                    .post(LOGIN_RESOURCE);
        } catch (Exception e){
            LOGER.error(e.getMessage(), e);
            Assertions.fail(e.getMessage());
        }
    }

    @Then("el usuario debera ver un codigo de respuesta exitoso y un token de respuesta")
    public void elUsuarioDeberaVerUnCodigoDeRespuestaExitosoYUnTokenDeRespuesta() {
        try{
            response.then()
                    .log()
                    .all()
                    .statusCode(HttpStatus.SC_OK)
                    .body("token", notNullValue());
        } catch (Exception e){
            LOGER.error(e.getMessage(), e);
            Assertions.fail(e.getMessage());
        }
    }

    private String body(String email, String password){
        return "{\n" +
                "    \"email\": \"" + email + "\",\n" +
                "    \"password\": \"" + password + "\"\n" +
                "}";
    }

}
