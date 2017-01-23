FROM openjdk:8-jre-alpine
LABEL maintainer guillaume.fillon@epitech.eu

ADD build/libs/fetcher-service-0.0.1.jar /

EXPOSE 8080

CMD java -jar /fetcher-service-0.0.1.jar
