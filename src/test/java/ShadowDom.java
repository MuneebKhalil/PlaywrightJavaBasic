import com.microsoft.playwright.*;

public class ShadowDom {

    public static void main(String[] args) {
        //Page -- DOM --> Shadow DOM --> Elements
        //Page -- DOM --> iFrame --> Shadow DOM --> Elements

        Playwright playwright = Playwright.create();
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();

        launchOptions.setHeadless(false);
        Browser browser = playwright.chromium().launch(launchOptions);
        BrowserContext browserContext = browser.newContext();
        Page page = browserContext.newPage();
        page.navigate("https://books-pwakit.appspot.com/");

        //From parent to child which is in shadow dom
        //Page -- DOM --> Shadow DOM --> Elements
        page.locator("book-app[apptitle='BOOKS'] #input").fill("Testing Books");

        BrowserContext browserContext1 = browser.newContext();
        Page page1 = browserContext1.newPage();
        page1.navigate("https://selectorshub.com/shadow-dom-in-iframe/");
        //Page -- DOM --> iFrame --> Shadow DOM --> Elements
        page1.frameLocator("#pact").locator("#snacktime #tea").fill("Ginger Tea");

    }
}
