package Pages;
import Locators.BliBliLoctors;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

public class FreshByBlibli {
    private Page page;
    private static BrowserContext context;

    public static BrowserContext getContext()
    {
        return context;
    }
    public FreshByBlibli(Page page,BrowserContext context)
    {
        this.page = page;
        this.context = context;
    }
    @Step("Verifying whether fresh blibli is present")
    public boolean isFreshByBliBLiAvailable() {
        boolean isFreshEnabled = page.isEnabled(BliBliLoctors.freshByBliBli);
        page.click(BliBliLoctors.freshByBliBli);
        return isFreshEnabled;
    }
    @Step("Accepting notifications")
    public boolean mulaiAccept() {
        boolean isMulaiEnabled = page.isEnabled(BliBliLoctors.mulaiAccept);
        page.click(BliBliLoctors.mulaiAccept);
        return isMulaiEnabled;
    }
    @Step("Accepting notifications")
    public boolean kategoriAgree() {
        boolean isKategoriAgreeAvailable = page.isEnabled(BliBliLoctors.kategori);
        page.click(BliBliLoctors.kategoriAgree);
        return isKategoriAgreeAvailable;
    }
    @Step("Accepting notifications")
    public boolean agreeFreshText() {
        boolean isagreeFreshText = page.isEnabled(BliBliLoctors.agreeFresh);
        page.click(BliBliLoctors.agreeFresh);
        return  isagreeFreshText;
    }
    @Step("Accepting notifications")
    public boolean agreeOke() {
        boolean isOkeAvailable = page.isEnabled(BliBliLoctors.getAgreeHeader);
        page.click(BliBliLoctors.getAgreeHeader);
        return isOkeAvailable;
    }
    @Step("Hover and fetching the wished products kategori")
    public void hoverKategori() {
        page.hover(BliBliLoctors.kategori);
        page.hover(BliBliLoctors.onHoverSelection);
        page.click(BliBliLoctors.onHoverSelection);
        page.click(BliBliLoctors.fromFirstHover);
    }
}
