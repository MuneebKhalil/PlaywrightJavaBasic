import com.microsoft.playwright.*;

public class PopUpAndTab {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();

        launchOptions.setHeadless(false);
        Browser browser = playwright.chromium().launch(launchOptions);
        BrowserContext bx1 = browser.newContext();
        BrowserContext bx2 = browser.newContext();

        Page page1 = bx1.newPage();
//        Page page2 = bx2.newPage();

        page1.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

//        Page popup = page1.waitForPopup(() -> {
//            page1.click("svg .oxd-icon orangehrm-sm-icon");
//        });

         Page popup = page1.waitForPopup(() -> {
             page1.click("a[target='_blank']");
         });
         popup.waitForLoadState();
         popup.navigate("https://www.google.com");

        System.out.println(popup.url());
//        popup.close();
////        page2.navigate("");
    }
}
