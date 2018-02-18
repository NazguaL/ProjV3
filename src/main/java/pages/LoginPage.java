package pages;

import libs.ActionsWithWebElements;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by User on 18.02.2018.
 */
public class LoginPage {
    WebDriver driver;
    Logger log;
    ActionsWithWebElements actionsWithWebElements;

    String loginNameInputXpath = "//*[@name='_username']";
    //String loginNameInputName = "_username";
    By loginNameInput = By.xpath("//*[@name='_username']");

    String loginPassInputXpath = ".//*[@id='password']";
    String loginPassInputId = "password";

    String loginSubmitButtonInputXpath = "//*[@type='submit']";
    //String loginSubmitButtonInputType = "submit";

    public LoginPage (WebDriver driver)
    {
        this.driver = driver;
        log = Logger.getLogger(getClass());
    }

    public void OpenLoginPage (String link)
    {
        try
        {
            driver.get(link);
            log.trace("Page is opened");
        }
        catch (Exception ex)
        {
            log.error("Can not open login page");
        }
    }

    public void InputLogin ()
    {
        actionsWithWebElements = new ActionsWithWebElements(driver);
        actionsWithWebElements.InputToTextField(loginNameInputXpath, "Student");
    }

    public void InputPass (String pass)
    {
        driver.findElement(By.id(loginPassInputId)).clear();
        driver.findElement(By.id(loginPassInputId)).sendKeys(pass);
    }

    public void ClickSubmitButton ()
    {
        driver.findElement(By.xpath(loginSubmitButtonInputXpath)).click();
    }
}
