package qa.pageobject.shoppingcart;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import qa.base.BasePage;

public class ShoppingCart extends BasePage {

    private final Table table;
    private final Locator errorMessage;
    private final Locator pageTitle;

    public ShoppingCart(Page page) {

        super(page);

        table = new Table(page);
        errorMessage = page.locator("li.error-msg");
        pageTitle = page.locator("div.page-title");
    }

    public Table getTable() {

        return table;
    }

    public boolean isErrorMessageVisible() {

        return errorMessage.isVisible();
    }

    public String getPageTitleText() {

        return pageTitle.textContent().trim();
    }
}