package web.Klever.configuration;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import web.Klever.communs.DriverFactory;

import java.time.LocalDateTime;

import static web.Klever.utils.logUtils.printHour;
import static web.Klever.utils.logUtils.printTime;

@Log4j2
public class Hooks {
    private static LocalDateTime timeInit;

    @Before
    public void beforeTest(Scenario scenario) {
        DriverFactory.getInstance().setCurrentDriver(DriverManagerType.CHROME);
        log.info("----------------------------NEW SCENARIO----------------------------------");
        printHour("Inital Hour.......", LocalDateTime.now());
        log.info("Iniciando o cenário: " + scenario.getName());
        DriverFactory.getInstance().getCurrentDriver().get("https://klever.io/");
        log.info("Acessando a seguinte url:" + "https://klever.io/");

    }

    @After
    public void aftertTest(Scenario scenario) {
        log.info("Finalizando o cenário: " + scenario.getName() + " com o status: " + scenario.getStatus());
        timeInit = LocalDateTime.now();
        LocalDateTime timeFinal = LocalDateTime.now();
        printHour("Final Hour........", LocalDateTime.now());
        timeFinal = timeFinal.minusHours(timeInit.getHour()).minusMinutes(timeInit.getMinute()).minusSeconds(timeInit.getSecond());
        printTime("Time of execution.", timeFinal);
        DriverFactory.getInstance().getCurrentDriver().quit();
    }

    @AfterStep
    public void afterStep(Scenario scenario) throws Exception {
        try {
            byte[] screenshot = ((TakesScreenshot) DriverFactory.getInstance().getCurrentDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        } catch (Exception exception) {
            throw new Exception("Não foi possivel gerar evidencias desse step. Erro: " + exception);
        }
    }
}
