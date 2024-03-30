package tests;

import pages.RegistrationPage;
import org.junit.jupiter.api.Test;

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
            subject = getRandomSubjectFaker(),
            hobby = getRandomHobbyFaker(),
            picture = getRandomPictureFaker(),
            address = getRandomAddressFaker(),
            state = getRandomStateFaker(),
            city = getRandomCityFaker(state);

    RegistrationPage registrationPage = new RegistrationPage();

    //A success way to fill out all the fields on the automation-practice-form
    @Test
    void fillFormTest() {
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setPhoneNumber(phone)
                .setBirthDate(birthYear, birthMonth)
                .setSubject(subject)
                .setHobby(hobby)
                .uploadPicture(picture)
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .submitForm();
        registrationPage.checkTableResults(firstName)
                .checkTableResults(lastName)
                .checkTableResults(email)
                .checkTableResults(gender)
                .checkTableResults(phone)
                .checkTableResults("15 " + birthMonth + "," + birthYear) //concat string
                .checkTableResults(subject)
                .checkTableResults(hobby)
                .checkTableResults(picture)
                .checkTableResults(address)
                .checkTableResults(state)
                .checkTableResults(city);
    }

    @Test
    void fillRequiredFieldsTest() {
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setPhoneNumber(phone)
                .submitForm();
        registrationPage.checkTableResults(firstName)
                .checkTableResults(lastName)
                .checkTableResults(gender)
                .checkTableResults(phone);
    }

    @Test
    void submitBlankFormNTest() {
        registrationPage.openPage()
                .submitForm();
        registrationPage.checkFormValidation();
    }
}