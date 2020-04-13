package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DropDown {

    //verifying of choice is not implemented coz it's test task, but in real it needed

    private WebDriver drv;
    private static WebDriverWait wait;
    private static final int DEFAULT_TIMEOUT = 30;
    private WebElement elem;

    public DropDown(WebDriver drv,WebElement elem){
        this.drv = drv;
        wait = new WebDriverWait(drv, DEFAULT_TIMEOUT);
        this.elem = elem;
    }

    public void chooseByName(String name){
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        elem.click();
        WebElement option = elem.findElement(By.xpath("//span[contains(text(),'"+name+"')]/../link"));
        option.click();
    }

}
