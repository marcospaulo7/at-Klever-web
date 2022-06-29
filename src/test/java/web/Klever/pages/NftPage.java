package web.Klever.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class NftPage {


    @FindBy(xpath = "//button[@class='ant-btn ant-btn-text klever-btn-filter']/span")
    private WebElement filterButton;

    @FindBy(xpath = "//div[@class='ant-modal-body']/descendant::span[text()='Agility Affinity']")
    private WebElement agilityAffinityOption;

    //clicar no meio
    @FindBy(xpath = "//div[@class='ant-modal-body']/descendant::div[@class='ant-slider-rail'][1]")
    private WebElement agilityAffinityBarLevel;


    @FindBy(xpath = "//div[@class='ant-modal-body']/descendant::span[text()='Agility Attribute']")
    private WebElement agilityAttributeOption;

    //clicar no meio
    @FindBy(xpath = "//div[@class='ant-modal-body']/descendant::div[@class='ant-slider-rail'][2]")
    private WebElement agilityAttributeBarLevel;


    @FindBy(xpath = "//div[@class='klever-properties-buttons']/button/span[text()='Apply']")
    private WebElement Applybutton;

    @FindBy(xpath = "//div[@role='tab']")
    private WebElement onSaleValue;


    public NftPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


}
