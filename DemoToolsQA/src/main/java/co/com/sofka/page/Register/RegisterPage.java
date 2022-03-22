package co.com.sofka.page.Register;


import co.com.sofka.model.ParaBank.FormContactUs;
import co.com.sofka.page.common.CommonActionOnPages;
import co.com.sofka.util.getRandomNum;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends CommonActionOnPages {

    String text = "Your account was created successfully. You are now logged in.";

    @CacheLookup
    @FindBy(xpath = "/html/body/div[1]/div[3]/div[1]/div/p[2]/a")
    private WebElement OpcionRegister;

    @CacheLookup
    @FindBy(id = "customer.firstName")
    private WebElement FirstName;

    @CacheLookup
    @FindBy(id = "customer.lastName")
    private WebElement LastName;

    @CacheLookup
    @FindBy(id = "customer.address.street")
    private WebElement Address;

    @CacheLookup
    @FindBy(id = "customer.address.city")
    private WebElement City;

    @CacheLookup
    @FindBy(id = "customer.address.state")
    private WebElement State;

    @CacheLookup
    @FindBy(id = "customer.address.zipCode")
    private WebElement ZipCode;

    @CacheLookup
    @FindBy(id = "customer.phoneNumber")
    private WebElement Phone;

    @CacheLookup
    @FindBy(id = "customer.ssn")
    private WebElement SSN;

    @CacheLookup
    @FindBy(id = "customer.username")
    private WebElement Username;

    @CacheLookup
    @FindBy(id = "customer.password")
    private WebElement Password;

    @CacheLookup
    @FindBy(id = "repeatedPassword")
    private WebElement Confirm;

    @CacheLookup
    @FindBy(xpath = "/html/body/div[1]/div[3]/div[1]/div/form/div[2]/input")
    private WebElement password;

    @CacheLookup
    @FindBy(xpath = "/html/body/div[1]/div[3]/div[2]/form/table/tbody/tr[13]/td[2]/input")
    private WebElement Register;

    @CacheLookup
    @FindBy(xpath = "/html/body/div[1]/div[3]/div[2]/p")
    private WebElement assertionRegister;

    @CacheLookup
    @FindBy(id = "customer.firstName.errors")
    private WebElement assertionRegisterError;

    public RegisterPage(WebDriver driver, int seconds) {
        super(driver, seconds, false);
        pageFactoryInitElement(driver, this);
    }
    public RegisterPage(WebDriver driver, int seconds, boolean explicitTime) {
        super(driver, seconds, explicitTime);
    }

    public void formRegisterPage(){
        getRandomNum num = new getRandomNum();
        clickOn(OpcionRegister);
        typeOn(FirstName,"Jhon");
        typeOn(LastName,"Sa");
        typeOn(Address,"cll15a 87b 40");
        typeOn(City,"colorado");
        typeOn(State,"florida");
        typeOn(ZipCode,"718613");
        typeOn(Phone,"91886871");
        typeOn(SSN,"9180139");
        typeOn(Username,"a"+num.getNumeber()+""+num.getNumeber()+""+num.getNumeber());
        typeOn(Password,"demo1");
        typeOn(Confirm,"demo1");
        clickOn(Register);
    }
    public void formInvalidRegisterPage(){
        clickOn(OpcionRegister);
        typeOn(FirstName,"");
        typeOn(LastName,"Sa");
        typeOn(Address,"cll15a 87b 40");
        typeOn(City,"colorado");
        typeOn(State,"florida");
        typeOn(ZipCode,"718613");
        typeOn(Phone,"91886871");
        typeOn(SSN,"9180139");
        typeOn(Username,"a4");
        typeOn(Password,"demo1");
        typeOn(Confirm,"demo1");
        clickOn(Register);
    }
    public void registersuccessmsg(){
        Assertions.assertTrue(assertionRegisterError.isDisplayed());
    }
    public void registersuccess(){
       Assertions.assertEquals(text,assertionRegister.getText());
    }
}
