
### Approach
- Using BDD with screen play pattern
- Two feature files are written using Gherkin syntax, see in `test/resources/features`
- Project is build with gradle

### Design
- Selenium hub/grid or standalone is running independently
- Use any library to verify expected web page statuses. Provided an interface for custom implementation to fetch and get status
- Use webdriver logs (geckodriver and chromedriver) to verify js errors 
-  Using browser logging to analyze errors in Firefox and Chrome. A custom implementation is provided to read logs for firefox. As `webDriver.manage().logs()`
  is not supported by firefox
   
### Libraries
- Selenium (Apache 2.0 License), see https://github.com/SeleniumHQ/selenium
- Cucumber JVM (MIT License) , see https://github.com/cucumber/cucumber-jvm
- Junit:4.11

#### Pre-Requisite
- docker and docker-compose is installed
- Java/gradle is configured

#### Running Tests  
- `docker-compose up`  to spin standalone instances of selenium for firefox and chrome. Firefox will run on port 4000 and chrome on 40001
- NOTE: In theory, you should be able to run against any selenium grid or 3rd party url (e.g saucelabs)
- goto `http://localhost:4444/` and make sure Selenium Grid is running  
- `export BROWSER=<firefox|chrome>`
- `export SELENIUM_REMOTE_URL=<>`
- `./scripts/run_firefox_regression.sh`  
- `./scripts/run_chrome_regression.sh`  

### Results
- Results can be found under `${projectDir}/build/reports/tests/regressionTests/index.html`
