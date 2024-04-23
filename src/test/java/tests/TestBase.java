package tests;

import com.codeborne.selenide.Configuration;
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

        //Configuration.browser = "Chrome";
        System.setProperty("browser", "chrome");
        Configuration.browser = System.getProperty("browser");

        //Configuration.browserSize = "1600x1000";
        System.setProperty("browserSize", "1000x1000");
        Configuration.browserSize = System.getProperty("browserSize");

        Configuration.timeout = 5000; //5 sec; default is 4 sec

        //Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
        System.setProperty("remote", "selenoid.example.com");
        Configuration.remote = "https://user1:1234@" + System.getProperty("remote") + "/wd/hub";

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
