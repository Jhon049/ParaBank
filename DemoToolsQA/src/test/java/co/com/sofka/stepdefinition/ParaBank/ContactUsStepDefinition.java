package co.com.sofka.stepdefinition.ParaBank;

import co.com.sofka.model.ParaBank.FormContactUs;
import co.com.sofka.page.ContactUs.ContactUsPage;
import co.com.sofka.runner.ParaBank.FormContactUS;
import co.com.sofka.stepdefinition.setup.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

public class ContactUsStepDefinition extends WebUI {

    private static final Logger LOGGER = Logger.getLogger(FormContactUS.class);
    private FormContactUs formContactUs; //model
    private ContactUsPage contactUsPage; //page object

    @Given("que el usuario se encuentra en el modula Contact US")
    public void queElUsuarioSeEncuentraEnElModulaContactUS() {
        try {
            setUpLog4j2();
            setUpWebDriver();
            generalStUp();
            formContactUs = new FormContactUs();
        }catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(), exception);
        }
    }
    @When("el usuario llena el fomulario en todos los campos y confirma la accion")
    public void elUsuarioLlenaElFomularioEnTodosLosCamposYConfirmaLaAccion() {
    }

    @Then("el sistema debera mostrar en pantalla mensaje de agradecimiento")
    public void elSistemaDeberaMostrarEnPantallaMensajeDeAgradecimiento() {
    }

    @When("el usuario no llena ningun campo del formulario y confirma la accion")
    public void elUsuarioNoLlenaNingunCampoDelFormularioYConfirmaLaAccion() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("el sistema debera mostrar mensajes de advertencia por campos obligatorios")
    public void elSistemaDeberaMostrarMensajesDeAdvertenciaPorCamposObligatorios() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
