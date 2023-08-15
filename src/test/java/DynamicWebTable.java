import com.microsoft.playwright.*;

public class DynamicWebTable {

    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();

        launchOptions.setHeadless(false);
        Browser browser = playwright.chromium().launch(launchOptions);
        BrowserContext browserContext = browser.newContext();
        Page page = browserContext.newPage();
        page.navigate("https://datatables.net/extensions/select/examples/initialisation/checkbox.html");

        Locator row = page.locator("#example tr");
        //To goto specific row in web table and perfrom action on any locator on that row
        row.locator(":scope", new Locator.LocatorOptions()
                .setHasText("Ashton Cox"))
                .locator(".select-checkbox").click();
        row.locator(":scope").allInnerTexts().forEach(e -> System.out.println(e));


    }
}
