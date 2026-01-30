# ---------- Build stage ----------
FROM eclipse-temurin:17-jdk AS builder
WORKDIR /build
COPY SimpleConfigServer.java .
RUN javac SimpleConfigServer.java

# ---------- Runtime stage ----------
FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=builder /build/SimpleConfigServer.class .
EXPOSE 8080
CMD ["java", "SimpleConfigServer"]
