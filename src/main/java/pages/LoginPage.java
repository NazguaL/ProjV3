package pages;

import libs.ActionsWithWebElements;
import libs.ConfigData;
import libs.ExceptionHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by User on 18.02.2018.
 */
public class LoginPage extends ParentPage
{

    /*Locators:*/
    //By loginNameInput = By.xpath("//*[@name='_username']");
    //By loginPassInput = By.xpath(".//*[@id='password']");
    //String loginSubmitButtonInputXpath = "//*[@type='submit']";
    //By loginSubmitButtonInput = By.xpath("//*[@type='submit']");

    @FindBy(name="_username")
    WebElement loginNameInput;

    @FindBy(id="password")
    WebElement loginPassInput;

    @FindBy(xpath = "//*[@type='submit']")
    WebElement loginSubmitButtonInput;


    public LoginPage (WebDriver driver)
    {
        super(driver);
    }

    public void OpenLoginPage ()
    {
        try
        {
            driver.get(ConfigData.getCfgValue("base_url") + "/login");
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

    public void LoginUser (String login, String pass)
    {
        OpenLoginPage();
        InputLogin(login);
        InputPass(pass);
        ClickSubmitButton();
    }
}
