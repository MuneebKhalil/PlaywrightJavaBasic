import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Inspector {


    //mvn exec:java -e -Dexec.mainClass=com.microsoft.playwright.CLI -Dexec.args="codegen https://academy.naveenautomationlabs.com/"
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();
        launchOptions.setChannel("msedge");
        launchOptions.setHeadless(false);
        Browser browser = playwright.chromium().launch(launchOptions);
        Page page = browser.newPage();
        page.navigate("https://academy.naveenautomationlabs.com/");
        page.pause();
        System.out.println(page.title());

        browser.close();
        playwright.close();
    }
}
