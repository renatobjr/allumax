FROM maven:3.8.4-openjdk-17-slim AS build
WORKDIR /api
COPY ./api/pom.xml .
COPY ./api/src ./src
RUN mvn package -DskipTests

FROM eclipse-temurin:17-jdk-alpine
COPY --from=build /api/target/*.jar ./api.jar
ENTRYPOINT ["java","-jar","/api.jar"]