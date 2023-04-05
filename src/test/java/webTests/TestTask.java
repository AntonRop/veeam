package webTests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.CareerPage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestTask extends TestBase {
    private CareerPage careerPage;

    @DataProvider(name = "number")
    public static Iterator<Object[]> dpMethod() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"Research & Development", "lang-option-0", 8});
        return list.iterator();
    }

    @BeforeMethod
    @Parameters("url")
    public void open(String url) {
        careerPage = new CareerPage(driver)
                .open(url);
    }

    @Test(dataProvider = "number")
    public void testWeb(String department, String language, int numberJob) {
        careerPage
                .closeCookieModal()
                .selectDepartment(department)
                .selectLanguage(language);

        Assert.assertTrue(careerPage.shouldShowCorrectNumberJobs(numberJob));
    }
}
