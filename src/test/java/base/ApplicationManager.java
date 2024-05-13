package base;

import base.helpers.LoginHelper;
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
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	private JavascriptExecutor js;
	private String username = "outlaw";
	private String password = "i!7am@pj_2CJUfd";

	private final LoginHelper loginHelper;


	private ApplicationManager() {
		driver = new ChromeDriver();
		baseUrl = "https://ap-pro.ru";
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		js = (JavascriptExecutor) driver;
		loginHelper = new LoginHelper(this);
	}

	public static ApplicationManager getInstance() {
		return new ApplicationManager();
	}
}
