package base.helpers;

import base.ApplicationManager;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.openqa.selenium.*;

@Getter
@AllArgsConstructor
public abstract class AbstractHelper {
	protected ApplicationManager manager;

	public WebDriver getDriver() {
		return manager.getDriver();
	}

	public void openHomePage() {
		getDriver().get(manager.getBaseUrl());
	}

	public boolean isElementNotPresented(By element) {
		try {
			getDriver().findElement(element);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public boolean isAlertPresent() {
		try {
			getDriver().switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	public String closeAlertAndGetItsText() {
		try {
			Alert alert = getDriver().switchTo().alert();
			String alertText = alert.getText();
			if (manager.isAcceptNextAlert()) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			manager.setAcceptNextAlert(true);
		}
	}
}
