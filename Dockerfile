# Stage 1: Build
FROM maven:3.9.9-amazoncorretto-21-debian-bookworm AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Runtime
FROM openjdk:21-jdk
ENV APP_HOME=/app \
    APP_NAME=app.jar \
    APP_PORT=8080 \
    JAVA_OPTS="" \
    APP_ARGS=""
WORKDIR $APP_HOME
COPY --from=build /app/target/*.jar $APP_NAME
EXPOSE $APP_PORT
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar $APP_NAME $APP_ARGS"]
