Java QA Automation Framework (Web + API)

📌 Overview

This repository contains a production-ready, scalable automation framework built using Java, Selenium, Rest Assured, TestNG, Maven, and GitHub Actions.

The framework supports:

Web UI automation

API automation

Parallel execution

Cross-browser testing

Environment-specific execution

Test categorization (smoke, sanity, regression)

Retry logic

Rich Extent reporting

CI/CD execution using GitHub Actions

The design follows enterprise automation standards and is suitable for real-world production testing as well as interview demonstrations.

🛠 Tech Stack
Layer	Technology
Language	Java 17
UI Automation	Selenium WebDriver
API Automation	Rest Assured
Test Framework	TestNG
Build Tool	Maven
Driver Management	WebDriverManager
Reporting	Extent Reports
Logging	Log4j
CI/CD	GitHub Actions
📁 Project Structure
java-adapter
│
├── src
│   ├── main
│   │   └── java
│   │       └── framework
│   │           ├── config
│   │           │   ├── ConfigManager.java
│   │           │   └── ApiConfig.java
│   │           │
│   │           ├── driver
│   │           │   ├── DriverFactory.java
│   │           │   ├── DriverManager.java
│   │           │   └── BrowserType.java
│   │           │
│   │           ├── listeners
│   │           │   └── ExtentTestListener.java
│   │           │
│   │           ├── retry
│   │           │   ├── RetryAnalyzer.java
│   │           │   └── RetryAnnotationTransformer.java
│   │           │
│   │           └── utils
│   │               ├── ExtentManager.java
│   │               └── CommonUtils.java
│   │
│   ├── test
│   │   └── java
│   │       └── tests
│   │           ├── base
│   │           │   ├── BaseTest.java
│   │           │   ├── BaseWebTest.java
│   │           │   └── BaseApiTest.java
│   │           │
│   │           ├── web
│   │           │   └── Web test classes
│   │           │
│   │           └── api
│   │               └── API test classes
│   │
│   └── resources
│       └── config
│           └── env.properties
│
├── testng.xml
├── pom.xml
└── .github
    └── workflows
        └── ci.yml

🔧 Configuration Management
env.properties
browser=chrome
baseUrl=https://example.com
apiBaseUrl=https://api.example.com

Priority Order

Maven system properties (-Dbrowser, -Denv)

TestNG parameters

env.properties defaults

🚗 WebDriver Architecture

Thread-safe WebDriver management

Uses ThreadLocal<WebDriver>

Ensures isolation for parallel execution

Browser lifecycle:

Initialized in @BeforeMethod

Quit and unloaded in @AfterMethod

Supported Browsers

Chrome

Firefox

Edge

🌐 API Automation Design

Built using Rest Assured

API tests do NOT open browsers

Base URI initialized once per class

Request & response logged to Extent report

🧪 Test Classification (TestNG Groups)
Group	Purpose
smoke	Critical flow validation
sanity	Basic stability check
regression	Full test coverage
api	API-only execution
web	Web-only execution

Example:

@Test(groups = {"smoke", "regression"})

🔁 Retry Logic

Implemented via RetryAnalyzer

Automatically retries failed tests

Integrated using TestNG annotation transformer

Helps stabilize flaky tests

📊 Reporting
Extent Reports

Generated after every execution

Supports:

Web steps

API request & response logs

Test status and exceptions

Output location:

test-output/

▶️ Running Tests Locally
Run all tests
mvn clean test

Run smoke tests
mvn clean test -Dgroups=smoke

Run regression tests
mvn clean test -Dgroups=regression

Run API tests only
mvn clean test -Papi

Run Web tests only
mvn clean test -Pweb -Dbrowser=chrome

🔄 Parallel Execution

Supported at:

Method level

Test level

Enabled via:

TestNG XML

CI matrix

Thread-safe driver ensures no collision

🤖 CI/CD – GitHub Actions
Features

Matrix execution:

Browsers: Chrome, Firefox

Environments: dev, qa

Groups: smoke (extendable)

Automatic browser installation

Report artifacts uploaded after execution

Trigger

Push to main

Pull request to main

✅ Current Capabilities Summary

✔ Web + API automation
✔ Cross-browser testing
✔ Parallel execution
✔ Environment-specific execution
✔ Retry mechanism
✔ Extent reporting
✔ CI/CD ready
✔ Interview-ready architecture

🚀 Future Enhancements (Optional)

Headless execution toggle

Screenshot capture on failure

API schema validation

Dockerized execution

Allure reporting

Test data management layer

👨‍💻 Author Notes

This framework was designed with enterprise-level scalability and maintainability in mind and reflects real-world automation best practices.
