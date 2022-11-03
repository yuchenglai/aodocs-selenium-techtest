package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitAction {

    private WebDriver driver;
    private static Duration globalWaitDuration = Duration.ofSeconds(10);

    //Constructor
    public WaitAction(WebDriver driver){
        this.driver = driver;

    }

    public WebElement waitForElementPresent(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, globalWaitDuration);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return driver.findElement(locator);
    }

    public WebElement waitForElementClickable(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, globalWaitDuration);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        return driver.findElement(locator);
    }

    public void waitForElementVisible(WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(driver, globalWaitDuration);
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

}
