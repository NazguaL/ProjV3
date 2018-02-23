package libs;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

/**
 * Created by User on 21.02.2018.
 */
public class DriverInitiator
{
    Logger log;

    public WebDriver StartCromeDriver ()
    {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        log = Logger.getLogger(getClass());
        log.trace("ChromeDriver initiated.");
        return driver;
    }

    public WebDriver StartFirefoxDriver ()
    {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(FirefoxDriver.MARIONETTE, false);
        WebDriver driver = new FirefoxDriver(caps);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        log.trace("FirefoxDriver initiated.");
        return driver;
    }

}
