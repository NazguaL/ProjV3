package libs;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

    public void CheckACheckbox (By checkbox) throws Exception
    {
        // isSelected() http://selftechy.com/2011/07/23/selenium-2-0-webdriver-some-useful-apis
        WebElement cancheck = driver.findElement(checkbox);
        if (!cancheck.isSelected())
        {
            cancheck.click();
            log.trace("Check a checkbox: " + checkbox);
        }
    }

    public void UnheckACheckbox (By checkbox) throws Exception
    {
        WebElement cancheck = driver.findElement(checkbox);
        if (cancheck.isSelected())
        {
            cancheck.click();
            log.trace("Uncheck a checkbox: " + checkbox);
        }
    }

    public boolean IsACheckboxSelected (By checkbox) throws Exception
    {
        WebElement cancheck = driver.findElement(checkbox);
        log.trace("checkbox: " + checkbox + "IsSelected: " + cancheck.isSelected());
        return cancheck.isSelected();
    }

}
