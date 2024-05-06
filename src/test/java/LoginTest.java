import base.basetests.AbstractTest;
import org.junit.Test;

public class LoginTest extends AbstractTest {
	@Test
	public void loginTest() {
		getApplicationManager().getLoginHelper().login();
	}

	@Test
	public void logoutTest() {
		getApplicationManager().getLoginHelper().login();

		getApplicationManager().getLoginHelper().logout();
	}
}
