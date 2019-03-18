package tests;

import helpers.SetGetEmailData;
import org.testng.annotations.Test;
import pages.DefaultEmailPage;
import pages.SentEmailsPage;

import java.io.IOException;

import static helpers.DataForTests.*;
import static helpers.Paths.PATH_TO_FILE;
import static pages.AfterSentEmailPage.GO_TO_INBOX_LETTERS_LINK;
import static pages.DefaultEmailPage.SENT_LETTERS_XPATH;
import static pages.DefaultEmailPage.WRITE_LETTER_BTN_XPATH;

public class WorkWithEmailsTests extends BaseTest {

    @Test(description = "This test creates, sends and checks for email in 'Sent emails'")
    public void createAndSendLetter() throws IOException {
        DefaultEmailPage defaultEmailPage = DefaultEmailPage.initPage(driver);
        defaultEmailPage
                .waitForElementPresence(WRITE_LETTER_BTN_XPATH, 3)
                .initCreationOfLetter()
                .fillLetter(
                        new SetGetEmailData()
                                .setAddress(SEND_LETTER_TO_ADDRESS)
                                .setSubject(SEND_LETTER_SUBJECT)
                                .setBody(SEND_LETTER_BODY)
                                .setFilePath(PATH_TO_FILE)
                )
                .sendLetter()
                .waitForElementPresence(GO_TO_INBOX_LETTERS_LINK, 3)
                .checkPresenceOfMessageAfterSending();
        defaultEmailPage
                .openLettersPage(SENT_LETTERS_XPATH);
        SentEmailsPage
                .initPage(driver)
                .checkPresenceOfLetterInSentList();
    }
}