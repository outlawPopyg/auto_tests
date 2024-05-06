package base;

import lombok.SneakyThrows;
import models.UserProfile;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public abstract class AbstractTest {

	protected WebDriver driver;
	protected String baseUrl;
	protected boolean acceptNextAlert = true;
	protected StringBuffer verificationErrors = new StringBuffer();
	JavascriptExecutor js;
	private static final String username = "outlaw";
	private static final String password = "i!7am@pj_2CJUfd";

	@Before
	public void setUp() {
		driver = new ChromeDriver();
		baseUrl = "https://ap-pro.ru";
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		js = (JavascriptExecutor) driver;
	}

	@After
	public void tearDown() {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!verificationErrorString.isEmpty()) {
			fail(verificationErrorString);
		}
	}

	protected void login() {
		if (!isElementPresented(By.linkText("Уже зарегистрированы? Войти"))) {
			openHomePage();
			driver.findElement(By.id("elUserSignIn")).click();
			driver.findElement(By.name("auth")).click();
			driver.findElement(By.name("auth")).clear();
			driver.findElement(By.name("auth")).sendKeys(username);
			driver.findElement(By.name("password")).click();
			driver.findElement(By.name("password")).clear();
			driver.findElement(By.name("password")).sendKeys(password);
			driver.findElement(By.id("elSignIn_submit")).click();
		} else {
			System.out.println("Already authorized");
		}

	}

	protected void openHomePage() {
		driver.get(baseUrl);
	}

	private boolean isElementPresented(By element) {
		try {
			driver.findElement(element);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	private String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}
}