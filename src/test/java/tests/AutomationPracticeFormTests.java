package tests;

import helpers.Attach;
import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import pages.RegistrationPage;
import org.junit.jupiter.api.*;
import pages.components.TableComponent;

import static utils.RandomUtils.*;

// ====================================================
//TESTS FOR https://demoqa.com/automation-practice-form
// ====================================================

@Tag("automation_practice_form")
@Feature("demoqa")
@Story("automation-practice-form")
@Owner("ivanov-ev")
@Severity(SeverityLevel.NORMAL)
@Link(name = "https://demoqa.com", url = "https://demoqa.com/automation-practice-form")
@DisplayName("Automation Practice Form Tests")
public class AutomationPracticeFormTests extends TestBase {

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Screenshot");
        Attach.addVideo();
        Attach.browserConsoleLogs();
        Attach.pageSource();
    }

    String firstName = getRandomFirstNameFaker(),
            lastName = getRandomLastNameFaker(),
            email = getRandomEmailFaker(firstName, lastName),
            gender = getRandomGenderFaker(),
            phone = getRandomPhoneFaker(),
            birthYear = getRandomYearFaker(),
            birthMonth = getRandomMonthFaker(),
            birthDay = getRandomDayFaker(birthYear, birthMonth),
            subject = getRandomSubjectFaker(),
            hobby = getRandomHobbyFaker(),
            picture = getRandomPictureFaker(),
            address = getRandomAddressFaker(),
            state = getRandomStateFaker(),
            city = getRandomCityFaker(state);

    RegistrationPage registrationPage = new RegistrationPage();

    TableComponent tableComponent = new TableComponent();

    //Fill out all the fields of the automation-practice-form
    @Test
    @DisplayName("Fill out all the fields")
    void fillFormTest() {
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setPhoneNumber(phone)
                .setBirthDate(birthYear, birthMonth, birthDay)
                .setSubject(subject)
                .setHobby(hobby)
                .uploadPicture(picture)
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .submitForm();
        tableComponent.checkResultsInTable(firstName)
                .checkResultsInTable(lastName)
                .checkResultsInTable(email)
                .checkResultsInTable(gender)
                .checkResultsInTable(phone)
                .checkResultsInTable(birthDay + " " + birthMonth + "," + birthYear)
                .checkResultsInTable(subject)
                .checkResultsInTable(hobby)
                .checkResultsInTable(picture)
                .checkResultsInTable(address)
                .checkResultsInTable(state)
                .checkResultsInTable(city);
    }

    @Test
    @DisplayName("Fill out only the required fields")
    void fillRequiredFieldsTest() {
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setPhoneNumber(phone)
                .submitForm();
        tableComponent.checkResultsInTable(firstName)
                .checkResultsInTable(lastName)
                .checkResultsInTable(gender)
                .checkResultsInTable(phone);
    }

    @Test
    @DisplayName("Submit the blank form")
    void submitBlankFormNTest() {
        registrationPage.openPage()
                .submitForm();
        Assertions.assertFalse(tableComponent.isTablePresent());
        Assertions.assertTrue(tableComponent.isValidationAttributePresent());
    }
}