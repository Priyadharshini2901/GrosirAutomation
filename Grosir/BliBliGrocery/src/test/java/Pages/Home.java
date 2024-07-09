package Pages;
import Locators.BliBliLoctors;
import com.microsoft.playwright.*;
import io.qameta.allure.Step;

public class Home {
    private Page page;
    private static BrowserContext context;
    public static BrowserContext getContext()
    {
        return context;
    }
    public Home(Page page,BrowserContext context)
    {
        this.page = page;
        this.context = context;
    }
    @Step("Viewing Address page")
    public boolean homeAddress() {
        boolean ishomeAddress = page.isEnabled(BliBliLoctors.homeAddress);
        page.click(BliBliLoctors.homeAddress);
        return ishomeAddress;
    }
    @Step("Checking new address content")
    public boolean isnewAddress() {
        boolean isNewHomeAddress = page.isEnabled(BliBliLoctors.addNewAddress);
        page.click(BliBliLoctors.addNewAddress);
        return isNewHomeAddress;
    }
    @Step("Choose the orders and deleting it")
    public boolean getOrders() {
        page.click(BliBliLoctors.homeIcon);
        page.waitForSelector(BliBliLoctors.HoverOnProfile);
        page.hover(BliBliLoctors.HoverOnProfile);
        page.waitForSelector(BliBliLoctors.orders);
        page.click(BliBliLoctors.orders);
        page.waitForSelector(BliBliLoctors.viewOrders);
        page.click(BliBliLoctors.viewOrders);
        page.waitForSelector(BliBliLoctors.cancelOrder);
        boolean isCancel = page.isEnabled(BliBliLoctors.cancelOrder);
        page.click(BliBliLoctors.cancelOrder);
        return isCancel;
    }
}
