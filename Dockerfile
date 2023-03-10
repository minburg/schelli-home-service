FROM eclipse-temurin:17.0.4.1_1-jre
MAINTAINER brgr.dev
ARG JAR_FILE
COPY build/libs/schelli-home-service-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-Dspring.profiles.active=prod", "-jar", "/app.jar"]
EXPOSE 8585

## Builder image, thrown away
#FROM eclipse-temurin:17.0.4.1_1-jdk AS build
#WORKDIR /workspace/app
#
#COPY . /workspace/app
#RUN --mount=type=cache,target=/root/.gradle ./gradlew clean build
#RUN mkdir -p build/dependency && (cd build/dependency; jar -xf ../libs/*.jar)
#
#FROM eclipse-temurin:17.0.4.1_1-jre
#VOLUME /tmp
#ARG DEPENDENCY=/workspace/app/build/dependency
#COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
#COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
#COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app
#ENTRYPOINT ["java","-cp","app:app/lib/*","dev.brgr.schellihomeservice.SchelliHomeServiceApplication"]


# Notes:
# To bring the Docker image to other machines without a repository:
# first delete build folder
# run gradle clean build
# docker build -t brgr/schelli-home-service --platform=linux/arm64/v8 .
# docker save -o ~/schelli.tar brgr/schelli-home-service
# copy file
# sudo docker load -i <path to image tar file>
# sudo docker run -d --name "schelli" --restart="always" -e TZ=Europe/Berlin -p 8585:8585 brgr/schelli-home-service
