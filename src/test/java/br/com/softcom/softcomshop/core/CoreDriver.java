package br.com.softcom.softcomshop.core;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.softcom.softcomshop.uteis.Propriedades;

//Classe que conter� os m�todos de inicializa��o e finaliza��o do WebDriver.
public class CoreDriver implements Constantes {

	private static WebDriver driver;

	Propriedades propriedades = new Propriedades();

	/* M�todo para inicializar o WebDriver: */

	public static WebDriver getDriver() throws MalformedURLException {

		// Caso o WebDriver n�o esteja iniciado, o driver ser� inicializado

		if (Propriedades.browser.equals("firefox")) {
			if (driver == null) {
				System.setProperty("webdriver.gecko.driver", "C:\\SeleniumDriver\\geckodriver.exe");

				// Set Firefox Headless mode as TRUE
				FirefoxOptions options = new FirefoxOptions();
				if (Propriedades.ocultar_browser) {
					options.setHeadless(true);
				}
				// Instantiate Web Driver
				driver = new FirefoxDriver(options);
			}
		} else if (Propriedades.browser.equals("chrome")) {
			if (driver == null) {
				System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDriver\\chromedriver.exe");

				// Set Chrome Headless mode as TRUE
				ChromeOptions options = new ChromeOptions();
				if (Propriedades.ocultar_browser) {
					options.setHeadless(true);
				}
				// Instantiate Web Driver
				driver = new ChromeDriver(options);
			}
		} else {
			if (driver == null) {
//				DesiredCapabilities cap = DesiredCapabilities.chrome();
//				driver = new RemoteWebDriver(new URL("http://10.0.0.20:4444/wd/hub"), cap);
				
				String AWS_URL = "";
				
				if (Propriedades.servidor == null) {
					AWS_URL = "http://localhost:4444/wd/hub";
				}else {
					AWS_URL = "http://" + Propriedades.servidor + ":4444/wd/hub";
				}
				
				ChromeOptions options = new ChromeOptions();
	            options.addArguments("start-maximized");
	            options.addArguments("--disable-infobars");
	            options.addArguments("--disable-extensions");
	            options.addArguments("chrome.switches", "--disable-extensions");
	            options.addArguments("--disable-gpu");
	            options.addArguments("--disable-dev-shm-usage");
	            options.addArguments("--no-sandbox");
	            options.addArguments("--disable-notifications");
	            options.addArguments("--disable-popup-blocking");
	            options.addArguments("enable-automation");
	            options.addArguments("--disable-dev-shm-usage");
	            options.addArguments("--disable-browser-side-navigation");
	            options.addArguments("--dns-prefetch-disable");
	            if (Propriedades.ocultar_browser) {
					options.setHeadless(true);
				}
	            driver = new RemoteWebDriver(new URL(AWS_URL), options);
			}
		}
		return driver;

	}

	/* M�todo para finalizar o WebDriver */

	public static void killDriver() {

		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}

	public void waitDriver(WebElement element, int milissegundos) throws MalformedURLException {
		WebDriverWait wait = new WebDriverWait(getDriver(), milissegundos);
		wait.until(ExpectedConditions.visibilityOfAllElements(element));
	}

	public void waitDriverInvisibility(WebElement element, int milissegundos) throws MalformedURLException {
		WebDriverWait wait = new WebDriverWait(getDriver(), milissegundos);
		wait.until(ExpectedConditions.invisibilityOfAllElements(element));
	}

	public void waitDriverVisibility(WebElement element, int milissegundos) throws MalformedURLException {
		WebDriverWait wait = new WebDriverWait(getDriver(), milissegundos);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitDriverClicavel(WebElement element, int milissegundos) throws MalformedURLException {
		WebDriverWait wait = new WebDriverWait(getDriver(), milissegundos);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waitDriverAll(WebElement element, int milissegundos) throws MalformedURLException {
		WebDriverWait wait = new WebDriverWait(getDriver(), milissegundos);
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

}
