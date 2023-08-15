import com.microsoft.playwright.*;

public class CommaSelectors {

    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();

        launchOptions.setHeadless(false);
        Browser browser = playwright.chromium().launch(launchOptions);
        BrowserContext browserContext = browser.newContext();
        Page page = browserContext.newPage();
        page.navigate("https://academy.naveenautomationlabs.com/");

//        page.locator("a:has-text('Login')," + "a:has-text('Signin')," + "a:has-text('login')").click();
        page.locator("//a[text()='Login'] | //a[text()='Signin']").click();

    }
}
