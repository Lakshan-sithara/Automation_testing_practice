# 🚀 Data Driven Testing - Automation Exercise

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Selenium](https://img.shields.io/badge/Selenium-43B02A?style=for-the-badge&logo=selenium&logoColor=white)
![TestNG](https://img.shields.io/badge/TestNG-FF7F00?style=for-the-badge&logo=testng&logoColor=white)
![RestAssured](https://img.shields.io/badge/RestAssured-005571?style=for-the-badge&logo=api&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A22?style=for-the-badge&logo=apachemaven&logoColor=white)

Welcome to the **Data Driven Testing** automation project! This repository contains automated UI and API test scripts for [Automation Exercise](https://automationexercise.com/), built using a robust Data-Driven approach.

## 📋 Table of Contents
- [✨ Features](#-features)
- [🛠️ Tech Stack](#️-tech-stack)
- [⚙️ Project Structure](#️-project-structure)
- [🚀 Getting Started](#-getting-started)
- [📊 Test Reporting](#-test-reporting)
- [📝 Configuration](#-configuration)

---

## ✨ Features
- **Data-Driven Approach:** Test data is separated from the test scripts for better maintainability and reusability.
- **Page Object Model (POM):** UI elements and actions are encapsulated in page classes.
- **API Testing:** Integration of RestAssured for backend API validation.
- **Automated Reporting:** ExtentReports integration for rich, interactive HTML test reports.
- **Centralized Configuration:** All application properties and locators are managed via `application.properties`.

## 🛠️ Tech Stack
- **Programming Language:** Java
- **UI Automation:** Selenium WebDriver
- **API Automation:** RestAssured
- **Test Framework:** TestNG
- **Build Tool:** Maven
- **Reporting:** ExtentReports

## ⚙️ Project Structure
```text
Data_Driven_Testing/
├── src/test/java/
│   ├── APIs/                  # API Test classes (e.g., API8.java)
│   ├── base/                  # Base classes for driver initialization
│   ├── configarationFiles/    # Application properties file
│   ├── library/               # Utilities (Property reader, String manipulation)
│   ├── pages/                 # Page Object Model classes
│   ├── reports/               # ExtentReport manager and listener
│   ├── testcases/             # TestNG UI test scripts
│   └── verify/                # Assertion and validation logic
├── testng.xml                 # TestNG suite configuration
└── pom.xml                    # Maven dependencies
```

## 🚀 Getting Started

### Prerequisites
- JDK 11 or higher
- Maven
- A supported browser (Brave/Chrome)

### Installation
1. Clone this repository:
   ```bash
   git clone <your-repository-url>
   ```
2. Navigate to the project directory:
   ```bash
   cd Data_Driven_Testing
   ```
3. Update the WebDriver binary path in `src/test/java/base/InitiateDriver.java` to match your local setup.

### Running the Tests
To run the complete test suite using TestNG:
- Right-click on `testng.xml` in your IDE and select **Run '...\testng.xml'**
- OR run via Maven command line (if configured):
  ```bash
  mvn clean test
  ```

## 📊 Test Reporting
After test execution, an interactive HTML report is automatically generated.
- **Location:** `src/test/java/reports/ExtentReport.html`
- Open this file in any web browser to view detailed test steps, passed/failed statuses, and execution times.

## 📝 Configuration
All major configurations, URLs, and element locators (XPaths, IDs) are stored in:
`src/test/java/configarationFiles/application.properties`

> **Note:** Sensitive credentials have been commented out or externalized. Ensure you add valid test credentials before running authentication-dependent tests.
