package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

// ==========================================
//PAGE OBJECT FOR https://demoqa.com/text-box
// ==========================================

public class TextBoxPage {

    private final SelenideElement
            userNameInput = $("#userName"),
            userEmailInput = $("#userEmail"),
            currentAddressInput = $("#currentAddress"),
            permanentAddressInput = $("#permanentAddress");
    private final SelenideElement submitButton = $("#submit");
    private final SelenideElement
            outputName = $("#output #name"),
            outputEmail = $("#output #email"),
            outputCurrentAddress = $("#output #currentAddress"),
            outputPermanentAddress = $("#output #permanentAddress");

    public TextBoxPage openPage() {
        open("/text-box");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public TextBoxPage setUserName (String value) {
        userNameInput.setValue(value);
        return this;
    }

    public TextBoxPage setUserEmail (String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public TextBoxPage setCurrentAddress (String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    public TextBoxPage setPermanentAddress (String value) {
        permanentAddressInput.setValue(value);
        return this;
    }

    public TextBoxPage submitForm () {
        submitButton.click();
        return this;
    }

    public TextBoxPage checkName (String value) {
        outputName.shouldHave(text(value));
        return this;
    }
    public TextBoxPage checkEmail (String value) {
        outputEmail.shouldHave(text(value));
        return this;
    }
    public TextBoxPage checkCurrentAddress (String value) {
        outputCurrentAddress.shouldHave(text(value));
        return this;
    }
    public TextBoxPage checkPermanentAddress (String value) {
        outputPermanentAddress.shouldHave(text(value));
        return this;
    }
}
