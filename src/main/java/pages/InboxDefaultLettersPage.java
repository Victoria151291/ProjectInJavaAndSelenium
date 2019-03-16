package pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

import static pages.MainPage.*;

public class InboxDefaultLettersPage extends Page {

    private WebDriver driver;

    private InboxDefaultLettersPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public static InboxDefaultLettersPage initPage(WebDriver driver) {
        return new InboxDefaultLettersPage(driver);
    }

    /**
     * init creation of the letter
     */
    public CreateLetterPage initCreationOfLetter() {
        super
                .clickOnWebElementByLMB(WRITE_LETTER_BTN_XPATH)
                .waitForElementPresence(LETTER_FORM_XPATH, 2);
        return CreateLetterPage.initPage(driver);
    }

    /**
     * open any letters' page from default
     *
     * @param lettersPage - letters' page
     */
    public InboxDefaultLettersPage openLettersPage(String lettersPage) {
        super.clickOnWebElementByLMB(lettersPage);
        try {
            super.waitForElementPresence(LETTER_ROW_XPATH, 5);
        } catch (TimeoutException ex) {
            driver.navigate().refresh();
        }
        return this;
    }

}