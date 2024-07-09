package Pages;
import ApplicationPropertyReader.ApplicationPropertiesReader;
import Locators.BliBliLoctors;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

public class Login {
    private Page page;
    private static BrowserContext context;
    public static BrowserContext getContext()
    {
        return context;
    }
    public Login(Page page,BrowserContext context)
    {
        this.page = page;
        this.context = context;
    }
    @Step("Entering the email")
    public String emailInput() {
        page.fill(BliBliLoctors.email, ApplicationPropertiesReader.getProperty("email"));
        return page.inputValue(BliBliLoctors.email);
    }
    @Step("Entering the password")
    public String passwordInput() {
        page.fill(BliBliLoctors.password,ApplicationPropertiesReader.getProperty("password"));
        return page.inputValue(BliBliLoctors.password);
    }
    @Step("Clicking on the Login Button")
    public boolean getLoginButton() {
        boolean isLoginEnabled = page.isEnabled(BliBliLoctors.loginButton);
        page.click(BliBliLoctors.loginButton);
        return isLoginEnabled;
    }
    @Step("Clicking the otp button")
    public boolean generateOtp() {
        boolean otpAvailable = page.isEnabled(BliBliLoctors.OtpButton);
        page.click(BliBliLoctors.OtpButton);
        return otpAvailable;
    }
    @Step("Entering the OTP")
    public String inputFieldOtp() {
        page.fill(BliBliLoctors.otpfield, String.valueOf(3333));
        return page.inputValue(BliBliLoctors.otpfield);
    }
    @Step("Trying to login using masuk")
    public boolean isMasukEnabled() {
        boolean isMasukEnable = page.isEnabled(BliBliLoctors.masuk);
        page.click(BliBliLoctors.masuk);
        return isMasukEnable;
    }
}
