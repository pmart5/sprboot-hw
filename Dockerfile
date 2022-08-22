FROM openjdk:17-alpine

EXPOSE 8081

COPY target/sprboothw-0.0.1-SNAPSHOT.jar myapp.jar

CMD ["java", "-jar", "/myapp.jar"]