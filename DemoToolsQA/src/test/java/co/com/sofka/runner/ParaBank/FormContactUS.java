package co.com.sofka.runner.ParaBank;

import co.com.sofka.model.ParaBank.FormContactUs;
import co.com.sofka.page.ContactUs.ContactUsPage;
import co.com.sofka.stepdefinition.setup.WebUI;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FormContactUS extends WebUI {

    private static final Logger LOGGER = Logger.getLogger(FormContactUS.class);

    private FormContactUs formContactUs;

    @BeforeEach
    public void setUp(){
        try{
            setUpLog4j2();
            setUpWebDriver();
            generalStUp();

            formContactUs = new FormContactUs();
            formContactUs.setName("Jhon");
            formContactUs.setEmail("js@gmail.com");
            formContactUs.setPhone("321");
            formContactUs.setMessage("MessageHere");

        } catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(), exception);
        }
    }

    @Test
    public void FormContactUsMandatoryFields(){
        try{
            ContactUsPage contactUsPage = new ContactUsPage(driver, formContactUs, 10);
            contactUsPage.fillFormContactUs();
            Assertions.assertTrue(contactUsPage.isContactDone().indexOf(forSubmittedForm())>0);

        } catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(), exception);
        }
    }

    @AfterEach
    public void tearDown(){
        quiteDriver();
    }

    private String forSubmittedForm(){
        String submitedFormResult = "";
        submitedFormResult = formContactUs.getName();
        return submitedFormResult;
    }
}
