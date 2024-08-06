package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CampaignsPage extends BasePage{
    private final By campaignsHeader = By.xpath("//h6[normalize-space()='Enterprise']");

    public CampaignsPage(WebDriver driver) {
        super(driver);
    }

    public String getCampaignsHeaderText() {
        return getElementText(campaignsHeader);
    }

}
