package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import static tests.InformationTest.cdriver;

public class InformationPage extends BasePage{
    // Page Header
    private final By contactSubelement = By.xpath("//a[@class='gtmheader'][contains(text(),'İletişim')]");
    private final By informationHeader = By.xpath("//h1[contains(text(),'İletişim')]");

    // Form Fields
    private final By nameInput = By.xpath("//input[@id='name']");
    private final By surnameInput = By.xpath("//input[@id='lastname']");
    private final By emailInput = By.xpath("//input[@id='email']");
    private final By emailconfirmInput = By.xpath("//input[@id='emailRpt']");
    private final By identityInput = By.xpath("//input[@id='TCKN']");
    private final By phoneNumberInput = By.xpath("//input[@id='phoneNumber']");

    // Radio Buttons
    private final By dontHaveRezervationNumberRadioButton = By.xpath("//input[@id='noneOrderType']");
    private final By transactionWithRezervationNumber = By.xpath("//label[contains(text(),'Rezervasyon Numarası ile işlem yapmak istiyorum')]");
    private final By transactionWithContractNumber = By.xpath("//label[contains(text(),'Sözleşme Numarası ile işlem yapmak istiyorum')]");

    // Message Box
    private final By messageBox = By.xpath("//textarea[@id='message']");

    // Buttons
    private final By sendButton = By.xpath("//span[normalize-space()='GÖNDER']");

    // Checkboxes
    private final By clientBox = By.xpath("//label[@for='customerExplicitConsent']");
    private final By privacyBox = By.xpath("//label[@for='CustomerConsentText']");
    private final By electronixMessageBox = By.xpath("//label[contains(text(),'Tarafıma tüm ticari kampanyalar dahil olmak üzere,')]");
    private final By recaptchaIframe = By.xpath("//iframe[contains(@src, 'recaptcha')]");
    private final By recaptchaCheckbox = By.cssSelector("div.recaptcha-checkbox-border");

    // Error Messages
    private final By nameBlank_err = By.xpath("//ul[@id='parsley-id-5']//li[@class='parsley-required'][contains(text(),'Bu alan boş bırakılamaz.')]");
    private final By surnameBlank_err = By.xpath("//ul[@id='parsley-id-7']//li[@class='parsley-required'][contains(text(),'Bu alan boş bırakılamaz.')]");
    private final By emailBlank_err = By.xpath("//ul[@id='parsley-id-9']//li[@class='parsley-required'][contains(text(),'Bu alan boş bırakılamaz.')]");
    private final By emailConfBlank_err = By.xpath("//ul[@id='parsley-id-11']//li[@class='parsley-required'][contains(text(),'Bu alan boş bırakılamaz.')]");
    private final By identityBlank_err = By.xpath("//ul[@id='parsley-id-15']//li[@class='parsley-required'][contains(text(),'Bu alan boş bırakılamaz.')]");
    private final By identity_err = By.xpath("//ul[@id='parsley-id-15']//li[1]");
    private final By identityLenght_err = By.xpath("//ul[@id='parsley-id-15']//li[1]");
    private final By phonenumBlank_err = By.xpath("//ul[@id='parsley-id-17']//li[@class='parsley-required'][contains(text(),'Bu alan boş bırakılamaz.')]");
    private final By messageboxBlank_err = By.xpath("//ul[@id='parsley-id-32']//li[@class='parsley-required'][contains(text(),'Bu alan boş bırakılamaz.')]");
    private final By clientCheckBoxBlank_err = By.xpath("//ul[@id='parsley-id-multiple-customerExplicitConsent']//li[@class='parsley-required'][contains(text(),'Bu alan boş bırakılamaz.')]");
    private final By privacyCheckBoxBlank_err = By.xpath("//ul[@id='parsley-id-multiple-CustomerConsentText']//li[@class='parsley-required'][contains(text(),'Bu alan boş bırakılamaz.')]");
    private final By electronixMessageBoxBlank_err = By.xpath("//ul[@id='parsley-id-multiple-CommunicationConfirmation']//li[@class='parsley-required'][contains(text(),'Bu alan boş bırakılamaz.')]");


