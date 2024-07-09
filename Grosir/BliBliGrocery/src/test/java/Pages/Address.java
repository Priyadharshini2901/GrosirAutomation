package Pages;
import ApplicationPropertyReader.ApplicationPropertiesReader;
import Locators.BliBliLoctors;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

public class Address {
    private Page page;
    private static BrowserContext context;
    public static BrowserContext getContext()
    {
        return context;
    }
    public Address(Page page,BrowserContext context)
    {
        this.page = page;
        this.context = context;
    }
    @Step("Entering the field of address")
    public String inputNewAddressField() {
        page.click(BliBliLoctors.gMapPlus);
        page.waitForSelector(BliBliLoctors.inputNewAddress1);
        page.click(BliBliLoctors.inputNewAddress1);
        page.fill(BliBliLoctors.inputNewAddress1,ApplicationPropertiesReader.getProperty("cityName"));
        page.keyboard().press("Enter");
        page.waitForSelector(BliBliLoctors.cityNameDisplayed);
        page.click(BliBliLoctors.cityNameDisplayed);
        return page.inputValue(BliBliLoctors.inputNewAddress1);
    }
    @Step("Clicking on the addressButton to save it")
    public boolean addressButton() {
        System.out.println("entering addressbutton");
        page.waitForSelector(BliBliLoctors.addressButton);
        boolean isVisibleAddressBtn  = page.isEnabled(BliBliLoctors.addressButton);
        page.click(BliBliLoctors.addressButton);
        return isVisibleAddressBtn;

    }
    @Step("Clicking and giving address information")
    public boolean AddressDetails() {
        page.waitForSelector(BliBliLoctors.labelNo);
        page.fill(BliBliLoctors.labelNo,ApplicationPropertiesReader.getProperty("labelAlamat"));
        page.waitForSelector(BliBliLoctors.labelName);
        page.fill(BliBliLoctors.labelName,ApplicationPropertiesReader.getProperty("recipientName"));
        page.waitForSelector(BliBliLoctors.labelMobile);
        page.fill(BliBliLoctors.labelMobile,ApplicationPropertiesReader.getProperty("recipientMobile"));
        page.waitForSelector(BliBliLoctors.toggle);
        page.waitForSelector(BliBliLoctors.toggle);
        page.click(BliBliLoctors.toggle);
        boolean isAddressEnabled = page.isEnabled(BliBliLoctors.submitAddress);
        page.click(BliBliLoctors.submitAddress);
        page.click(BliBliLoctors.conformAddress);
        return isAddressEnabled;
    }
}
