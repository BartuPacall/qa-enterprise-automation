package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FleetPage extends BasePage{
    private final By fleetHeader = By.xpath("//div[@class='col-md-12 mb-2']//a[@class='link link-dark-color gtmheader'][normalize-space()='Tüm Filomuz']");

    public FleetPage(WebDriver driver) {
        super(driver);
    }

    public String getFleetHeaderText() {
        return getElementText(fleetHeader);
    }

}
