# BlazeDemo Automation Framework

## Overview

This project is an end-to-end Selenium WebDriver automation framework developed to automate the flight booking workflow on the BlazeDemo Travel Application.

**Application Under Test:** https://blazedemo.com/

The framework follows industry-standard automation practices including Page Object Model (POM), PageFactory, TestNG, Maven, Extent Reports, and externalized test data management.

---

## Technology Stack

| Technology              | Purpose                       |
| ----------------------- | ----------------------------- |
| Java 21                 | Programming Language          |
| Selenium WebDriver 4    | Browser Automation            |
| TestNG                  | Test Execution Framework      |
| Maven                   | Build & Dependency Management |
| Page Object Model (POM) | Framework Design Pattern      |
| PageFactory             | Object Repository Management  |
| WebDriverManager        | Driver Management             |
| Extent Reports          | Test Reporting                |
| Jackson Databind        | JSON Test Data Handling       |
| Git & GitHub            | Version Control               |

---

## Framework Architecture

```text
BlazeDemoAutomation
│
├── Jenkinsfile
│
├── src/main/java
│
│   ├── base
│   │   └── BaseTest.java
│   │
│   ├── pages
│   │   ├── HomePage.java
│   │   ├── FlightSelectionPage.java
│   │   ├── PurchasePage.java
│   │   └── ConfirmationPage.java
│   │
│   ├── utilities
│   │   ├── DriverFactory.java
│   │   ├── ConfigReader.java
│   │   ├── JsonDataReader.java
│   │   ├── WaitUtils.java
│   │   ├── ScreenshotUtils.java
│   │   └── ExtentManager.java
│   │
│   ├── listeners
│   │   └── TestListener.java
│   │
│   └── constants
│       └── FrameworkConstants.java
│
├── src/test/java
│   │
│   └── tests
│       └── FlightBookingTest.java
│
├── src/test/resources
│   │
│   ├── config
│   │   └── config.properties
│   │
│   └── testdata
│       └── bookingData.json
│
├── reports
├── screenshots
├── testng.xml
├── pom.xml
├── README.md
└── .gitignore
```

---

## Test Scenario Covered

### Flight Booking Workflow

1. Launch BlazeDemo application
2. Select departure city
3. Select destination city
4. Click Find Flights
5. Verify available flights are displayed
6. Select a flight
7. Verify Purchase Flight page
8. Enter passenger details
9. Enter payment details
10. Purchase flight
11. Verify successful booking confirmation
12. Capture booking ID

---

## Features Implemented

### Framework Features

* Page Object Model (POM)
* PageFactory Implementation
* External Configuration Management
* JSON-Based Test Data Management
* Explicit Waits
* Centralized Driver Management
* TestNG Execution
* Screenshot Utility
* Extent Report Integration
* TestNG Listener Support
* Reusable Components
* Clean Project Structure

### Reporting

* Extent Reports
* Test Pass/Fail Status
* Execution Logs
* Failure Tracking
* Screenshot Capture on Failure

---

## Test Data Management

### Configuration File

Location:

```text
src/test/resources/config/config.properties
```

Example:

```properties
url=https://blazedemo.com

browser=chrome

departureCity=Boston
destinationCity=London
```

### Booking Data

Location:

```text
src/test/resources/testdata/bookingData.json
```

Example:

```json
{
  "name": "Arpan Jana",
  "address": "Salt Lake",
  "city": "Kolkata",
  "state": "West Bengal",
  "zipCode": "700091",

  "creditCardNumber": "4111111111111111",
  "creditCardMonth": "12",
  "creditCardYear": "2028",

  "nameOnCard": "Arpan Jana"
}
```

---

## Running the Tests

### Using Maven

```bash
mvn clean test
```

### Using TestNG

Run:

```text
testng.xml
```

from Eclipse or IntelliJ.

---

## Sample Execution Output

```text
================================
Flight Booking Successful
Booking ID : 1780814956356
================================

PASSED: bookFlight

Tests run: 1
Passes: 1
Failures: 0
```

---

## Reports

Extent Report is generated under:

```text
reports/AutomationReport.html
```

Open the generated HTML file in any browser to view execution details.

---

# Jenkins Setup

This project uses Jenkins to automate test execution.

## Workflow

GitHub → Jenkins → Maven Build → TestNG Execution → Extent Report → Email Notification

## Build Command

```bash
mvn clean test
```

## Plugins Used

* Git
* Maven Integration
* HTML Publisher
* Email Extension

## Outcome

* Automated Selenium Test Execution
* Extent Report Generation
* Build Status Email Notifications


## Design Patterns Used

### Page Object Model (POM)

Encapsulates page elements and actions into separate page classes to improve maintainability and readability.

### PageFactory

Uses `@FindBy` annotations and lazy initialization for efficient web element management.

---

## Future Enhancements

* Cross Browser Execution
* Selenium Grid Integration
* Dockerized Test Execution
* Jenkins CI/CD Pipeline
* Parallel Execution
* Log4j2 Logging
* Retry Analyzer
* DataProvider Integration
* Allure Reporting
* Cloud Execution 

---

## 🎥 Project Demonstration

Watch the complete end-to-end automation execution on YouTube:

[![BlazeDemo Automation Framework Demo](https://img.youtube.com/vi/Bri73L5QHwE/maxresdefault.jpg)](https://youtu.be/Bri73L5QHwE)

🔗 Direct Video Link:
https://youtu.be/Bri73L5QHwE

## Author

**Arpan Jana**

* GitHub: https://github.com/ArpanJana2002
* LinkedIn: [www.linkedin.com/in/arpan-jana](http://www.linkedin.com/in/arpan-jana)

---


