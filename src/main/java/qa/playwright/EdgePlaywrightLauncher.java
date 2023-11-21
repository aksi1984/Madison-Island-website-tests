package qa.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;

public class EdgePlaywrightLauncher extends PlaywrightBrowserLauncher {

    @Override
    public Browser launch() {

        Playwright playwright = Playwright.create();

        return playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("msedge").setHeadless(false).setSlowMo(50));
    }
}