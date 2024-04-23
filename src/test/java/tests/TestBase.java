package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLog;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;
import java.util.logging.Level;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {

    @BeforeAll
    static void setup() {
        //pay attention to the trailing slash, because it concatenates with open() and may result in 2 slashes
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";

        Configuration.timeout = 5000; //5 sec; default is 4 sec

        Configuration.remote = "https://user1:1234@" + Configuration.remote + "/wd/hub";


        Configuration.webdriverLogsEnabled = true;
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.of(
                "enableVNC", true,
                "enableVideo",true
        ));
        Configuration.browserCapabilities = capabilities;
    }

    @AfterEach
    void tearDown() {
        closeWebDriver();
    }
}
