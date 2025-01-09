# Stage 1: Build
FROM maven:3.9.9-amazoncorretto-21-debian-bookworm AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Runtime
FROM openjdk:21-jdk
# Accept build-time arguments
ARG SERVER_PORT=8090
ARG DATABASE_USERNAME=root
ARG DATABASE_PASSWORD=default_password
ARG DATABASE_URL=your_database_url
ARG JWT_SECRET_KEY=default_secret_key
ARG MAIL_USERNAME=default_email@gmail.com
ARG MAIL_PASSWORD=default_mail_password
ARG PAYPAL_CLIENT_ID=default_client_id
ARG PAYPAL_CLIENT_SECRET=default_client_secret

# Use build args as environment variables
ENV SERVER_PORT=${SERVER_PORT}
ENV DATABASE_USERNAME=${DATABASE_USERNAME}
ENV DATABASE_PASSWORD=${DATABASE_PASSWORD}
ENV DATABASE_URL=${DATABASE_URL}
ENV JWT_SECRET_KEY=${JWT_SECRET_KEY}
ENV MAIL_USERNAME=${MAIL_USERNAME}
ENV MAIL_PASSWORD=${MAIL_PASSWORD}
ENV PAYPAL_CLIENT_ID=${PAYPAL_CLIENT_ID}
ENV PAYPAL_CLIENT_SECRET=${PAYPAL_CLIENT_SECRET}
ENV APP_HOME=/app \
    APP_NAME=app.jar \
    APP_PORT=8080 \
    JAVA_OPTS="" \
    APP_ARGS=""
WORKDIR $APP_HOME
COPY --from=build /app/target/*.jar $APP_NAME
EXPOSE $APP_PORT
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar $APP_NAME $APP_ARGS"]
