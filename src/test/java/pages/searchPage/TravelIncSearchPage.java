package pages.searchPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.testng.Assert;
import pages.BasePage;

import java.util.List;

public class TravelIncSearchPage extends BasePage {

    public final String TRAVEL_INC_SEARCH_PAGE_URL = "https://www.gobear.com/ph/insurance/travel/quote-online";
    public final String LOADER_XPATH = "//div[@data-gb-name='loading-status']";
    public final String FILTER_BAR_XPATH = "//div[@data-gb-name='filter-bar']";
    public final String SORT_BAR_XPATH = "//div[@data-gb-name='sort-bar']";;
    public final String DETAILS_BAR_XPATH = "//div[@data-gb-name='edit-detail-bar']";
    public final String RESULT_CARD_XPATH = "//div[@data-gb-name='travel-plan']";
    public final String FILTER_COLLAPSE_XPATH = "//*[@id='collapseSeemoreBtn']";

    public final String FILTER_FPG_INSURANCE_CHECKBOX_XPATH = FILTER_BAR_XPATH + "//div[@data-filter-name='FPG Insurance']";
    public final String PERSONAL_ACCIDENT_RANGE_XPATH = FILTER_BAR_XPATH + "//input[@id='gb-slider-1']/..";
    public final String SORT_PRICE_DESC_RADIO_XPATH = "//*[@id='gb_radio_4']/..";
    public final String DESTINATION_FIRST_DROPDOWN_XPATH = "//div[@data-gb-destination]";
    public final String DATE_BLOCK_XPATH = "//div[@data-gb-name='dates']";
    public final String DATE_TILL_INPUT_XPATH = DATE_BLOCK_XPATH + "//div[@class='date-to']";
    public final String SEARCH_TOP_DETAILS_BLOCK_XPATH = "//div[@data-gb-name='travel-nav-data']";

    @FindBy(xpath = LOADER_XPATH)
    public WebElement loader;

    @FindBy(xpath = FILTER_BAR_XPATH)
    public WebElement filterBar;

    @FindBy(xpath = SORT_BAR_XPATH)
    public WebElement sortBar;

    @FindBy(xpath = DETAILS_BAR_XPATH)
    public WebElement detailsBar;

    @FindBy(xpath = RESULT_CARD_XPATH)
    public List<WebElement> searchResults;

    @FindBy(xpath = FILTER_FPG_INSURANCE_CHECKBOX_XPATH)
    public WebElement fpgInsuranceCheckbox;

    @FindBy(xpath = FILTER_COLLAPSE_XPATH)
    public WebElement filterCollapseBtn;

    @FindBy(xpath = PERSONAL_ACCIDENT_RANGE_XPATH)
    public WebElement personalAccidentRangeSlider;

    @FindBy(xpath = SORT_PRICE_DESC_RADIO_XPATH)
    public WebElement sortPriceDescRadio;

    @FindBy(xpath = DESTINATION_FIRST_DROPDOWN_XPATH)
    public WebElement destinationFirstDropDown;

    @FindBy(xpath = DATE_TILL_INPUT_XPATH)
    public WebElement dateTillInput;

    @FindBy(xpath = SEARCH_TOP_DETAILS_BLOCK_XPATH)
    public WebElement topDetailsBlock;

    public TravelIncSearchPage(WebDriver drv) {
        super(drv);
        PageFactory.initElements(drv, this);
    }

    public void isTravelIncSearchPage() {
        waitUntilPageReady();
        waitUntilUrlContains(TRAVEL_INC_SEARCH_PAGE_URL);
        Assert.assertTrue(filterBar.isDisplayed());
        Assert.assertTrue(sortBar.isDisplayed());
        Assert.assertTrue(detailsBar.isDisplayed());
    }

    public int getCountOfResults() {
        waitUntilPageReady();
        waitUntilDisplayIsNone(loader);
        return searchResults.size();
    }

    public void waitUntilResultWillBeEqual(int count){
        waitUntilPageReady();
        waitUntilDisplayIsNone(loader);
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                if (count == searchResults.size())
                    return true;
                else
                    return false;
            }
        });
    }

    public void collapseFilterBlock() {
        click(filterCollapseBtn);
    }

    public boolean checkDescPriceSorting(){
        int[] prices = new int[searchResults.size()];
        boolean result = false;
        for(int j = 0; j <searchResults.size(); j++){
            prices[j] = Integer.parseInt(searchResults.get(j)
                    .findElement(By.xpath("//div[@class='policy-price']")).getAttribute("premium"));
        }
        for(int i = 1; i<prices.length; i++){
            if(prices[i] >= prices[i-1]){
                if(i == prices.length-1) result = true;
            }
        }
        return result;
    }

    public void openCalendar(){
        click(dateTillInput);
    }

    public void getLastDayOfTrip(){
        //dateTillInput
    }

    public void verifyThatTopDetailsContains(String text){
        String fullText = topDetailsBlock.getText();
        Assert.assertTrue(fullText.contains(text), "'"+fullText+"' does not contain '"+text+"'");
    }

}
