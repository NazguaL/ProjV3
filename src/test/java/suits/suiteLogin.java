package suits;

import loginTests.NegativeLogin;
import loginTests.NegativeLoginWithParamWithDataFromExcel;
import loginTests.PositiveLogin;
import loginTests.PositiveLoginFromExcel;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by User on 04.03.2018.
 */

@RunWith(Suite.class)
@Suite.SuiteClasses
        ({
        NegativeLogin.class,
        PositiveLogin.class,
        NegativeLoginWithParamWithDataFromExcel.class,
        PositiveLoginFromExcel.class
})

public class suiteLogin {
}
