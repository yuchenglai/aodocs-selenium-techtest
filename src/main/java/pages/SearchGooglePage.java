package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.PropertyLoader;
import utils.WaitAction;

public class SearchGooglePage {

    private WebDriver driver;
    private WaitAction waitAction;

    //Locators
    @FindBy(id="L2AGLb")
    WebElement acceptGoogleGDPR;

    @FindBy(name="q")
    WebElement googleSearchBox;

    By googleSearchBoxLocator = By.name("q");


    public SearchGooglePage(WebDriver driver, PropertyLoader properties) {
        this.driver=driver;
        waitAction = new WaitAction(driver);
        PageFactory.initElements(driver, this);
        driver.get(properties.getPropertyValue("googleUrl"));
        waitAction.waitForElementPresent(googleSearchBoxLocator);
        System.out.println("Opening page on:" + driver.getCurrentUrl());
    }

    public void acceptGoogleGDPR() {
        acceptGoogleGDPR.click();
        System.out.println("Accept Google GDPR button clicked");
    }

    public GoogleResultPage searchKeyword(String keyword) {
        googleSearchBox.clear();
        googleSearchBox.sendKeys(keyword);
        googleSearchBox.submit();
        System.out.println("Search keyword \""+keyword+"\" in google");
        return new GoogleResultPage(driver);
    }

}
