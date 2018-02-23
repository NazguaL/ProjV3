package loginTests;

import libs.DriverInitiator;
import libs.ExceptionHelper;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import pages.LoginPage;

// import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Created by User on 18.02.2018.
 */
public class PositiveLogin
{
    WebDriver driver;
    //WebDriverWait wait;
    Logger log;
    LoginPage loginPage;
    HomePage homePage;
    ExceptionHelper exceptionHelper;
    DriverInitiator driverInitiator;

    @Before
    public void Setup ()
    {
        //File fileFF = new File("./drivers/chromedriver.exe");
        //System.setProperty("webdriver.chrome.driver", fileFF.getAbsolutePath());
        //driver = new ChromeDriver();
        //wait = new WebDriverWait(driver, 10);
        driverInitiator = new DriverInitiator();
        this.driver = driverInitiator.StartCromeDriver();
        log = Logger.getLogger(getClass());
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginPage = new LoginPage(driver);
        exceptionHelper = new ExceptionHelper();
        homePage = new HomePage(driver);
    }

    @Test
    public void ValidLogin ()
    {
        loginPage.OpenLoginPage("http://v3.qalight.com.ua/login");
        loginPage.InputLogin("Student");
        loginPage.InputPass("909090");
        loginPage.ClickSubmitButton();
        log.trace(driver.getTitle());
        String expectedTitle = "Учет запчастей";
        homePage.CompareTitle(expectedTitle);
    }


    @After
    public void CloseDriver ()
    {
        driver.quit();
    }

}
