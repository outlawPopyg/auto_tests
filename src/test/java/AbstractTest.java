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
	public void setUp() throws Exception {
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

	@SneakyThrows
	protected void editProfile(UserProfile profile) {
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
