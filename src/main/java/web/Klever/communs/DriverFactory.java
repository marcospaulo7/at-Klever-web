package web.Klever.communs;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class DriverFactory {


    private static DriverFactory instance = null;
    private WebDriver currentDriver = null;

    public static DriverFactory getInstance() {
        if (instance == null) {
            instance = new DriverFactory();
        }
        return instance;
    }


    public WebDriver getCurrentDriver() {
        if (currentDriver == null) {
            throw new IllegalStateException("Não foi possivel encontrar o navegador atual, verifique se o mesmo foi inicializado");
        } else {
            currentDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            return currentDriver;
        }
    }


    public void setCurrentDriver(DriverManagerType driverManagerType) {
        WebDriverManager.getInstance(driverManagerType).setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-gpu");
        try {
            if (driverManagerType == DriverManagerType.CHROME) {
                currentDriver = new ChromeDriver(options);
            } else {
                Class<?> browserClass = Class.forName(driverManagerType.browserClass());
                currentDriver = (WebDriver) browserClass.newInstance();
            }
            currentDriver.manage().window().maximize();
        } catch (Exception e) {
            throw new IllegalStateException("Houve um erro ao tentar inicializar o navegador: " + e.getMessage());
        }
    }

    public void closeDriver() {
        if (currentDriver != null) {
            currentDriver.quit();
            currentDriver = null;
        }
    }
}
