package pages;

import org.openqa.selenium.WebDriver;

import static helpers.DataForTests.*;
import static helpers.Urls.BASE_URL;

public class MainPage extends Page {

    private WebDriver driver;

    //XPATHs for auth
    private static final String FIELD_LOGIN_XPATH = "//input[@id='mailbox:login']";
    private static final String FIELD_PASS_XPATH = "//input[@id='mailbox:password']";
    private static final String SAVE_AUTH_CHECKBOX_XPATH = "//input[@class='mailbox__saveauth']";
    private static final String LOGIN_BTN_XPATH = "//label[@id='mailbox:submit']";
    private static final String LOGOUT_BTN_XPATH = "//a[@id='PH_logoutLink']";

    //XPATHs of letters's groups
    public static final String LETTER_ROW_XPATH = "//div[@class='b-datalist__item__panel']";
    public static final String WRITE_LETTER_BTN_XPATH = "//span[contains(text(),'Написать письмо')]";
    public static final String LETTER_FORM_XPATH = "//div[@id='b-compose']";
    public static final String SENT_LETTERS_XPATH = "//span[text()='Отправленные']";

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
    public InboxDefaultLettersPage authAndLogIn() {
        super
                .clearAndSetValueIntoField(FIELD_LOGIN_XPATH, TEST_LOGIN)
                .clearAndSetValueIntoField(FIELD_PASS_XPATH, TEST_PASS)
                .clickOnWebElementByLMB(SAVE_AUTH_CHECKBOX_XPATH)
                .clickOnWebElementByLMB(LOGIN_BTN_XPATH);
        return InboxDefaultLettersPage.initPage(driver);
    }

    /**
     * logout from the page
     */
    public MainPage logOut() {
        super.clickOnWebElementByLMB(LOGOUT_BTN_XPATH);
        return this;
    }

}