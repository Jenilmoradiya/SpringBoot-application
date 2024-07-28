FROM openjdk:17-jdk
COPY target/firstjobapp.jar .
EXPOSE 8080
ENTRYPOINT["java","-jar","firstjobapp.jar"]