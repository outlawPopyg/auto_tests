package base;

import configuration.Settings;
import configuration.SettingsDTO;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

@Getter
@Setter
public class ApplicationManager {
	private WebDriver driver;
	private boolean acceptNextAlert;
	private StringBuffer verificationErrors;
	private JavascriptExecutor js;
	private String baseUrl;
	private String username;
	private String password;

	private ApplicationManager() {
		SettingsDTO settings = Settings.loadProperties();
		baseUrl = settings.getBaseUrl();
		username = settings.getLogin();
		password = settings.getPassword();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		js = (JavascriptExecutor) driver;
		acceptNextAlert = true;
		verificationErrors = new StringBuffer();
	}

	public static ApplicationManager getInstance() {
		return new ApplicationManager();
	}
}
