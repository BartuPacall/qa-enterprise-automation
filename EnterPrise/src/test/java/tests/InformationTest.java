package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.*;
import utils.DataBaseUtils;

import java.time.Duration;

public class InformationTest {
    public static WebDriver cdriver;
    static SoftAssert softAssert;
    static WebDriverWait wait;
    static JavascriptExecutor jsx;
    static HomePage homePage;
    static InformationPage informationPage;
    static HomeButtons homeButtons;
    int millis = 2000;

    // Veritabanından alınan veriler
    private String name;
    private String surname;

    @BeforeClass
    public void setUp() {
        // Veritabanından rasgele verileri al
        String[] nameAndSurname = DataBaseUtils.getRandomNameAndSurname();
        if (nameAndSurname != null) {
            name = nameAndSurname[0];
            surname = nameAndSurname[1];
        }

        
        
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
        informationPage = new InformationPage(cdriver);
        homeButtons = new HomeButtons(cdriver);
    }

    @AfterClass
    public void tearDown() {
        cdriver.quit();
    }

    @AfterMethod
    public void beforeAllTests() throws InterruptedException {
        cdriver.get("https://www.enterprise.com.tr");
        Thread.sleep(millis);
    }

    @Test(priority = 1)
    public void setInformationPage() throws InterruptedException {
        homeButtons.clickCookies();
        Thread.sleep(millis);

        try {
            Assert.assertEquals(homeButtons.alertMessage(),"Bizden anında bildirim gelmesini ister misiniz?");
            homeButtons.acceptNotification();
            Thread.sleep(millis);
        }catch (TimeoutException e){
            System.out.println("Alert mesajına ulaşılmadı");
        }
        homePage.clickInformation();
        Thread.sleep(millis);

        informationPage.clickContact();
        Thread.sleep(millis);

        jsx.executeScript("window.scrollBy(20,300)");
        Assert.assertEquals(informationPage.getInformationHeaderText(), "İletişim");
        Thread.sleep(millis);

        // Veritabanından alınan rasgele verileri kullan
        informationPage.fillName(name);
        Thread.sleep(millis);

        informationPage.fillSurname(surname);
        Thread.sleep(millis);

        informationPage.fillEmail("deneme@hotmail.com");
        Thread.sleep(millis);

        informationPage.fillConfirmEmail("deneme@hotmail.com");
        Thread.sleep(millis);

        informationPage.dropdownIdentityInfo("10000000146");
        Thread.sleep(millis);

        informationPage.phoneNumber("5444444444");
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

    @Test(priority = 2)
    public void blankErrInformationPage() throws InterruptedException {
        Thread.sleep(millis);
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

        Assert.assertEquals(informationPage.nameBlankError(), "Bu alan boş bırakılamaz.");
        informationPage.fillName(name); // Rasgele veri
        Thread.sleep(millis);

        Assert.assertEquals(informationPage.surnameBlankError(), "Bu alan boş bırakılamaz.");
        informationPage.fillSurname(surname); // Rasgele veri
        Thread.sleep(millis);

        Assert.assertEquals(informationPage.emailBlankError(), "Bu alan boş bırakılamaz.");
        informationPage.fillEmail("deneme@hotmail.com");
        Thread.sleep(millis);

        Assert.assertEquals(informationPage.emailConfirmBlankError(), "Bu alan boş bırakılamaz.");
        informationPage.fillConfirmEmail("deneme@hotmail.com");
        Thread.sleep(millis);

        jsx.executeScript("window.scrollBy(20,400)");
        Assert.assertEquals(informationPage.identityBlankError(), "Bu alan boş bırakılamaz.");
        informationPage.dropdownIdentityInfo("123");
        Thread.sleep(millis);

        informationPage.sendButton();
        jsx.executeScript("window.scrollBy(20,-300)");

        Assert.assertEquals(informationPage.identityLengthError(), "TCKN No alanı 11 karakter uzunluğunda olmalıdır.");
        informationPage.dropdownIdentityInfoClear();

        informationPage.dropdownIdentityInfo("11111111111");
        Thread.sleep(millis);

        informationPage.sendButton();
        jsx.executeScript("window.scrollBy(20,-300)");

        Assert.assertEquals(informationPage.identityError(), "TCKN hatalı. Lütfen girilen değeri kontrol ediniz.");
        informationPage.dropdownIdentityInfoClear();

        informationPage.dropdownIdentityInfo("10000000146");
        Thread.sleep(millis);

        Assert.assertEquals(informationPage.phoneBlankError(), "Bu alan boş bırakılamaz.");
        informationPage.phoneNumber("5444444444");
        Thread.sleep(millis);

        informationPage.dropDownOffice();
        Thread.sleep(millis);

        jsx.executeScript("window.scrollBy(20,600)");
        informationPage.dontHaveRezervationContactRadioButton();
        Thread.sleep(millis);

        informationPage.topic();
        Thread.sleep(millis);

        Assert.assertEquals(informationPage.messageBoxBlankError(), "Bu alan boş bırakılamaz.");
        informationPage.messageBox("Site çok karışık yapılmış tekrar yapın lütfen !!!");
        Thread.sleep(millis);

        Assert.assertEquals(informationPage.clientCheckBoxBlankError(), "Bu alan boş bırakılamaz.");
        informationPage.clickClientCheckBox();
        Thread.sleep(millis);

        Assert.assertEquals(informationPage.privacyCheckBoxBlankError(), "Bu alan boş bırakılamaz.");
        informationPage.clickPrivacyCheckBox();
        Thread.sleep(millis);

        Assert.assertEquals(informationPage.electronixMessageblankError(), "Bu alan boş bırakılamaz.");
        informationPage.clickElectronixCheckBox();
        Thread.sleep(millis);

        informationPage.completeRecaptcha();
        Thread.sleep(millis);
    }
}
