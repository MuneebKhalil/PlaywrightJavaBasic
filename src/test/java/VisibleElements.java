import com.microsoft.playwright.*;

import java.util.List;

public class VisibleElements {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();

        launchOptions.setHeadless(false);
        Browser browser = playwright.chromium().launch(launchOptions);
        BrowserContext browserContext = browser.newContext();
        Page page = browserContext.newPage();
        page.navigate("https://rahulshettyacademy.com/AutomationPractice/");
        FrameLocator framePage = page.frameLocator("#courses-iframe");
     String text =   framePage.locator("li a[href*='lifetime-access']:visible").textContent();
        System.out.println(text);

        BrowserContext browserContext1 = browser.newContext();
        Page page1 = browserContext1.newPage();
        page1.navigate("https://www.amazon.com/");
      List<String> linksText =  page1.locator("a:visible").allInnerTexts();
      linksText.forEach(e -> System.out.println(e));
    }
}
