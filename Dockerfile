FROM gradle:latest

RUN mkdir -p regressionTests regressionTests/src

ADD gradle/ regressionTests/gradle/
ADD src/ regressionTests/src/

ADD gradlew.bat regressionTests/
ADD gradlew regressionTests/
ADD build.gradle regressionTests/
ADD settings.gradle regressionTests/

ADD scripts/ regressionTests/scripts/

WORKDIR regressionTests/
RUN ["gradle", "clean", "compileTestJava"]

CMD ["gradle", "regressionTests", "--info"]
