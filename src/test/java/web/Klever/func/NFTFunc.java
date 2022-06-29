package web.Klever.func;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import web.Klever.communs.DriverFactory;
import web.Klever.pages.NftPage;
import web.Klever.utils.PageHelper;

public class NFTFunc {
    WebDriver driver;
    NftPage nftPage;


    public NFTFunc() {
        this.driver = DriverFactory.getInstance().getCurrentDriver();
        nftPage = new NftPage(driver);
    }

    public void verifyNftTitlePage() {
        PageHelper.getWait().until(ExpectedConditions.titleContains("Klever NFT"));
        MatcherAssert.assertThat(driver.getTitle(), CoreMatchers.containsString("Klever NFT"));
    }

    public void clickFilterButton() {
        PageHelper.elementIsVisible(nftPage.getFilterButton(), "Button Filter").click();
    }

    public void clickAgilityAffinityFilter() {
        PageHelper.elementIsVisible(nftPage.getAgilityAffinityOption(), "Agility Affinity option").click();
        PageHelper.moveBarElement(nftPage.getAgilityAffinityBarLevel(), Keys.ARROW_RIGHT, 5);


    }

    public void clickAgilityattributeFilter() {


        PageHelper.elementIsVisible(nftPage.getAgilityAttributeOption(), "Agility Attribute option").click();
        PageHelper.moveBarElement(nftPage.getAgilityAttributeBarLevel(), Keys.ARROW_RIGHT, 5);


    }

    public void clickApplyFiltersButton() {
        PageHelper.elementIsVisible(nftPage.getApplybutton(), "Apply button").click();
    }

    public String getOnsaleValue() throws InterruptedException {
        Thread.sleep(3000);
        String onSaleCurrent = PageHelper.elementIsVisible(nftPage.getOnSaleValue(), "On save value list").getText();
        return onSaleCurrent;
    }
}
