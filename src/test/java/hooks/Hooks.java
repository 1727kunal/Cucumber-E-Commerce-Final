package hooks;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import testbase.TestBase;

public class Hooks{

	@Before
	public void openBrowser() {
		TestBase.setUp();
	}

	@After
	public void closeBrowser(Scenario scenario) {
		if (scenario.isFailed()) {

			// Ensure folder exists
			File dir = new File("test-output/Screenshots");
			if (!dir.exists()) {
				dir.mkdirs();
			}

			String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

			String fileName = scenario.getName().replaceAll("[^a-zA-Z0-9]", "_");

			File dest = new File(dir, fileName + "_" + timeStamp + ".png");

			try {
				File src = ((TakesScreenshot) TestBase.getDriver()).getScreenshotAs(OutputType.FILE);

				Files.copy(src.toPath(), dest.toPath());

				byte[] screenshot = Files.readAllBytes(dest.toPath());
				scenario.attach(screenshot, "image/png", "Failure Screenshot");

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		TestBase.tearDown();
	}

}
