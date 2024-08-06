package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomeButtons extends BasePage{
    private  final By cookies = By.xpath("(//a[@href='javascript:App.CookieBar.cookieClose();'])[2]");
    private final By alertMessage = By.xpath("//p[@class='dn-slide-message']");
    private final By acceptNotification = By.xpath("//div[@class='dn-slide-buttons horizontal']//button[@class='dn-slide-deny-btn'][contains(text(),'Hayır')]");
    public HomeButtons(WebDriver driver) {
        super(driver);
    }

    public void clickCookies(){
        clickElement(cookies);
    }
    public void acceptNotification(){
        clickElement(acceptNotification);
    }

    public String alertMessage(){
        return getElementText(alertMessage);
    }

}
