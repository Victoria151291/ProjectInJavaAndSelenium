package pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

public class DefaultEmailPage extends Page {

    private WebDriver driver;

    private static final String LETTER_ROW_XPATH = "//div[@class='b-datalist__item__panel']";
    public static final String WRITE_LETTER_BTN_XPATH = "//span[contains(text(),'Написать письмо')]";
    private static final String LETTER_FORM_XPATH = "//div[@id='b-compose']";
    public static final String SENT_LETTERS_XPATH = "//span[text()='Отправленные']";

    private DefaultEmailPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public static DefaultEmailPage initPage(WebDriver driver) {
        return new DefaultEmailPage(driver);
    }


    public CreateEmailPage initCreationOfLetter() {
        clickOnElementByLMB(WRITE_LETTER_BTN_XPATH)
                .waitForElementPresence(LETTER_FORM_XPATH, 2);
        return CreateEmailPage.initPage(driver);
    }

    public DefaultEmailPage openLettersPage(String lettersPage) {
        clickOnElementByLMB(lettersPage);
        try {
            waitForElementPresence(LETTER_ROW_XPATH, 5);
        } catch (TimeoutException ex) {
            driver.navigate().refresh();
        }
        return this;
    }

    @Override
    public DefaultEmailPage waitForElementPresence(String elementXpath, int seconds) {
        super.waitForElementPresence(elementXpath, seconds);
        return this;
    }
}