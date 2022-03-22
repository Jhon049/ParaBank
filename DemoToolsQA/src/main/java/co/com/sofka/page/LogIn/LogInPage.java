package co.com.sofka.page.LogIn;


import co.com.sofka.model.ParaBank.FormContactUs;
import co.com.sofka.page.common.CommonActionOnPages;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class LogInPage extends CommonActionOnPages {

    @CacheLookup
    @FindBy(id = "name")
    private WebElement name;

    private final By Email = By.id("email");
    private final By Contact = By.xpath("/html/body/div[2]/div/ul[1]/li[8]/a");

    @CacheLookup
    @FindBy(id = "phone")
    private WebElement phone;

    @CacheLookup
    @FindBy(id = "message")
    private WebElement message;

    @CacheLookup
    @FindBy(xpath = "/html/body/div[1]/div[3]/div[1]/div/form/div[1]/input")
    private WebElement Username;

    @CacheLookup
    @FindBy(xpath = "/html/body/div[1]/div[3]/div[1]/div/form/div[2]/input")
    private WebElement password;

    @CacheLookup
    @FindBy(xpath = "/html/body/div[1]/div[3]/div[1]/div/form/div[3]/input")
    private WebElement Login;

    @CacheLookup
    @FindBy(xpath = "/html/body/div[1]/div[3]/div[1]/p/b")
    private WebElement assertionLogin;

    @CacheLookup
    @FindBy(xpath = "/html/body/div[1]/div[3]/div[2]/h1")
    private WebElement assertionLoginInvalido;

    public LogInPage(WebDriver driver,  int seconds) {
        super(driver, seconds, false);
        pageFactoryInitElement(driver, this);
    }

    public LogInPage(WebDriver driver, int seconds, boolean explicitTime) {
        super(driver, seconds, explicitTime);
    }

    public void formLogInPage(){
        typeOn(Username,"john");
        typeOn(password,"demo");
        clickOn(Login);
    }
    public void formLogInPageNovalido(){
        typeOn(Username,"Jhon");
        typeOn(password,"beta");
        clickOn(Login);
    }
    public void Loginsuccess(){
        Assertions.assertTrue(getText(assertionLogin).indexOf("Welcome")>=0);
    }
    public void Loginnovalido(){
        Assertions.assertEquals("Error!",assertionLoginInvalido.getText());
    }


}
