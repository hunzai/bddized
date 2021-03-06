
### Approach
- Using BDD with screen play pattern
- Test cases are written using Gherkin syntax, see in `test/resources/features`
- Using `selenium` with `FireFoxDriver`, `ChromeDriver` and `HttpURLConnection`

### Design
- Selenium hub/grid or standalone is running independently
- Use any library to verify expected web page statuses. Provided an interface for custom implementation to fetch and get status
- Use webdriver logs (geckodriver and chromedriver) to verify js errors 
- Using browser logging to analyze errors in Firefox and Chrome. A custom implementation is provided to read logs for firefox. As `webDriver.manage().logs()`
  is not supported by firefox
   
### Libraries
- Selenium (Apache 2.0 License), see https://github.com/SeleniumHQ/selenium
- Cucumber JVM (MIT License) , see https://github.com/cucumber/cucumber-jvm
- Junit:4.11

#### Pre-Requisite
- docker and docker-compose is installed
- Java/gradle is configured

#### Running Tests  
- checkout project `git clone https://github.com/hunzai/bddized.git`
- goto project root and run `docker-compose up`. See https://github.com/SeleniumHQ/docker-selenium for more details
  - spin standalone instances of selenium for firefox and chrome
  - chrome will run on port 4004 and firefox on 4005
- NOTE: In theory, you should be able to run against any selenium grid or 3rd party url (e.g saucelabs)
- run firefox regression test `./scripts/run_firefox_regression.sh`  
- run chrome regression test`./scripts/run_chrome_regression.sh`  
- run edge regression test`./scripts/run_ie_regression.sh`  
OR
- run chrome regression with `BROWSER="chrome" SELENIUM_REMOTE_URL="http://127.0.0.1:4004" gradle clean compileTestJava regressionTests --info`
- run firefox regression with `BROWSER="firefox" SELENIUM_REMOTE_URL="http://127.0.0.1:4005" gradle clean compileTestJava regressionTests --info`
- you can set env to run a specific test `TAGS` e.g. `TAGS="@jsErrors"`

#### Docker Image
You can also build the docker image and run tests
- Build image `docker build -t bbdized:latest . `
- Run tests `docker run -e BROWSER=<chrome|firefox|ie> -e SELENIUM_REMOTE_URL=<url_to_selenium_hub> bbdized:latest `
### Results
- Results can be found under `${projectDir}/build/reports/tests/regressionTests/index.html`
AND
- optionally results are published to https://reports.cucumber.io/reports/<id>. Please see console for the correct url  


## NOTES
- in case of firefox `webDriver.get("browser").logs()` is not working therefore logs are parsed from log file. See https://github.com/SeleniumHQ/selenium/issues/7792
