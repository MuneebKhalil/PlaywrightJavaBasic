import com.microsoft.playwright.*;

public class RelativeLocators {

    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();

        launchOptions.setHeadless(false);
        Browser browser = playwright.chromium().launch(launchOptions);
        BrowserContext browserContext = browser.newContext();
        Page page = browserContext.newPage();
        page.navigate("https://selectorshub.com/xpath-practice-page/");
        page.locator("input:below(label:text('User Email'))").first().click();
        page.locator("input:below(label:text('User Email'))").first().fill("Muneeb");
//        page.locator("input[type='checkbox']:left-of(a:text('Joe.Root'))").first().click();
    }
}
