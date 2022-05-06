FROM openjdk:13-ea-12-jdk-alpine
USER root
RUN   apk update \
  &&   apk add ca-certificates wget curl \
  &&   update-ca-certificates
#RUN wget -O dd-java-agent.jar "https://dtdg.co/latest-java-tracer"
RUN addgroup -S spring && adduser -S spring -G spring
#RUN chown spring:spring dd-java-agent.jar

USER spring:spring
ENV SPRING_PROFILE="default"
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

#ENTRYPOINT ["java","-Xmx128m","-Dspring.profiles.active=$SPRING_PROFILE","-Djdk.tls.client.protocols=TLSv1.2","-javaagent:/dd-java-agent.jar","-jar","/app.jar"]
ENTRYPOINT ["java","-Xmx512m","-Djdk.tls.client.protocols=TLSv1.2","-jar","/app.jar"]