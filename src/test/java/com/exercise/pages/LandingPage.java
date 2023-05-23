package com.exercise.pages;

import com.exercise.helper.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.exercise.helper.Common.printLog;
import static com.exercise.helper.Common.take;
import static org.junit.Assert.assertEquals;

public class LandingPage {

    private final WebDriver browser;
    private final WebDriverWait wait;
    private static final String TEST_REPORT_FOLDER = "./reports/LandingPage/";

    public LandingPage(WebDriver browser) {
        this.browser = browser;
        this.wait = new WebDriverWait(browser, 5);
    }

    public LandingPage openLandingPage(String LandingPage) {
        browser.get(LandingPage);
        return this;
    }

    public LandingPage checkLandingPageTitle(String expectedTitle) {
        String landingPageTitlePath = "//h1";

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(landingPageTitlePath)));
        String actualTitle = browser.findElement(By.xpath(landingPageTitlePath)).getText();
        assertEquals(expectedTitle, actualTitle);
        take(browser, TEST_REPORT_FOLDER + "checkLandingPageTitle" + Common.dateTimeToFile() + ".png");
        printLog("checkLandingPageTitle = Passed");

        return this;
    }

    public LandingPage checkSelectEZwei(String expectedTitle) {
        String ezweiPath = "//label[2]/mat-card/mat-card-content";
        String modelSelectedTitlePath = "//app-bonus-model/div/p";

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(modelSelectedTitlePath)));
        browser.findElement(By.xpath(ezweiPath)).click();
        String actualTitle = browser.findElement(By.xpath(modelSelectedTitlePath)).getText();

        assertEquals(actualTitle, expectedTitle);
        take(browser, TEST_REPORT_FOLDER + "checkSelectEZwei" + Common.dateTimeToFile() + ".png");
        printLog("checkSelectEZwei = Passed");

        return this;
    }

    public void checkSelectFlex(String expectedTitle) {
        String flexOptionPath = "//button/span[2]";
        String actualTitlePath = "//h2";

        browser.findElement(By.xpath(flexOptionPath)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(actualTitlePath)));
        String actualTitle = browser.findElement(By.xpath(actualTitlePath)).getText();

        assertEquals(actualTitle, expectedTitle);
        take(browser, TEST_REPORT_FOLDER + "checkSelectFlex" + Common.dateTimeToFile() + ".png");
        printLog("checkSelectFlex = Passed");
    }

}
