package co.com.sofka.stepdefinition.ParaBank;

import co.com.sofka.runner.ParaBank.FormContactUS;
import co.com.sofka.stepdefinition.setup.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;

public class RegisterStepDefinition extends WebUI {

    private static final Logger LOGGER = Logger.getLogger(FormContactUS.class);

    @Given("Usuario ingreso al modulo Register")
    public void usuarioIngresoAlModuloRegister() {
        setUpLog4j2();
        setUpWebDriver();
        generalStUp();
    }
    @When("ingresa formulario completo")
    public void ingresaFormularioCompleto() {
        ingresaFormulario();

    }
    @Then("registro de usuario exitoso")
    public void registroDeUsuarioExitoso() {
        validarregister();
        quiteDriver();
    }
    @When("ingresa formulario incorrecto")
    public void ingresaformularioincorrecto() {
        ingresaFormularioNovaido();

    }
    @Then("verifico que se muestre mensaje de error")
    public void verificoquesemuestremensajedeerror() {
        validarerrorderegister();
        quiteDriver();
    }
}
