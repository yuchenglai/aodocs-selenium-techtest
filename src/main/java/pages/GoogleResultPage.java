package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.PropertyLoader;
import utils.WaitAction;

public class GoogleResultPage {

    private WebDriver driver;
    private WaitAction waitAction;

    //Locators
    @FindBy(xpath="//a[@href='https://www.aodocs.com/']")
    WebElement aodocsResultLink;

    public GoogleResultPage(WebDriver driver) {
        this.driver=driver;
        waitAction = new WaitAction(driver);
        PageFactory.initElements(driver, this);
        System.out.println("Opening page on:" + driver.getCurrentUrl());
    }

    public String getSearchResultPageTitle() {
        waitAction.waitForElementVisible(aodocsResultLink);
        return driver.getTitle();
    }

    public HomePage clickAODocsSearchResult() {
        aodocsResultLink.click();
        System.out.println("Click on www.aodocs.com");
        return new HomePage(driver);
    }



}
