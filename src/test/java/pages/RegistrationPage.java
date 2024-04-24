package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

// ==========================================================
//PAGE OBJECT FOR https://demoqa.com/automation-practice-form
// ==========================================================

public class RegistrationPage {

    private final SelenideElement firstNameInput = $("#firstName");
    private final SelenideElement lastNameInput = $("#lastName");
    private final SelenideElement emailInput = $("#userEmail");
    private final SelenideElement genderInput = $("#genterWrapper");
    private final SelenideElement phoneNumberInput = $("#userNumber");
    private final SelenideElement calendarInput = $("#dateOfBirthInput");
    private final SelenideElement subjectInput = $("#subjectsInput");
    private final SelenideElement hobbyInput = $("#hobbiesWrapper");
    private final SelenideElement uploadPictureInput = $("#uploadPicture");
    private final SelenideElement addressInput = $("#currentAddress");
    private final SelenideElement stateInput = $(byText("Select State"));
    private final SelenideElement cityInput = $(byText("Select City"));
    private final SelenideElement submitButton = $("#submit");

    //Init components
    CalendarComponent calendarComponent = new CalendarComponent();


    @Step("Open /automation-practice-form")
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        removeBanner();
        return this;
    }

    @Step("Remove the banner")
    public RegistrationPage removeBanner() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    @Step("Set the first name")
    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    @Step("Set the last name")
    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    @Step("Set the email")
    public RegistrationPage setEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    @Step("Set the gender")
    public RegistrationPage setGender(String gender) {
        genderInput.$(byText(gender)).click();
        return this;
    }

    @Step("Set the phone number")
    public RegistrationPage setPhoneNumber(String value) {
        phoneNumberInput.setValue(value);
        return this;
    }

    @Step("Set the birthdate")
    public RegistrationPage setBirthDate(String year, String month, String day) {
        //Opens the date picker
        calendarInput.click();
        calendarComponent.setDate(year, month, day);
        return this;
    }

    @Step("Set the subject")
    public RegistrationPage setSubject(String subject) {
        subjectInput.click();
        subjectInput.setValue(subject).pressEnter();
        return this;
    }

    @Step("Set the hobby")
    public RegistrationPage setHobby(String hobby) {
        hobbyInput.$(byText(hobby)).click();
        return this;
    }

    //Not sure whether this works for a real file upload, especially a large one
    @Step("Upload the picture")
    public RegistrationPage uploadPicture(String path) {
        ((RemoteWebElement)uploadPictureInput).setFileDetector(new LocalFileDetector());
        uploadPictureInput.uploadFromClasspath(path);
        return this;
    }

    @Step("Set the address")
    public RegistrationPage setAddress(String value) {
        addressInput.setValue(value);
        return this;
    }

    @Step("Set the state")
    public RegistrationPage setState(String stateName) {
        stateInput.click();
        $(byText(stateName)).click();
        return this;
    }

    @Step("Set the city")
    public RegistrationPage setCity(String cityName) {
        cityInput.click();
        $(byText(cityName)).click();
        return this;
    }

    @Step("Submit the form")
    public RegistrationPage submitForm() {
        submitButton.click();
        return this;
    }
}
