package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Calendar {

    //it is simple implementation of using calendar, and it's not useful for real test framework, but it test task and it's too much to implement all functionality of calendar(custom)

    private final String NEXT_DAY_XPATH = "//div[@class='datepicker-days']//td[@class='day']";
    private final String NEXT_MONTH_XPATH = "//div[@class='datepicker-days']//th[@class='next']";

    private WebDriver drv;
    private static WebDriverWait wait;
    private static final int DEFAULT_TIMEOUT = 30;
    private WebElement elem;


    public Calendar(WebDriver drv){
        this.drv = drv;
        wait = new WebDriverWait(drv, DEFAULT_TIMEOUT);
    }

    public String plusOneDay(){
        List<WebElement> availableDays = drv.findElements(By.xpath(NEXT_DAY_XPATH));
        if(availableDays.size()>0) {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(NEXT_DAY_XPATH)));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(NEXT_DAY_XPATH)));
            WebElement calDay = drv.findElement(By.xpath(NEXT_DAY_XPATH));
            wait.until(ExpectedConditions.elementToBeClickable(calDay));
            String day = calDay.getText();
            calDay.click();
            return day;
        }else{
            drv.findElement(By.xpath(NEXT_MONTH_XPATH)).click();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(NEXT_DAY_XPATH)));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(NEXT_DAY_XPATH)));
            WebElement calDay = drv.findElement(By.xpath(NEXT_DAY_XPATH));
            wait.until(ExpectedConditions.elementToBeClickable(calDay));
            String day = calDay.getText();
            calDay.click();
            return day;
        }
    }
    //private boolean waitUntilDay

}
