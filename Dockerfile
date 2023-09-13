FROM openjdk:17-alpine

WORKDIR /app

COPY target/net.java.jenkins-0.0.1-SNAPSHOT.jar /app/net.java.jenkins-0.0.1-SNAPSHOT.jar

CMD ["java", "-jar", "net.java.jenkins-0.0.1-SNAPSHOT.jar"]