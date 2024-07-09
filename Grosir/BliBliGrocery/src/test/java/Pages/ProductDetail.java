package Pages;
import Locators.BliBliLoctors;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

public class ProductDetail {
    private Page page;
    private static BrowserContext context;
    public static BrowserContext getContext()
    {
        return context;
    }
    public ProductDetail(Page page,BrowserContext context)
    {
        this.page = page;
        this.context = context;
    }
    @Step("Verify the addToCart button")
    public boolean isAddToCartAVailable() {
        boolean isCartIconAvaialble = page.isEnabled(BliBliLoctors.addToCart);
        page.click(BliBliLoctors.addToCart);
        return isCartIconAvaialble;
    }
    @Step("Verify to increase and decrease the quanity")
    public void increaseAndDecrease() {
        page.click(BliBliLoctors.increaseCount);
        page.click(BliBliLoctors.increaseCount);
        page.click(BliBliLoctors.decreaseCount);
    }
    @Step("Onboarding details")
    public boolean isViewOnboardAvailable() {
        boolean isAvaiableOnboarding = page.isEnabled(BliBliLoctors.viewOnboarding);
        page.click(BliBliLoctors.viewOnboarding);
        return isAvaiableOnboarding;
    }
    @Step("Popup for the checkOut page")
    public boolean popUpForAddToCart() {
        boolean isAvaiablePop = page.isEnabled(BliBliLoctors.afterPopup);
        page.click(BliBliLoctors.afterPopup);
        page.click(BliBliLoctors.viewOnboarding);
        return isAvaiablePop;
    }
}
