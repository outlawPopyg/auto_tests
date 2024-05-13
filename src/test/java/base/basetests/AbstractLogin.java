package base.basetests;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class AbstractLogin extends AbstractTest {
	public void login() {
		openHomePage();
		WebDriver driver = getApplicationManager().getDriver();
		WebElement login = null;
		try {
			login = driver.findElement(By.id("elUserSignIn"));
		} catch (NoSuchElementException exception) {
			System.out.println("Already authorized");
		}

		if (login != null) {
			driver.findElement(By.id("elUserSignIn")).click();
			driver.findElement(By.name("auth")).click();
			driver.findElement(By.name("auth")).clear();
			driver.findElement(By.name("auth")).sendKeys(getApplicationManager().getUsername());
			driver.findElement(By.name("password")).click();
			driver.findElement(By.name("password")).clear();
			driver.findElement(By.name("password")).sendKeys(getApplicationManager().getPassword());
			driver.findElement(By.id("elSignIn_submit")).click();
		}
	}

	public void logout() {
		WebDriver driver = getApplicationManager().getDriver();
		WebElement logout = null;
		openHomePage();
		try {
			logout = driver.findElement(By.xpath("//a[@id='elUserLink']/i"));
		} catch (NoSuchElementException exception) {
			System.out.println("Not authorized yet");
		}

		if (logout != null) {
			logout.click();
			driver.findElement(By.linkText("Выйти")).click();
		}
	}
}
