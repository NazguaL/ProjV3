package suits;

import loginTests.InvalidLogin;
import loginTests.PositiveLogin;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by User on 04.03.2018.
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({PositiveLogin.class, InvalidLogin.class} )

public class suiteLogin {
}
