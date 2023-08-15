import com.microsoft.playwright.*;

public class JsAlerts {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();

        launchOptions.setHeadless(false);
        Browser browser = playwright.chromium().launch(launchOptions);
        BrowserContext browserContext = browser.newContext();
        Page page = browserContext.newPage();
        page.onDialog(dialog -> {
            String text = dialog.message();
            System.out.println(text);
            dialog.accept("Hi this is my alert");
        });
        page.navigate("https://the-internet.herokuapp.com/javascript_alerts");

        page.click("//button[text()='Click for JS Prompt']");
        System.out.println(page.textContent("#result"));

        page.close();
        browser.close();
        playwright.close();
    }
}
