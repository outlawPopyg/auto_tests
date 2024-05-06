import base.AbstractEditProfile;
import models.UserProfile;
import org.junit.Test;


public class EditProfileTest extends AbstractEditProfile {

	@Test
	public void editUserProfileBirthDate() {
		login();

		editProfile(UserProfile.builder()
				.birthDay(1)
				.birthMonth(UserProfile.MONTHS.NOV)
				.birthYear(2004)
				.build());
	}

	@Test
	public void editUserProfileExtraData() {
		login();

		editProfile(UserProfile.builder()
				.name("Джон")
				.sex(UserProfile.SEX.M)
				.build());
	}

}
