package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.commands.Find;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.io.File;

import static com.codeborne.selenide.Condition.name;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

// ====================================================
//TESTS FOR https://demoqa.com/automation-practice-form
// ====================================================
public class AutomationPracticeFormTests {

    @BeforeAll
    static void setup() {
        //pay attention to the trailing slash, because it concatenates with open() and may result in 2 slashes
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy= "eager";
        //Configuration.browser = "Chrome";
        Configuration.browserSize = "1920x1200";
        Configuration.timeout = 5000; //5 sec; default is 4 sec

    }

    @AfterEach
    void tearDown() {
        closeWebDriver();
    }

    //The test may require scrolling down or making the browser window size more than the actual screen size
    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        //For classes, use a dot. For ids, use #.
        $("#firstName").setValue("John");
        $("#lastName").setValue("Doe");
        $("#userEmail").setValue("john.doe@example.com");

        //Gender - Choose Male
        //SelenideElement radioButton = $(".custom-control-label");
        //radioButton.click();
        //$("#gender-radio-2").selectRadio("gender-radio-2");



        $("#userNumber").setValue("12223334455");


        //Date of birth - Change month, Change year, Change date.


        //Subjects - Select English, Select Computer science





        //$("[id=hobbies-checkbox-1]").setSelected(true);
        //$("#hobbies-checkbox-3").click();
        //Hobbies - Select Sports, Select Music
        $(".custom-control-inline").selectRadio("hobbies-checkbox-1");



        $("#uploadPicture").uploadFile(new File("src\\test\\java\\tests\\SampleImage.png"));
        $("#currentAddress").setValue("35, Current Street, \nCurrent Country"); //multi-line = \n


        //State and City - Select Uttar Pradesh, Select Agra



        //$("[id=stateCity-wrapper]").selectOption(1);
        $(byText("Select State")).click();



        //$().scrollIntoView().click()


/*
        public class DropdownExample {
            public static void main(String[] args) {
                // Open the webpage with the dropdown list
                open("https://www.example.com");

                // Find the dropdown element by its selector
                $("#dropdown").selectOption("Option 1");

                // Verify that the selected option is as expected
                $("#dropdown").shouldHave(text("Option 1"));
            }
        }
*/



        $("#submit").click();





        //Select #output and then select one of its sub-elements
        //$("#output #name").shouldHave(text("John Doe"));
        //$("#output #email").shouldHave(text("john.doe@example.com"));
        //$("#output #currentAddress").shouldHave(text("35, Current Street, Current Country"));
        //("#output #permanentAddress").shouldHave(text("20, Permanent Street, Permanent Country"));
        //click Close and check the window is closed
    }
}