package pages;

import org.openqa.selenium.WebDriver;

import static helpers.DataForTests.*;

public class CreateLetterPage extends Page {

    private WebDriver driver;

    private static final String SEND_LETTER_TO_XPATH = "//textarea[@data-original-name='To']";
    private static final String SEND_LETTER_SUBJECT_XPATH = "//input[@name='Subject']";
    private static final String SEND_LETTER_BODY_XPATH = "//*[@id='tinymce']";
    private static final String TOOLKIT_FRAME_XPATH = "//iframe[contains(@id,'toolkit')]";
    private static final String SEND_LETTER_BTN_XPATH = "(//span[text()='Отправить'])[1]";
    private static final String MESSAGE_SENT_XPATH = "//div[@class='message-sent__title']";
    private static final String UPLOAD_BTN_FOR_FILE_XPATH = "//span[text()='Прикрепить файл']/../preceding-sibling::input";

    private CreateLetterPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public static CreateLetterPage initPage(WebDriver driver) {
        return new CreateLetterPage(driver);
    }

    /**
     * set value for field 'To'
     */
    public CreateLetterPage setValueForFieldTo() {
        super.clearAndSetValueIntoField(SEND_LETTER_TO_XPATH, SEND_LETTER_TO);
        return this;
    }

    /**
     * set value for field 'Subject'
     */
    public CreateLetterPage setValueForFieldSubject() {
        super.clearAndSetValueIntoField(SEND_LETTER_SUBJECT_XPATH, SEND_LETTER_SUBJECT);
        return this;
    }

    /**
     * set value for field 'Body'
     */
    public CreateLetterPage setValueForFieldBody() {
        super
                .switchToFrame(findWebElementByXpath(TOOLKIT_FRAME_XPATH))
                .clearAndSetValueIntoField(SEND_LETTER_BODY_XPATH, SEND_LETTER_BODY)
                .switchToDefaultContent();
        return this;
    }

    /**
     * upload file into the letter
     *
     * @param filePath - path to file
     */
    public CreateLetterPage uploadFile(String filePath) {
        super.uploadFile(UPLOAD_BTN_FOR_FILE_XPATH, filePath);
        return this;
    }

    /**
     * send the letter
     */
    public void sendLetter() {
        super
                .clickOnWebElementByLMB(SEND_LETTER_BTN_XPATH)
                .checkThatExists(MESSAGE_SENT_XPATH);
    }
}