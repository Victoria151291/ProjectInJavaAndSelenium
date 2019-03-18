package tests;

import helpers.Letter;
import org.testng.annotations.Test;
import pages.DefaultLettersPage;
import pages.SentLettersPage;

import java.io.IOException;

import static helpers.DataForTests.*;
import static helpers.Paths.PATH_TO_FILE;
import static pages.AfterSentLetterPage.GO_TO_INBOX_LETTERS_LINK;
import static pages.DefaultLettersPage.SENT_LETTERS_XPATH;
import static pages.DefaultLettersPage.WRITE_LETTER_BTN_XPATH;

public class WorkWithLettersTests extends BaseTest {

    @Test(description = "This test creates, sends and checks for email in 'Sent emails'")
    public void createAndSendLetter() throws IOException {
        DefaultLettersPage defaultLettersPage = DefaultLettersPage.initPage(driver);
        defaultLettersPage
                .waitForElementPresence(WRITE_LETTER_BTN_XPATH, 3)
                .initCreationOfLetter()
                .fillLetter(
                        new Letter()
                                .setAddress(SEND_LETTER_TO_ADDRESS)
                                .setSubject(SEND_LETTER_SUBJECT)
                                .setBody(SEND_LETTER_BODY)
                                .setFilePath(PATH_TO_FILE)
                )
                .sendLetter()
                .waitForElementPresence(GO_TO_INBOX_LETTERS_LINK, 3)
                .checkPresenceOfMessageAfterSending();
        defaultLettersPage
                .openLettersPage(SENT_LETTERS_XPATH);
        SentLettersPage
                .initPage(driver)
                .checkPresenceOfLetterInSentList();
    }
}