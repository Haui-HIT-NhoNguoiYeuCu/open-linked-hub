FROM openjdk:17-slim
WORKDIR /app
COPY target/*.jar app.jar
EXPOSE 8080 # Cổng của gateway
ENTRYPOINT ["java", "-jar", "app.jar"]