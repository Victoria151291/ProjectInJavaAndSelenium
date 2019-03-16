package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

import static java.util.logging.Logger.getLogger;
import static org.openqa.selenium.By.xpath;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class Page {

    private WebDriver driver;

    Page(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * finds web element by xpath
     *
     * @param elementXpath - web element's xpath
     */
    WebElement findElementByXpath(String elementXpath) {
        return driver.findElement(xpath(elementXpath));
    }

    /**
     * clicks on the web element by left mouse's button
     *
     * @param elementXpath - element's xpath for a click
     */
    Page clickOnElementByLMB(String elementXpath) {
        WebElement element = findElementByXpath(elementXpath);
        element.click();
        return this;
    }

    /**
     * sets value into the field
     *
     * @param fieldXpath - field's xpath
     * @param value      - field's value
     */
    Page clearAndSetValueIntoField(String fieldXpath, String value) {
        WebElement field = findElementByXpath(fieldXpath);
        field.clear();
        field.sendKeys(value);
        return this;
    }

    /**
     * waits for presence of the element
     *
     * @param elementXpath - element's xpath
     * @param seconds      - time in seconds
     */
    public Page waitForElementPresence(String elementXpath, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.until(ExpectedConditions.presenceOfElementLocated(xpath(elementXpath)));
        return this;
    }

    /**
     * switches to frame
     *
     * @param elementXpath - element's xpath
     */
    Page switchToFrame(WebElement elementXpath) {
        driver.switchTo().frame(elementXpath);
        return this;
    }

    /**
     * switches to default content
     */
    void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    /**
     * gets visible element's text and assert it with matched text
     *
     * @param elementXpath - element's xpath
     * @param matchedText  - matched text
     */
    void getVisibleTextAndAssertIt(String elementXpath, String matchedText) {
        String elementText = findElementByXpath(elementXpath).getText();
        assertEquals(elementText, matchedText);
    }

    /**
     * uploads file into the letter
     *
     * @param inputXpath - input element's xpath
     * @param filePath   - path to file
     */
    void uploadFile(String inputXpath, String filePath) throws IOException {
        try {
            findElementByXpath(inputXpath).sendKeys(new File(filePath).getCanonicalPath());
        } catch (IllegalArgumentException ex) {
            getLogger("MainLogger").info("File not found by the path: " + filePath);
        }
    }

    /**
     * checks if the element is displayed on the page
     *
     * @param elementXpath - element's xpath
     */
    void checkThatExists(String elementXpath) {
        WebElement element = findElementByXpath(elementXpath);
        if (!element.isDisplayed()) {
            fail("Element " + elementXpath + " is not found");
        }
    }
}