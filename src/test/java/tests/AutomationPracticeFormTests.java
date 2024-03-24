package tests;

import pages.RegistrationPage;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

// ====================================================
//TESTS FOR https://demoqa.com/automation-practice-form
// ====================================================
public class AutomationPracticeFormTests {

    @BeforeAll
    static void setup() {
        //pay attention to the trailing slash, because it concatenates with open() and may result in 2 slashes
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy= "eager";
        //Configuration.browser = "Chrome";
        Configuration.browserSize = "1920x1200";
        Configuration.timeout = 5000; //5 sec; default is 4 sec

    }

    @AfterEach
    void tearDown() {
        closeWebDriver();
    }

    RegistrationPage registrationPage = new RegistrationPage();

    //A success way to fill out all the fields on the automation-practice-form
    @Test
    void fillFormTest() {
        registrationPage.openPage()
                .setFirstName("John")
                .setLastName("Doe")
                .setEmail("john.doe@example.com")
                .setMaleGender()
                .setPhoneNumber("4959999999")
                .setBirthDate("1985", "August")
                .setSubject("English")
                .setSubject("Computer Science")
                .setHobbySports()
                .setHobbyMusic()
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
                .setMaleGender()
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
                .requiredAttributeChecker()
                .submitForm();
        registrationPage.checkUserFormIsValidated();
    }
}