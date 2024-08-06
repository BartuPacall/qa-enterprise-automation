package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OfficesPage extends BasePage{
    private final By officesHeader = By.xpath("//a[normalize-space()='Tüm Lokasyonlar']");

    public OfficesPage(WebDriver driver) {
        super(driver);
    }

    public String getOfficesHeaderText() {
        return getElementText(officesHeader);
    }

}
