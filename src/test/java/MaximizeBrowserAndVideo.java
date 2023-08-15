import com.microsoft.playwright.*;

import java.awt.*;
import java.nio.file.Paths;

public class MaximizeBrowserAndVideo {
    public static void main(String[] args) {
     Dimension screenSize =   Toolkit.getDefaultToolkit().getScreenSize();
     int width = (int)screenSize.getWidth();
     int height =(int)screenSize.getHeight();

        Playwright playwright = Playwright.create();
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();

        launchOptions.setHeadless(false);
        Browser browser = playwright.chromium().launch(launchOptions);
        BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(width,height).
                setRecordVideoDir(Paths.get("myvideos")));
        Page page = context.newPage();
        page.navigate("http://www.amazon.com");


        context.close();
        page.close();
        playwright.close();



    }
}
