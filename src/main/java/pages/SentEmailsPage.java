package pages;

import org.openqa.selenium.WebDriver;

import static helpers.DataForTests.SEND_LETTER_TO_ADDRESS;

public class SentEmailsPage extends Page {


    private static final String SENT_LETTER_ADDRESS_XPATH = "//div[@class='b-datalist__item__addr']";

    private SentEmailsPage(WebDriver driver) {
        super(driver);
    }

    public static SentEmailsPage initPage(WebDriver driver) {
        return new SentEmailsPage(driver);
    }

    public SentEmailsPage checkPresenceOfLetterInSentList() {
        getVisibleTextAndAssertIt(SENT_LETTER_ADDRESS_XPATH, SEND_LETTER_TO_ADDRESS);
        return this;
    }

}