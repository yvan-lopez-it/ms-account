FROM openjdk:17-jdk-slim
VOLUME /tmp
COPY target/ms-account-0.0.1-SNAPSHOT.jar account-service.jar
ENTRYPOINT ["java", "-Xms2048m", "-Xmx2048m", "-jar","/account-service.jar"]
