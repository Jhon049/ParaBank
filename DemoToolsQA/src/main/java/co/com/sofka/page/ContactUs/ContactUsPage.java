package co.com.sofka.page.ContactUs;

import co.com.sofka.model.ParaBank.FormContactUs;
import co.com.sofka.page.common.CommonActionOnPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class ContactUsPage extends CommonActionOnPages {

    private FormContactUs formContactUs;

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

    private final By submit = By.xpath("/html/body/div[1]/div[3]/div[2]/form/table/tbody/tr[5]/td[2]/input");

    @CacheLookup
    @FindBy(xpath = " /html/body/div[1]/div[3]/div[2]")
    private WebElement assertionContact;

    public ContactUsPage(WebDriver driver, FormContactUs formContactUs, int seconds) {
        super(driver, seconds, false);
        pageFactoryInitElement(driver, this);
        this.formContactUs = formContactUs;
    }

    public void fillFormContactUs() throws InterruptedException {
        clickOn(Contact);

        scrollOn(name);
        clearOn(name);
        typeOn(name, formContactUs.getName());

        scrollOn(Email);
        clearOn(Email);
        typeOn(Email, formContactUs.getEmail());

        scrollOn(phone);
        clearOn(phone);
        typeOn(phone, formContactUs.getPhone());

        scrollOn(message);
        clearOn(message);
        typeOn(message, formContactUs.getMessage());

        doSubmit(submit);
    }

    public String isContactDone(){
        String submitedContactResul = "";
        submitedContactResul = getText(assertionContact).trim();
        return submitedContactResul;
    }
}