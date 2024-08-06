/*package tests;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pages.*;
import java.time.Duration;


public class EnterpriseTests {
    public static WebDriver cdriver;
    static SoftAssert softAssert;
    static WebDriverWait wait;
    static JavascriptExecutor jsx;
    static CampaignsPage campaignsPage;
    static FleetPage fleetPage;
    static HomePage homePage;
    static InformationPage informationPage;
    static InvestorRelationsPage investorRelationsPage;
    static OfficesPage officesPage;
    static RezervationPage rezervationPage;
    static SuitableCarPage suitableCarPage;

    int millis = 1500;

    @BeforeClass
    public static void setUp() throws InterruptedException {
        cdriver = new ChromeDriver();
        softAssert = new SoftAssert();
        jsx = (JavascriptExecutor) cdriver;
        wait = new WebDriverWait(cdriver, Duration.ofSeconds(8));
        cdriver.manage().window().maximize();
        cdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        cdriver.get("https://www.enterprise.com.tr/");
        homePage = new HomePage(cdriver);
        suitableCarPage = new SuitableCarPage(cdriver);
        rezervationPage = new RezervationPage(cdriver);
        campaignsPage = new CampaignsPage(cdriver);
        officesPage = new OfficesPage(cdriver);
        fleetPage = new FleetPage(cdriver);
        informationPage = new InformationPage(cdriver);
        investorRelationsPage = new InvestorRelationsPage(cdriver);
        Thread.sleep(2000);
        homePage.acceptAllCookies();
        Thread.sleep(4000);
        homePage.rejectFeedBack();
        Thread.sleep(2000);

    }


    @AfterClass
    public static void tearDown() {
        cdriver.quit();
    }

    @AfterMethod
    public void beforeAllTests() throws InterruptedException {
        cdriver.get("https://www.enterprise.com.tr");
        Thread.sleep(millis);
    }


    @Test (priority = 1)
    public void selectSuitableCar() throws InterruptedException {
        suitableCarPage.selectDropdownCity("Çanakkale Merkez");
        Thread.sleep(millis);

        suitableCarPage.selectPurchaseDate();
        Thread.sleep(millis);

        suitableCarPage.selectPurchaseTime("13:30");
        Thread.sleep(millis);

        suitableCarPage.selectReturnDate();
        Thread.sleep(millis);

        suitableCarPage.selectReturnTime("15:15");
        Thread.sleep(millis);

        suitableCarPage.selectAge(22);
        Thread.sleep(millis);

        suitableCarPage.leaveDifPlaces("Bursa FSM Ofis");
        Thread.sleep(millis);

        suitableCarPage.usePromotion("Garanti BBVA Çalışanları");
        Thread.sleep(millis);

        suitableCarPage.clickSuitableCarButton();
        Thread.sleep(millis);


        suitableCarPage.selectEconomicFilter();
        Thread.sleep(millis);

        suitableCarPage.selectGasolineFilter();
        Thread.sleep(millis);

        suitableCarPage.selectManuelFilter();
        Thread.sleep(millis);

        Assert.assertTrue(suitableCarPage.verifyCarClass("Ekonomik"), "Not all visible cars are of class Ekonomik");
        Assert.assertTrue(suitableCarPage.verifyCarFuelType("Benzinli"), "Not all visible cars are of fuel type Benzinli");
        Assert.assertTrue(suitableCarPage.verifyCarTransmission("Manuel"), "Not all visible cars are of transmission type Manuel");

    }

    @Test(priority = 2)
    public void selectSuitableError() throws InterruptedException {
        suitableCarPage.selectDropdownCity("Şanlıurfa Havalimanı (GNY)");
        Thread.sleep(millis);

        suitableCarPage.selectPurchaseDate();
        Thread.sleep(millis);

        suitableCarPage.selectPurchaseTime("22:30");
        Thread.sleep(millis);

        suitableCarPage.selectReturnDate();
        Thread.sleep(millis);

        suitableCarPage.selectReturnTime("19:00");
        Thread.sleep(millis);

        suitableCarPage.selectAge(22);
        Thread.sleep(millis);

        suitableCarPage.leaveDifPlaces("Bursa FSM Ofis");
        Thread.sleep(millis);

        suitableCarPage.usePromotion("Garanti BBVA Çalışanları");
        Thread.sleep(millis);

        suitableCarPage.clickSuitableCarButton();
        Thread.sleep(millis);

        Assert.assertEquals(suitableCarPage.selectErrorHeader(),"Uyarı");
        Thread.sleep(millis);

        suitableCarPage.closeErr();
        Thread.sleep(millis);
        suitableCarPage.clickPlace();
        selectSuitableCar();
    }
    @Test(priority = 3)
    public void selectSuitablePromotionErr() throws InterruptedException {
        suitableCarPage.selectDropdownCity("Şanlıurfa Havalimanı (GNY)");
        Thread.sleep(millis);

        suitableCarPage.selectPurchaseDate();
        Thread.sleep(millis);

        suitableCarPage.selectPurchaseTime("22:30");
        Thread.sleep(millis);

        suitableCarPage.selectReturnDate();
        Thread.sleep(millis);

        suitableCarPage.selectReturnTime("15:15");
        Thread.sleep(millis);

        suitableCarPage.selectAge(22);
        Thread.sleep(millis);

        suitableCarPage.leaveDifPlaces("Bursa FSM Ofis");
        Thread.sleep(millis);

        suitableCarPage.usePromotionCode("Zubizu", "11111111111111");
        Thread.sleep(millis);

        suitableCarPage.clickSuitableCarButton();
        Thread.sleep(millis);

        Assert.assertEquals(suitableCarPage.selectErrorHeader(),"Uyarı");
        suitableCarPage.closeErr();
        Thread.sleep(millis);
    }


    @Test(priority = 4)
    public void setRezervationPage() throws InterruptedException {
        homePage.clickRezervation();
        Thread.sleep(millis);

        Assert.assertEquals(rezervationPage.getRezervationHeaderText(),"Rezervasyon");
        Thread.sleep(millis);
    }

    @Test(priority = 5)
    public void setCampaignsPage() throws InterruptedException {
        homePage.clickCampaigns();
        Thread.sleep(millis);

        Assert.assertEquals(campaignsPage.getCampaignsHeaderText(),"Enterprise");
        Thread.sleep(millis);
    }

    @Test(priority = 6)
    public void setOfficesPage() throws InterruptedException {
        homePage.clickOffices();
        Thread.sleep(millis);

        Assert.assertEquals(officesPage.getOfficesHeaderText(),"Tüm Lokasyonlar");
        Thread.sleep(millis);
    }

    @Test(priority = 7)
    public void setFleetPage() throws InterruptedException {
        homePage.clickFleet();
        Thread.sleep(millis);

        Assert.assertEquals(fleetPage.getFleetHeaderText(),"Tüm Filomuz");
        Thread.sleep(millis);
    }

    @Test(priority = 8)
    public void setInformationPage() throws InterruptedException {
        homePage.clickInformation();
        Thread.sleep(millis);

        informationPage.clickContact();
        Thread.sleep(millis);

        jsx.executeScript("window.scrollBy(20,300)");
        Assert.assertEquals(informationPage.getInformationHeaderText(),"İletişim");
        Thread.sleep(millis);

        informationPage.fillName("name");
        Thread.sleep(millis);

        informationPage.fillSurname("surname");
        Thread.sleep(millis);

        informationPage.fillEmail("deneme@hotmail.com");
        Thread.sleep(millis);

        informationPage.fillConfirmEmail("deneme@hotmail.com");
        Thread.sleep(millis);

        informationPage.dropdownIdentityInfo("28246371890");
        Thread.sleep(millis);

        informationPage.phoneNumber("5428357130");
        Thread.sleep(millis);

        informationPage.dropDownOffice();
        Thread.sleep(millis);

        jsx.executeScript("window.scrollBy(20,600)");
        informationPage.dontHaveRezervationContactRadioButton();
        Thread.sleep(millis);

        informationPage.topic();
        Thread.sleep(millis);

        informationPage.messageBox("Site çok karışık yapılmış tekrar yapın lütfen !!!");
        Thread.sleep(millis);

        informationPage.clickClientCheckBox();
        Thread.sleep(millis);

        informationPage.clickPrivacyCheckBox();
        Thread.sleep(millis);

        informationPage.clickElectronixCheckBox();
        Thread.sleep(millis);

        informationPage.completeRecaptcha();
        Thread.sleep(millis);

    }

    @Test(priority=9)
    public void blankErrInformationPage() throws InterruptedException {
        homePage.clickInformation();
        Thread.sleep(millis);

        informationPage.clickContact();
        Thread.sleep(millis);

        jsx.executeScript("window.scrollBy(20,900)");
        Thread.sleep(millis);

        informationPage.sendButton();
        Thread.sleep(millis);

        jsx.executeScript("window.scrollBy(20,-900)");
        Thread.sleep(millis);

        Assert.assertEquals(informationPage.nameBlankError(),"Bu alan boş bırakılamaz.");
        informationPage.fillName("name");
        Thread.sleep(millis);

        Assert.assertEquals(informationPage.surnameBlankError(),"Bu alan boş bırakılamaz.");
        informationPage.fillSurname("surname");
        Thread.sleep(millis);

        Assert.assertEquals(informationPage.emailBlankError(),"Bu alan boş bırakılamaz.");
        informationPage.fillEmail("deneme@hotmail.com");
        Thread.sleep(millis);

        Assert.assertEquals(informationPage.emailConfirmBlankError(),"Bu alan boş bırakılamaz.");
        informationPage.fillConfirmEmail("deneme@hotmail.com");
        Thread.sleep(millis);

        jsx.executeScript("window.scrollBy(20,400)");
        Assert.assertEquals(informationPage.identityBlankError(),"Bu alan boş bırakılamaz.");
        informationPage.dropdownIdentityInfo("123");
        Thread.sleep(millis);

        informationPage.sendButton();
        jsx.executeScript("window.scrollBy(20,-300)");

        Assert.assertEquals(informationPage.identityLengthError(),"TCKN No alanı 11 karakter uzunluğunda olmalıdır.");
        informationPage.dropdownIdentityInfoClear();

        informationPage.dropdownIdentityInfo("11111111111");
        Thread.sleep(millis);

        informationPage.sendButton();
        jsx.executeScript("window.scrollBy(20,-300)");

        Assert.assertEquals(informationPage.identityError(),"TCKN hatalı. Lütfen girilen değeri kontrol ediniz.");
        informationPage.dropdownIdentityInfoClear();

        informationPage.dropdownIdentityInfo("28246371890");
        Thread.sleep(millis);

        Assert.assertEquals(informationPage.phoneBlankError(),"Bu alan boş bırakılamaz.");
        informationPage.phoneNumber("5428357130");
        Thread.sleep(millis);

        informationPage.dropDownOffice();
        Thread.sleep(millis);

        jsx.executeScript("window.scrollBy(20,600)");
        informationPage.dontHaveRezervationContactRadioButton();
        Thread.sleep(millis);

        informationPage.topic();
        Thread.sleep(millis);

        Assert.assertEquals(informationPage.messageBoxBlankError(),"Bu alan boş bırakılamaz.");
        informationPage.messageBox("Site çok karışık yapılmış tekrar yapın lütfen !!!");
        Thread.sleep(millis);

        Assert.assertEquals(informationPage.clientCheckBoxBlankError(),"Bu alan boş bırakılamaz.");
        informationPage.clickClientCheckBox();
        Thread.sleep(millis);

        Assert.assertEquals(informationPage.privacyCheckBoxBlankError(),"Bu alan boş bırakılamaz.");
        informationPage.clickPrivacyCheckBox();
        Thread.sleep(millis);

        Assert.assertEquals(informationPage.electronixMessageblankError(),"Bu alan boş bırakılamaz.");
        informationPage.clickElectronixCheckBox();
        Thread.sleep(millis);

        informationPage.completeRecaptcha();
        Thread.sleep(millis);
    }


    @Test(priority = 10)
    public void setInvestorRelationsPage() throws InterruptedException {
        homePage.clickInvestorRelations();
        Thread.sleep(millis);

        Assert.assertEquals(investorRelationsPage.getInvestorHeaderText(), "Halka Arz");
        Thread.sleep(millis);
    }

}*/