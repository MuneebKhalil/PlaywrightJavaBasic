import com.microsoft.playwright.*;

public class Iframes {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();

        launchOptions.setHeadless(false);
        Browser browser = playwright.chromium().launch(launchOptions);
        BrowserContext browserContext = browser.newContext();
        Page page = browserContext.newPage();
        page.navigate("http://londonfreelance.org/courses/frames/index.html");

//       String header = page.frameLocator("frame[name='main']").locator("h2").textContent();
//        System.out.println(header);

       String header2 = page.frame("main").locator("h2").textContent();
        System.out.println(header2);

        BrowserContext browserContext1 = browser.newContext();
        Page page1 = browserContext1.newPage();
        page1.navigate("https://www.formsite.com/templates/registration-form-templates/vehicle-registration-form/");
        page1.locator("img[alt='Vehicle Registration Form']").click();
        page1.frameLocator("//iframe[contains(@id,'frame-one')]").locator("#RESULT_TextField-8")
                .fill("Muneeb Khalil");


//        browser.close();
//        playwright.close();
    }
}
