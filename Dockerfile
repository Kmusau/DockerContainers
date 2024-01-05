FROM openjdk:17-jdk-slim
WORKDIR /app
COPY ./target/docker-containers-0.0.1-SNAPSHOT.jar /app
EXPOSE 8080
CMD ["java", "-jar", "docker-containers-0.0.1-SNAPSHOT.jar"]