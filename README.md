# Java WebDriver Automation Framework

## Introduction
This Test Automation Framework is created using Java + Selenium Web Driver + TestNG+ Maven Page Object Model(POM). 
Which can be used across different web based applications.It is used to make the code more readable, maintainable and reusable.

## Pre-requisite:
1. Java
2. Maven
3. Selenium WebDriver
4. TestNG
5. Browsers (Firefox, Chrome, IE)
6. Respective Browser drivers
7. Intellij or Eclipse

## Steps to clone execute the tests
`git clone https://github.com/keshavjha06/SeleniumE2EProject.git`<br/>
 `cd SeleniumFramework`<br/>
 `mvn clean install`<br/>
 `mvn test`

## Screenshot:
* Take Screenshots On test failures Method will automatically capture & store the screenshots under /screenshots directory. 
  The screenshot files will be named of the test method name.

## Reporting:
* The framework produce index.html report. It resides in the same 'test-output.This reports gives the link to all the different component of the TestNG reports like   Groups & Reporter Output. On clicking these will display detailed descriptions of execution.
* You can find emailable-report.html from test-output to email the test reports. As this is a html report you can open it with browser.
