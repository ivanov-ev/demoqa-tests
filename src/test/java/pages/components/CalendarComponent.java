package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class CalendarComponent {

    private final SelenideElement yearSelect = $(".react-datepicker__year-select");
    private final SelenideElement monthSelect = $(".react-datepicker__month-select");
    private final String last20DaysPrefix = ".react-datepicker__day--0",
            first10DaysPrefix = last20DaysPrefix + "0",
            dayInCurrentMonth = ":not(.react-datepicker__day--outside-month)";

    public void setDate(String year, String month, String day) {
        yearSelect.click();
        $(byText(year)).click();

        monthSelect.click();
        $(byText(month)).click();

        if (Integer.parseInt(day) > 9) {
            $(last20DaysPrefix + day + dayInCurrentMonth).click();
        } else {
            $(first10DaysPrefix + day + dayInCurrentMonth).click();
        }
    }
}

