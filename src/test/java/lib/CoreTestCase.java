package lib;

import io.appium.java_client.AppiumDriver;
import junit.framework.TestCase;
import lib.iu.WelcomePageObject;
import org.openqa.selenium.ScreenOrientation;

import java.time.Duration;

public class CoreTestCase extends TestCase {

    protected AppiumDriver driver;

    @Override
    protected void setUp() throws Exception {

        super.setUp();
        driver = Platform.getInstance().getDriver();
        if (Platform.getInstance().isIOS()) {
            this.skipWelcomePageForIOSApp();
        }
    }

    @Override
    protected void tearDown() throws Exception {
        driver.quit();

        super.tearDown();
    }

    protected void rotateScreenPortrait() {
        driver.rotate(ScreenOrientation.PORTRAIT);
    }

    protected void rotateScreenLandscape() {
        driver.rotate(ScreenOrientation.LANDSCAPE);
    }

    protected void backgroundApp(int seconds) {
        driver.runAppInBackground(Duration.ofSeconds(seconds));
    }

    private void skipWelcomePageForIOSApp() {
        WelcomePageObject welcomePageObject = new WelcomePageObject(driver);
        welcomePageObject.clickSkip();
    }
}
