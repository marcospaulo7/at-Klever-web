package web.Klever.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class MarketPage {

    @FindBy(xpath = "//div[@class='klever-header']")
    private WebElement kleverHeader;

    @FindBy(xpath = "//input[@class='ant-input']")
    private WebElement pairSearchField;

    private String pairHeadText = "//thead[@class='ant-table-thead']//descendant::span[contains(.,'Pairs')]";
    private String pairsRows = "//tbody[@class='ant-table-tbody']/tr";

    public MarketPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}
