package com.exercise;

import com.exercise.pages.LandingPage;
import com.exercise.pages.StepOnePage;
import com.exercise.pages.StepTwoPage;
import org.junit.FixMethodOrder;
import org.testng.annotations.Test;

import static com.exercise.helper.Common.printLog;
import static com.exercise.helper.WebdriverFactory.URL;
import static org.junit.runners.MethodSorters.NAME_ASCENDING;

@FixMethodOrder(NAME_ASCENDING)
public class GeneralPOTest extends AutomationTest {

    @Test
    public void case_01_landingPageOpen() {
        printLog("Starting execution of Test Set:  " + new Throwable().getStackTrace()[0].getMethodName());
        cleanReports("./reports/BranchPage/");
        String START_PAGE = URL + "/version";
        new LandingPage(browser).openLandingPage(START_PAGE);
    }

    @Test
    public void case_02_checkLandingPage() {
        printLog("Starting execution of Test Set:  " + new Throwable().getStackTrace()[0].getMethodName());
        cleanReports("./reports/LandingPage");
        new LandingPage(browser)
                .openLandingPage(URL)
                .checkLandingPageTitle("Sichern Sie sich jetzt Ihre THG-Prämie von bis zu 360€!")
                .checkSelectEZwei("Prämienmodell für Ihr E-Zweirad")
                .checkSelectFlex("Fahrzeugschein hochladen");
    }

    @Test
    public void case_03_checkStepOnePage() {
        printLog("Starting execution of Test Set:  " + new Throwable().getStackTrace()[0].getMethodName());
        cleanReports("./reports/StepOnePage");
        new StepOnePage(browser)
                .checkAddAttachment("Fahrzeugschein Vorderseite", "1280px-DE_Licence_2013_Front.jpg")
                .checkAddAttachment("Fahrzeugschein Rückseite", "1280px-DE_Licence_2013_Back.jpg")
                .checkNextPageButton("Persönliche Daten eingeben")
        ;
    }

    @Test
    public void case_04_checkStepTwoPage() {
        printLog("Starting execution of Test Set:  " + new Throwable().getStackTrace()[0].getMethodName());
        cleanReports("./reports/StepTwoPage");

        User user = new User("Erika",
                "Mustermann",
                "erica.mustermann@email.com",
                "GB33BUKB20201555555555");

        new StepTwoPage(browser)
                .selectPrivatePerson()
                .checkFillTheForm(user, "Angaben überprüfen & THG-Prämie beantragen");

    }

}



