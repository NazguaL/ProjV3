package libs;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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


}
