package tests.travelInsuranceTests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTests extends BaseTest{

    @Test(description = "open travel Insurance advanced search page and verify there are 3 or more results, there are all filter blocks", priority=1)
    public void openTravelInsuranceTest(){
        mainPage.openTravelInsuranceSearchPage();
        travelIncSearchPage.isTravelIncSearchPage();
        Assert.assertTrue(travelIncSearchPage.getCountOfResults() >= 3, "count of results is less then 3" );
    }

    @Test(description = "verify that Checkbox in FILTERS is working", groups = {"AdvancedSearch"}, priority=2)
    public void FilterCheckBoxTest(){
        travelIncSearchPage.collapseFilterBlock();
        travelIncSearchPage.clickCheckbox(travelIncSearchPage.fpgInsuranceCheckbox);
        travelIncSearchPage.waitUntilResultWillBeEqual(2);
    }

    @Test(description = "verify that RangeSlider in FILTERS is working", groups = {"AdvancedSearch"}, priority=2)
    public void FilterRangeTest(){
        travelIncSearchPage.collapseFilterBlock();
        travelIncSearchPage.changeRangeSlider(travelIncSearchPage.personalAccidentRangeSlider, 140); //need implement method by price
        travelIncSearchPage.waitUntilResultWillBeEqual(4);
        //need add verify by Trip cancellation row in insurance card
    }

    @Test(description = "verify that sorting Desc in SORT is working", groups = {"AdvancedSearch"}, priority=2)
    public void SortRadioBtnDescPriceTest() {
        travelIncSearchPage.clickRadioBtn(travelIncSearchPage.sortPriceDescRadio);

        Assert.assertTrue(travelIncSearchPage.checkDescPriceSorting(), "is not sorted" );
    }

    @Test(description = "verify that destination dropdown in DETAILS is working", groups = {"AdvancedSearch"}, priority=2)
    public void SortDropdownTest() {
        travelIncSearchPage.chooseDropdownValueByName(travelIncSearchPage.destinationFirstDropDown, "Thailand");
        travelIncSearchPage.waitUntilResultWillBeEqual(22);
    }

    @Test(description = "verify that calendar of travel date in DETAILS is working", groups = {"AdvancedSearch"}, priority=2)
    public void CalendarTest() {
        travelIncSearchPage.openCalendar();
        String newDay = travelIncSearchPage.calendarPlusOneDayToRange();
        travelIncSearchPage.verifyThatTopDetailsContains("to "+newDay);
    }
}
