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
src/test/java
├── base
├── models
├── payloads
├── tests
└── utils

postman
├── Lalucia_API_Automation_Assessment.postman_collection.json
└── Auto_API_Assessment.postman_environment.json
```

## APIs Covered

- Login
- Create Announcement
- Update Announcement
- Delete Announcement
- Get Published Courses

## Technologies Used

- Java 21
- Maven
- Rest Assured
- TestNG
- Allure Reports
- Postman

## How to Run

1. Clone the repository.

2. Run the tests:

```bash
mvn clean test
```

3. Generate the Allure Report:

```bash
allure serve allure-results
```

## Postman

The project includes:

- Postman Collection
- Postman Environment

Both files are located in the **postman/** folder.
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
