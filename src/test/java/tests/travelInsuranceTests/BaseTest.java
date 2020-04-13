package tests.travelInsuranceTests;

import base.Browser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.mainPage.MainPage;
import pages.searchPage.TravelIncSearchPage;

public class BaseTest {

    public final String baseUrl = "https://www.gobear.com/ph?x_session_type=UAT";
    public String AdvancedSearchDefaultURL= null;
    public WebDriver drv;
    public MainPage mainPage;
    public TravelIncSearchPage travelIncSearchPage;

    @BeforeTest
    public void beforeTest(){
        Browser browser = new Browser();
        drv = browser.getDesktopChrome();

        mainPage = new MainPage(drv);
        travelIncSearchPage = new TravelIncSearchPage(drv);

        drv.get(baseUrl);
    }
    @BeforeGroups(groups = "AdvancedSearch")
    public void beforeAdvancedSearchGroup(){
        drv.get(baseUrl);
        mainPage.openTravelInsuranceSearchPage();
        travelIncSearchPage.isTravelIncSearchPage();
        travelIncSearchPage.waitUntilUrlContains(travelIncSearchPage.TRAVEL_INC_SEARCH_PAGE_URL);
        AdvancedSearchDefaultURL = drv.getCurrentUrl();
    }

    @BeforeMethod(onlyForGroups = {"AdvancedSearch"})
    public void beforeMethodForAdvancedSearch(){

    }

    @AfterMethod(onlyForGroups = {"AdvancedSearch"})
    public void AfterMethodForAdvancedSearch(){
        drv.manage().deleteAllCookies();
        drv.get(AdvancedSearchDefaultURL);
        travelIncSearchPage.clearLocalStorage();
    }
    @AfterTest
    public void afterTest(){
        drv.quit();
    }

}

