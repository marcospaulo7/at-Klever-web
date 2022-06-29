package web.Klever.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class MarketPage {


    @FindBy(xpath = "//input[@class='ant-input']")
    private WebElement pairSearchField;

    private final String pairsRows = "//tbody[@class='ant-table-tbody']/tr";

    public MarketPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}
