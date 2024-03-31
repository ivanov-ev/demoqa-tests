package tests;

import org.junit.jupiter.api.Assertions;
import pages.RegistrationPage;
import org.junit.jupiter.api.*;
import pages.components.TableComponent;

import static utils.RandomUtils.*;

// ====================================================
//TESTS FOR https://demoqa.com/automation-practice-form
// ====================================================

public class AutomationPracticeFormTests extends TestBase {

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
    void submitBlankFormNTest() {
        registrationPage.openPage()
                .submitForm();
        Assertions.assertFalse(tableComponent.isTablePresent());
        Assertions.assertTrue(tableComponent.isValidationAttributePresent());
    }
}