package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests {

    @BeforeAll
    static void setup() {
        //pay attention to the trailing slash, because it concatenates with open() and may result in 2 slashes
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy= "eager";
        //Configuration.browser = "Chrome";
        Configuration.browserSize = "1600x1000";
        Configuration.timeout = 5000; //5 sec; default is 4 sec

    }

    @AfterEach
    void tearDown() {
        closeWebDriver();
    }
    @Test
    void fillFormTest() {
        open("/text-box");
        //For classes, use a dot. For ids, use #.
        $("#userName").setValue("John Doe");
        $("#userEmail").setValue("john.doe@example.com");
        $("#currentAddress").setValue("35, Current Street, Current Country");
        $("#permanentAddress").setValue("20, Permanent Street, Permanent Country");
        $("#submit").click();

        //Select #output and then select one of its sub-elements
        $("#output #name").shouldHave(text("John Doe"));
        $("#output #email").shouldHave(text("john.doe@example.com"));
        $("#output #currentAddress").shouldHave(text("35, Current Street, Current Country"));
        $("#output #permanentAddress").shouldHave(text("20, Permanent Street, Permanent Country"));
    }
}