FROM maven:3.8.7-eclipse-temurin-17 AS build
WORKDIR /app


COPY pom.xml ./

RUN mvn -B -f pom.xml -DskipTests dependency:go-offline

COPY src ./src
RUN mvn -B -DskipTests package

FROM eclipse-temurin:17-jre
WORKDIR /app

RUN addgroup --system appgroup && adduser --system --ingroup appgroup appuser

COPY --from=build /app/target/*.jar /app/app.jar

ENV JAVA_OPTS="-Xms256m -Xmx512m -Dspring.profiles.active=prod"

EXPOSE 8080

USER appuser

ENTRYPOINT ["sh","-c","exec java $JAVA_OPTS -jar /app/app.jar"]
