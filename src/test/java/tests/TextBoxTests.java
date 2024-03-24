package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

import static com.codeborne.selenide.Selenide.*;

// ====================================
//TESTS FOR https://demoqa.com/text-box
// ====================================
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

    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void fillFormTest() {
        textBoxPage.openPage()
                .setUserName("John Doe")
                .setUserEmail("john.doe@example.com")
                .setCurrentAddress("35, Current Street, Current Country")
                .setPermanentAddress("20, Permanent Street, Permanent Country")
                .submitForm();
       textBoxPage.checkName("John Doe")
               .checkEmail("john.doe@example.com")
               .checkCurrentAddress("35, Current Street, Current Country")
               .checkPermanentAddress("20, Permanent Street, Permanent Country");
    }
}