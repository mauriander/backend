FROM amazoncorretto:11-alpine-jdk
MAINTAINER SpringB
COPY target/SpringBoot-0.0.1-SNAPSHOT portfolio-app.jar
ENTRYPOINT ["java","-jar","/portfolio-app.jar"]
