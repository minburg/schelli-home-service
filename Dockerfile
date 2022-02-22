FROM eclipse-temurin:17.0.2_8-jre-centos7
VOLUME /tmp
EXPOSE 8585
COPY build/libs/schelli-home-service-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
# Notes:
# To bring the Docker image to other machines without a repository:
# docker build -t brgr/schelli-home-service --platform=linux/arm64/v8 .
# docker save -o ~/schelli.tar brgr/schelli-home-service
# copy file
# sudo docker load -i <path to image tar file>
# sudo docker run -d --restart="always" -e TZ=Europe/Berlin -p 8585:8585 brgr/schelli-home-service
