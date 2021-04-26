
### Approach

- Using BDD with screen play pattern
- Two feature files are written using Gherkin syntax, see in `test/resources/features`
- Project is build with gradle
- Using browser logging to analyze errors in Firefox and Chrome. A custom implementation is provided to read logs for firefox. As `webDriver.manage().logs()`
is not supported by firefox
- Using `https://github.com/bonigarcia/webdrivermanager` to mange driver binaries

### Assumption
- Use any library to verify expected web page statues 
- Use selenium (geckodriver and chromedriver) to verify js errors

### Out of scope
- Running in cloud (e.g. saucelabs) or using selenium grid


### Dependencies
- Selenium (Apache 2.0 License), see https://github.com/SeleniumHQ/selenium
- WebDriverManager (Apache 2.0 License), see https://github.com/bonigarcia/webdrivermanager
- Cucumber JVM (MIT License) , see https://github.com/cucumber/cucumber-jvm
- Junit:4.11


### Running tests

#### Pre-Requisit
- `docker-compose up`  to run standalone instances of selenium for firefox and chrome. Firefox will run on port 4000 and chrome on 40001
- `export BROWSER=<firefox|chrome>`
- `export SELENIUM_REMOTE_URL=<>`
- `./script`  
- checkout project 
- run in  firefox
``
gradle clean compileTestJava regressionTests -Dbrowser=chrome -Dtags="@jsErrors" --info
``

- run in chrome  

```
gradle clean compileTestJava regressionTests -Dbrowser=chrome -Dtags="@jsErrors" --info
```

### Results
- Results can be found under `${projectDir}/reports/tests/regressionTests/index.html`


### docker
- selenium-docker, see `https://github.com/SeleniumHQ/docker-selenium`
`$ docker run -d -p 4444:4444 -v /dev/shm:/dev/shm selenium/standalone-firefox:4.0.0-beta-3-prerelease-20210422
`
