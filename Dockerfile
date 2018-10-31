FROM openjdk:8-jre

ENTRYPOINT ["/usr/bin/java", "-jar", "/usr/share/myservice/myservice.jar"]

ADD target/exemplo-unico.jar /usr/share/myservice/myservice.jar
