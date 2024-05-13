import base.basetests.AbstractLogin;
import configuration.Settings;
import org.junit.Test;

public class LoginTest extends AbstractLogin {
	@Test
	public void loginTest() {
		System.out.println(Thread.currentThread().getName());
		login();
	}

	@Test
	public void loginWithBadCredentials() {
		Settings.setFilePath("bad-credentials.xml");
		login();
	}

	@Test
	public void logoutTest() {
		System.out.println(Thread.currentThread().getName());
		login();
		logout();
	}
}
