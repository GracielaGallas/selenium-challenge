package com.exercise.pages;

import com.exercise.User;
import com.exercise.helper.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.exercise.helper.Common.printLog;
import static com.exercise.helper.Common.take;
import static org.junit.Assert.assertEquals;

public class StepTwoPage {

    private final WebDriver browser;
    private final WebDriverWait wait;
    private static final String TEST_REPORT_FOLDER = "./reports/StepTwoPage/";

    public StepTwoPage(WebDriver browser) {
        this.browser = browser;
        this.wait = new WebDriverWait(browser, 5);
    }

    public StepTwoPage selectPrivatePerson() {
        String privatePersonRadioButtonPath = "mat-radio-2";

        WebElement radioElement = browser.findElement(By.id(privatePersonRadioButtonPath));
        boolean selectState = radioElement.isSelected();
        if (!selectState) {
            radioElement.click();
        }
        take(browser, TEST_REPORT_FOLDER + "selectPrivatePerson" + Common.dateTimeToFile() + ".png");
        printLog("selectPrivatePerson = Passed");

        return this;
    }

    public void checkFillTheForm(User user, String expectedTitle) {
        String newAttachmentNamePath = "path[d='M7 10l5 5 5-5z']";
        String frauOptionButtonPath = "//span[contains(.,'Frau')]";
        String firstNameFieldPath = "//div/div/div/input";
        String lastNameFieldPath = "//onpier-input[2]/div/div/div/input";
        String emailAddressFieldPath = "//form/onpier-input/div/div/div/input";
        String accountOwnerFieldPath = "//div[3]/onpier-input/div/div/div/input";
        String ibanFieldPath = "//div[3]/onpier-input[2]/div/div/div/input";
        String buttonNextPagePath = "//*[@id='cdk-step-content-0-1']/div/app-step2/app-stepper-buttons/div/div[2]/button[2]/span[2]/div";
        String thirdPageTitlePath = "//*[@id='cdk-step-content-0-2']/app-step3/div/h2";

        browser.findElement(By.cssSelector(newAttachmentNamePath)).click();
        browser.findElement(By.xpath(frauOptionButtonPath)).click();
        browser.findElement(By.xpath(firstNameFieldPath)).sendKeys(user.getFirstName());
        browser.findElement(By.xpath(lastNameFieldPath)).sendKeys(user.getLastName());
        browser.findElement(By.xpath(emailAddressFieldPath)).sendKeys(user.getEmail());
        browser.findElement(By.xpath(accountOwnerFieldPath)).sendKeys(user.getFullName());
        browser.findElement(By.xpath(ibanFieldPath)).sendKeys(user.getIban());
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(buttonNextPagePath)));
        element.click();
        String actualTitle = browser.findElement(By.xpath(thirdPageTitlePath)).getText();

        assertEquals(actualTitle, expectedTitle);
        take(browser, TEST_REPORT_FOLDER + "checkFillTheForm" + Common.dateTimeToFile() + ".png");
        printLog("checkFillTheForm = Passed");
    }

}
