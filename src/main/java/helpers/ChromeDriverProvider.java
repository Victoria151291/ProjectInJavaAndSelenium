package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static helpers.Paths.*;

public class ChromeDriverProvider {

    private static WebDriver chromeDriver;
    private static final String CHROME_DRIVER_PROPERTY_NAME = "webdriver.chrome.driver";

    private static void initPropertiesForChromeDriver() {
        String operSystem = System.getProperty("os.name");
        if (operSystem.contains("Windows")) {
            System.setProperty(CHROME_DRIVER_PROPERTY_NAME, PATH_TO_CHROME_DRIVER_WINDOWS);
        } else if (operSystem.contains("Linux")) {
            System.setProperty(CHROME_DRIVER_PROPERTY_NAME, PATH_TO_CHROME_DRIVER_LINUX);
        }
    }

    private static ChromeOptions initChromeOptions() {
        ChromeOptions opts = new ChromeOptions();
        opts.addArguments("--no-sandbox", "--incognito", "--window-size=1280,1024");
        return opts;
    }

    public static WebDriver getWebDriver() {
        initPropertiesForChromeDriver();
        return getChromeDriver(initChromeOptions());
    }

    private static WebDriver getChromeDriver(ChromeOptions chromeOptions) {
        if (chromeDriver == null) {
            chromeDriver = new ChromeDriver(chromeOptions);
        }
        return chromeDriver;
    }
}