package session;

import factoryBrowser.FactoryBrowser;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class Session1 {
    private static Session1 session;
    private WebDriver browser;
    private Session1(){
        browser = FactoryBrowser.make("chrome").create();
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
        browser.get("https://todoist.com/auth/login");
    }
    public static Session1 getInstance(){
        session = new Session1();
        return session;
    }

}