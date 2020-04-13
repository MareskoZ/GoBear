package pages.mainPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;

public class MainPage extends BasePage {

    public final String INSURANCE_SEARCH_TAB_XPATH = "//*[@data-gb-name='Insurance']";
    public final String INSURANCE_SEARCH_TAB_CONTAINER_XPATH = "//div[@id='Insurance']";
    public final String TRAVEL_INSURANCE_SEARCH_TAB_XPATH = INSURANCE_SEARCH_TAB_CONTAINER_XPATH + "//*[@aria-controls='Travel']";
    public final String TRAVEL_INSURANCE_SEARCH_TAB_CONTAINER_XPATH = "//*[@id='Travel']";
    public final String TRAVEL_INSURANCE_SEARCH_SHOW_RESULT_BTN_MULTI_XPATH =TRAVEL_INSURANCE_SEARCH_TAB_CONTAINER_XPATH + "//button[@name='product-form-submit']";

    @FindBy(xpath = INSURANCE_SEARCH_TAB_XPATH)
    public WebElement insuranceSearchTab;

    @FindBy(xpath = TRAVEL_INSURANCE_SEARCH_TAB_XPATH)
    public WebElement travelInsuranceSearchTab;

    @FindBy(xpath = TRAVEL_INSURANCE_SEARCH_SHOW_RESULT_BTN_MULTI_XPATH)
    public WebElement travelInsuranceShowResultBtn;

    public MainPage(WebDriver drv) {
        super(drv);
        PageFactory.initElements(drv, this);
    }

    public void openTravelInsuranceSearchPage(){
        click(insuranceSearchTab);
        click(travelInsuranceSearchTab);
        click(travelInsuranceShowResultBtn);
    }
}
