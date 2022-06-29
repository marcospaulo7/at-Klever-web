package web.Klever.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class HomePage {


    @FindBy(xpath = "//a[@href='/markets']")
    private WebElement marketsLinkButton;

    @FindBy(xpath = "//a[@href='/nft']")
    private WebElement NFTLinkButton;


    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


}
