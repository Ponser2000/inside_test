FROM openjdk:17-jdk-alpine

ARG JAR_FILE=target/appInside.jar

WORKDIR /opt/app

COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","app.jar"]
