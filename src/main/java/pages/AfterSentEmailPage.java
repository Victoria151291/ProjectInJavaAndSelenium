package pages;

import org.openqa.selenium.WebDriver;

public class AfterSentEmailPage extends Page {

    public static final String GO_TO_INBOX_LETTERS_LINK = "//a[text()='Перейти во Входящие']";
    private static final String MESSAGE_SENT_LETTER_XPATH = "//div[@class='message-sent__title']";

    private AfterSentEmailPage(WebDriver driver) {
        super(driver);
    }

    static AfterSentEmailPage initPage(WebDriver driver) {
        return new AfterSentEmailPage(driver);
    }

    public AfterSentEmailPage checkPresenceOfMessageAfterSending() {
        checkThatExists(MESSAGE_SENT_LETTER_XPATH);
        return this;
    }

    @Override
    public AfterSentEmailPage waitForElementPresence(String elementXpath, int seconds) {
        super.waitForElementPresence(elementXpath, seconds);
        return this;
    }
}