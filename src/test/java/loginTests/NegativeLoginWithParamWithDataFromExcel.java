package loginTests;

/**
 * Created by NazguaL on 10.03.2018.
 */
        import libs.ConfigData;
        import libs.SpreadsheetData;
        import org.junit.Test;
        import org.junit.runners.Parameterized;
        import parentTest.ParentTest;

        import java.io.FileInputStream;
        import java.io.IOException;
        import java.io.InputStream;
        import java.util.Collection;

public class NegativeLoginWithParamWithDataFromExcel extends ParentTest
{
    String login, pass;

    public NegativeLoginWithParamWithDataFromExcel (String browser, String login, String pass) {
        super(browser);
        this.login = login;
        this.pass = pass;
    }

    @Parameterized.Parameters
    public static Collection testData() throws IOException
    {
        InputStream spreadsheet = new FileInputStream(ConfigData.getCfgValue("DATA_FILE_PATH"));
        return new SpreadsheetData(spreadsheet, "InvalidLogOn").getData();      //2й параметр - указываем название листа в екселе
    }



    @Test
    public void invalidLogin(){
        loginPage.LoginUser(login,pass);
        checkAcceptanceCriteria("Title not match", loginPage.GetTitle(), "Account of spare:Авторизация");
    }
}
