FROM fabric8/java-alpine-openjdk8-jre 

ENTRYPOINT ["/usr/bin/java", "-jar", "/myservice.jar"]

ADD target/exemplo-unico.jar /myservice.jar
