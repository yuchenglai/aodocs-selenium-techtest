package test;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import pages.GoogleResultPage;
import pages.HomePage;
import pages.RequestDemoPage;
import pages.SearchGooglePage;
import selenium.driver.WebDriverUtility;
import selenium.driver.Browser;
import utils.CompanySize;
import utils.PropertyLoader;
import java.util.Map;

public class TestRequestDemo {

    public static WebDriver driver;

    public static PropertyLoader propertyLoader;

    public TestRequestDemo(){
        propertyLoader = new PropertyLoader();
    }

    @BeforeEach
    public void setup(){
        String browser = propertyLoader.getPropertyValue("browser").toString();
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = WebDriverUtility.getWebDriver(Browser.CHROME);
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = WebDriverUtility.getWebDriver(Browser.FIREFOX);
        }
    }

    @AfterEach
    public void close(){
        driver.close();
    }

    @Test
    void test01() {

        // Handle Google GDPR setting, then search AODocs on Google, check that the browser redirects to AODocs result page
        SearchGooglePage searchGooglePage = new SearchGooglePage(driver, propertyLoader);
        searchGooglePage.acceptGoogleGDPR();
        GoogleResultPage googleResultPage = searchGooglePage.searchKeyword("AODocs");
        Assertions.assertTrue(googleResultPage.getSearchResultPageTitle().contains("AODocs"));

        // In the result, open website www.aodocs.com, check that the site is open
        HomePage homePage = googleResultPage.clickAODocsSearchResult();
        Assertions.assertEquals("https://www.aodocs.com/",driver.getCurrentUrl());

        // Handle aodocs.com GDPR setting, then click Request a demo button
        homePage.clickAcceptGDPRJavaScript();
        RequestDemoPage requestDemoPage = homePage.clickOnRequestDemoButton();

        // Enter my first name, leave last name empty, put a random email address and choose a company size
        requestDemoPage.setFirstName("Yucheng");
        requestDemoPage.setLastName("");
        requestDemoPage.setEmail("random#$%");
        requestDemoPage.setCompanySize(CompanySize.SIZE_5_50.getValue());

        // Fetch all error messages and store them to a map. Then check them one by one
        Map<String, String> errorMessageList = requestDemoPage.mapErrorMessages();
        requestDemoPage.checkErrorMessage(RequestDemoPage.ERROR_MSG_REQUIRED_FIELD, errorMessageList.get("lastname"));
        requestDemoPage.checkErrorMessage(RequestDemoPage.ERROR_MSG_WRONG_EMAIL_FORMAT, errorMessageList.get("email"));

    }

}
