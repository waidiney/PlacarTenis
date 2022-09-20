FROM openjdk:17-alpine
WORKDIR /workspace/app
COPY . /workspace/app
RUN ./mvnw clean package -DskipTests
ENTRYPOINT exec java -jar ./target/PlacarTenis-0.0.1-SNAPSHOT.jar
