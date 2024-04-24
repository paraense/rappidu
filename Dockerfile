FROM maven:3.8.5-openjdk-17

WORKDIR project

COPY . project/

RUN mvn -f project/pom.xml clean package

ENTRYPOINT ["java", "-jar", "project/web/target/web-0.0.1-SNAPSHOT.jar"]

EXPOSE 8080/tcp