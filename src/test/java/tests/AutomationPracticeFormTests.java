package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import java.io.File;

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

    //A success way to fill out all the fields on the automation-practice-form
    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        //For classes, use a dot. For ids, use #.

        $("#firstName").setValue("John");

        $("#lastName").setValue("Doe");

        $("#userEmail").setValue("john.doe@example.com");

        $(byText("Male")).click();

        $("#userNumber").setValue("4959999999");

        //Opens the date picker
        $("#dateOfBirthInput").click();
        //Open the year drop-down list and selects a year
        $(".react-datepicker__year-select").click();
        $(byText("1985")).click();
        //Open the month drop-down list and selects a month
        //Selecting a day from the month view may be unstable because the month view can contain the same number twice (e.g. 29 July and 29 August)
        $(".react-datepicker__month-select").click();
        $(byText("August")).click();
        //Opens the month view and selects a day
        $(".react-datepicker__day--015").click();

        //Field that suggests selections after entering some text
        $("#subjectsInput").click();
        $("#subjectsInput").setValue("English").pressEnter();
        $("#subjectsInput").click();
        $("#subjectsInput").setValue("Computer Science").pressEnter();

        //Checks the boxes for hobbies
        $(byText("Sports")).click();
        $(byText("Music")).click();

        //Not sure whether this works for a real file upload, especially a large one
        $("#uploadPicture").uploadFile(new File("src\\test\\java\\tests\\SampleImage.png"));

        //Multi-line text box
        $("#currentAddress").setValue("35, Current Street, \nCurrent Country"); //multi-line = \n

        //Selects values from two drop-down lists
        $(byText("Select State")).click();
        $(byText("Rajasthan")).click();
        $(byText("Select City")).click();
        $(byText("Jaiselmer")).click();

        //Submits the form
        $("#submit").click();

        //Checks the final results in the table
        $(".table-responsive").shouldHave(text("John"));
        $(".table-responsive").shouldHave(text("Doe"));
        $(".table-responsive").shouldHave(text("john.doe@example.com"));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text("4959999999"));
        $(".table-responsive").shouldHave(text("15 August,1985"));
        $(".table-responsive").shouldHave(text("English"));
        $(".table-responsive").shouldHave(text("Computer Science"));
        $(".table-responsive").shouldHave(text("Sports"));
        $(".table-responsive").shouldHave(text("Music"));
        $(".table-responsive").shouldHave(text("SampleImage.png"));
        $(".table-responsive").shouldHave(text("35, Current Street, \nCurrent Country"));
        $(".table-responsive").shouldHave(text("Rajasthan"));
        $(".table-responsive").shouldHave(text("Jaiselmer"));

    }
}