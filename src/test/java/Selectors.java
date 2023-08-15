import com.microsoft.playwright.*;

public class Selectors {

    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();
        launchOptions.setChannel("chrome");
        launchOptions.setHeadless(false);
        Browser browser = playwright.chromium().launch(launchOptions);
        BrowserContext browserContext = browser.newContext();
        Page page = browserContext.newPage();
        page.navigate("https://www.orangehrm.com/");
//         page.locator("text=Contact Sales").last().click();

         Locator links = page.locator("text=Privacy Policy");
         for(int i=0; i< links.count(); i++){
             String text = links.nth(i).textContent();
             if(text.contains("Service Privacy Policy")){
                 links.nth(i).click();
                 break;
             }
         }
         BrowserContext browserContext2 = browser.newContext();
         Page page2 = browserContext2.newPage();
         page2.navigate("https://demo.opencart.com/index.php?route=account/login&language=en-gb");
      String header =   page2.locator("h2:has-text('New Customer')").textContent();
        System.out.println(header);
        page2.locator("'Login'").click();
        browser.close();
        playwright.close();

    }
}
