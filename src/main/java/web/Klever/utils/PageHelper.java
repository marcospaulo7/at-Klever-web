package web.Klever.utils;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import web.Klever.communs.DriverFactory;

import java.time.Duration;

@Log4j2
public class PageHelper {


    private PageHelper() {
        throw new IllegalStateException("Classe de utilidade para manipulação de paginas, não é necessario criar uma instancia");
    }


    public static WebElement elementIsVisible(WebElement element, String description) {
        try {
            log.info("Localizando elemento: " + description);
            getWait(1).until(ExpectedConditions.visibilityOf(element));
            log.info("Elemento:: " + description + " encontrado.");
            return element;
        } catch (Exception e) {
            log.warn("nao foi possivel localizar o elemento" + description);
            log.warn("Retornado o seguinte erro:" + e.getMessage());
            throw new ElementNotVisibleException(e.getMessage());
        }
    }


    public static Wait<WebDriver> getWait() {
        Wait<WebDriver> wait;
        wait = new FluentWait<>(DriverFactory.getInstance().getCurrentDriver())
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(3))
                .ignoring(ElementClickInterceptedException.class)
                .ignoring(ElementNotVisibleException.class)
                .ignoring(ElementNotInteractableException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class)
                .ignoring(InvalidElementStateException.class)
                .ignoring(ElementNotSelectableException.class);
        return wait;
    }

    public static Wait<WebDriver> getWait(int seconds) {
        Wait<WebDriver> wait;
        wait = new FluentWait<>(DriverFactory.getInstance().getCurrentDriver())
                .withTimeout(Duration.ofSeconds(seconds))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementNotVisibleException.class)
                .ignoring(ElementNotInteractableException.class)
                .ignoring(ElementClickInterceptedException.class);
        return wait;
    }

    public static void waitVisibilityText(String containsText, String description, int time) {
        try {
            log.info("localizando o seguinte texto: " + description);
            WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getCurrentDriver(), time);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'" + containsText + "')]")));
            log.info("encontrado o texto: " + description + ".");

        } catch (Exception e) {
            log.info("Nao foi possivel localizar o elemento" + description);
            log.info("Retornado o seguinte erro:" + e.getMessage());
            throw new ElementNotVisibleException(e.getMessage());
        }
    }

    private static void clearElement(WebElement element, String description) {
        try {
            element.clear();
        } catch (Exception ignore) {
            log.info("Nao foi possivel localizar/limpar o elemento" + description);
            log.info("Retornado o seguinte erro:" + ignore.getMessage());
            throw new ElementNotVisibleException(ignore.getMessage());
        }
    }

    public static void moveBarElement(WebElement element, Keys key, int quantityMove) {
        try {
            Actions action = new Actions(DriverFactory.getInstance().getCurrentDriver());
            Thread.sleep(1000);
            action.click(element).build().perform();
            for (int i = 0; i < quantityMove; i++) {
                Thread.sleep(200);
                action.sendKeys(key).build().perform();
            }
        } catch (Exception ignore) {
            log.info("Nao foi possivel a barra do elemento");
            log.info("Retornado o seguinte erro:" + ignore.getMessage());
            throw new ElementNotVisibleException(ignore.getMessage());
        }

    }
}