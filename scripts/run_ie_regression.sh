export BROWSER="ie"
export SELENIUM_REMOTE_URL="http://127.0.0.1:4006"
gradle clean compileTestJava regressionTests --info
