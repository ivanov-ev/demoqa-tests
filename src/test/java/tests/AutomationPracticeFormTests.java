package tests;

import pages.RegistrationPage;
import org.junit.jupiter.api.Test;

// ====================================================
//TESTS FOR https://demoqa.com/automation-practice-form
// ====================================================

public class AutomationPracticeFormTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    //A success way to fill out all the fields on the automation-practice-form
    @Test
    void fillFormTest() {
        registrationPage.openPage()
                .setFirstName("John")
                .setLastName("Doe")
                .setEmail("john.doe@example.com")
                .setGender("Male")
                .setPhoneNumber("4959999999")
                .setBirthDate("1985", "August")
                .setSubject("English")
                .setSubject("Computer Science")
                .setHobby("Sports")
                .setHobby("Music")
                .uploadPicture("SampleImage.png")
                .setAddress("35, Current Street, \nCurrent Country")//multi-line = \n
                .setState("Rajasthan")
                .setCity("Jaiselmer")
                .submitForm();
        registrationPage.checkTableResults("John")
                .checkTableResults("Doe")
                .checkTableResults("john.doe@example.com")
                .checkTableResults("Male")
                .checkTableResults("4959999999")
                .checkTableResults("15 August,1985")
                .checkTableResults("English")
                .checkTableResults("Computer Science")
                .checkTableResults("Sports")
                .checkTableResults("Music")
                .checkTableResults("SampleImage.png")
                .checkTableResults("35, Current Street, \nCurrent Country")
                .checkTableResults("Rajasthan")
                .checkTableResults("Jaiselmer");
    }

    @Test
    void fillRequiredFieldsTest () {
        registrationPage.openPage()
                .setFirstName("John")
                .setLastName("Doe")
                .setGender("Male")
                .setPhoneNumber("4959999999")
                .submitForm();
        registrationPage.checkTableResults("John")
                .checkTableResults("Doe")
                .checkTableResults("Male")
                .checkTableResults("4959999999");
    }

    @Test
    void submitBlankFormNTest() {
        registrationPage.openPage()
                .submitForm();
        registrationPage.checkFormValidation();
    }
}