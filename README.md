# Selenium Cucumber Test Automation for SauceDemo

- This project is a Selenium + Cucumber framework designed to automate UI testing for [SauceDemo](https://www.saucedemo.com/). 
- The sole purpose of this project is to introduce myself to Java Selenium testing. 

## Prerequisites

Ensure you have the following installed on your system:
- [Java JDK 22](https://www.oracle.com/java/technologies/javase/jdk22-archive-downloads.html)
- [Apache Maven](https://maven.apache.org/download.cgi)

## Project Setup

1. Install Java and Maven, validate they're installed and are the same version (22.0.2):
   ```bash
   java -version
   mvn -version
   ```

2. Install dependencies:
   ```bash
   mvn clean install
   ```

3. In IntelliJ make sure you have the following plugins under File > Settings > Plugins:
   - Cucumber for Java
   - Maven
   - JUnit / TestNG (I have both)
## Running Tests

### Run All Tests
To run all feature files:
```bash
mvn test
```
This will run all the tests under /src/test/java/tests

### Run Specific Feature File
To run a particular feature file, right click on it and click run. It will then appear under last runs on the top right:
![image](https://github.com/user-attachments/assets/0219fbeb-cd4f-45ba-abc4-ffc494057d00)

## Project Structure
```
src/
├── main/
│   └── java/
│       ├── models/                   # Contains object models
|       └── pages/                    # Contains page object models
├── test/
│   ├── java/
│   │   └── stepDefinitions/          # Step definitions used by feature files
│   │   └── features/                 # Cucumber feature files
│   │   └── hooks/                    # Hooks that contain before and after steps
|   |   └── tests/                    # Non-feature file tests
```

## Troubleshooting
- **Browser Driver Issues:** Ensure your driver version matches your browser version.
- **Dependency Issues:** Run `mvn dependency:resolve` to check for missing dependencies.
- **Java not found or Java version mismatch:** Check your env variables and validate that `JAVA_HOME = /path/to/JDK`, and `PATH` also contains an entry for `/path/to/JDK`.
