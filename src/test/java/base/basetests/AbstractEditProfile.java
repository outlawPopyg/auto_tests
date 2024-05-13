package base.basetests;

import lombok.SneakyThrows;
import models.UserProfile;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public abstract class AbstractEditProfile extends AbstractLogin {
	@SneakyThrows
	protected void editProfile(UserProfile profile) {
		WebDriver driver = getApplicationManager().getDriver();

		login();

		driver.findElement(By.id("cUserLink")).click();
		driver.findElement(By.id("elUserLink")).click();
		driver.findElement(By.linkText("Профиль")).click();
		driver.findElement(By.xpath("//ul[@id='elEditProfile']/li[2]/a/span")).click();

		if (profile.getBirthDay() != null) {
			driver.findElement(By.name("bday[day]")).click();
			new Select(driver.findElement(By.name("bday[day]"))).selectByVisibleText(profile.getBirthDay().toString());
		}

		if (profile.getBirthMonth() != null) {
			driver.findElement(By.name("bday[month]")).click();
			new Select(driver.findElement(By.name("bday[month]"))).selectByVisibleText(profile.getBirthMonth().getValue());
		}

		if (profile.getBirthYear() != null) {
			driver.findElement(By.name("bday[year]")).click();
			new Select(driver.findElement(By.name("bday[year]"))).selectByVisibleText(profile.getBirthYear().toString());
		}

		if (profile.getSex() != null) {
			driver.findElement(By.id("elSelect_core_pfield_4")).click();
			new Select(driver.findElement(By.id("elSelect_core_pfield_4"))).selectByVisibleText(profile.getSex().getValue());
		}

		if (profile.getName() != null) {
			driver.findElement(By.id("elInput_core_pfield_6")).click();
			driver.findElement(By.id("elInput_core_pfield_6")).clear();
			driver.findElement(By.id("elInput_core_pfield_6")).sendKeys(profile.getName());
		}

		driver.findElement(By.xpath("//div[@class='ipsDialog']/div/div/form/ul/li/button")).click();
		TimeUnit.SECONDS.sleep(2);
	}

	protected WebDriver openEditPage() {
		WebDriver driver = getApplicationManager().getDriver();

		driver.findElement(By.id("cUserLink")).click();
		driver.findElement(By.id("elUserLink")).click();
		driver.findElement(By.linkText("Профиль")).click();
		driver.findElement(By.xpath("//ul[@id='elEditProfile']/li[2]/a/span")).click();

		return driver;
	}
}
