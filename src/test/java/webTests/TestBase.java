package webTests;

import manager.AppManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {
    public WebDriver driver;

    @BeforeClass
    public void setUp() {
        AppManager appManager = new AppManager();
        driver = appManager.init();//create browser instance
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
