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

    //Page URL
    private static String PAGE_URL="https://www.aodocs.com";

    //Locators

    //Request a demo Button
    private By requestDemoLocator = By.linkText("Request a demo");

    //Accept GDPR Locator
    private By acceptGDPRLocator = By.id("ccc-notify-accept");
    private String acceptGDPRJavaScript = "document.getElementById('ccc-notify-accept').click()";

    //Constructor
    public HomePage(WebDriver driver, String baseURL){
        this.driver=driver;
        this.waitAction = new WaitAction(driver);
        driver.get(baseURL);
        //Initialise Elements
        PageFactory.initElements(driver, this);
    }


    public void clickAcceptGDPR() {
        //Improvement: need to dectect if a user is from EU or not. GDPR popup may only appears to EU ip
        WebElement acceptGDPR = waitAction.waitForElementClickable(acceptGDPRLocator);
        acceptGDPR.click();
    }

    public void clickAcceptGDPRJavaScript() {
        waitAction.waitForElementPresent(acceptGDPRLocator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(acceptGDPRJavaScript);
    }

    public void clickOnRequestDemoButton(){
        WebElement requestDemo = waitAction.waitForElementClickable(requestDemoLocator);
        requestDemo.click();
    }
}
