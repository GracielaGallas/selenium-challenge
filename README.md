Exercise
========

Requirements
------------

-   Java >= 11

Chromedriver Setup
------------------

To run the exercise, ensure that you have the following set up:

-   Download the ChromeDriver version compatible with your browser.
-   For this exercise, the required version of ChromeDriver is `chromedriver_v113`.
-   Set the path of your current chromedriver inside the `application.properties` file.

About the Test Cases
--------------------

The test cases provided below were created to test step 2 (personal details form step) of a specific application using Selenium and Java. These test cases focus on positive scenarios, covering the happy path as per the instructions in the email.

Test Sets Description
---------------------

### Test Set 01: `openLandingPage`

This test set verifies if the browser's configuration is working correctly.

### Test Set 02: `checkLandingPage`

This test set is composed of the following test cases:

#### Test Case 1: `openLandingPage`

Given I have correctly configured the browser.\
When I press the "play" button.\
Then the browser should open.

#### Test Case 2: `checkLandingPageTitle`

Given I have the URL "<https://thg-greenair.dev.wgv.onpier.de/landing>".\
When I access the URL.\
Then the title of the page should be "Sichern Sie sich jetzt Ihre THG-Prämie von bis zu 360€!".

#### Test Case 3: `checkSelectEZwei`

Given I am on the landing page.\
When I click the "E-Zweiräder" button.\
Then the Prämienmodell should display the following description: "Prämienmodell für Ihr E-Zweirad".

#### Test Case 4: `checkSelectFlex`

Given I successfully completed the previous test case.\
When I click the "Prämie beantragen" button.\
Then the page with the first step "Fahrzeugschein hochladen" should be displayed.

### Test Set 03: `checkStepOnePage`

This test set is composed of the following test cases:

#### Test Case 1: `checkAddAttachment - Front Side`

Given I click the "Fahrzeugschein Vorderseite hochladen" button.\
When I upload the file.\
Then the name of the uploaded file should be displayed under the image of the file.

#### Test Case 2: `checkAddAttachment - Back Side`

Given I click the "Fahrzeugschein Rückseite hochladen" button.\
When I upload the file.\
Then the name of the uploaded file should be displayed under the image of the file.

#### Test Case 3: `checkNextPageButton`

Given I have uploaded both files.\
And the "Weiter" button is available.\
When I click the "Weiter" button.\
Then the page with the second step "Persönliche Daten eingeben" should be displayed.

### Test Set 04: `checkStepTwoPage`

This test set is composed of the following test cases:

#### Test Case 1: `selectPrivatePerson`

Given I have selected the "PrivatPerson" radio button.\
When I check the form.\
Then The form display the fields according the selection of "PrivatPerson"
#### Test Case 2: `checkFillTheForm`

Given The form for "PrivatPerson" is displayed.\
When I enter the following information in each field:

-   Anrede: "Frau"
-   Vorname: "Erika"
-   Nachname: "Mustermann"
-   E-mail-Adresse: "<erica.mustermann@email.com>"
-   Kontoinhaber: "Erika Mustermann"
-   Iban: "GB33BUKB20201555555555"\

And I click the "Weiter" button.\
Then the page with the third step "Prämie beantragen" should be displayed.