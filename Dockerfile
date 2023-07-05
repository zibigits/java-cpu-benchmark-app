FROM openjdk:11
COPY CPUBenchmarkExample.jar /opt
ENV TZ="Europe/Warsaw"
ENV JAVA_OPTS=""
ENV APP_OPTIONS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /opt/CPUBenchmarkExample.jar $APP_OPTIONS" ]
