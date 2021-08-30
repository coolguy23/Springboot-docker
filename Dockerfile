FROM lpicanco/java11-alpine
EXPOSE 8080
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "-Dserver.port=8080", "-Djava.security.egd=file:/dev/./urandom", "/app.jar"]