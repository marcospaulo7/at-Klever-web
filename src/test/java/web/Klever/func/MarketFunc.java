package web.Klever.func;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import web.Klever.communs.DriverFactory;
import web.Klever.pages.MarketPage;
import web.Klever.utils.PageHelper;

import java.util.List;

public class MarketFunc {

    WebDriver driver;
    MarketPage marketPage;

    public MarketFunc() {
        driver = DriverFactory.getInstance().getCurrentDriver();
        marketPage = new MarketPage(driver);
    }

    public void searchForPair(String pair) throws InterruptedException {
        Thread.sleep(1000);
        PageHelper.elementIsVisible(marketPage.getPairSearchField(), pair).sendKeys(pair);

    }

    public String researchedPair(String pair) throws Exception {
        String pairTextFromElement = null;
        try {
            List<WebElement> pairsTable = driver.findElements(By.xpath(marketPage.getPairsRows()));
            for (WebElement pairsArray : pairsTable) {
                if (pairsArray.getText().contains(pair)) {
                    System.out.println("aqui esta" + pairsArray.getText());
                    pairTextFromElement = pairsArray.getText();
                }
            }
        } catch (Exception e) {
            throw new Exception("Ocorreu um erro ao validar a pair retornada" + e);

        }
        return pairTextFromElement;
    }

    public void verifyNftTitlePage() {
        PageHelper.getWait().until(ExpectedConditions.titleContains("Markets"));
        MatcherAssert.assertThat(driver.getTitle(), CoreMatchers.containsString("Markets"));
    }
}