package base.helpers;

import base.ApplicationManager;
import org.openqa.selenium.By;

public class LoginHelper extends AbstractHelper {

	public LoginHelper(ApplicationManager manager) {
		super(manager);
	}

	public void login() {
		if (!isElementNotPresented(By.linkText("Уже зарегистрированы? Войти"))) {
			openHomePage();
			getDriver().findElement(By.id("elUserSignIn")).click();
			getDriver().findElement(By.name("auth")).click();
			getDriver().findElement(By.name("auth")).clear();
			getDriver().findElement(By.name("auth")).sendKeys(manager.getUsername());
			getDriver().findElement(By.name("password")).click();
			getDriver().findElement(By.name("password")).clear();
			getDriver().findElement(By.name("password")).sendKeys(manager.getPassword());
			getDriver().findElement(By.id("elSignIn_submit")).click();
		} else {
			System.out.println("Already authorized");
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
