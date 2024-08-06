package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

import static tests.SelectSuitableCarTest.cdriver;

public class SuitableCarPage extends BasePage {
    // Promotions and places
    private final By dropdownPickupCityTable = By.xpath("//input[@id='searchDomesticWrap-input']");
    private final By promotionDropdown = By.xpath("//input[@id='promotionType-input']");
    private final By promotionTypeCode = By.xpath("//input[@id='promotionType-code']");
    private final By difPlaceDropdown = By.xpath("//input[@id='searchDomesticBackWrap-input']");
    private final By nearestLoc = By.xpath("//div[@id='swal2-content']//ul/li[1]/a");


    // Date picker
    private final By purchaseTimePicker = By.cssSelector("div[id='startDate'] span[placeholder='Saat']");
    private final By returnTimePicker = By.cssSelector("div[id='endDate'] span[placeholder='Saat']");
    private final By purchaseNext = By.xpath("//div[@id='startDatepicker']//a[@title='ileri>']");
    private final By returnNext = By.xpath("//div[@id='endDatepicker']//a[@title='ileri>']");

    // Buttons
    private final By ageButton = By.xpath("//input[@id='age']");
    private final By findSuitableCarButton = By.xpath("//button[@type='button']");


    // Check boxes
    private final By promotionCheckbox = By.xpath("//label[@for='searchPromotionCheckbox']");
    private final By leaveDifPlaceCheckBox = By.xpath("//label[@for='searchDomesticBackCheckbox']");

    // Filters
    private final By carTypeFilter = By.xpath("//h3[normalize-space()='ARAÇ SINIFI']//following::label[1]");
    private final By fuelTypeFilter = By.xpath("//h3[contains(text(),'YAKIT TİPİ')]//following::label[1]");
    private final By gearTypeFilter = By.xpath("//h3[contains(text(),'VİTES TİPİ')]//following::label[1]");
    
    // Errors
    private final By availableCarError = By.xpath("//div[@id='swal2-content']");
    private final By locationError = By.xpath("//div[@id='swal2-content']");
    private final By errorCloseButton = By.xpath("//button[normalize-space()='Kapat']");
    private final By selectErrorHeader = By.xpath("//div[@id='swal2-content']");
        private final By nearestLocError = By.xpath("//div[@id='swal2-content']//p[1]");

    public SuitableCarPage(WebDriver driver) {
        super(driver);
    }

    public void selectDropdownCity(String cCity) {
        clickElement(dropdownPickupCityTable);

        List<WebElement> cities = driver.findElements(By.xpath("//div[@class='search__component-form-group-result open animate']//li"));

        for (WebElement city : cities) {
            if (city.getText().equals(cCity)) {
                city.click();
                break;
            }
        }
    }

    public void selectRandomDropdownCity() throws InterruptedException {
        clickElement(dropdownPickupCityTable);

        List<WebElement> cities = driver.findElements(By.xpath("//div[@class='search__component-form-group-result open animate']//li"));

        if (!cities.isEmpty()) {
            Random rand = new Random();
            int randomIndex = rand.nextInt(cities.size());
            WebElement randomCity = cities.get(randomIndex);
            Thread.sleep(1500);
            wait.until(ExpectedConditions.elementToBeClickable(randomCity)).click();
        }
    }

