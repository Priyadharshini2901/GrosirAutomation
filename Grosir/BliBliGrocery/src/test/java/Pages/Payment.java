package Pages;
import Locators.BliBliLoctors;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

public class Payment {
    private Page page;
    private static BrowserContext context;

    public static BrowserContext getContext()
    {
        return context;
    }
    public Payment(Page page,BrowserContext context)
    {
        this.page = page;
        this.context = context;
    }
    @Step("Verifying the presence of Transfer account")
    public boolean isTransferAccount() {
        boolean isAvailableChangeOption = page.isEnabled(BliBliLoctors.changeBankOption);
        page.click(BliBliLoctors.changeBankOption);
        return isAvailableChangeOption;
    }
    @Step("Verifying the presence of customer's wished account")
    public boolean isWishedBank() {
        boolean isWishedAvailable = page.isEnabled(BliBliLoctors.bankChosen);
        page.click(BliBliLoctors.bankChosen);
        return isWishedAvailable;
    }
    @Step("Verifying the presence of selecting the bank")
    public boolean isSelectedMethod() {
        boolean isSelectedMethodButtonAvailable = page.isEnabled(BliBliLoctors.selectMethod);
        page.click(BliBliLoctors.selectMethod);
        return isSelectedMethodButtonAvailable;
    }
    @Step("Payment icon after changing the banks")
    public boolean payMent() {
        boolean isPaymentButtonEnabled = page.isEnabled(BliBliLoctors.payButton);
        page.click(BliBliLoctors.payButton);
        return isPaymentButtonEnabled;
    }
    @Step("Continue for paying")
    public boolean continuePay() {
        page.waitForSelector(BliBliLoctors.confirmPayment);
        boolean isContinuePay = page.isEnabled(BliBliLoctors.confirmPayment);
        page.click(BliBliLoctors.confirmPayment);
        return isContinuePay;
    }
    @Step("Go to home after payment")
    public boolean goBackHome() {
        page.waitForSelector(BliBliLoctors.goBackToHome);
        boolean goBackTohome = page.isEnabled(BliBliLoctors.goBackToHome);
        page.click(BliBliLoctors.goBackToHome);
        return goBackTohome;
    }
}
