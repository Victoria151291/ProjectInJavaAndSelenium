package tests;

import helpers.ChromeDriverProvider;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import pages.MainPage;

public class BaseTest {

   WebDriver driver;

    /**
     * gets default chrome driver from factory and logs into the opened page
     */
    @BeforeMethod
    public void initSettings() {
        driver = ChromeDriverProvider.getWebDriver();
        MainPage
                .initPage(driver)
                .openMainPage()
                .authAndLogIn();
    }

    /**
     * logs out from the page and closes the chrome driver
     */
    @AfterClass
    public void tearDown() {
        MainPage
                .initPage(driver)
                .logOut();
        driver.quit();
    }
}