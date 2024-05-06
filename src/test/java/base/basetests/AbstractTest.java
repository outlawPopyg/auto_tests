package base.basetests;

import base.ApplicationManager;
import lombok.Getter;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.Assert.fail;

@Getter
public abstract class AbstractTest {
	private ApplicationManager applicationManager;

	@Before
	public void setUp() {
		this.applicationManager = new ApplicationManager();
	}

	@After
	public void tearDown() {
		applicationManager.getDriver().quit();
		String verificationErrorString = applicationManager.getVerificationErrors().toString();
		if (!verificationErrorString.isEmpty()) {
			fail(verificationErrorString);
		}
	}
}
