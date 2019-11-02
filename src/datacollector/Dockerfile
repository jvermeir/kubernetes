FROM openjdk:11-jre-slim

RUN \
  apt-get update && apt-get install && \
  useradd --home-dir /home/serv --create-home -U serv

USER serv
COPY target/datacollector-v1.jar /home/serv/

WORKDIR /home/serv

EXPOSE 8080

CMD java -Djava.security.egd=file:/dev/./urandom -jar /home/serv/datacollector-v1.jar
