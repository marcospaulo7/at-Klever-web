package web.Klever.steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import web.Klever.communs.DriverFactory;
import web.Klever.func.HomeFunc;
import web.Klever.func.MarketFunc;

public class MarketStep {

    HomeFunc homeFunc;
    MarketFunc marketFunc;
    WebDriver driver;

    public MarketStep() {
        homeFunc = new HomeFunc();
        marketFunc = new MarketFunc();
        driver = DriverFactory.getInstance().getCurrentDriver();
    }

    @Dado("que esteja na aba Markets da Klever")
    public void queEstejaNaAbaMarketsDaKlever() {
        homeFunc.accessMarketTab();
        marketFunc.verifyNftTitlePage();
        Assert.assertEquals(driver.getCurrentUrl(), "https://klever.io/markets");
    }

    @Quando("informar uma {string} no campo de busca")
    public void informarUmaNoCampoDeBusca(String pair) throws InterruptedException {
        marketFunc.searchForPair(pair);
    }

    @Entao("deve ser retornado em tela as informaçoes dessa {string}")
    public void deveSerRetornadoEmTelaAsInformaçoesDessaPair(String pair) throws Exception {
        MatcherAssert.assertThat(marketFunc.researchedPair(pair), CoreMatchers.containsString(pair));
    }
}