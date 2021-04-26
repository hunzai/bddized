export BROWSER="chrome"
export SELENIUM_REMOTE_URL="http://127.0.0.1:4004"
gradle clean compileTestJava regressionTests --info
