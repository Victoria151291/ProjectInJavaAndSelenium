package pages;

import org.openqa.selenium.WebDriver;

import static helpers.DataForTests.SEND_LETTER_TO_ADDRESS;

public class SentLettersPage extends Page {


    private static final String SENT_LETTER_ADDRESS_XPATH = "//div[@class='b-datalist__item__addr']";

    private SentLettersPage(WebDriver driver) {
        super(driver);
    }

    public static SentLettersPage initPage(WebDriver driver) {
        return new SentLettersPage(driver);
    }

    public SentLettersPage checkPresenceOfLetterInSentList() {
        getVisibleTextAndAssertIt(SENT_LETTER_ADDRESS_XPATH, SEND_LETTER_TO_ADDRESS);
        return this;
    }

}