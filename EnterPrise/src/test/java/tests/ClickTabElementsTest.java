package tests;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.*;
import java.time.Duration;

public class ClickTabElementsTest {
    public static WebDriver cdriver;
    static SoftAssert softAssert;
    static WebDriverWait wait;
    static JavascriptExecutor jsx;
    static CampaignsPage campaignsPage;
    static FleetPage fleetPage;
    static HomePage homePage;
    static InvestorRelationsPage investorRelationsPage;
    static OfficesPage officesPage;
    static RezervationPage rezervationPage;
    static HomeButtons homeButtons;

    int millis = 1500;

    @BeforeClass
    public static void setUp()  {

        String headlessMode = System.getProperty("headlessMode");
        System.out.println(System.getProperty("parallelSuite"));
        System.out.println(System.getProperty("testClasses"));
        System.out.println("Headless mode key value: " + headlessMode);
        ChromeOptions options = new ChromeOptions();
        
        if ("headless".equals(headlessMode)) {
            options.addArguments("--headless");
            options.addArguments("--window-size=1920,1080");
            System.out.println("Headless mode open");
        } else {
            System.out.println("Windowed mode open");
        }

        cdriver = new ChromeDriver(options);
        softAssert = new SoftAssert();
        jsx = (JavascriptExecutor) cdriver;
        wait = new WebDriverWait(cdriver, Duration.ofSeconds(25));
        cdriver.manage().window().maximize();
        cdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        cdriver.get("https://www.enterprise.com.tr/");
        homePage = new HomePage(cdriver);
        rezervationPage = new RezervationPage(cdriver);
        campaignsPage = new CampaignsPage(cdriver);
        officesPage = new OfficesPage(cdriver);
        fleetPage = new FleetPage(cdriver);
        investorRelationsPage = new InvestorRelationsPage(cdriver);
        homeButtons = new HomeButtons(cdriver);
    }

    @AfterClass
    public static void tearDown() {
        if (cdriver != null) {
            cdriver.quit();
        }
    }

    @Test(priority = 1)
    public void setRezervationPage() throws InterruptedException {
        homeButtons.clickCookies();
        Thread.sleep(millis);

        try {
            Assert.assertEquals(homeButtons.alertMessage(),"Bizden anında bildirim gelmesini ister misiniz?");
            homeButtons.acceptNotification();
            Thread.sleep(millis);
        }catch (TimeoutException e){
            System.out.println("Alert mesajına ulaşılmadı");
        }
        homePage.clickRezervation();
        Thread.sleep(millis);

        Assert.assertEquals(rezervationPage.getRezervationHeaderText(), "Rezervasyon");
        Thread.sleep(millis);
    }

    @Test(priority = 2)
    public void setCampaignsPage() throws InterruptedException {
        homePage.clickCampaigns();
        Thread.sleep(millis);

        Assert.assertEquals(campaignsPage.getCampaignsHeaderText(), "Enterprise");
        Thread.sleep(millis);
    }

    @Test(priority = 3)
    public void setOfficesPage() throws InterruptedException {
        homePage.clickOffices();
        Thread.sleep(millis);

        Assert.assertEquals(officesPage.getOfficesHeaderText(), "Tüm Lokasyonlar");
        Thread.sleep(millis);
    }

    @Test(priority = 4)
    public void setFleetPage() throws InterruptedException {
        homePage.clickFleet();
        Thread.sleep(millis);

        Assert.assertEquals(fleetPage.getFleetHeaderText(), "Tüm Filomuz");
        Thread.sleep(millis);
    }

    @Test(priority = 5)
    public void setInvestorRelationsPage() throws InterruptedException {
        homePage.clickInvestorRelations();
        Thread.sleep(millis);

        Assert.assertEquals(investorRelationsPage.getInvestorHeaderText(), "Halka Arz");
        Thread.sleep(millis);
    }
}
