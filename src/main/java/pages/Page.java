package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.util.logging.Logger.getLogger;
import static org.openqa.selenium.By.xpath;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class Page {

    WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Find web element by xpath
     *
     * @param elementXpath - web element's xpath
     */
    WebElement findWebElementByXpath(String elementXpath) {
        return driver.findElement(xpath(elementXpath));
    }

    /**
     * Click on the web element by left mouse's button
     *
     * @param elementXpath - element's xpath for a click
     */
    public Page clickOnWebElementByLMB(String elementXpath) {
        WebElement webElement = findWebElementByXpath(elementXpath);
        webElement.click();
        return this;
    }

    /**
     * Set value into the field
     *
     * @param fieldXpath - field's xpath
     * @param value      - field's value
     */
    public Page clearAndSetValueIntoField(String fieldXpath, String value) {
        WebElement field = findWebElementByXpath(fieldXpath);
        field.clear();
        field.sendKeys(value);
        return this;
    }

    /**
     * Wait for presence of the element
     *
     * @param elementXpath - element's xpath
     * @param seconds      - time in seconds
     */
    Page waitForElementPresence(String elementXpath, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.until(ExpectedConditions.presenceOfElementLocated(xpath(elementXpath)));
        return this;
    }

    /*Page executeJavaScript(String jsCode, Object... arguments) {
        Selenide.executeJavaScript(jsCode, arguments);
        return this;
    }*/

    /**
     * Switch to frame
     *
     * @param elementXpath - element's xpath
     */
    public Page switchToFrame(WebElement elementXpath) {
        driver.switchTo().frame(elementXpath);
        return this;
    }

    /**
     * Switch to default content
     */
    public Page switchToDefaultContent() {
        driver.switchTo().defaultContent();
        return this;
    }

    /**
     * Get visible element's text and assert it with matched text
     *
     * @param elementXpath - element's xpath
     * @param matchedText  - matched text
     */
    public Page getVisibleTextAndAssertIt(String elementXpath, String matchedText) {
        String elementText = findWebElementByXpath(elementXpath).getText();
        assertEquals(elementText, matchedText);
        return this;
    }

    /**
     * upload file into the letter
     *
     * @param inputXpath - input element's xpath
     * @param filePath   - path to file
     */
    public Page uploadFile(String inputXpath, String filePath) {
        try {
            findWebElementByXpath(inputXpath).sendKeys(filePath);
        } catch (IllegalArgumentException ex) {
            getLogger("MainLogger").info("File not found by the path: " + filePath);
        }
        return this;
    }

    /**
     * @param elementXpath - element's xpath
     */
    public Page checkThatExists(String elementXpath) {
        WebElement element = findWebElementByXpath(elementXpath);
        if (!element.isDisplayed()) {
            fail("Element " + elementXpath + " is not found");
        }
        return this;
    }
}