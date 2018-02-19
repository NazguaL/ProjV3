package libs;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by User on 18.02.2018.
 */
public class ActionsWithWebElements
{
    WebDriver driver;
    Logger log;

    public ActionsWithWebElements  (WebDriver driver)
    {
        this.driver = driver;
        log = Logger.getLogger(getClass());
    }

    public void InputToTextField(By element, String value)
    {
        try
        {
            driver.findElement(element).clear();
            driver.findElement(element).sendKeys(value);
            log.trace(value + " is inputed to " + element);
        }
        catch (Exception ex)
        {
            log.error("Login doesn't input " + ex);
        }
    }


}
