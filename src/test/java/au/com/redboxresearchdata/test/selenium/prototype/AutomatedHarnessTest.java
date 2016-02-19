package au.com.redboxresearchdata.test.selenium.prototype;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

/**
 * @author <a href="matt@redboxresearchdata.com.au">Matt Mulholland</a>
 */
public class AutomatedHarnessTest {
    public static final String USERNAME = "mattRedBox";
    public static final String ACCESS_KEY = "806d2999-870b-418f-90d6-d1d7e5def45a";

    public static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void test() throws Exception {
        DesiredCapabilities caps = DesiredCapabilities.chrome();
        caps.setCapability("platform", "Windows XP");
        caps.setCapability("version", "43.0");
        // Instantiate a webDriver implementation
        WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
        driver.get("https://saucelabs.com/test/redbox");
        Assert.assertEquals("Home - Everything - ReDBox", driver.getTitle());
        driver.quit();
    }
}
