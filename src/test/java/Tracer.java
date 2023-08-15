import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

import java.nio.file.Paths;

public class Tracer {




        public static void main(String[] args) {
            //trace.playwright.dev
            //mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="show-trace trace.zip"
            try (Playwright playwright = Playwright.create()) {
                Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                        .setHeadless(false));
                BrowserContext context = browser.newContext();
                context.tracing().start(new Tracing.StartOptions()
                        .setScreenshots(true)
                        .setSnapshots(true)
                        .setSources(true));
                Page page = context.newPage();
                page.navigate("https://academy.naveenautomationlabs.com/");
                page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Login")).click();
                page.frameLocator("#microfe-popup-login").getByText("Sign up").click();
                page.frameLocator("#microfe-popup-login").getByPlaceholder("Name").click();
                page.frameLocator("#microfe-popup-login").getByPlaceholder("Name").fill("Muneeb");
                page.frameLocator("#microfe-popup-login").getByPlaceholder("Email address").click();
                page.frameLocator("#microfe-popup-login").locator("#loginPopupCloseBtn path").click();
                page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Courses").setExact(true)).click();
                context.tracing().stop(new Tracing.StopOptions()
                        .setPath(Paths.get("trace.zip")));
            }
        }

}
