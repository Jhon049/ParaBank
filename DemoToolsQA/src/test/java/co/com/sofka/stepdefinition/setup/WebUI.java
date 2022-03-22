package co.com.sofka.stepdefinition.setup;

import co.com.sofka.page.LogIn.LogInPage;
import co.com.sofka.page.Register.RegisterPage;
import co.com.sofka.stepdefinition.ParaBank.RegisterStepDefinition;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static co.com.sofka.util.Log4jValues.LOG4J_PROPERTIES_FILE_PATH;
import static com.google.common.base.StandardSystemProperty.USER_DIR;

public class WebUI {

    private static final String WEBDRIVER_CHROME_DRIVER = "webdriver.chrome.driver";
    private static final String WEBDRIVER_CHROME_DRIVER_PATH = "src/test/resources/driver/windows/chrome/chromedriver.exe";

    private static final String PRUEBA_PARABANK = "https://parabank.parasoft.com/parabank/index.htm";

    protected WebDriver driver;

    protected void setUpWebDriver(){
        System.setProperty(WEBDRIVER_CHROME_DRIVER, WEBDRIVER_CHROME_DRIVER_PATH);
    }

    protected void generalStUp(){
        driver = new ChromeDriver();
        driver.get(PRUEBA_PARABANK);
        driver.manage().window().maximize();
    }
    protected void Login(){
        LogInPage Login = new LogInPage(driver, 3);
        Login.formLogInPage();
    }
    protected void LoginNoValido(){
        LogInPage Login = new LogInPage(driver, 3);
        Login.formLogInPageNovalido();
    }
    protected void validateLogin(){
        LogInPage Login = new LogInPage(driver, 3);
        Login.Loginsuccess();
    }
    protected void validateLoginNovalido(){
        LogInPage Login = new LogInPage(driver, 3);
        Login.Loginnovalido();
    }
    protected void ingresaFormulario(){
        RegisterPage register = new RegisterPage(driver , 3);
        register.formRegisterPage();
    }
    protected void validarregister(){
        RegisterPage register = new RegisterPage(driver , 3);
        register.registersuccess();
    }
    protected void ingresaFormularioNovaido(){
        RegisterPage register = new RegisterPage(driver , 3);
        register.formInvalidRegisterPage();
    }
    protected void validarerrorderegister(){
        RegisterPage register = new RegisterPage(driver , 3);
        register.registersuccessmsg();
    }
    protected void setUpLog4j2(){
        PropertyConfigurator.configure(USER_DIR.value() + LOG4J_PROPERTIES_FILE_PATH.getValue());
    }

    protected void quiteDriver(){
        driver.quit();
    }
}
