package pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

public class DefaultLettersPage extends Page {

    private WebDriver driver;

    private static final String LETTER_ROW_XPATH = "//div[@class='b-datalist__item__panel']";
    public static final String WRITE_LETTER_BTN_XPATH = "//span[contains(text(),'Написать письмо')]";
    private static final String LETTER_FORM_XPATH = "//div[@id='b-compose']";
    public static final String SENT_LETTERS_XPATH = "//span[text()='Отправленные']";

    private DefaultLettersPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public static DefaultLettersPage initPage(WebDriver driver) {
        return new DefaultLettersPage(driver);
    }


    public CreateLetterPage initCreationOfLetter() {
        clickOnElementByLMB(WRITE_LETTER_BTN_XPATH)
                .waitForElementPresence(LETTER_FORM_XPATH, 2);
        return CreateLetterPage.initPage(driver);
    }

    public DefaultLettersPage openLettersPage(String lettersPage) {
        clickOnElementByLMB(lettersPage);
        try {
            waitForElementPresence(LETTER_ROW_XPATH, 5);
        } catch (TimeoutException ex) {
            driver.navigate().refresh();
        }
        return this;
    }

    @Override
    public DefaultLettersPage waitForElementPresence(String elementXpath, int seconds) {
        super.waitForElementPresence(elementXpath, seconds);
        return this;
    }
}