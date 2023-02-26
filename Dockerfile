FROM amazoncorretto:8-alpine-jdk
MAINTAINER MAURIANDER
COPY target/SpringBoot-0.0.1-SNAPSHOT.jar SpringBoot-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/SpringBoot-0.0.1-SNAPSHOT.jar"]
