package pages;

import pages.components.*;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {

    private final SelenideElement userForm = $("#userForm");
    public final SelenideElement firstNameInput = $("#firstName");
    public final SelenideElement lastNameInput = $("#lastName");
    private final SelenideElement emailInput = $("#userEmail");
    public final SelenideElement maleGenderInput = $(byText("Male"));
    public final SelenideElement femaleGenderInput = $(byText("Female"));
    public final SelenideElement phoneNumberInput = $("#userNumber");
    private final SelenideElement calendarInput = $("#dateOfBirthInput");

    private final SelenideElement subjectInput = $("#subjectsInput");

    private final SelenideElement hobbySportsInput = $(byText("Sports")),
            hobbyReadingInput = $(byText("Reading")),
            hobbyMusicInput = $(byText("Music"));

    private final SelenideElement uploadPictureInput = $("#uploadPicture");

    private final SelenideElement addressInput = $("#currentAddress");

    private final SelenideElement stateInput = $(byText("Select State"));
    private final SelenideElement cityInput = $(byText("Select City"));

    private final SelenideElement submitButton = $("#submit");

    CalendarComponent calendarComponent = new CalendarComponent();

    TableComponent tableComponent = new TableComponent();


    public RegistrationPage openPage() {
        open("/automation-practice-form");
		return this;
    }

    public RegistrationPage requiredAttributeChecker() {
        firstNameInput.shouldHave(attribute("required"));
        lastNameInput.shouldHave(attribute("required"));
        maleGenderInput.preceding(0).shouldHave(attribute("required"));
        phoneNumberInput.shouldHave(attribute("required"));
        return this;
    }

    public RegistrationPage checkUserFormIsValidated() {
        userForm.shouldHave(attribute("class", "was-validated"));
        return this;
    }

    public RegistrationPage setFirstName (String value) {
        firstNameInput.setValue(value);
        return this;
    }
    public RegistrationPage setLastName (String value) {
        lastNameInput.setValue(value);
        return this;
    }
    public RegistrationPage setEmail (String value) {
        emailInput.setValue(value);
        return this;
    }

    //May be improved to pass one of three radio buttons as a variable
    public RegistrationPage setMaleGender () {
        maleGenderInput.click();
        return this;
    }

    public RegistrationPage setPhoneNumber (String value) {
        phoneNumberInput.setValue(value);
        return this;
    }

    public RegistrationPage setBirthDate (String year, String month) {
        //Opens the date picker
        calendarInput.click();
        calendarComponent.setDate(year, month);
        return this;
    }

    public RegistrationPage setSubject (String subject) {
        subjectInput.click();
        subjectInput.setValue(subject).pressEnter();
        return this;
    }

    public RegistrationPage setHobbySports () {
        hobbySportsInput.click();
        return this;
    }

    public RegistrationPage setHobbyReading () {
        hobbyReadingInput.click();
        return this;
    }

    public RegistrationPage setHobbyMusic () {
        hobbyMusicInput.click();
        return this;
    }

    //Not sure whether this works for a real file upload, especially a large one
    public RegistrationPage uploadPicture (String path) {
        uploadPictureInput.uploadFromClasspath(path);
        return this;
    }

    public RegistrationPage setAddress (String value) {
        addressInput.setValue(value);
        return this;
    }

    public RegistrationPage setState (String stateName) {
        stateInput.click();
        $(byText(stateName)).click();
        return this;
    }

    public RegistrationPage setCity (String cityName) {
        cityInput.click();
        $(byText(cityName)).click();
        return this;
    }

    public RegistrationPage submitForm () {
        submitButton.click();
        return this;
    }

    public RegistrationPage checkTableResults (String value) {
        tableComponent.checkTable(value);
        return this;
    }
}
