package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.PageFactory;
import utils.WaitAction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RequestDemoPage {
    private WebDriver driver;
    private WaitAction waitAction;

    //Locators
    @FindBy(name = "firstname")
    private WebElement fieldFirstName;

    By fieldFirstNameLocator = By.name("firstname");

    @FindBy(name = "lastname")
    private WebElement fieldLastName;

    @FindBy(name = "email")
    private WebElement fieldEmail;

    @FindBy(name = "company")
    private WebElement fieldYourCompanyName;

    @FindBy(name = "company_size__c")
    private WebElement dropdownCompanySize;

    @FindBy(name = "country")
    private WebElement dropdownCountry;

    @FindBy( className = "hs-error-msg")
    private List<WebElement> listErrorMsgs;

    //Error messages text
    public static final String ERROR_MSG_REQUIRED_FIELD = "Please complete this required field.";
    public static final String ERROR_MSG_WRONG_EMAIL_FORMAT = "Email must be formatted correctly.";
    public static final String ERROR_MSG_WRONG_PHONE_FORMAT = "Must contain only numbers, +()-. and x.";


    //Constructor
    public RequestDemoPage(WebDriver driver) {
        this.driver = driver;
        waitAction = new WaitAction(driver);
        PageFactory.initElements(driver, this);
        //Give time for the page to load
        waitAction.waitForElementPresent(fieldFirstNameLocator);
        System.out.println("Opening page on:" + driver.getCurrentUrl());
    }


    public void setFirstName(String firstName) {
        fieldFirstName.clear();
        fieldFirstName.sendKeys(firstName);
        System.out.println("First Name on request demo page set as: " +firstName);
    }

    public void setLastName(String lastName) {
        fieldLastName.clear();
        fieldLastName.sendKeys(lastName);
        System.out.println("Last Name on request demo page set as: " +lastName);
    }

    public void setEmail(String email) {
        fieldEmail.clear();
        fieldEmail.sendKeys(email);
        System.out.println("Email on request demo page set as: " +email);
    }

    public void setCompanyName(String companyName) {
        fieldYourCompanyName.clear();
        fieldYourCompanyName.sendKeys(companyName);
        System.out.println("Company Name on request demo page set as: " +companyName);
    }

    public void setCompanySize(String companySize){
        Select selectCompanySize = new Select(dropdownCompanySize);
        selectCompanySize.selectByValue(companySize);
        System.out.println("Company Size on request demo page set as: " +companySize);
    }

    // Map all the error messages and map them with corresponding unique name attribute
    public Map<String, String> mapErrorMessages () {
        Map<String, String> errorMassageMap = new HashMap<String, String>();
        for (WebElement errorMsg:listErrorMsgs) {
            String textFieldName = errorMsg.findElement(By.xpath("ancestor::ul/preceding-sibling::div/input")).getAttribute("name");
            errorMassageMap.put(textFieldName, errorMsg.getText());
        }
        return errorMassageMap;
    }

    public void checkErrorMessage(String expected, String actual) {
        System.out.println("Check Error Message");
        System.out.println("Expected: "+ expected);
        System.out.println("Actual: "+ actual);
        Assertions.assertEquals(expected,actual);
    }

}
