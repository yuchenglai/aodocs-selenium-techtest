package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import utils.WaitAction;

public class HomePage {

    private WebDriver driver;
    private WaitAction waitAction;

    //Locators
    //Request a demo Button
    private By requestDemoLocator = By.linkText("Request a demo");

    //Accept GDPR Locator
    private By acceptGDPRLocator = By.id("ccc-notify-accept");

    //Accept GDPR Javascript
    private String acceptGDPRJavaScript = "document.getElementById('ccc-notify-accept').click()";

    //Constructor
    public HomePage(WebDriver driver){
        this.driver=driver;
        this.waitAction = new WaitAction(driver);
        PageFactory.initElements(driver, this);
        // Give the page time to load
        waitAction.waitForElementPresent(requestDemoLocator);
        System.out.println("Opening page on:" + driver.getCurrentUrl());
    }

    public void clickAcceptGDPR() {
        //Improvement: need to detect if a user is from EU or not. GDPR popup may only appears to EU ip
        WebElement acceptGDPR = waitAction.waitForElementClickable(acceptGDPRLocator);
        acceptGDPR.click();
        System.out.println("Accept GDPR button clicked");
    }

    public void clickAcceptGDPRJavaScript() {
        //Improvement: need to detect if a user is from EU or not. GDPR popup may only appears to EU ip
        waitAction.waitForElementPresent(acceptGDPRLocator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(acceptGDPRJavaScript);
        System.out.println("Accept GDPR button clicked with JavaScript");
    }

    public RequestDemoPage clickOnRequestDemoButton() {
        WebElement requestDemo = driver.findElement(requestDemoLocator);
        requestDemo.click();
        System.out.println("Request demo button clicked on Home Page");
        return new RequestDemoPage(this.driver);
    }
}
