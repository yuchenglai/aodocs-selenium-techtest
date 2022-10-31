package test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.RequestDemoPage;
import selenium.driver.WebDriverUtility;
import selenium.driver.Browser;

public class TestRequestDemo {

    WebDriver driver;

    @BeforeEach
    public void setup(){
        //use Chrome Driver
        driver = WebDriverUtility.getWebDriver(Browser.CHROME);
        driver.manage().window().maximize();
    }

    @AfterEach
    public void close(){
        driver.close();
    }

    @Test
    void test01(){

        HomePage homePage = new HomePage(driver);// Improvement needed: wait for page to load fully
        homePage.clickAcceptGDPRJavaScript();
        homePage.clickOnRequestDemoButton();

        RequestDemoPage requestDemoPage = new RequestDemoPage(driver);// Improvement needed: wait for page to load fully
        requestDemoPage.setFirstName("Jason");
        requestDemoPage.setLastName("Bourne");
        requestDemoPage.setLastName("");
        Assertions.assertEquals("Please complete this required field.",requestDemoPage.getSingleErrorMsg());

        requestDemoPage.setLastName("Bourne");
        requestDemoPage.setEmail("abc");
        requestDemoPage.setCompanyName("SQA");
        Assertions.assertEquals("Email must be formatted correctly.",requestDemoPage.getSingleErrorMsg());


    }

    @Test
    void test02(){

        HomePage homePage = new HomePage(driver);// Improvement needed: wait for page to load fully
        homePage.clickAcceptGDPRJavaScript();
        homePage.clickOnRequestDemoButton();

    }

    @Test
    void test03(){

        HomePage homePage = new HomePage(driver);// Improvement needed: wait for page to load fully
        homePage.clickAcceptGDPRJavaScript();
        homePage.clickOnRequestDemoButton();

    }

    @Test
    void test04(){

        HomePage homePage = new HomePage(driver);// Improvement needed: wait for page to load fully
        homePage.clickAcceptGDPRJavaScript();
        homePage.clickOnRequestDemoButton();

    }

    @Test
    void test05(){

        HomePage homePage = new HomePage(driver);// Improvement needed: wait for page to load fully
        homePage.clickAcceptGDPRJavaScript();
        homePage.clickOnRequestDemoButton();

    }

    @Test
    void test06(){

        HomePage homePage = new HomePage(driver);// Improvement needed: wait for page to load fully
        homePage.clickAcceptGDPRJavaScript();
        homePage.clickOnRequestDemoButton();

    }

    @Test
    void test07(){

        HomePage homePage = new HomePage(driver);// Improvement needed: wait for page to load fully
        homePage.clickAcceptGDPRJavaScript();
        homePage.clickOnRequestDemoButton();

    }

    @Test
    void test08(){

        HomePage homePage = new HomePage(driver);// Improvement needed: wait for page to load fully
        homePage.clickAcceptGDPRJavaScript();
        homePage.clickOnRequestDemoButton();

    }

    @Test
    void test09(){

        HomePage homePage = new HomePage(driver);// Improvement needed: wait for page to load fully
        homePage.clickAcceptGDPRJavaScript();
        homePage.clickOnRequestDemoButton();

    }

    @Test
    void test10(){

        HomePage homePage = new HomePage(driver);// Improvement needed: wait for page to load fully
        homePage.clickAcceptGDPRJavaScript();
        homePage.clickOnRequestDemoButton();

    }

    @Test
    void test11(){

        HomePage homePage = new HomePage(driver);// Improvement needed: wait for page to load fully
        homePage.clickAcceptGDPRJavaScript();
        homePage.clickOnRequestDemoButton();

    }

    @Test
    void test12(){

        HomePage homePage = new HomePage(driver);// Improvement needed: wait for page to load fully
        homePage.clickAcceptGDPRJavaScript();
        homePage.clickOnRequestDemoButton();

    }

    @Test
    void test13(){

        HomePage homePage = new HomePage(driver);// Improvement needed: wait for page to load fully
        homePage.clickAcceptGDPRJavaScript();
        homePage.clickOnRequestDemoButton();

    }

    @Test
    void test14(){

        HomePage homePage = new HomePage(driver);// Improvement needed: wait for page to load fully
        homePage.clickAcceptGDPRJavaScript();
        homePage.clickOnRequestDemoButton();

    }

    @Test
    void test15(){

        HomePage homePage = new HomePage(driver);// Improvement needed: wait for page to load fully
        homePage.clickAcceptGDPRJavaScript();
        homePage.clickOnRequestDemoButton();

    }
}
