FROM gradle:6.3.0-jdk13 AS build
ADD  . /home/AM53
WORKDIR /home/AM53
RUN gradle build --stacktrace

FROM openjdk:13-jdk-alpine
EXPOSE 8080
RUN mkdir /app
COPY --from=build /home/AM53/build/libs/*.jar /app/spring-boot-application.jar

ENTRYPOINT ["java", "-jar","/app/spring-boot-application.jar"]