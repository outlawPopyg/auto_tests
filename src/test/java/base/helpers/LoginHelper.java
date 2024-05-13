package base.helpers;

import base.ApplicationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class LoginHelper extends AbstractHelper {

	public LoginHelper(ApplicationManager manager) {
		super(manager);
	}

	public void login() {
		openHomePage();
		WebElement login = null;
		try {
			login = getDriver().findElement(By.id("elUserSignIn"));
		} catch (NoSuchElementException exception) {
			System.out.println("Already authorized");
		}

		if (login != null) {
			getDriver().findElement(By.id("elUserSignIn")).click();
			getDriver().findElement(By.name("auth")).click();
			getDriver().findElement(By.name("auth")).clear();
			getDriver().findElement(By.name("auth")).sendKeys(manager.getUsername());
			getDriver().findElement(By.name("password")).click();
			getDriver().findElement(By.name("password")).clear();
			getDriver().findElement(By.name("password")).sendKeys(manager.getPassword());
			getDriver().findElement(By.id("elSignIn_submit")).click();
		}
	}

	public void logout() {
		if (isElementNotPresented(By.linkText("Уже зарегистрированы? Войти"))) {
			openHomePage();
			getDriver().findElement(By.xpath("//a[@id='elUserLink']/i")).click();
			getDriver().findElement(By.linkText("Выйти")).click();
		}
	}
}
