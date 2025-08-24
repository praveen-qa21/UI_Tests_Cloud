# Different Ways of Executing the Tests
1. Clone the Repository to your local machine and execute locally 
Pre-Requisite:
- JAVA MAVEN BROWSER(CHROME and FIREFOX)
- Change the config.properties and execute via IDE
- Execute via CLI 
-  mvn clean test -P pr-checks (OR)
   mvn clean verify -P full-regression -D browserName=chrome -D browserHeadless=true

2. Clone the Repository to your local machine and execute via Docker Selenium Grid
   Pre-Requisite:
- JAVA MAVEN DOCKER
- cd to project directory and do docker-compose up to spin up the SeleniumGrid via localhost:PORT 
- Change the config.properties(seleniumGridEnabled=true) and execute via IDE
- Execute via CLI
-  mvn clean test -P pr-checks (OR)
   mvn clean verify -P full-regression -D browserName=chrome -D -DseleniumGridEnabled=true

3. Check before Docker image
- After mvn package completes you will see package under target/
- Navigate to that package directory in cli 
- set CP=ui-test-cloud.jar;ui-test-cloud-tests.jar;libs\*
- check echo %CP%
- execute java -cp %CP% org.testng.TestNG testngReg.xml (OR)
- java -cp %CP% -DseleniumGridEnabled=true org.testng.TestNG -threadcount 1 testngSmoke.xml
inside container
- export CP="ui-test-cloud.jar:ui-test-cloud-tests.jar:libs/*"
- echo $CP
  java -cp $CP org.testng.TestNG -threadcount 1 testngSmoke.xml