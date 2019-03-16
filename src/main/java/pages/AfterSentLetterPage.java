package pages;

import org.openqa.selenium.WebDriver;

public class AfterSentLetterPage extends Page {

    public static final String GO_TO_INBOX_LETTERS_LINK = "//a[text()='Перейти во Входящие']";
    private static final String MESSAGE_SENT_LETTER_XPATH = "//div[@class='message-sent__title']";

    private AfterSentLetterPage(WebDriver driver) {
        super(driver);
    }

    static AfterSentLetterPage initPage(WebDriver driver) {
        return new AfterSentLetterPage(driver);
    }

    public AfterSentLetterPage checkPresenceOfMessageAfterSending() {
        checkThatExists(MESSAGE_SENT_LETTER_XPATH);
        return this;
    }

    @Override
    public AfterSentLetterPage waitForElementPresence(String elementXpath, int seconds) {
        super.waitForElementPresence(elementXpath, seconds);
        return this;
    }
}