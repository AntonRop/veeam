package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static helpers.ActionsHelper.click;
import static helpers.SeleniumHelper.waitClickable;

public class CareerPage extends BasePage {
    @FindBy(xpath = "(//*[@id=\"sl\"])[1]")
    private WebElement allDepartmentDropDown;
    @FindBy(xpath = "(//*[@id=\"sl\"])[2]")
    private WebElement allLanguagesDropDown;
    @FindBy(xpath = "//*[contains(@class,\"card-sm\")]")
    private List<WebElement> jobList;
    @FindBy(xpath = "//*[@id=\"cookiescript_accept\"]")
    private WebElement closeCookieIcon;

    public CareerPage(WebDriver driver) {
        super(driver);
    }

    public CareerPage open(String url) {
        driver.get(url);
        return this;
    }

    public CareerPage selectDepartment(String department) {
        waitClickable(allDepartmentDropDown, wait).click();
        //can be used with different departments
        waitClickable(
                driver.findElement(By.xpath("//*[@class=\"form-group\"]//*[contains(text(),\"" + department + "\")]")),
                wait).click();
        return this;
    }

    public CareerPage selectLanguage(String language) {
        waitClickable(allLanguagesDropDown, wait).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class=\"show dropdown\"]")));
        //can be used with different languages
        click(driver.findElement(By.xpath("//*[@id=\"" + language + "\"]")), driver);
        return this;
    }

    public boolean shouldShowCorrectNumberJobs(int i) {
        try {
            return jobList.size() == i;
        } catch (WebDriverException e) {
            return false;
        }
    }

    public CareerPage closeCookieModal() {
        //check if modal exist
        if (driver.findElements(By.xpath("//*[@id=\"cookiescript_accept\"]")).size() > 0) {
            waitClickable(closeCookieIcon, wait);
            click(closeCookieIcon, driver);
        }
        return this;
    }
}
