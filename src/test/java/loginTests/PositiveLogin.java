package loginTests;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Created by User on 18.02.2018.
 */
public class PositiveLogin
{
    WebDriver driver;
    Logger log;
    LoginPage loginPage;

    @Before
    public void Setup ()
    {
        //File fileFF = new File("./drivers/chromedriver.exe");
        //System.setProperty("webdriver.chrome.driver", fileFF.getAbsolutePath());
        driver = new ChromeDriver();
        log = Logger.getLogger(getClass());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginPage = new LoginPage(driver);
        // homePage = new HomePage(driver);
    }

    @Test
    public void ValidLogin ()
    {

        loginPage.OpenLoginPage("http://v3.qalight.com.ua/login");
        //loginPage.InputLogin("Student");
        loginPage.InputLogin();
        loginPage.InputPass("909090");

        loginPage.ClickSubmitButton();

    }

    @After
    public void CloseDriver ()
    {
       // driver.quit();
    }

}
