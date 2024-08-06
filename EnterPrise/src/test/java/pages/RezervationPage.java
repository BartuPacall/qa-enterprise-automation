package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RezervationPage extends BasePage{
    private final By rezervationHeader = By.xpath("//h6[normalize-space()='Rezervasyon']");

    public RezervationPage(WebDriver driver) {
        super(driver);
    }

    public String getRezervationHeaderText() {
        return getElementText(rezervationHeader);
    }

}
