package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RangeSlider {

    //verifying of choice is not implemented coz it's test task, but in real it needed

    private WebDriver drv;
    private static WebDriverWait wait;
    private static final int DEFAULT_TIMEOUT = 30;
    private WebElement elem;
    private Actions actions;
    private String minHandle_Xpath = "//div[contains(@class, 'min-slider-handle')]";
    private String maxHandle_Xpath = "//div[contains(@class, 'max-slider-handle')]";


    public RangeSlider(WebDriver drv,WebElement elem){
        this.drv = drv;
        wait = new WebDriverWait(drv, DEFAULT_TIMEOUT);
        this.elem = elem;
        actions = new Actions(drv);
    }

    public void changeMinValue(int value){
        WebElement minHandle = elem.findElement(By.xpath(minHandle_Xpath));

        Action action = actions.dragAndDropBy(minHandle, value, 0).build();
        action.perform();
    }
    public void changeMaxValue(int value){
        WebElement maxHandle = elem.findElement(By.xpath(maxHandle_Xpath));
        Action action = actions.dragAndDropBy(maxHandle, value, 0).build();
        action.perform();
    }
    public void changeValues(int minValue, int maxValue){
        changeMinValue(minValue);
        changeMaxValue(maxValue);
    }
    public String getMinValue(){
        return null;
    }
    public String getMaxValue(){
        return null;
    }

}
