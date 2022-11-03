# AODocs Selenium technical test - candiate Yucheng LAI

### Some note from Yucheng
1. I noticed that the GDPR panel (or accept cookies) in www.aodocs.com will sometimes(around 1 to 2 out of 50 runs) have exception "org.openqa.selenium.ElementClickInterceptedException" In order to deal with this, I tried several methods such as waiting the element to present. Unfortunately it is not working quite well. I believe such issue can have some impact if we have lots of automated test. So I implement a method to click on this accept cookies button with JavaScript command. This is more reliable. I also implement a traditional way to do so by simply have the web element click. I believe a very small portion of tests should still use the traditional way as this is simulation how the actual users are using it.
2. Again for the GDPR panel, if time permit we should implement a way to detect IP address that apply the GDPR law. I tried to use VPN connected to USA server and the GDPR panel will not be proposed. So a more intelligent test should be able to detect this.
3. I used test.properties file to stored some environment data. If CI/CD pipelines are being considered in the future, a new mechanism such as passing the variable by defining the System properties maybe needed.



## ---------------- Dividing from the original text ------------------------

This project is about assessing QA automation abilities.

## Getting Started

### Prerequisites
* Java JDK: 10 or higher
* Maven: 3.3.9 or higher

## Test Objectives
The marketing team ask you to write an automation test to validate how prospect access to our website, and the form to request a demo of the product.
 
The test steps are:
 1. Search AODocs in Google
 2. In the result, open the website www.aodocs.com
 3. Into the website click on the "Request a demo" button
 4. Fill the form with:
     * your first name
     * set empty in the "Last Name" field
     * fill a random string in the "Your Email" field
     * choose a value in Company Size
 5. Check the error messages

## Notes
In this project you can find a utility class "WebDriverUtility" to help you to start a browser locally.
To write the test, you need to use Junit 5 already configured in pom.xml
