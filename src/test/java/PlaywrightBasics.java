import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightBasics {

    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();
        launchOptions.setChannel("msedge");
        launchOptions.setHeadless(false);
      Browser browser = playwright.chromium().launch(launchOptions);
      Page page = browser.newPage();
      page.navigate("https://www.amazon.com/");
        System.out.println(page.title());

        browser.close();
        playwright.close();
    }
}
