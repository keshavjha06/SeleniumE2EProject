package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class base {

	public  static WebDriver driver;
	public Properties prop;

	public WebDriver initializeDriver() throws IOException {

		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\data.properties");

		prop.load(fis);
		// mvn test -Dbrowser=chrome
		//String browserName = System.getProperty("browser");
		 String browserName = prop.getProperty("browser");
		System.out.println(browserName);
		if (browserName.contains("chrome")) {

			// execute in chrome
			if (browserName.contains("headless")) {

				ChromeOptions options = new ChromeOptions();

				options.addArguments("headless");

				driver = new ChromeDriver(options);

			}

			else {

				driver = new ChromeDriver();

			}

		}

		else if (browserName.equals("firefox")) {
			driver = new FirefoxDriver();
			// firefox code
		} 
		else if (browserName.equals("IE")) {
			//	IE code
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;

	}

	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;

	}

}
