import base.basetests.AbstractTest;
import org.junit.Test;

public class LoginTest extends AbstractTest {
//	@Test
	public void loginTest() {
		System.out.println(Thread.currentThread().getName());
		getApplicationManager().getLoginHelper().login();
	}

//	@Test
	public void logoutTest() {
		System.out.println(Thread.currentThread().getName());

		getApplicationManager().getLoginHelper().login();

		getApplicationManager().getLoginHelper().logout();
	}
}
