import com.microsoft.playwright.*;

public class NthElement {

    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();

        launchOptions.setHeadless(false);
        Browser browser = playwright.chromium().launch(launchOptions);
        BrowserContext browserContext = browser.newContext();
        Page page = browserContext.newPage();
        page.navigate("https://www.bigbasket.com/");

        Locator firstEle = page.locator("div.footer-links li a >> nth=0");
        Locator lastEle = page.locator("div.footer-links li a >> nth=-1");
    }
}
