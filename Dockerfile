FROM amazoncorretto:11-al2-full
WORKDIR /app
COPY ./target/**.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]