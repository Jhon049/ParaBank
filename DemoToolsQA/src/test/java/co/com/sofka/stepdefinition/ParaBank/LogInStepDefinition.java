package co.com.sofka.stepdefinition.ParaBank;

import co.com.sofka.model.ParaBank.FormContactUs;
import co.com.sofka.page.ContactUs.ContactUsPage;
import co.com.sofka.page.LogIn.LogInPage;
import co.com.sofka.runner.ParaBank.FormContactUS;
import co.com.sofka.stepdefinition.setup.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

public class LogInStepDefinition extends WebUI {

    private static final Logger LOGGER = Logger.getLogger(FormContactUS.class);

    @Given("Usuario se encuentra en el Home principal")
    public void usuarioSeEncuentraEnElHomePrincipal() {
        setUpLog4j2();
        setUpWebDriver();
        generalStUp();
    }
    @When("ingresa credenciales validas")
    public void ingresaCredencialesValidas() {
        Login();
    }
    @When("ingresa credenciales no validas")
    public void ingresaCredencialesNoValidas() {
        LoginNoValido();
    }
    @Then("accede a la plataforma de manera exitosa")
    public void accedeALaPlataformaDeManeraExitosa() {
        validateLogin();
        quiteDriver();
    }
    @Then("valido mensaje de error")
    public void validoMensajeDeError() {
        validateLoginNovalido();
        quiteDriver();
    }
}
