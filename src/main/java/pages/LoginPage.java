package pages;

import libs.ActionsWithWebElements;
import libs.ExceptionHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by User on 18.02.2018.
 */
public class LoginPage extends ParentPage
{

    /*Locators:*/
    By loginNameInput = By.xpath("//*[@name='_username']");
    By loginPassInput = By.xpath(".//*[@id='password']");
    //String loginSubmitButtonInputXpath = "//*[@type='submit']";
    By loginSubmitButtonInput = By.xpath("//*[@type='submit']");


    public LoginPage (WebDriver driver)
    {
        this.driver = driver;
        log = Logger.getLogger(getClass());
        actionsWithWebElements = new ActionsWithWebElements(driver);
        exceptionHelper = new ExceptionHelper();
    }

    public void OpenLoginPage (String link)
    {
        try
        {
            driver.get(link);
            log.trace("Page is opened");
        }
        catch (Exception e)
        {
            exceptionHelper.ExceptionLogger("Can not open login page!", e);
        }
    }

    public void InputLogin (String login)
    {
        try
        {
            actionsWithWebElements.InputToTextField(loginNameInput, login);
        } catch (Exception e)
        {
            exceptionHelper.ExceptionLogger("Can not fill login!", e);
        }
    }

    public void InputPass (String pass)
    {
        try
        {
            actionsWithWebElements.InputToTextField(loginPassInput, pass);
        } catch (Exception e)
        {
            exceptionHelper.ExceptionLogger("Can not fill password!", e);
        }
    }

    public void ClickSubmitButton ()
    {
        try
        {
            actionsWithWebElements.ClickOnButton(loginSubmitButtonInput);
        } catch (Exception e)
        {
            exceptionHelper.ExceptionLogger("Can not click on \"Submit\" button!", e);
        }
    }
}
