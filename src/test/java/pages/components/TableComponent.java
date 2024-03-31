package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TableComponent {
    private final SelenideElement table = $(".table-responsive");
    private final SelenideElement userForm = $("#userForm");
    private final String isValidated = "was-validated";
    //UserForm receives the "was-validated" attribute after submission

    public TableComponent checkResultsInTable(String value) {
        table.shouldHave(text(value));
        return this;
    }

    public boolean isTablePresent() {
        return table.exists();
    }

    public boolean isValidationAttributePresent() {
        return userForm.has(attribute("class", isValidated));
    }
}
