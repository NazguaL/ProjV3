package pages;

import libs.ActionsWithWebElements;
import libs.ExceptionHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by User on 24.02.2018.
 */
public class ParentPage
{
        WebDriver driver;
        Logger log;
        ActionsWithWebElements actionsWithWebElements;
        ExceptionHelper exceptionHelper;

    public ParentPage (WebDriver driver)
    {
        this.driver = driver;
        log = Logger.getLogger(getClass());
        actionsWithWebElements = new ActionsWithWebElements(driver);
        exceptionHelper = new ExceptionHelper();
        PageFactory.initElements(driver, this);
    }

}
