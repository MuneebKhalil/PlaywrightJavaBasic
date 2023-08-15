import com.microsoft.playwright.*;
import com.microsoft.playwright.options.FilePayload;

import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUpload {

    public static void main(String[] args) throws InterruptedException {
        Playwright playwright = Playwright.create();
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();

        launchOptions.setHeadless(false);
        Browser browser = playwright.chromium().launch(launchOptions);
        BrowserContext browserContext = browser.newContext();
        Page page = browserContext.newPage();
        page.navigate("https://davidwalsh.name/demo/multiple-file-upload.php");

        //Select one File
//        page.setInputFiles("#filesToUpload", Paths.get("applogin.json"));
//        //To remove
//        Thread.sleep(3000);
//        page.setInputFiles("#filesToUpload", new Path[0]);

        //Select Multiple Files
//        page.setInputFiles("#filesToUpload", new Path[] {
//                Paths.get("applogin.json"),Paths.get("my bank detail.txt"),Paths.get("ReadMe.txt")
//        });
//        Thread.sleep(3000);
//        page.setInputFiles("#filesToUpload", new Path[0]);

        //run time file upload
        page.setInputFiles("#filesToUpload", new FilePayload("muneeb.text","text/plain",
                "this is muneeb".getBytes(StandardCharsets.UTF_8)));

    }
}
