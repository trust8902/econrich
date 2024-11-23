FROM eclipse-temurin:21

ARG TARGET_PATH
ARG BUILD_APP
ARG PROFILE

RUN mkdir /opt/app
COPY ./build/libs/api-0.0.1-SNAPSHOT.jar /opt/app/app.jar

ENTRYPOINT ["java", "-jar", "/opt/app/app.jar"]