    public void selectPurchaseDate()  {
        LocalDate today = LocalDate.now().plusDays(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MMMM-yyyy");
        String expectedDate = today.format(formatter);
        String emonth = expectedDate.split("-")[1];
        String eyear = expectedDate.split("-")[2];
        String edate = expectedDate.split("-")[0];
        System.out.println(emonth + "***" + eyear + "***" + edate);

        // Checking both sides of the date picker
        while (true) {
            String cmonthLeft = cdriver.findElement(By.xpath("(//span[contains(@class,'ui-datepicker-month')])[1]")).getText().trim();
            String cyearLeft = cdriver.findElement(By.xpath("(//span[contains(@class,'ui-datepicker-year')])[1]")).getText().trim();
            String cmonthRight = cdriver.findElement(By.xpath("(//span[contains(@class,'ui-datepicker-month')])[2]")).getText().trim();
            String cyearRight = cdriver.findElement(By.xpath("(//span[contains(@class,'ui-datepicker-year')])[2]")).getText().trim();

            if ((cmonthLeft.equals(emonth) && cyearLeft.equals(eyear)) || (cmonthRight.equals(emonth) && cyearRight.equals(eyear))) {
                break;
            }
            clickElement(purchaseNext);
        }

        List<WebElement> datesLeft = cdriver.findElements(By.xpath("(//table[contains(@class,'ui-datepicker-calendar')])[1]//a[contains(@class,'ui-state-default')]"));
        for (WebElement e : datesLeft) {
            if (e.getText().trim().equals(edate)) {
                e.click();
                return;
            }
        }

        List<WebElement> datesRight = cdriver.findElements(By.xpath("(//table[contains(@class,'ui-datepicker-calendar')])[2]//a[contains(@class,'ui-state-default')]"));
        for (WebElement e : datesRight) {
            if (e.getText().trim().equals(edate)) {
                e.click();
                return;
            }
        }
    }

    public void selectReturnDate()  {
        LocalDate today = LocalDate.now();
        LocalDate future = today.plusDays(5);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MMMM-yyyy");
        String expectedDate = future.format(formatter);
        System.out.println(expectedDate);
        String emonth = expectedDate.split("-")[1];
        String eyear = expectedDate.split("-")[2];
        String edate = expectedDate.split("-")[0];
        System.out.println(emonth + "***" + eyear + "***" + edate);

        while (true) {
            String cmonthLeft = cdriver.findElement(By.xpath("(//span[contains(@class,'ui-datepicker-month')])[3]")).getText().trim();
            String cyearLeft = cdriver.findElement(By.xpath("(//span[contains(@class,'ui-datepicker-year')])[3]")).getText().trim();
            String cmonthRight = cdriver.findElement(By.xpath("(//span[contains(@class,'ui-datepicker-month')])[4]")).getText().trim();
            String cyearRight = cdriver.findElement(By.xpath("(//span[contains(@class,'ui-datepicker-year')])[4]")).getText().trim();


            if ((cmonthLeft.equals(emonth) && cyearLeft.equals(eyear)) || (cmonthRight.equals(emonth) && cyearRight.equals(eyear))) {
                break;
            }
            clickElement(returnNext);
        }

        List<WebElement> datesLeft = cdriver.findElements(By.xpath("(//table[contains(@class,'ui-datepicker-calendar')])[3]//a[contains(@class,'ui-state-default')]"));
        for (WebElement e : datesLeft) {
            if (e.getText().trim().equals(edate)) {
                e.click();
                return;
            }
        }

        List<WebElement> datesRight = cdriver.findElements(By.xpath("(//table[contains(@class,'ui-datepicker-calendar')])[4]//a[contains(@class,'ui-state-default')]"));
        for (WebElement e : datesRight) {
            if (e.getText().trim().equals(edate)) {
                e.click();
                return;
            }
        }
    }

    public void selectPurchaseTime() {
        clickElement(purchaseTimePicker);

        List<WebElement> timeSlots = driver.findElements(By.xpath("//div[@id='startTimePicker']//li"));

        if (!timeSlots.isEmpty()) {
            Random rand = new Random();
            int randomIndex = rand.nextInt(timeSlots.size());
            timeSlots.get(randomIndex).click();
        }
    }

    public void selectReturnTime() {
        clickElement(returnTimePicker);

        List<WebElement> timeSlots = driver.findElements(By.xpath("//div[@id='endTimePicker']//li"));

        if (!timeSlots.isEmpty()) {
            Random rand = new Random();
            int randomIndex = rand.nextInt(timeSlots.size());
            timeSlots.get(randomIndex).click();
        }
    }


    public void selectAge(int age){
        clickElement(ageButton);
        if(age>27){
            cdriver.findElement(By.xpath("//a[normalize-space()='27+']")).click();
        } else if (26 >= age && age >= 25) {
            cdriver.findElement(By.xpath("//a[normalize-space()='25-26']")).click();
        }
        else{
            cdriver.findElement(By.xpath("//a[normalize-space()='21-24']")).click();
        }
    }

    public void usePromotion(String promotion) throws InterruptedException {
        clickElement(promotionCheckbox);
        Thread.sleep(1000);
        clickElement(promotionDropdown);
        List<WebElement> promotionTypes = cdriver.findElements(By.xpath("//div[@id='promotionTypePicker']//li"));

        for (WebElement promotionType : promotionTypes) {
            if (promotionType.getText().equals(promotion)) {
                promotionType.click();
                break;
            }
        }
    }

    public void leaveDifPlaces(String leaveDifPlace) throws InterruptedException {
        clickElement(leaveDifPlaceCheckBox);
        Thread.sleep(1000);
        clickElement(difPlaceDropdown);
        List<WebElement> difPlaces = cdriver.findElements(By.xpath("//div[@class='search__component-form-group-result open animate']//li"));

        for (WebElement difPlace : difPlaces) {
            if (difPlace.getText().equals(leaveDifPlace)) {
                difPlace.click();
                break;
            }
        }
    }


    public void clickSuitableCarButton(){
        clickElement(findSuitableCarButton);
    }


    public void usePromotionCode (String promotion, String promotionCode) throws InterruptedException {
        clickElement(promotionCheckbox);
        Thread.sleep(1000);
        clickElement(promotionDropdown);
        Thread.sleep(1000);
        List<WebElement> promotionTypes = cdriver.findElements(By.xpath("//div[@id='promotionTypePicker']//li"));

        for (WebElement promotionType : promotionTypes) {
            if (promotionType.getText().equals(promotion)) {
                promotionType.click();
                break;
            }
        }
        Thread.sleep(1000);
        enterText(promotionTypeCode,promotionCode);
    }

    public String nearestLocationError(){
        return getElementText(nearestLocError);
    }

    public void clickNearestLoc(){
        clickElement(nearestLoc);
    }

    public String availableCarError() {
        return getElementText(availableCarError);
    }

    public String locationError() {
        return getElementText(locationError);
    }

    public String selectErrorHeader() {
        return getElementText(selectErrorHeader);
    }

    public void closeErr(){
        clickElement(errorCloseButton);
    }

    public void carTypeFilter() {
        clickElement(carTypeFilter);
    }

    public void fuelTypeFilter() {
        clickElement(fuelTypeFilter);
    }

    public void gearTypeFilter() {
        clickElement(gearTypeFilter);
    }

    public String carTypeText(){
        return getElementText(carTypeFilter);
    }

    public String fuelTypeText(){
        return getElementText(fuelTypeFilter);
    }

    public String gearTypeText(){
        return getElementText(gearTypeFilter);
    }

    public boolean verifyCarClass(String expectedClass) {
        List<WebElement> carClassList = driver.findElements(By.xpath("//div[@selected-text='ŞU ANKİ SEÇİM']//*[not(contains(@class, 'd-none'))]//h6[contains(@class, 'text')]"));
        boolean allMatch = true;
        for (WebElement carClass : carClassList) {
            String carClassText = carClass.getText().trim();
            if (carClassText.isEmpty()) {
                continue;
            }
            System.out.println("Araç Sınıfı: " + carClassText);
            if (!carClassText.contains(expectedClass)) {
                System.out.println("Uymayan Araç Sınıfı: " + carClassText);
                allMatch = false;
            }
        }
        return allMatch;
    }

    public boolean verifyCarFuelType(String expectedFuelType) {
        List<WebElement> carFuelTypeList = driver.findElements(By.xpath("//div[@selected-text='ŞU ANKİ SEÇİM']//*[not(contains(@class, 'd-none'))]//h5[contains(@class, 'title')]"));
        boolean allMatch = true;
        for (WebElement carFuelType : carFuelTypeList) {
            String carFuelTypeText = carFuelType.getText().trim();
            if (carFuelTypeText.isEmpty()) {
                continue;
            }
            System.out.println("Yakıt Tipi: " + carFuelTypeText);
            if (!carFuelTypeText.contains(expectedFuelType)) {
                System.out.println("Uymayan Yakıt Tipi: " + carFuelTypeText);
                allMatch = false;
            }
        }
        return allMatch;
    }

    public boolean verifyCarTransmission(String expectedTransmission) {
        List<WebElement> carTransmissionList = driver.findElements(By.xpath("//div[@selected-text='ŞU ANKİ SEÇİM']//*[not(contains(@class, 'd-none'))]//h5[contains(@class, 'title')]"));
        boolean allMatch = true;
        for (WebElement carTransmission : carTransmissionList) {
            String carTransmissionText = carTransmission.getText().trim();
            if (carTransmissionText.isEmpty()) {
                continue;
            }
            System.out.println("Şanzıman Tipi: " + carTransmissionText);
            if (!carTransmissionText.contains(expectedTransmission)) {
                System.out.println("Uymayan Şanzıman Tipi: " + carTransmissionText);
                allMatch = false;
            }
        }
        return allMatch;
    }
}
