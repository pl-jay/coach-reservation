FROM adoptopenjdk/openjdk11:alpine

# Refer to Maven build -> finalName
ARG JAR_FILE=target/api-gw-0.0.1-SNAPSHOT.jar

# cd /opt/app
WORKDIR /opt/app


EXPOSE 9090

# cp target/spring-boot-web.jar /opt/app/app.jar
COPY ${JAR_FILE} app.jar

# java -jar /opt/app/app.jar
ENTRYPOINT ["java","-jar","app.jar"]