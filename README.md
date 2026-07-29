# Lalucia REST Assured Assessment 2026

## Project Overview

This project is an API automation framework built using Java, REST Assured, TestNG, Maven, and Allure Reports.

## Technologies Used

- Java 21
- REST Assured
- TestNG
- Maven
- Allure Reports

## Project Structure

```
src
 └── test
      ├── java
      │    ├── base
      │    ├── models
      │    ├── payloads
      │    ├── tests
      │    └── utils
      └── resources
```

## Automated Test Scenarios

1. Login
2. Create Announcement
3. Update Announcement
4. Delete Announcement
5. Get Published Courses

## Running the Tests

```bash
mvn clean test
```

## Generate Allure Report

```bash
allure serve allure-results
```

## Test Results

- Total Tests: 5
- Passed: 5
- Failed: 0