package loginTests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import parentTest.ParentTest;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by User on 25.02.2018.
 */

@RunWith(value = Parameterized.class)

public class InvalidLoginWithParam extends ParentTest
{
    String login, pass;

    public InvalidLoginWithParam (String browser, String login, String pass)
    {
        super(browser);
        this.login = login;
        this.pass = pass;
    }

    @Parameterized.Parameters
    public static Collection testData(){
        return Arrays.asList(new Object[][]{
                {"chrome", "student", "906090"},
                {"chrome","tudent","906090"}
        });
    }

    @Test
    public void InvalidLogin ()
    {
        loginPage.LoginUser(login,pass);
        checkAcceptanceCriteria("Title is not expected", homePage.GetTitle(), "Account of spare:Авторизация");
    }
}
