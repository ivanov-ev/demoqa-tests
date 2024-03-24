package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class CalendarComponent {

    //TO DO: Add day selection

    private final SelenideElement yearSelect = $(".react-datepicker__year-select");
    private final SelenideElement monthSelect = $(".react-datepicker__month-select");
    private final SelenideElement day15Select = $(".react-datepicker__day--015");

    public void setDate(String year, String month) {

        //Selects a year
        yearSelect.click();
        $(byText(year)).click();

        //Selects a month
        //Open the month drop-down list and selects a month
        //Selecting a day from the month view may be unstable because the month view can contain the same number twice (e.g. 29 July and 29 August)
        monthSelect.click();
        $(byText(month)).click();

        //Selects a day
        //Opens the month view and selects Day 15
        day15Select.click();

    }

}
