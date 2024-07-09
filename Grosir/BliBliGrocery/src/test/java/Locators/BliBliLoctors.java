package Locators;

import ApplicationPropertyReader.ApplicationPropertiesReader;

public class BliBliLoctors {
    public static final String masuk = "//div[@class='auth-container']//a/button";
    public static final String email = "//input[@class='text-field__input dark']";
    public static final String password = "//input[@class='form__input login__password']";
    public static final String loginButton = "//div[@class='login__button']/button";
    public static final String OtpButton = "//div[@class='otp-type-selection__send']/button";
    public static final String otpfield = "//li/input[@class='otp__textField space item active']";
    public static final String homeAddress = "//div[@class='location__address']";
    public static final String addNewAddress = "//div[@class='body__slider blu b-overflow-x']//div[text()='Tambah alamat baru']";
    public static final String gMapPlus = "//div[@class='gmnoprint']//button[@aria-label='Perbesar']";
    public static final String inputNewAddress1 = "//div[@class='blu-field__content blue-3']/input";
    public static final String cityNameDisplayed = "//div[@class='address-search__autocomplete b-overflow-y']//span";
    public static final String addressButton = "//div[@class='footer__btn']/button";
    public static final String labelNo = "//label[text()='Label alamat']/parent::div/following-sibling::input";
    public static final String labelName = "//label[text()='Nama penerima']/parent::div/following-sibling::input";
    public static final String labelMobile = "//label[text()='Nomor HP penerima']/parent::div/following-sibling::input";
    public static final String toggle = "//div[@class='form__text-field']/label";
    public static final String submitAddress = "//div[@class='blu-modal__footer']/button";
    public static final String conformAddress = "//div//button[@class='blu-button b-common b-primary']";
    public static final String freshByBliBli = "//div[@title='Fresh by Bliblimart']";
    public static final String kategori = "//section[@class='cat-drop-container category-dropdown']";
    public static final String mulaiAccept = "//button[@class='blu-button b-common b-primary onboarding-primary-button']";
    public static final String onHoverSelection = "//div[@class='category-title' and text() = '"+ApplicationPropertiesReader.getProperty("dropdownSelection")+"'] ";
    public static final String kategoriAgree = "//div[@class='onboarding-tooltip b-active b-right-bottom']//button[text()='Lanjut']";
    public static final String agreeFresh = "//div[@class='onboarding-tooltip b-active b-bottom-left']//button[text()='Lanjut']";
    public static final String getAgreeHeader = "//div[@class='onboarding-tooltip__footer b-footer-stepper']//button[text()='Oke']";
    public static final String fromFirstHover = "//div[starts-with(@class,'category-title')][text()='Garam & Bumbu Masak']";
    public static final String withDiscount = "//section[@class='product-details-container']//div/div";
    public static final String addToCart = "//button[@data-testid='groceryStickyCtaButtonNoQuantity']";
    public static final String increaseCount = "//button[@data-testid='groceryStickyCtaButtonPlus']";
    public static final String decreaseCount = "//button[@data-testid='groceryStickyCtaButtonMinus']";
    public static final String viewOnboarding = "//div[@class='onboarding-tooltip-highlight']//span";
    public static final String afterPopup = "//div[@class='onboarding-tooltip__footer b-footer-default']//button";
    public static final String payButton = "//div[@class='summary-wrapper']//button[@data-testid='payButton']";
    public static final String changeBankOption = "//div[@class='payment-section__method']//span";
    public static final String confirmPayment = "//div[@class='blu-modal__footer']//button[@class='blu-button b-common b-primary']";
    public static final String bankChosen = "//div[@data-testid='paymentGroup-1']//div[@data-testid ='paymentOption-0']";
    public static final String selectMethod="//button[@data-testid ='chooseMethodButton']";
    public static final String goBackToHome = "//button[@data-testid='goToHomeButton']";
    public static final String homeIcon = "//div[@class='onboarding-tooltip-highlight']/img[@alt='Blibli Logo']";
    public static final String HoverOnProfile = "//div[@class='account tooltip__trigger hover-gray']";
    public static final String orders = "//span[text()='Daftar pesanan']";
    public static final String viewOrders = "//section[@class='order-list__list']//div[@class='product']";
    public static final String cancelOrder = "//button[@class='blu-btn cancel-order b-outline b-secondary b-medium']";
}
