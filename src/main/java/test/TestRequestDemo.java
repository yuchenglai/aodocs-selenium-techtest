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

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.io.FileReader;

public class TestRequestDemo {

    WebDriver driver;
    FileReader reader=new FileReader("src/main/resources/test.properties");
    Properties props = new Properties();



    public TestRequestDemo() throws Exception {
    }

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
    void test01() throws IOException {

        props.load(reader);
        System.out.println(props.get("baseUrlProd"));
        System.out.println(props.get(props.get("test01_demo_company_size").toString()));

        HomePage homePage = new HomePage(driver,props.get("baseUrlProd").toString());// Improvement needed: wait for page to load fully
        homePage.clickAcceptGDPRJavaScript();
        homePage.clickOnRequestDemoButton();

        RequestDemoPage requestDemoPage = new RequestDemoPage(driver);// Improvement needed: wait for page to load fully
        requestDemoPage.setFirstName(props.get("test01_demo_firstname").toString());
        requestDemoPage.setLastName(props.get("test01_demo_lastname").toString());
        requestDemoPage.setLastName("");
        Assertions.assertEquals("Please complete this required field.",requestDemoPage.getSingleErrorMsg());

        requestDemoPage.setLastName(props.get("test01_demo_lastname").toString());
        requestDemoPage.setEmail(props.get("test01_demo_email").toString());
        requestDemoPage.setCompanySize(props.get(props.get("test01_demo_company_size").toString()).toString());
        Assertions.assertEquals("Email must be formatted correctly.",requestDemoPage.getSingleErrorMsg());


    }

//    @Test
//    void test02(){
//
//        HomePage homePage = new HomePage(driver);// Improvement needed: wait for page to load fully
//        homePage.clickAcceptGDPRJavaScript();
//        homePage.clickOnRequestDemoButton();
//
//    }
//
//    @Test
//    void test03(){
//
//        HomePage homePage = new HomePage(driver);// Improvement needed: wait for page to load fully
//        homePage.clickAcceptGDPRJavaScript();
//        homePage.clickOnRequestDemoButton();
//
//    }
//
//    @Test
//    void test04(){
//
//        HomePage homePage = new HomePage(driver);// Improvement needed: wait for page to load fully
//        homePage.clickAcceptGDPRJavaScript();
//        homePage.clickOnRequestDemoButton();
//
//    }
//
//    @Test
//    void test05(){
//
//        HomePage homePage = new HomePage(driver);// Improvement needed: wait for page to load fully
//        homePage.clickAcceptGDPRJavaScript();
//        homePage.clickOnRequestDemoButton();
//
//    }
//
//    @Test
//    void test06(){
//
//        HomePage homePage = new HomePage(driver);// Improvement needed: wait for page to load fully
//        homePage.clickAcceptGDPRJavaScript();
//        homePage.clickOnRequestDemoButton();
//
//    }
//
//    @Test
//    void test07(){
//
//        HomePage homePage = new HomePage(driver);// Improvement needed: wait for page to load fully
//        homePage.clickAcceptGDPRJavaScript();
//        homePage.clickOnRequestDemoButton();
//
//    }
//
//    @Test
//    void test08(){
//
//        HomePage homePage = new HomePage(driver);// Improvement needed: wait for page to load fully
//        homePage.clickAcceptGDPRJavaScript();
//        homePage.clickOnRequestDemoButton();
//
//    }
//
//    @Test
//    void test09(){
//
//        HomePage homePage = new HomePage(driver);// Improvement needed: wait for page to load fully
//        homePage.clickAcceptGDPRJavaScript();
//        homePage.clickOnRequestDemoButton();
//
//    }
//
//    @Test
//    void test10(){
//
//        HomePage homePage = new HomePage(driver);// Improvement needed: wait for page to load fully
//        homePage.clickAcceptGDPRJavaScript();
//        homePage.clickOnRequestDemoButton();
//
//    }
//
//    @Test
//    void test11(){
//
//        HomePage homePage = new HomePage(driver);// Improvement needed: wait for page to load fully
//        homePage.clickAcceptGDPRJavaScript();
//        homePage.clickOnRequestDemoButton();
//
//    }
//
//    @Test
//    void test12(){
//
//        HomePage homePage = new HomePage(driver);// Improvement needed: wait for page to load fully
//        homePage.clickAcceptGDPRJavaScript();
//        homePage.clickOnRequestDemoButton();
//
//    }
//
//    @Test
//    void test13(){
//
//        HomePage homePage = new HomePage(driver);// Improvement needed: wait for page to load fully
//        homePage.clickAcceptGDPRJavaScript();
//        homePage.clickOnRequestDemoButton();
//
//    }
//
//    @Test
//    void test14(){
//
//        HomePage homePage = new HomePage(driver);// Improvement needed: wait for page to load fully
//        homePage.clickAcceptGDPRJavaScript();
//        homePage.clickOnRequestDemoButton();
//
//    }
//
//    @Test
//    void test15(){
//
//        HomePage homePage = new HomePage(driver);// Improvement needed: wait for page to load fully
//        homePage.clickAcceptGDPRJavaScript();
//        homePage.clickOnRequestDemoButton();
//
//    }
}
