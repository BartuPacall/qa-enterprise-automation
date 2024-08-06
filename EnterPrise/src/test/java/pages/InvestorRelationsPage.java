package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InvestorRelationsPage extends BasePage {
    private final By investorHeader = By.xpath("//h1[normalize-space()='Halka Arz']");

    public InvestorRelationsPage(WebDriver driver) {
        super(driver);
    }

    public String getInvestorHeaderText() {
        return getElementText(investorHeader);
    }

}