    public InformationPage(WebDriver driver) {
        super(driver);
    }

    public String getInformationHeaderText() {
        return getElementText(informationHeader);
    }

    public void clickContact(){
        clickElement(contactSubelement);
    }

    public void fillName(String nameText) throws InterruptedException {
        enterText(nameInput,nameText);
    }

    public void fillSurname(String surnameText) throws InterruptedException {
        enterText(surnameInput,surnameText);
    }

    public void fillEmail(String emailText) throws InterruptedException {
        enterText(emailInput,emailText);
    }

    public void fillConfirmEmail(String confirmEmailText) throws InterruptedException {
        enterText(emailconfirmInput, confirmEmailText);
    }

    public void dropdownIdentityInfo(String identityText) {
        WebElement dropdownIdentity = cdriver.findElement(By.xpath("//select[@name='isPassportNumber']"));
        Select selectIdentity = new Select(dropdownIdentity);
        selectIdentity.selectByIndex(0);
        enterText(identityInput,identityText);
    }

    public void phoneNumber(String phoneText) throws InterruptedException {
        enterText(phoneNumberInput, phoneText);
        Thread.sleep(1500);
    }

    public void dropDownOffice(){
        WebElement office = cdriver.findElement(By.xpath("//select[@id='location']"));
        Select cities = new Select(office);
        cities.selectByIndex(6);
    }

    public void dontHaveRezervationContactRadioButton() throws InterruptedException {
        clickElement(dontHaveRezervationNumberRadioButton);
        Thread.sleep(1500);
    }

    public void rezervationRadioButton() throws InterruptedException {
        clickElement(transactionWithRezervationNumber);
        Thread.sleep(1500);
    }

    public void contractRadioButton() throws InterruptedException {
        clickElement(transactionWithContractNumber);
    }

    public void topic() {
        WebElement title = cdriver.findElement(By.xpath("//select[@name='titleId']"));
        Select themes = new Select(title);
        themes.selectByIndex(1);
    }

    public void messageBox (String messageText) throws InterruptedException {
        enterText(messageBox,messageText);
    }

    public void clickClientCheckBox() throws InterruptedException {
        clickElement(clientBox);
    }

    public void clickPrivacyCheckBox(){
        clickElement(privacyBox);
    }

    public void clickElectronixCheckBox(){
        clickElement(electronixMessageBox);
    }

    public void completeRecaptcha() {
        clickRecaptcha(recaptchaIframe, recaptchaCheckbox);
    }


    public void dropdownIdentityInfoClear() {
        clearElement(identityInput);
    }

    public String nameBlankError(){
        return getElementText(nameBlank_err);
    }

    public String surnameBlankError(){
        return getElementText(surnameBlank_err);
    }

    public String emailBlankError(){
        return getElementText(emailBlank_err);
    }

    public String emailConfirmBlankError(){
        return getElementText(emailConfBlank_err);
    }

    public String identityBlankError(){
        return getElementText(identityBlank_err);
    }

    public String identityLengthError(){
        return getElementText(identityLenght_err);
    }

    public String identityError(){
        return getElementText(identity_err);
    }

    public String phoneBlankError(){
        return getElementText(phonenumBlank_err);
    }

    public String messageBoxBlankError(){
        return getElementText(messageboxBlank_err);
    }

    public String clientCheckBoxBlankError(){
        return getElementText(clientCheckBoxBlank_err);
    }

    public String privacyCheckBoxBlankError(){
        return getElementText(privacyCheckBoxBlank_err);
    }

    public String electronixMessageblankError(){
        return getElementText(electronixMessageBoxBlank_err);
    }

    public void sendButton(){
        clickElement(sendButton);
    }

}
