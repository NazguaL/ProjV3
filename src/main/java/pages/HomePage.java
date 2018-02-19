package pages;

import libs.ActionsWithWebElements;
import libs.ExceptionHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by User on 18.02.2018.
 */
public class HomePage
{
    WebDriver driver;
    Logger log;
    ActionsWithWebElements actionsWithWebElements;
    ExceptionHelper exceptionHelper;
    /*Locators:*/
    By TitleLogo = By.xpath("//a[@class='logo']");

    public HomePage (WebDriver driver)
    {
        this.driver = driver;
        log = Logger.getLogger(getClass());
    }

}
