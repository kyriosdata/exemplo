FROM openjdk:8-jre

ENTRYPOINT ["/usr/bin/java", "-jar", "/myservice.jar"]

ADD target/exemplo-unico.jar /myservice.jar
