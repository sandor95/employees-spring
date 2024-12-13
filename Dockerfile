FROM maven:3.9.9-eclipse-temurin-21 AS builder
WORKDIR /app
COPY . /app
RUN mvn clean install -T 2 -DskipTests

FROM eclipse-temurin:21-ubi9-minimal
WORKDIR /app

COPY --from=builder /app/apps/emp-track-relational/target/*.jar /app/app.jar

ADD https://raw.githubusercontent.com/vishnubob/wait-for-it/master/wait-for-it.sh .
RUN chmod +x ./wait-for-it.sh

EXPOSE 8080

CMD ["java", "-jar", "/app/app.jar"]
