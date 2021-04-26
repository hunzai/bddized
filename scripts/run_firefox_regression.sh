export BROWSER="firefox"
export SELENIUM_REMOTE_URL="http://127.0.0.1:4005"
gradle clean compileTestJava regressionTests --info
