FROM openjdk:17-jdk-slim
WORKDIR /app
COPY /target/acervo-da-tecnologia-0.0.1-SNAPSHOT.jar /app/app.jar
CMD ["java", "-jar", "app.jar"]
EXPOSE 8080