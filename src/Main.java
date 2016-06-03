import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.thoughtworks.selenium.SeleneseTestNgHelper.assertEquals;

public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        long startTime = System.currentTimeMillis();
        //m.test();
        m.test2();
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println(elapsedTime);
    }

    private void test() {
        Selenium selenium;

        WebDriver webDriver = new FirefoxDriver();

        String baseUrl = "http://newtours.demoaut.com/";
        selenium = new WebDriverBackedSelenium(webDriver, baseUrl);

        selenium.open("/");
        try {
            assertEquals("Welcome: Mercury Tours", selenium.getTitle());
        } catch (AssertionError e) {
            System.out.println(e);
        }
        selenium.type("name=userName", "invalidUN");
        selenium.type("name=password", "invalidPW");
        selenium.click("name=login");
    }

    private void test2() {
        Selenium selenium;
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
                ".\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");
        WebDriver webDriver = new PhantomJSDriver(caps);

        String baseUrl = "http://newtours.demoaut.com/";
        selenium = new WebDriverBackedSelenium(webDriver, baseUrl);

        selenium.open("/");
        try {
            assertEquals("Welcome: Mercury Tours", selenium.getTitle());
        } catch (AssertionError e) {
            System.out.println(e);
        }
        selenium.type("name=userName", "invalidUN");
        selenium.type("name=password", "invalidPW");
        selenium.click("name=login");
    }
}