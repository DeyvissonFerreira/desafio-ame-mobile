package setup;

import java.net.URL;
import java.util.Enumeration;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;

public class Capabilities {
	private static ThreadLocal<MobileDriver<?>> driver = new ThreadLocal<MobileDriver<?>>();
	protected static ThreadLocal<String> udidCheck = new ThreadLocal<String>();
	private static WebDriverWait wait;
	public static Properties PROPS = new LeitorProperties("config.properties").getProperties();

	/**
	 * Metodo para retornar o driver conforme o browser informado na suite
	 * @param platform
	 */
	@BeforeClass()
	@Parameters({ "platforma", "local", "udid", "systemPort"})
	protected void defineBrowser(String platforma, boolean local, @Optional String udid, @Optional String systemPort) {
		try {
		DesiredCapabilities cap = new DesiredCapabilities();
		if (driver.get() == null) {
			switch (platforma) {
			case "Android":
				cap.setCapability("systemPort", systemPort);	
				if (udid.contains("emulator")) {
					cap.setCapability("deviceName", "Android Emulator");
				}
				break;
			case "IOS":
				cap.setCapability("wdaLocalPort", systemPort);
				break;
			default:
				driver = null;
				break;
			}
		}
		
		if ((platforma.equalsIgnoreCase("Android") || platforma.equalsIgnoreCase("IOS"))) {
			Properties props = new LeitorProperties(platforma.toLowerCase() + "Device.properties").getProperties();
			for (Enumeration<?> elms = props.propertyNames(); elms.hasMoreElements();) {
				String prop = (String) elms.nextElement();
				cap.setCapability(prop, props.getProperty(prop));
			}
			udidCheck.set(udid);
			cap.setCapability("custom:sicoobDevice", udid);
			cap.setCapability("udid", udid);
			cap.setCapability("deviceName", udid);

			String url = local ? PROPS.getProperty("local.url.mobile") : PROPS.getProperty("node.url.web");
			driver.set(new AppiumDriver<MobileElement>(new URL(url), cap));
			
		} 

		wait = new WebDriverWait(driver.get(), 30);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Finalizar browser ao terminar teste de uma classe
	 */
	@AfterClass
	protected void finalizar() {
		driver.get().quit();
		driver.set(null);
	}

	/**
	 * Acessa a aplicacao
	 */
	public static void acessaAplicacao(String url) {
		driver.get().manage().window().maximize();
		driver.get().get(url);
	}

	/**
	 * @return the driver
	 */
	public static MobileDriver<?> getDriver() {
		return driver.get();
	}

	/**
	 * @return the wait
	 */
	public static WebDriverWait getWait() {
		return wait;
	}
}