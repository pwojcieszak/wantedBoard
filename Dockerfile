FROM eclipse-temurin:17-jdk-alpine
EXPOSE 8080
ADD target/wantedBoard.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]