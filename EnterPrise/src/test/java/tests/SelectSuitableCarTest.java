package tests;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
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


import java.time.Duration;

public class SelectSuitableCarTest {
    public static WebDriver cdriver;
    static SoftAssert softAssert;
    static WebDriverWait wait;
    static JavascriptExecutor jsx;
    static HomePage homePage;
    static SuitableCarPage suitableCarPage;
    static HomeButtons homeButtons;

    int millis = 2500;

    @BeforeClass
    public static void setUp() {

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
        wait = new WebDriverWait(cdriver, Duration.ofSeconds(15));
        cdriver.manage().window().maximize();
        cdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        cdriver.get("https://www.enterprise.com.tr/");
        homePage = new HomePage(cdriver);
        suitableCarPage = new SuitableCarPage(cdriver);
        homeButtons = new HomeButtons(cdriver);
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


    @Test(priority = 1)
    public void selectSuitableCar() throws InterruptedException {
        homeButtons.clickCookies();

        try {
            Assert.assertEquals(homeButtons.alertMessage(),"Bizden anında bildirim gelmesini ister misiniz?");
            homeButtons.acceptNotification();
            Thread.sleep(millis);
        }catch (TimeoutException e){
            System.out.println("Alert mesajına ulaşılmadı");
        }

        suitableCarPage.selectDropdownCity("Bursa Merkez");
        Thread.sleep(millis);

        suitableCarPage.selectPurchaseDate();
        Thread.sleep(millis);

        suitableCarPage.selectPurchaseTime();
        Thread.sleep(millis);

        suitableCarPage.selectReturnDate();
        Thread.sleep(millis);

        suitableCarPage.selectReturnTime();
        Thread.sleep(millis);

        suitableCarPage.selectAge(25);
        Thread.sleep(millis);

        suitableCarPage.leaveDifPlaces("Ankara Merkez");
        Thread.sleep(millis);

        suitableCarPage.usePromotion("Garanti BBVA Çalışanları");
        Thread.sleep(millis);

        suitableCarPage.clickSuitableCarButton();
        Thread.sleep(millis);

        try {
            String fullMessage = suitableCarPage.locationError();

            String expectedFirstError = "Seçtiğiniz alış zamanı alış ofisinin çalışma saatleri dışında kalmaktadır.";

            // Tam mesajı bölerek ilk hata mesajını alın (noktadan sonraki boşluğa göre bölerek ilk kısmı alıyoruz)
            String actualFirstError = fullMessage.split("\\.\\s+")[0] + "."; // İlk kısmı alıp tekrar nokta ekliyoruz
            System.out.println(actualFirstError);

            Assert.assertEquals(actualFirstError, expectedFirstError);

            suitableCarPage.clickNearestLoc();
            Thread.sleep(millis);

            suitableCarPage.clickSuitableCarButton();
            Thread.sleep(millis);
        } catch (TimeoutException e) {
            System.out.println("Bekleme süresi doldu, pencere bulunamadı.");
        } catch (AssertionError e) {
            System.out.println("Farklı bir hata verdi. Devam ediyorum.");
        }


        try {
            Assert.assertEquals(suitableCarPage.availableCarError(),"Seçtiğiniz tarih ve ofiste müsait araç bulunmamaktadır. Lütfen başka bir ofis ya da tarih deneyiniz.");
            suitableCarPage.closeErr();
            Thread.sleep(millis);

            suitableCarPage.selectRandomDropdownCity();
            Thread.sleep(millis);

            suitableCarPage.clickSuitableCarButton();
            Thread.sleep(millis);

        }
        catch (TimeoutException e) {
            System.out.println("Bekleme süresi doldu, pencere bulunamadı.");
        }
        catch (AssertionError e){
            System.out.println("Farklı bir hata verdi. Devam ediyorum.");
        }


        try {
            Assert.assertEquals(suitableCarPage.locationError(),"Seçmiş olduğunuz lokasyonda bu tarihlerde herhangi bir araç bulunmamaktadır. Farklı kriterlerle arama yaparak işleminize devam edebilirsiniz.");
            suitableCarPage.closeErr();
            Thread.sleep(millis);

            suitableCarPage.selectRandomDropdownCity();
            Thread.sleep(millis);

            suitableCarPage.clickSuitableCarButton();
            Thread.sleep(millis);
        }
        catch (AssertionError e){
            System.out.println("Farklı bir hata verdi. Devam ediyorum.");
        }
        catch (TimeoutException e) {
            System.out.println("Bekleme süresi doldu, pencere bulunamadı.");
        }

        suitableCarPage.carTypeFilter();
        Thread.sleep(millis);

        suitableCarPage.fuelTypeFilter();
        Thread.sleep(millis);

        suitableCarPage.gearTypeFilter();
        Thread.sleep(millis);


        Assert.assertTrue(suitableCarPage.verifyCarClass(suitableCarPage.carTypeText()), "Görüntülenen tüm arabalar uygun tür değil.");
        Assert.assertTrue(suitableCarPage.verifyCarFuelType(suitableCarPage.fuelTypeText()), "Görüntülenen tüm arabalar uygun yakıt değil.");
        Assert.assertTrue(suitableCarPage.verifyCarTransmission(suitableCarPage.gearTypeText()), "Görüntülenen tüm arabalar uygun şanzıman değil.");

    }


    @Test(priority = 2)
    public void selectSuitablePromotionErr() throws InterruptedException {
        suitableCarPage.selectDropdownCity("Ankara Merkez");
        Thread.sleep(millis);

        suitableCarPage.selectPurchaseDate();
        Thread.sleep(millis);

        suitableCarPage.selectPurchaseTime();
        Thread.sleep(millis);

        suitableCarPage.selectReturnDate();
        Thread.sleep(millis);

        suitableCarPage.selectReturnTime();
        Thread.sleep(millis);

        suitableCarPage.selectAge(22);
        Thread.sleep(millis);

        suitableCarPage.leaveDifPlaces("Bursa FSM Ofis");
        Thread.sleep(millis);

        suitableCarPage.usePromotionCode("Zubizu", "1222211111111111111111111111");
        Thread.sleep(millis);

        suitableCarPage.clickSuitableCarButton();
        Thread.sleep(millis);

        try {
            Assert.assertEquals(suitableCarPage.selectErrorHeader(), "Promosyon bulunamadı.");
            Thread.sleep(millis);
            suitableCarPage.closeErr();
            Thread.sleep(millis);
        }catch (TimeoutException e) {
            System.out.println("Bekleme süresi doldu, pencere bulunamadı.");
        }
    }

}
