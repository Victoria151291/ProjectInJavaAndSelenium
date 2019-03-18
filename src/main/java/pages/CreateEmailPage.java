package pages;

import helpers.SetGetEmailData;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class CreateEmailPage extends Page {

    private WebDriver driver;

    private static final String SEND_LETTER_TO_XPATH = "//textarea[@data-original-name='To']";
    private static final String SEND_LETTER_SUBJECT_XPATH = "//input[@name='Subject']";
    private static final String SEND_LETTER_BODY_XPATH = "//*[@id='tinymce']";
    private static final String TOOLKIT_FRAME_XPATH = "//iframe[contains(@id,'toolkit')]";
    private static final String SEND_LETTER_BTN_XPATH = "//span[text()='Отправить']";
    private static final String UPLOAD_BTN_FOR_FILE_XPATH = "//span[text()='Прикрепить файл']/../preceding-sibling::input";

    private CreateEmailPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    static CreateEmailPage initPage(WebDriver driver) {
        return new CreateEmailPage(driver);
    }

    private CreateEmailPage setValueForFieldTo(String sendLetterToXpath, String address) {
        clearAndSetValueIntoField(sendLetterToXpath, address);
        return this;
    }

    private CreateEmailPage setValueForFieldSubject(String sendLetterSubjectXpath, String subject) {
        clearAndSetValueIntoField(sendLetterSubjectXpath, subject);
        return this;
    }

    private CreateEmailPage setValueForFieldBody(String sendLetterBodyXpath, String body) {

        switchToFrame(findElementByXpath(TOOLKIT_FRAME_XPATH))
                .clearAndSetValueIntoField(sendLetterBodyXpath, body)
                .switchToDefaultContent();
        return this;
    }

    private CreateEmailPage uploadFile(String filePath) throws IOException {
        uploadFile(UPLOAD_BTN_FOR_FILE_XPATH, filePath);
        return this;
    }

    public CreateEmailPage fillLetter(SetGetEmailData setGetEmailData) throws IOException {
        setValueForFieldTo(SEND_LETTER_TO_XPATH, setGetEmailData.getAddress());
        setValueForFieldSubject(SEND_LETTER_SUBJECT_XPATH, setGetEmailData.getSubject());
        setValueForFieldBody(SEND_LETTER_BODY_XPATH, setGetEmailData.getBody());
        uploadFile(setGetEmailData.getFilePath());
        return this;
    }

    public AfterSentEmailPage sendLetter() {
        clickOnElementByLMB(SEND_LETTER_BTN_XPATH);
        return AfterSentEmailPage.initPage(driver);
    }
}