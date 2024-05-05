import models.UserProfile;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;


public class ApProTest extends AbstractTest {
	private static final String username = "outlaw";
	private static final String password = "i!7am@pj_2CJUfd";

	@Test
	public void loginTest() {
		login(username, password);
	}

	@Test
	public void editUserProfile() {
		login(username, password);

		editProfile(UserProfile.builder()
				.birthDay(1)
				.birthMonth(UserProfile.MONTHS.NOV)
				.birthYear(2004)
				.build());
	}

}
