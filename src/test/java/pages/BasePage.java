package pages;

import elements.Calendar;
import elements.DropDown;
import elements.RangeSlider;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    public static final int DEFAULT_TIMEOUT = 30;
    public WebDriver drv;
    public static WebDriverWait wait;
    public JavascriptExecutor js;

    public BasePage(WebDriver drv){
        this.drv = drv;
        wait = new WebDriverWait(drv, DEFAULT_TIMEOUT);
        this.js = (JavascriptExecutor) drv;
    }

    public void click(WebElement elem){
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        elem.click();
    }
    public void waitUntilPageReady(){
        wait.until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }
    public void waitUntilDisplayIsNone(WebElement elem){
        wait.until(ExpectedConditions.attributeContains(elem,"style","display: none;"));
    }

    public void waitUntilUrlContains(String url){
        wait.until(ExpectedConditions.urlContains(url));
    }

    public void clickCheckbox(WebElement elem){
        click(elem);
    }

    public void clickRadioBtn(WebElement elem){
        click(elem);
    }

    public void changeRangeSlider(WebElement elem, int min, int max){
        RangeSlider rangeSlider = new RangeSlider(drv, elem);
        rangeSlider.changeValues(min,max);
    }

    public void changeRangeSlider(WebElement elem, int min){
        RangeSlider rangeSlider = new RangeSlider(drv, elem);
        rangeSlider.changeMinValue(min);
    }

    public void chooseDropdownValueByName(WebElement elem, String name){
        DropDown dropDown = new DropDown(drv, elem);
        dropDown.chooseByName(name);
    }

    public String calendarPlusOneDayToRange(){
        Calendar calendar = new Calendar(drv);
        String day = calendar.plusOneDay();
        return day;
    }

    public void clearLocalStorage() {
        js.executeScript(String.format("window.localStorage.clear();"));
    }
}

