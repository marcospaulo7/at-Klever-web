package web.Klever.steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.WebDriver;
import web.Klever.communs.DriverFactory;
import web.Klever.func.HomeFunc;
import web.Klever.func.NFTFunc;

import static org.hamcrest.CoreMatchers.*;

public class NFTStep {

    HomeFunc homeFunc;
    NFTFunc nftFunc;
    WebDriver driver;

    String onSaleValueInitial;

    public NFTStep() {
        driver = DriverFactory.getInstance().getCurrentDriver();
        homeFunc = new HomeFunc();
        nftFunc = new NFTFunc();
    }

    @Dado("que esteja na aba de NFTs")
    public void queEstejaNaAbaDeNFTs() throws InterruptedException {
        homeFunc.accessNfttab();
        nftFunc.verifyNftTitlePage();
        onSaleValueInitial = nftFunc.getOnsaleValue();
        MatcherAssert.assertThat(driver.getCurrentUrl(), containsString("klever.io/nft"));
    }

    @Quando("filtrar a busca por {string}")
    public void filtrarABuscaPor(String arg0) {
        nftFunc.clickFilterButton();
        nftFunc.clickAgilityAffinityFilter();

    }

    @E("filtrar por {string}")
    public void filtrarPor(String arg0) {
        nftFunc.clickAgilityattributeFilter();
        nftFunc.clickApplyFiltersButton();
    }

    @Entao("deve ser retornado em tela os NFTs filtrados")
    public void deveSerRetornadoEmTelaOsNFTsFiltrados() throws InterruptedException {
        MatcherAssert.assertThat(onSaleValueInitial, not(equalTo(nftFunc.getOnsaleValue())));
    }
}
