package tests;

import org.junit.jupiter.api.*;

//These items are required for successfulSearchTest only
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

//Minimal lifecycle of an auto-test (JUnit5 + Selenide)
public class SimpleJUnitTest {

    int result;

    @BeforeAll
    static void beforeAll() {
        System.out.println("### beforeAll ()\n");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("### beforeEach ()");
        result = getResult();
    }

    @AfterEach
    void afterEach() {
        System.out.println("### afterEach ()\n");
        result = 0;
    }

    @AfterAll
    static void afterAll() {
        System.out.println("### afterAll ()\n");
    }

    @Test
    void firstTest() {
        System.out.println("### firstTest ()");
        Assertions.assertTrue(result > 2);
    }

    @Test
    void secondTest() {
        System.out.println("### secondTest ()");
        Assertions.assertTrue(result > 2);
    }

    @Test
    void thirdTest() {
        System.out.println("### thirdTest ()");
        Assertions.assertTrue(result > 2);
    }

    //successfulSearchTest uses Selenide
    /*
    @Test
    void successfulSearchTest() {
        open("https://www.google.com/");
        $("[name=q]").setValue("selenide").pressEnter();
        $("[id=search]").shouldHave(text("https://selenide.org"));
    }
    */

    private int getResult() {
        return 3;
    }
}

