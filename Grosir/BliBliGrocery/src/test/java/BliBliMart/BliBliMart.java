package BliBliMart;

import ApplicationPropertyReader.ApplicationPropertiesReader;
import Pages.*;
import com.microsoft.playwright.*;
import com.microsoft.playwright.Dialog;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.util.Collections;

public class BliBliMart {
    private Playwright playwright;
    private Page page;
    public String baseUrl;
    public Browser browser;
    public FreshByBlibli freshByBlibli;
    public Product product;
    private Address address;
    private Payment  payment;
    SoftAssert softAssert = new SoftAssert();
    private Home homeBliBli;
    private Login loginPage;
    private  ProductDetail productDetails;
    private FreshByBlibli freshByBlibli1;

    @BeforeTest
    public void setUp()
    {
        playwright = Playwright.create();
        BrowserType.LaunchOptions options = new BrowserType.LaunchOptions().setHeadless(false);
        browser = playwright.chromium().launch(options);
        BrowserContext context = browser.newContext();
        context.grantPermissions(Collections.singletonList("geolocation"));
        context.onDialog(Dialog::dismiss);
        page = context.newPage();
        this.baseUrl = ApplicationPropertiesReader.getProperty("baseUrl");
        page.navigate(this.baseUrl);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();
        page.setViewportSize(width, height);
    }

    @Test(description = "Purchasing a discounted product from a location in BliBli platform")
    public void Test()
    {
        loginPage = new Login(page,Login.getContext());
        softAssert.assertTrue(loginPage.isMasukEnabled(),"Masuk is not enabled");
        softAssert.assertEquals(loginPage.emailInput(),ApplicationPropertiesReader.getProperty("email"),"The provided email do not match with original");
        softAssert.assertEquals(loginPage.passwordInput(),ApplicationPropertiesReader.getProperty("password"),"The provided password do not match");
        softAssert.assertTrue(loginPage.getLoginButton(),"Button is not displayed");
        softAssert.assertTrue(loginPage.generateOtp(),"Otp button is not available");
        softAssert.assertEquals(loginPage.inputFieldOtp(),"otp is invalid");

        homeBliBli = new Home(page,Home.getContext());
        softAssert.assertTrue(homeBliBli.homeAddress(),"Failed to get home address");
        softAssert.assertTrue(homeBliBli.isnewAddress(),"adding new address is not available");

        address = new Address(page,Address.getContext());
        softAssert.assertEquals(address.inputNewAddressField(),ApplicationPropertiesReader.getProperty("cityName"),"Input entered is mismatched!");
        softAssert.assertTrue(address.addressButton(),"address button is not available");
        softAssert.assertTrue(address.AddressDetails(),"Submitted successfully");

        freshByBlibli1 = new FreshByBlibli(page,FreshByBlibli.getContext());
        softAssert.assertTrue(freshByBlibli1.isFreshByBliBLiAvailable(),"The fresh blibli is not available");
        softAssert.assertTrue(freshByBlibli1.mulaiAccept(),"Accepted the mulai");
        softAssert.assertTrue(freshByBlibli1.kategoriAgree(),"kategori guidance is not provided");
        softAssert.assertTrue(freshByBlibli1.agreeFreshText(),"FreshByBlibli page is not guided");
        softAssert.assertTrue(freshByBlibli1.agreeOke(),"User acceptance is not asked");
        freshByBlibli1.hoverKategori();

        product = new Product(page,Product.getContext());
        softAssert.assertTrue(product.withDiscountAvailable(),"discounted products are not available");

        productDetails = new ProductDetail(page,ProductDetail.getContext());
        softAssert.assertTrue(productDetails.isAddToCartAVailable(),"Add to cart is not avaialble");
        productDetails.increaseAndDecrease();
        softAssert.assertTrue(productDetails.isViewOnboardAvailable(),"Onboarding option is not seen");
        softAssert.assertTrue(productDetails.popUpForAddToCart(),"pop up is missing");

        payment = new Payment(page,Payment.getContext());
        softAssert.assertTrue(payment.isTransferAccount(),"account change option not available");
        softAssert.assertTrue(payment.isWishedBank(),"Preferred bank not available");
        softAssert.assertTrue(payment.isSelectedMethod(),"Pay button not available");
        softAssert.assertTrue(payment.payMent(),"Payment done successfully");
        softAssert.assertTrue(payment.continuePay(),"payment successfully continued");
        softAssert.assertTrue(payment.goBackHome(),"Go back to the home is not successfull");

        softAssert.assertTrue(homeBliBli.getOrders(),"cancel button is available");

    }
}