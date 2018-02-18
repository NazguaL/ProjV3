package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by User on 18.02.2018.
 */
public class HomePage
{
    WebDriver driver;
    Logger log;
    String TitleLogo = "//a[@class='logo']";

    public HomePage (WebDriver driver)
    {
        this.driver = driver;
        log = Logger.getLogger(getClass());
    }

}
