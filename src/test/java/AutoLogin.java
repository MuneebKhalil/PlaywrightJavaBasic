import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class AutoLogin {

    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();

        launchOptions.setHeadless(false);

        Browser browser = playwright.chromium().launch(launchOptions);
        BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions()
                .setStorageStatePath(Paths.get("applogin.json")));
//        BrowserContext browserContext = browser.newContext();
        Page page = browserContext.newPage();
        page.setViewportSize(1920, 1080);

        page.navigate("https://unjaded.pk/");

//        page.fill("#CustomerEmail", "muneebkhalil96@gmail.com");
//        page.locator("#CustomerPassword").fill("unjaded7969");
//        page.click("text=Sign in");
//
////        To create session file
//        browserContext.storageState(new BrowserContext.StorageStateOptions()
//                .setPath(Paths.get("applogin.json")));

    }
}
