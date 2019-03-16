package pages;

import helpers.Letter;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class CreateLetterPage extends Page {

    private WebDriver driver;

    private static final String SEND_LETTER_TO_XPATH = "//textarea[@data-original-name='To']";
    private static final String SEND_LETTER_SUBJECT_XPATH = "//input[@name='Subject']";
    private static final String SEND_LETTER_BODY_XPATH = "//*[@id='tinymce']";
    private static final String TOOLKIT_FRAME_XPATH = "//iframe[contains(@id,'toolkit')]";
    private static final String SEND_LETTER_BTN_XPATH = "//span[text()='Отправить']";
    private static final String UPLOAD_BTN_FOR_FILE_XPATH = "//span[text()='Прикрепить файл']/../preceding-sibling::input";

    private CreateLetterPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    static CreateLetterPage initPage(WebDriver driver) {
        return new CreateLetterPage(driver);
    }

    private CreateLetterPage setValueForFieldTo(String sendLetterToXpath, String address) {
        clearAndSetValueIntoField(sendLetterToXpath, address);
        return this;
    }

    private CreateLetterPage setValueForFieldSubject(String sendLetterSubjectXpath, String subject) {
        clearAndSetValueIntoField(sendLetterSubjectXpath, subject);
        return this;
    }

    private CreateLetterPage setValueForFieldBody(String sendLetterBodyXpath, String body) {

        switchToFrame(findElementByXpath(TOOLKIT_FRAME_XPATH))
                .clearAndSetValueIntoField(sendLetterBodyXpath, body)
                .switchToDefaultContent();
        return this;
    }

    private CreateLetterPage uploadFile(String filePath) throws IOException {
        uploadFile(UPLOAD_BTN_FOR_FILE_XPATH, filePath);
        return this;
    }

    public CreateLetterPage fillLetter(Letter letter) throws IOException {
        setValueForFieldTo(SEND_LETTER_TO_XPATH, letter.getAddress());
        setValueForFieldSubject(SEND_LETTER_SUBJECT_XPATH, letter.getSubject());
        setValueForFieldBody(SEND_LETTER_BODY_XPATH, letter.getBody());
        uploadFile(letter.getFilePath());
        return this;
    }

    public AfterSentLetterPage sendLetter() {
        clickOnElementByLMB(SEND_LETTER_BTN_XPATH);
        return AfterSentLetterPage.initPage(driver);
    }
}