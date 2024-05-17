FROM openjdk:17
ARG JAR_FILE=target/sistema-crud-0.0.2-SNAPSHOT.jar
ARG PROPERTIES_FILE=target/application.properties
COPY ${JAR_FILE} sistema-crud-0.0.2-SNAPSHOT.jar
COPY ${PROPERTIES_FILE} application.properties
ENTRYPOINT ["java","-jar","/sistema-crud-0.0.2-SNAPSHOT.jar","--spring.config.location=/application.properties"]