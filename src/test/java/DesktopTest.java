import FlaNium.WinAPI.webdriver.DesktopOptions;
import FlaNium.WinAPI.webdriver.FlaNiumDriver;
import FlaNium.WinAPI.webdriver.FlaNiumDriverService;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DesktopTest {
	@Test
	public void test() throws InterruptedException {
		String DRIVER_PATH = "./src/main/resources/FlaNium.Desktop.Driver-v2.2.1/FlaNium.Driver.exe";
		String APP_PATH = "C:\\Users\\kalim\\IdeaProjects\\selenium-demo\\src\\main\\resources\\ListBoxer.exe";
		int driverPort = 7885;

		FlaNiumDriverService service = new FlaNiumDriverService.Builder()
				.usingDriverExecutable(new File(DRIVER_PATH).getAbsoluteFile())
				.usingPort(driverPort)
				.withVerbose(true)
				.withSilent(false)
				.build();

		DesktopOptions options = new DesktopOptions()
				.setApplicationPath(APP_PATH)
				.setConnectToRunningApp(true);


		FlaNiumDriver driver = new FlaNiumDriver(service, options);
		List<WebElement> elements = driver.findElements(By.xpath("//*"));

		elements.stream().filter(w -> w.getTagName().equals("Edit"))
				.findFirst().get().sendKeys("HELLO!!!");
		TimeUnit.SECONDS.sleep(2);

		elements.stream().filter(w -> w.getTagName().equals("Button")).toList().get(2).click();
		TimeUnit.SECONDS.sleep(2);
		elements.stream().filter(w -> w.getTagName().equals("Button")).toList().get(0).sendKeys("All");


		TimeUnit.SECONDS.sleep(20);
	}
}

