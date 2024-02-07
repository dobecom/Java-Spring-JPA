FROM openjdk:17.0.1-jdk-buster

VOLUME /tmp

RUN mkdir /springboot

WORKDIR /springboot
COPY build/libs/*.jar springboot.jar
COPY src/main/resources/* /springboot

ENTRYPOINT ["sh","-c","java -jar springboot.jar"]
