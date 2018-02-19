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

    public void InputToTextField(By element, String value) throws Exception
    {
        driver.findElement(element).clear();
        driver.findElement(element).sendKeys(value);
        log.trace(value + " is filled to element: " + element);
    }

    public void ClickOnButton (By button) throws Exception
    {
        driver.findElement(button).click();
        log.trace("Clicked on button: " + button);
    }



}
