package pages;

import org.openqa.selenium.WebDriver;

import static helpers.DataForTests.*;
import static helpers.Urls.BASE_URL;

public class MainPage extends Page {

    private WebDriver driver;

    private static final String FIELD_LOGIN_XPATH = "//input[@id='mailbox:login']";
    private static final String FIELD_PASS_XPATH = "//input[@id='mailbox:password']";
    private static final String SAVE_AUTH_CHECKBOX_XPATH = "//input[@class='mailbox__saveauth']";
    private static final String LOGIN_BTN_XPATH = "//label[@id='mailbox:submit']";
    private static final String LOGOUT_BTN_XPATH = "//a[@id='PH_logoutLink']";

    private MainPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public static MainPage initPage(WebDriver driver) {
        return new MainPage(driver);
    }

    /**
     * open the main page's URL
     */
    public MainPage openMainPage() {
        driver.get(BASE_URL);
        return this;
    }

    /**
     * auth and login into the page
     */
    public DefaultEmailPage authAndLogIn() {
        clearAndSetValueIntoField(FIELD_LOGIN_XPATH, TEST_LOGIN)
                .clearAndSetValueIntoField(FIELD_PASS_XPATH, TEST_PASS)
                .clickOnElementByLMB(SAVE_AUTH_CHECKBOX_XPATH)
                .clickOnElementByLMB(LOGIN_BTN_XPATH);
        return DefaultEmailPage.initPage(driver);
    }

    /**
     * logout from the page
     */
    public MainPage logOut() {
        clickOnElementByLMB(LOGOUT_BTN_XPATH);
        return this;
    }

}