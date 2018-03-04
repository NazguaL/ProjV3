package loginTests;

import libs.ConfigData;
import org.junit.Test;
import parentTest.ParentTest;

import java.io.IOException;
import java.util.Map;

/**
 * Created by User on 04.03.2018.
 */
public class PositiveLoginFromExcel extends ParentTest {


    public PositiveLoginFromExcel (String browser)
    {
        super(browser);
    }

    @Test
    public void ValidLogin () throws IOException
    {
        String excelDataFile = ConfigData.getCfgValue("DATA_FILE");
        Map dataFromExcelFileForLogin = excelDriver.getData(excelDataFile, "validLogOn");
        loginPage.OpenLoginPage();
        loginPage.InputLogin(dataFromExcelFileForLogin.get("login").toString());


    }


}
