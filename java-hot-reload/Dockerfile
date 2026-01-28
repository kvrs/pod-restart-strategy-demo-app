FROM eclipse-temurin:21-jdk
WORKDIR /app

COPY target/hot-reload-1.0.0.jar app.jar

EXPOSE 8081
ENTRYPOINT ["java", "-jar", "app.jar"]