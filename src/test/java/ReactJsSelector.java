import com.microsoft.playwright.*;

public class ReactJsSelector {
    public static void main(String[] args) {
        //Extension : React Developer tools --> in extension use components


        Playwright playwright = Playwright.create();
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();

        launchOptions.setHeadless(false);
        Browser browser = playwright.chromium().launch(launchOptions);
        BrowserContext browserContext = browser.newContext();
        Page page = browserContext.newPage();
        page.navigate("https://www.netflix.com/browse");
        page.locator("_react=p[name='email'] >> input");

    }
}
