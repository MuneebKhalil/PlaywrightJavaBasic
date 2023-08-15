import com.microsoft.playwright.*;

public class Locators {

    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();
        launchOptions.setChannel("msedge");
        launchOptions.setHeadless(false);
        Browser browser = playwright.chromium().launch(launchOptions);
        BrowserContext browserContext = browser.newContext();
        Page page = browserContext.newPage();
        page.navigate("https://academy.naveenautomationlabs.com/");
      Locator loginBtn =  page.locator(".loginBtn");
      loginBtn.hover();
      loginBtn.click();


        browser.close();
        playwright.close();
//      page.close();

    }
}
