package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.PageFactory;

public class RequestDemoPage {
    private WebDriver driver;

    //Locators

    //Apply as Developer Button
    @FindBy(name = "firstname")
    private WebElement fieldFirstName;

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

    @FindBy(className = "hs-button.primary.large")
    private WebElement btnSubmit;

    @FindBy(className = "hs-error-msg")
    private WebElement singleErrorMsg;

    static final String COMPANY_SIZE_ZERO_TO_FOUR = "0-4 employees";

    //Constructor
    public RequestDemoPage(WebDriver driver){
        this.driver=driver;
        //Initialise Elements
        PageFactory.initElements(driver, this);
    }


    public void setFirstName(String firstName) {
        fieldFirstName.clear();
        fieldFirstName.sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        fieldLastName.clear();
        fieldLastName.sendKeys(lastName);
    }

    public void setEmail(String email) {
        fieldEmail.clear();
        fieldEmail.sendKeys(email);
    }

    public void setCompanyName(String companyName) {
        fieldYourCompanyName.clear();
        fieldYourCompanyName.sendKeys(companyName);
    }

    public void setCompanySize(){
        Select selectCompanySize = new Select(dropdownCompanySize);
        selectCompanySize.selectByValue(COMPANY_SIZE_ZERO_TO_FOUR);
    }

    public void setCountry(){
        Select selectCountry = new Select(dropdownCountry);
        selectCountry.selectByValue("France");
    }

    public void clickSubmitBtn() {
        btnSubmit.click();
    }

    public String getSingleErrorMsg() {
        return singleErrorMsg.getText();
    }



}
