package web.Klever.func;

import web.Klever.communs.DriverFactory;
import web.Klever.pages.HomePage;
import web.Klever.utils.PageHelper;

public class HomeFunc {
    HomePage homePage;

    public HomeFunc() {
        homePage = new HomePage(DriverFactory.getInstance().getCurrentDriver());
    }

    public void accessMarketTab() {
        PageHelper.elementIsVisible(homePage.getMarketsLinkButton(), "market link button").click();
    }

    public void accessNfttab() throws InterruptedException {
        PageHelper.elementIsVisible(homePage.getNFTLinkButton(), "market link button").click();
   Thread.sleep(1000);
    }

}
