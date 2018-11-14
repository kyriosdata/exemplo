FROM fabric8/java-alpine-openjdk8-jre 

ENTRYPOINT ["/usr/bin/java", "-jar", "/app.jar"]

ADD target/api.jar /app.jar
