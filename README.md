# Selenium E2E Project

## Introduction
This Test Automation Framework is created using Java + Selenium Web Driver + TestNG + Cucumber + Maven Page Object Model(POM). 
Which can be used across different web based applications.It is used to make the code more readable, maintainable and reusable.

## Technologies/Tools used in building the framework
- IntelliJ IDEA - IDE
- Selenium - Browser Automation library
- Maven - Build automation tool
- Java - Programming language
- TestNG - Test Management library
- BDD - Cucumber
- Allure - Reporting framework
- GitHub - Version control
- Jenkins - CI/CD

## Steps to clone execute the tests
`git clone https://github.com/keshavjha06/SeleniumE2EProject.git`<br/>
 `cd SeleniumE2EProject`<br/>
 `mvn clean install`<br/>
 `mvn test`

## Screenshot:
- On a test failure a screenshot is captured automatically (before the browser closes) and attached to the Allure report,
  for both TestNG tests and Cucumber scenarios.

## Reporting:
- Allure results are written to `target/allure-results` on every run (TestNG and Cucumber).
- `mvn allure:serve` - build the report and open it in a browser
- `mvn allure:report` - build a static report at `target/site/allure-maven-plugin/index.html`
