package Pages;
import Locators.BliBliLoctors;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

public class Product {
    private Page page;
    private static BrowserContext context;
    public static BrowserContext getContext()
    {
        return context;
    }
    public Product(Page page,BrowserContext context)
    {
        this.page = page;
        this.context = context;
    }
    @Step("Only discounted products are selected")
    public boolean withDiscountAvailable() {
        boolean isDiscountAvailable = page.isEnabled(BliBliLoctors.withDiscount);
        page.click(BliBliLoctors.withDiscount);
        return isDiscountAvailable;
    }
}
