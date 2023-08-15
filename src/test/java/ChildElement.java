import com.microsoft.playwright.*;

public class ChildElement {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();

        launchOptions.setHeadless(false);
        Browser browser = playwright.chromium().launch(launchOptions);
        BrowserContext browserContext = browser.newContext();
        Page page = browserContext.newPage();

        page.navigate("https://www.orangehrm.com/en/30-day-free-trial");
       Locator country = page.locator("select#Form_getForm_Country:has(option[value='Pakistan'])");
       country.allInnerTexts().forEach(e -> System.out.println(e));
    }
}
