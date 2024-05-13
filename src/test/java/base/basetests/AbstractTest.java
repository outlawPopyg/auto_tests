package base.basetests;

import base.ApplicationManager;
import lombok.Getter;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.Assert.fail;

@Getter
public abstract class AbstractTest {
	public static ThreadLocal<ApplicationManager> applicationManager =
			ThreadLocal.withInitial(ApplicationManager::getInstance);

	public static ApplicationManager getApplicationManager() {
		return applicationManager.get();
	}

	@AfterClass
	public static void tearDown() {
		getApplicationManager().getDriver().quit();
		String verificationErrorString = getApplicationManager().getVerificationErrors().toString();
		if (!verificationErrorString.isEmpty()) {
			fail(verificationErrorString);
		}
	}
}
