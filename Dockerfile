FROM openjdk:17-slim

EXPOSE 8080

COPY build/libs/hw2_AuthorizationService-0.0.1-SNAPSHOT.jar app.jar

CMD ["java", "-jar", "app.jar"]