FROM java:8

LABEL maintainer="uu"

VOLUME "/tmp"

COPY *.jar /app.jar

#对外暴露的端口

EXPOSE 8080

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]