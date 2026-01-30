FROM eclipse-temurin:17-jre
WORKDIR /app
COPY SimpleConfigServer.java .
RUN javac SimpleConfigServer.java
EXPOSE 8080
CMD ["java", "SimpleConfigServer"]
