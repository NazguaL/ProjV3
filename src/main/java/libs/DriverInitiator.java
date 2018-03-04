package libs;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Created by User on 21.02.2018.
 */
public class DriverInitiator
{
    public WebDriver driver;
    Logger log;

    public WebDriver StartCromeDriver ()
    {
        WebDriver driver  = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        log = Logger.getLogger(getClass());
        log.trace("ChromeDriver initiated.");
        return driver;
    }

    public WebDriver StartFirefoxDriver ()
    {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(FirefoxDriver.MARIONETTE, false);
        WebDriver driver  = new FirefoxDriver(caps);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        log.trace("FirefoxDriver initiated.");
        return driver;
    }

    public WebDriver StartDriver (String browser)
    {

        if ("chrome".equals(browser)) {
    //log.info("Chrome is starting");
    File fileFF = new File("./drivers/chromedriver.exe");
    System.setProperty("webdriver.chrome.driver", fileFF.getAbsolutePath());
    driver  = new ChromeDriver();
    //log.info("Chrome is started");
}else if ("iedriver".equals(browser)) {
    log.info("IE will be started");
    File file1 = new File("./drivers/IEDriverServer.exe");
    System.setProperty("webdriver.ie.driver", file1.getAbsolutePath());
    DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
    capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
    capabilities.setCapability("ignoreZoomSetting", true);
    capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
    driver = new InternetExplorerDriver();
    log.info(" IE is started");
} else if ("fireFox".equals(browser)) {
                /*log.info("FireFox will be started");
                File fileFF = new File("./drivers/geckodriver.exe");
                System.setProperty("webdriver.gecko.driver", fileFF.getAbsolutePath());
                FirefoxProfile profile = new FirefoxProfile();
                profile.setPreference("browser.startup.page", 0); // Empty start page
                profile.setPreference("browser.startup.homepage_override.mstone", "ignore"); // Suppress the "What's new" page
                driver = new FirefoxDriver();
                log.info(" FireFox is started");*/
    DesiredCapabilities caps = new DesiredCapabilities();
    caps.setCapability(FirefoxDriver.MARIONETTE, false);
    driver = new FirefoxDriver(caps);
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    log.trace("FirefoxDriver initiated.");

}
        return driver;
}

}
