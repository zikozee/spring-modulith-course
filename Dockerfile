## Start with a base image containing Java runtime
#FROM amazoncorretto:21
#
#EXPOSE 8080
#
## Add Maintainer Info
#LABEL maintainer="Ezekiel Eromosei <ezekiel.eromosei@gmail.com>"
#
## The application's jar file  - defines the JAR_FILE variable set by dockerfile-maven-plugin
#ARG JAR_FILE=target/*.jar
#
## Add the application's jar to the container
#COPY ${JAR_FILE} app.jar
#
##execute the application
#ENTRYPOINT exec java  \
# -Dspring.profiles.active=$SPRING_PROFILE \
# -Duser.timezone=Africa/Lagos \
# -jar app.jar


FROM amazoncorretto:21 as build
WORKDIR application
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} application.jar
RUN java -Djarmode=layertools -jar application.jar extract

FROM amazoncorretto:21
WORKDIR application
COPY --from=build application/dependencies/ ./
COPY --from=build application/spring-boot-loader/ ./
COPY --from=build application/snapshot-dependencies/ ./
COPY --from=build application/application/ ./
ENTRYPOINT ["java", "-Duser.timezone=Africa/Lagos", "org.springframework.boot.loader.launch.JarLauncher"]