package libs;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

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

    public String Title ()
    {
        String title =  driver.getTitle();
        log.trace("Title is: " + title);
        return title;
    }

    public void InputToTextField (WebElement element, String value) throws Exception
    {
        element.clear();
        element.sendKeys(value);
        log.trace(value + " is filled to element: " + element);
    }

    public void ClickOnButton (WebElement button) throws Exception
    {
        button.click();
        log.trace("Clicked on button: " + button);
    }

    public void SelectACheckbox(By checkbox) throws Exception {
        // isSelected() http://selftechy.com/2011/07/23/selenium-2-0-webdriver-some-useful-apis
        WebElement cancheck = driver.findElement(checkbox);
        if (!cancheck.isSelected()) {
            cancheck.click();
            log.trace("Select a checkbox: " + checkbox);
        }
    }

    public void UnSelectACheckbox(By checkbox) throws Exception {
        WebElement cancheck = driver.findElement(checkbox);
        if (cancheck.isSelected()) {
            cancheck.click();
            log.trace("UnSelect a checkbox: " + checkbox);
        }
    }

    public boolean IsACheckboxSelected (By checkbox) throws Exception
    {
        WebElement cancheck = driver.findElement(checkbox);
        log.trace("Checkbox: " + checkbox + "IsSelected: " + cancheck.isSelected());
        return cancheck.isSelected();
    }

    public void SelectARadiobutton (By radiobutton) throws Exception
    {
        driver.findElement(radiobutton).click();
        log.trace("Select a Radiobutton: " + radiobutton);
    }

    public boolean IsARadiobuttonSelected (By radiobutton) throws Exception
    {
        WebElement cancheck = driver.findElement(radiobutton);
        log.trace("radiobutton: " + radiobutton + " IsSelected: " + cancheck.isSelected());
        return cancheck.isSelected();
    }

    public boolean IsElementPresent (WebElement element)
    {
        return element.isDisplayed() && element.isEnabled();
    }

    public void SelectItemFromDropDownByVisibleElement (WebElement elementDD, String textForSelect)
    {
        Select optionFromDD = new Select(elementDD);
        optionFromDD.deselectByVisibleText(textForSelect);
        log.trace(textForSelect + " was selected from DD menu.");
    }

}
