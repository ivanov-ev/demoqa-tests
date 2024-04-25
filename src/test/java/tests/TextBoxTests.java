package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

// ====================================
//TESTS FOR https://demoqa.com/text-box
// ====================================
@Tag("text_box_tests")
public class TextBoxTests extends TestBase {

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