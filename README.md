# 🚀 Java QA Automation Framework (Web + API)

[![Build Status](https://img.shields.io/badge/build-GitHub%20Actions-blue?logo=github)](#)
[![License](https://img.shields.io/badge/license-MIT-green.svg)](#)
[![Java](https://img.shields.io/badge/Java-17-blue?logo=java)](#)
[![TestNG](https://img.shields.io/badge/TestNG-%E2%89%A5-green?logo=testng)](#)

## 📌 Overview

This repository contains a production-ready, scalable QA automation framework built using Java, Selenium, Rest Assured, TestNG, Maven, and GitHub Actions.  
Designed to follow enterprise automation standards, this framework is suitable for:

- Real-world production testing 🌐  
- CI/CD pipelines 🤖  
- Technical interviews and portfolio demonstrations 🎯

### ✨ Key Capabilities

- 🌐 Web UI automation (Selenium WebDriver)  
- 🔗 API automation (Rest Assured)  
- ⚡ Parallel execution & thread-safe driver management  
- 🌍 Cross-browser testing (Chrome, Firefox, Edge)  
- 🧪 Smoke, sanity, and regression testing classification  
- 🔁 Retry logic for flaky tests (RetryAnalyzer)  
- 📊 Rich Extent Reports (web steps, API logs)  
- 🤖 CI/CD execution via GitHub Actions with matrix runs

---

## 🛠 Tech Stack

| Layer             | Technology           |
|------------------:|---------------------:|
| Language           | Java 17              |
| UI Automation      | Selenium WebDriver   |
| API Automation     | Rest Assured         |
| Test Framework     | TestNG               |
| Build Tool         | Maven                |
| Driver Management  | WebDriverManager     |
| Reporting          | Extent Reports       |
| Logging            | Log4j                |
| CI/CD              | GitHub Actions       |

---

## 📁 Project Structure

```
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
│   ��           │   ├── BaseTest.java
│   │           │   ├── BaseWebTest.java
│   │           │   └── BaseApiTest.java
│   │           │
│   │           ├── web
│   │           │   └── (Web test classes)
│   │           │
│   │           └── api
│   │               └── (API test classes)
│   │
│   └── resources
│       └── config
│           └── env.properties
│
├── testng.xml
├── pom.xml
└── .github/workflows/ci.yml
```

---

## 🔧 Configuration Management

All environment-specific and runtime configuration is centralized in `src/test/resources/config/env.properties`, with override priority as follows:

1. Maven system properties (e.g. `-Dbrowser=chrome`, `-Denv=qa`)  
2. TestNG parameters (when used)  
3. `env.properties` defaults

Example `env.properties` keys:
```properties
browser=chrome
baseUrl=https://example.com
apiBaseUrl=https://api.example.com
timeout.ms=5000
retry.count=2
```

---

## 🚗 WebDriver Architecture

- Thread-safe WebDriver management using `ThreadLocal` ensures fully isolated execution for parallel runs.  
- Browser lifecycle:
  - Initialized in `@BeforeMethod`
  - Quit and cleaned in `@AfterMethod`  
- Supported browsers: Chrome, Firefox, Edge (via WebDriverManager)

---

## 🌐 API Automation Design

- Built using Rest Assured for API interactions.  
- API tests do NOT open browsers.  
- Base URI initialized once per test class; requests & responses logged and attached to Extent reports.

---

## 🧪 Test Classification (TestNG Groups)

Use TestNG groups to categorize tests:

- `smoke` — Critical flow validation 🚨  
- `sanity` — Basic stability checks ✅  
- `regression` — Full test coverage 🧭  
- `api` — API-only execution 🔗  
- `web` — Web-only execution 🌐

Sample:
```java
@Test(groups = {"smoke", "regression"})
public void criticalFlowTest() { ... }
```

---

## 🔁 Retry Logic

- Implemented using `RetryAnalyzer` and integrated via a TestNG annotation transformer.  
- Automatically retries failed tests to mitigate flaky failures. Configure retry count in `env.properties` or via system property.

---

## 📊 Reporting

- Extent Reports are generated after every execution and include:
  - Web test steps and screenshots (if enabled)  
  - API request and response logs  
  - Test status and failure details

Output directory:
```
test-output/
```

---

## ▶️ Running Tests Locally

Run all tests:
```bash
mvn clean test
```

Run tests by groups:
```bash
# Smoke
mvn clean test -Dgroups=smoke

# Regression
mvn clean test -Dgroups=regression
```

Run API-only or Web-only via Maven profiles and browser override:
```bash
# API tests only
mvn clean test -Papi

# Web tests only (explicit browser)
mvn clean test -Pweb -Dbrowser=chrome
```

Parallel execution is controlled by `testng.xml` and TestNG parameters (method-level or test-level parallelism). Thread-safe driver management prevents conflicts during parallel runs.

---

## 🤖 CI/CD — GitHub Actions

CI features:
- Matrix execution (browsers: Chrome, Firefox; environments: dev, qa)  
- Automatic browser setup using WebDriverManager or containerized drivers  
- Test report artifacts uploaded after execution  
- Triggers:
  - push to main
  - pull request against main

A sample workflow file: `.github/workflows/ci.yml` (ensure it matches your desired matrix and artifact upload steps).

---

## ✅ Current Capabilities Summary

- ✔ Web + API automation  
- ✔ Cross-browser testing  
- ✔ Parallel execution  
- ✔ Environment-specific execution  
- ✔ Retry mechanism for flaky tests  
- ✔ Extent reporting with API logs  
- ✔ CI/CD ready (GitHub Actions)  
- ✔ Interview-ready architecture & examples

---

## 🚀 Future Enhancements (Optional)

- Headless execution toggle for faster CI runs  
- Screenshot capture on failure (per-test)  
- API schema validation (JSON Schema / OpenAPI checks)  
- Dockerized execution for reproducible CI environments  
- Add Allure reporting and centralized test data management

---

## 📂 Examples & Recommendations

Add example folders to accelerate onboarding:

- `examples/basic` — simple web + api usage examples  
- `examples/async` — async flows and advanced scenarios  
- `examples/spring-boot` — Spring Boot test integration (if relevant)

---

## 🤝 Contributing

We welcome contributions! Suggested flow:

1. Fork the repo 🍴  
2. Create a branch: `git checkout -b feat/my-feature` 🌱  
3. Add tests and documentation ✅  
4. Run all tests locally and ensure code style is followed 🔍  
5. Open a pull request with a clear description and link to any related issue 🔗

Please include unit tests for new logic and update README/examples when APIs change.

---

## 🛡️ License

This project is licensed under the MIT License — see the `LICENSE` file for details. 📝

---

## 👨‍💻 Author Notes

This framework is designed with scalability, maintainability, and real-world usage in mind. It reflects industry best practices for modern QA automation and is suitable for CI pipelines and interview/portfolio demos.

Maintainer: @Mcube333  
Issues & feature requests: please open GitHub issues
