FROM openjdk:21-jdk-slim-bullseye
EXPOSE 8080
COPY ./build/libs/*.jar ./app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]