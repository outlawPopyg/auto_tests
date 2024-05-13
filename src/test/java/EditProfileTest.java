import base.basetests.AbstractEditProfile;
import models.UserProfile;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class EditProfileTest extends AbstractEditProfile {
//	@Test
	public void editUserProfileBirthDate() {
		System.out.println(Thread.currentThread().getName());
		editProfile(UserProfile.builder()
				.birthDay(1)
				.birthMonth(UserProfile.MONTHS.NOV)
				.birthYear(2004)
				.build());

		WebDriver driver = openEditPage();

		String day = driver.findElement(By.name("bday[day]")).getAttribute("value");
		String month = driver.findElement(By.name("bday[month]")).getAttribute("value");
		String year = driver.findElement(By.name("bday[year]")).getAttribute("value");

		Assert.assertEquals("1", day);
		Assert.assertEquals(UserProfile.MONTHS.NOV.ordinal() + 1, Integer.parseInt(month));
		Assert.assertEquals("2004", year);

	}

//	@Test
	public void editUserProfileExtraData() {
		System.out.println(Thread.currentThread().getName());
		editProfile(UserProfile.builder()
				.name("Калим")
				.sex(UserProfile.SEX.M)
				.build());

		WebDriver driver = openEditPage();

		String name = driver.findElement(By.id("elInput_core_pfield_6")).getAttribute("value");
		String sex = driver.findElement(By.id("elSelect_core_pfield_4")).getAttribute("value");

		Assert.assertEquals("Калим", name);
		Assert.assertEquals(UserProfile.SEX.M.getValue(), sex);

	}

}
